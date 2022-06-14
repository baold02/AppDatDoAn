package com.huongdancode.nhom6_app.Activity;

import static com.huongdancode.nhom6_app.Utils.OverUtils.ERROR_MESSAGE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseError;
import com.huongdancode.nhom6_app.Adapter.CategoryAdapter;
import com.huongdancode.nhom6_app.Adapter.ProductAdapter;
import com.huongdancode.nhom6_app.Dao.ProductDao;
import com.huongdancode.nhom6_app.Dao.ProductTypeDao;
import com.huongdancode.nhom6_app.Interface.IAfterGetAllObject;
import com.huongdancode.nhom6_app.Interface.UpdateRecyclerView;
import com.huongdancode.nhom6_app.Model.LoaiSP;
import com.huongdancode.nhom6_app.Model.Product;
import com.huongdancode.nhom6_app.R;
import com.huongdancode.nhom6_app.Utils.OverUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity implements UpdateRecyclerView {

    private TextView edtTimKiem;

    RecyclerView recyclerViewCategoryProduct, recyclerViewProduct;

    ProductAdapter productAdapter;
    CategoryAdapter categoryAdapter;

    List<Product> productArrayList;
    List<LoaiSP> categoryArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        anhXa();
        recyclerViewCategory();
        recyclerViewProduct();

        edtTimKiem.setOnClickListener(v -> {
            Intent intent = new Intent(ProductActivity.this, SearchActivity.class);
            startActivity(intent);
        });
    }

    private void anhXa() {
        recyclerViewCategoryProduct = findViewById(R.id.recyclerViewCategoryProduct);
        recyclerViewProduct = findViewById(R.id.recyclerViewProduct);
        edtTimKiem = findViewById(R.id.edtTimKiem);
    }

    private void recyclerViewCategory() {
        categoryArrayList = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(this, categoryArrayList, this);
        recyclerViewCategoryProduct.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewCategoryProduct.setAdapter(categoryAdapter);

        ProductTypeDao.getInstance().getAllProductType(new IAfterGetAllObject() {
            @Override
            public void iAfterGetAllObject(Object obj) {
                categoryArrayList = (List<LoaiSP>) obj;
                categoryAdapter.setData(categoryArrayList);
            }

            @Override
            public void onError(DatabaseError error) {
                OverUtils.makeToast(ProductActivity.this, ERROR_MESSAGE);
            }
        });
    }

    private void recyclerViewProduct() {
        productArrayList = new ArrayList<>();
        productAdapter = new ProductAdapter(this, productArrayList);
        recyclerViewProduct.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewProduct.setAdapter(productAdapter);

        String categoryId = getIntent().getStringExtra("categoryId");
        ProductDao.getInstance().getProductByType(categoryId, new IAfterGetAllObject() {
            @Override
            public void iAfterGetAllObject(Object obj) {
                productArrayList = (List<Product>) obj;
                productAdapter.setData(productArrayList);
            }

            @Override
            public void onError(DatabaseError error) {
                OverUtils.makeToast(ProductActivity.this, ERROR_MESSAGE);
            }
        });
    }


    public void btnReturn(View view) {
        onBackPressed();
    }

    @Override
    public void callback(String categoryId) {
        ProductDao.getInstance().getProductByType(categoryId, new IAfterGetAllObject() {
            @Override
            public void iAfterGetAllObject(Object obj) {
                productArrayList = (List<Product>) obj;
                productAdapter.setData(productArrayList);
            }

            @Override
            public void onError(DatabaseError error) {
                OverUtils.makeToast(ProductActivity.this, ERROR_MESSAGE);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}