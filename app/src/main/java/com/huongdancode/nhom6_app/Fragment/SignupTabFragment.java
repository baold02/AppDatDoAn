package com.huongdancode.nhom6_app.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.huongdancode.nhom6_app.HomeActivity;
import com.huongdancode.nhom6_app.LoginActivity;
import com.huongdancode.nhom6_app.R;

import java.util.concurrent.Executor;


public class SignupTabFragment extends Fragment {

    private static final String TAG = "EmailPassword";
    private Context context;
    private EditText edtTenDangNhap;
    private EditText edtMatKhau;
    private EditText edtNhapLaiMatKhau;
    private Button btnHuyDangKi;
    private Button btnDangKi;

    private LoginActivity loginActivity;
    private  LoginTabFragment fragment;

    // biến môi trường kết nối của Auth của Firebase
    //private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        loginActivity = (LoginActivity) getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_signup_tab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
          initView(view);
//        setUpEdtSoDienThoai();
//        setUpBtnCheckPass(btnCheckPass, edtMatKhau);
//        setUpBtnCheckPass(btnCheckPass2, edtNhapLaiMatKhau);
          setUpBtnCancel();
        setDangKi();
    }

    private void initView(View view) {

        edtTenDangNhap = view.findViewById(R.id.edtEmail);
        edtMatKhau = view.findViewById(R.id.edtpass);
        btnHuyDangKi = view.findViewById(R.id.btnHuyDangKi);
        btnDangKi = view.findViewById(R.id.btnDangKi);

    }



    private void setUpBtnCheckPass(ToggleButton btnCheckPass, EditText edtMatKhau) {
        btnCheckPass.setOnClickListener(v -> {
            if (btnCheckPass.isChecked()) {
                edtMatKhau.setTransformationMethod(null);
            } else {
                edtMatKhau.setTransformationMethod(new PasswordTransformationMethod());
            }

        });
    }



    private void setUpBtnCancel() {
        btnHuyDangKi.setOnClickListener(v -> {
            edtTenDangNhap.setText("");
            edtMatKhau.setText("");

            ;
        });
    }

    private void  setDangKi(){
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DangKy();
            }
        });
    }

    private void DangKy(){
        String Email = edtTenDangNhap.getText().toString().trim();
        String password = edtMatKhau.getText().toString().trim();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(Email, password)
                .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent intent = new Intent(getContext(), HomeActivity.class);
                            startActivity(intent);






                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getContext(),"That bai",Toast.LENGTH_SHORT).show();
//                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();

                        }
                    }


                });

    }




    private void goToLoginFragment() {

        edtMatKhau.setText("");
        edtNhapLaiMatKhau.setText("");
        edtTenDangNhap.setText("");
        loginActivity.getTabLayout().selectTab(loginActivity.getTabLayout().getTabAt(0));
    }






}