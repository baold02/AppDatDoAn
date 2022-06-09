package com.huongdancode.nhom6_app.Fragment;

import static com.huongdancode.nhom6_app.Activity.SplashActivity.userLogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseError;
import com.huongdancode.nhom6_app.Adapter.CategoryAdapter;
import com.huongdancode.nhom6_app.Dao.ProductTypeDao;
import com.huongdancode.nhom6_app.Interface.IAfterGetAllObject;
import com.huongdancode.nhom6_app.Interface.UpdateRecyclerView;
import com.huongdancode.nhom6_app.Model.LoaiSP;
import com.huongdancode.nhom6_app.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements UpdateRecyclerView {
    private TextView tvTenNguoiDung;
    private RecyclerView recyclerViewCategoryList;
    private CategoryAdapter categoryAdapter;
    private List<LoaiSP> loaiSPList;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         initView(view);
        // setUpTvHoTen();

    }

    private void initView(View view) {
        tvTenNguoiDung = view.findViewById(R.id.tvTenNguoiDung);

    }

    private void recyclerViewCategory() {
        recyclerViewCategoryList = view.findViewById(R.id.recyclerViewCategoryList);
        recyclerViewCategoryList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        loaiSPList = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(getContext(), loaiSPList, this);
        recyclerViewCategoryList.setAdapter(categoryAdapter);

        ProductTypeDao.getInstance().getAllProductType(new IAfterGetAllObject() {
            @Override
            public void iAfterGetAllObject(Object obj) {
                loaiSPList = (List<LoaiSP>) obj;
                categoryAdapter.setData(loaiSPList);
            }

            @Override
            public void onError(DatabaseError error) {

            }
        });
    }


    @Override
    public void callback(String categoryId) {
//        Intent intent = new Intent(getContext(), ProductActivity.class);
//        intent.putExtra("categoryId", categoryId);
//        startActivity(intent);
    }
}
