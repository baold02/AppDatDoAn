package com.huongdancode.nhom6_app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.huongdancode.nhom6_app.Adapter.DanhSachDonHangPagerAdapter;
import com.huongdancode.nhom6_app.Model.TrangThai;
import com.huongdancode.nhom6_app.R;

import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private DanhSachDonHangPagerAdapter danhSachDonHangPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_order, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        tabLayout = v.findViewById(R.id.tabLayout_order);
        viewPager2 = v.findViewById(R.id.viewpager2_order);

        List<TrangThai> trangThaiList = getListTrangThai();
        danhSachDonHangPagerAdapter = new DanhSachDonHangPagerAdapter(getActivity(), trangThaiList);
        viewPager2.setAdapter(danhSachDonHangPagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            tab.setText(TrangThai.values()[position].getTrangThai());
        }).attach();
    }

    private List<TrangThai> getListTrangThai() {
        List<TrangThai> result = new ArrayList<>();
        for(int i = 0; i < TrangThai.values().length; i++) {
            if(!TrangThai.values()[i].getTrangThai().equals(TrangThai.HUY_DON.getTrangThai())) {
                result.add(TrangThai.values()[i]);
            }
        }
        return result;
    }
}