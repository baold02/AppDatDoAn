package com.huongdancode.nhom6_app.Activity;

import static com.huongdancode.nhom6_app.Utils.OverUtils.ERROR_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.style.Wave;
import com.google.firebase.database.DatabaseError;
import com.huongdancode.nhom6_app.Dao.UserDao;
import com.huongdancode.nhom6_app.Interface.IAfterGetAllObject;
import com.huongdancode.nhom6_app.Model.User;
import com.huongdancode.nhom6_app.R;
import com.huongdancode.nhom6_app.Utils.OverUtils;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    public static User userLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String passState = OverUtils.getSPInstance(SplashActivity.this, OverUtils.PASS_FILE)
                .getString("pass", OverUtils.NO_PASS);
        setUpPassAction(passState);
    }

    private void setUpPassAction(String passState) {
        switch (passState) {
            case OverUtils.NO_PASS:
                setContentView(R.layout.activity_main);
                break;
            case OverUtils.PASS_FLASH_ACTIVITY:
                Intent loginIntent = new Intent(SplashActivity.this, LoginActivity.class);
                goToActivity(loginIntent);
                break;
            case OverUtils.PASS_LOGIN_ACTIVITY:
                Intent homeIntent = new Intent(SplashActivity.this, HomeActivity.class);
                goToActivity(homeIntent);
                break;
            default:
                break;
        }
    }

    private void goToActivity(Intent intent) {
        ProgressBar progressCircular;
        Timer timer = new Timer();
        setContentView(R.layout.activity_splash);
        progressCircular = findViewById(R.id.progress_circular);
        progressCircular.setIndeterminateDrawable(new Wave());

        UserDao.getInstance().getUserByUserName(OverUtils.getUserLogin(SplashActivity.this).getUsername(), new IAfterGetAllObject() {
            @Override
            public void iAfterGetAllObject(Object obj) {
                if(obj != null) {
                    userLogin = (User) obj;
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            startActivity(intent);
                            finish();
                        }
                    }, 500);
                }
            }

            @Override
            public void onError(DatabaseError error) {
                OverUtils.makeToast(SplashActivity.this, OverUtils.ERROR_MESSAGE);
            }
        });

        // cài đặt delay vào màn hình login

    }


    public void btnStart(View view) {
        SharedPreferences.Editor editor = OverUtils.getSPInstance(SplashActivity.this, OverUtils.PASS_FILE).edit();
        editor.putString("pass", OverUtils.PASS_FLASH_ACTIVITY);
        editor.apply();
        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        finish();
    }
}