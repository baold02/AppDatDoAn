package com.huongdancode.nhom6_app.Activity;

import static com.huongdancode.nhom6_app.Activity.SplashActivity.userLogin;
import static com.huongdancode.nhom6_app.Utils.OverUtils.ERROR_MESSAGE;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseError;
import com.huongdancode.nhom6_app.Adapter.DonHangAdapter;
import com.huongdancode.nhom6_app.Dao.UserDao;
import com.huongdancode.nhom6_app.Interface.IAfterGetAllObject;
import com.huongdancode.nhom6_app.Model.DonHang;
import com.huongdancode.nhom6_app.R;
import com.huongdancode.nhom6_app.Utils.OverUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    private List<DonHang> donHangList;
    private DonHangAdapter donHangAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initView();
        getListDonHang();
    }

    private void initView() {
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView = findViewById(R.id.rv_donhang);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getListDonHang() {
        donHangList = new ArrayList<>();
        donHangAdapter = new DonHangAdapter(OrderActivity.this, donHangList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(OrderActivity.this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(donHangAdapter);
        UserDao.getInstance().getDonHangByUser(userLogin, new IAfterGetAllObject() {
            @Override
            public void iAfterGetAllObject(Object obj) {
                donHangList = (List<DonHang>) obj;
                Collections.reverse(donHangList);
                donHangAdapter.setData(donHangList);
            }

            @Override
            public void onError(DatabaseError error) {
                OverUtils.makeToast(OrderActivity.this, ERROR_MESSAGE);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}