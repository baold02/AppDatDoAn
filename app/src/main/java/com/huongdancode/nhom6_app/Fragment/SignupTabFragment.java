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
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.huongdancode.nhom6_app.LoginActivity;
import com.huongdancode.nhom6_app.R;


public class SignupTabFragment extends Fragment {

    private EditText edtSoDienThoai;
    private EditText edtTenDangNhap;
    private EditText edtMatKhau;
    private EditText edtNhapLaiMatKhau;
    private ToggleButton btnCheckPass2;
    private ToggleButton btnCheckPass;
    private Button btnHuyDangKi;
    private Button btnDangKy;

    private LoginActivity loginActivity;

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
//        setUpBtnCancel();
    }

    private void initView(View view) {
        edtSoDienThoai = view.findViewById(R.id.edtSoDienThoai);
        edtTenDangNhap = view.findViewById(R.id.edtTenDangNhap);
        edtMatKhau = view.findViewById(R.id.edtMatKhau);
        edtNhapLaiMatKhau = view.findViewById(R.id.edtNhapLaiMatKhau);
        btnCheckPass2 = view.findViewById(R.id.btnCheckPass2);
        btnHuyDangKi = view.findViewById(R.id.btnHuyDangKi);
        btnDangKy = view.findViewById(R.id.btnDangKy);
        btnCheckPass = view.findViewById(R.id.btnCheckPass);
    }

    private void setUpEdtSoDienThoai() {
        edtSoDienThoai.setOnFocusChangeListener((v, hasFocus) -> {
            if(hasFocus) {
                edtSoDienThoai.setHint("");
            } else {
                edtSoDienThoai.setHint("Nhập số điện thoại");
            }
        });
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
            edtNhapLaiMatKhau.setText("");
            edtSoDienThoai.setText("");
        });
    }



    private void goToLoginFragment() {
        edtSoDienThoai.setText("");
        edtMatKhau.setText("");
        edtNhapLaiMatKhau.setText("");
        edtTenDangNhap.setText("");
        loginActivity.getTabLayout().selectTab(loginActivity.getTabLayout().getTabAt(0));
    }






}