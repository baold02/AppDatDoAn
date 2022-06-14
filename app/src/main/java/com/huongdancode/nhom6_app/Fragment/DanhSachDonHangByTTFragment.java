package com.huongdancode.nhom6_app.Fragment;

import static com.huongdancode.nhom6_app.Activity.FlashActivity.userLogin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseError;
import com.huongdancode.nhom6_app.Adapter.DonHangAdapter;
import com.huongdancode.nhom6_app.Dao.UserDao;
import com.huongdancode.nhom6_app.Interface.IAfterGetAllObject;
import com.huongdancode.nhom6_app.Model.DonHang;
import com.huongdancode.nhom6_app.Model.TrangThai;
import com.huongdancode.nhom6_app.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DanhSachDonHangByTTFragment extends Fragment {
    private TrangThai trangThai;
    private RecyclerView rcvDanhSachDonHang;
    private List<DonHang> donHangList;
    private DonHangAdapter donHangAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_danh_sach_don_hang_by_t_t, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDuLieu();
        initView(view);
        setUpListDonHang();
    }

    private void getDuLieu() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            trangThai = (TrangThai) bundle.getSerializable("trang_thai");
        }

    }

    private void initView(View view) {
        rcvDanhSachDonHang = view.findViewById(R.id.rcvDonHang);
    }

    private void setUpListDonHang() {
        donHangList = new ArrayList<>();
        donHangAdapter = new DonHangAdapter(getContext(), donHangList);
        rcvDanhSachDonHang.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvDanhSachDonHang.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        rcvDanhSachDonHang.setAdapter(donHangAdapter);
        UserDao.getInstance().getDonHangByUser(userLogin, new IAfterGetAllObject() {
            @Override
            public void iAfterGetAllObject(Object obj) {
                donHangList = loc(trangThai, (List<DonHang>) obj);
                Collections.reverse(donHangList);
                donHangAdapter.setData(donHangList);
            }

            @Override
            public void onError(DatabaseError error) {

            }
        });

    }


    public List<DonHang> loc(TrangThai trangThai, List<DonHang> donHangList) {
        List<DonHang> result = new ArrayList<>();
        for (DonHang donHang : donHangList) {
            if (donHang.getTrang_thai().equals(trangThai.getTrangThai())) {
                result.add(donHang);
            }
        }
        return result;
    }

}