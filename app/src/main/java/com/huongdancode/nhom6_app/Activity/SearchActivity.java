package com.huongdancode.nhom6_app.Activity;

import static androidx.recyclerview.widget.DividerItemDecoration.VERTICAL;
import static com.huongdancode.nhom6_app.Utils.OverUtils.ERROR_MESSAGE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseError;
import com.huongdancode.nhom6_app.Adapter.FilterProductAdapter;
import com.huongdancode.nhom6_app.Dao.ProductDao;
import com.huongdancode.nhom6_app.Interface.IAfterGetAllObject;
import com.huongdancode.nhom6_app.Interface.OnClickItem;
import com.huongdancode.nhom6_app.Model.Product;
import com.huongdancode.nhom6_app.R;
import com.huongdancode.nhom6_app.Utils.OverUtils;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements OnClickItem {
    private ImageButton btnBack;
    private SearchView searchView;
    private RecyclerView rcvSearchedSanPham;



    private FilterProductAdapter filterProductAdapter;

    private List<Product> retrieveProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        setUpListProduct();
        setUpBtnBack();
        setUpActionSearch();
    }


    private void setUpBtnBack() {
        btnBack.setClickable(true);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchActivity.this.onBackPressed();
            }
        });
    }

    private void setUpListProduct() {
        retrieveProductList = new ArrayList<>();
        filterProductAdapter = new FilterProductAdapter(retrieveProductList, this);
        rcvSearchedSanPham.setLayoutManager(new LinearLayoutManager(SearchActivity.this));
        rcvSearchedSanPham.setHasFixedSize(true);
        rcvSearchedSanPham.addItemDecoration(new DividerItemDecoration(SearchActivity.this, VERTICAL));
        rcvSearchedSanPham.setAdapter(filterProductAdapter);

        ProductDao.getInstance().getAllProduct(new IAfterGetAllObject() {
            @Override
            public void iAfterGetAllObject(Object obj) {
                retrieveProductList = (List<Product>) obj;
                filterProductAdapter.setData(retrieveProductList);
            }

            @Override
            public void onError(DatabaseError error) {
                OverUtils.makeToast(SearchActivity.this, ERROR_MESSAGE);
            }
        });
    }

    private void setUpActionSearch() {
        searchView.requestFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterProductAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterProductAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }


    private void initView() {
        btnBack = findViewById(R.id.btnBack);
        searchView = findViewById(R.id.searchView);
        rcvSearchedSanPham = findViewById(R.id.rcvSearchedSanPham);
    }

    @Override
    public void onClickItem(Object obj) {
        String productId = (String) obj;
        Intent intent = new Intent(SearchActivity.this, ShowProductActivity.class);
        intent.putExtra("productId", productId);
        startActivity(intent);
    }

    @Override
    public void onDeleteItem(Object obj) {}

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
