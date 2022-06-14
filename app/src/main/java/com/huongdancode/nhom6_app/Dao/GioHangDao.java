package com.huongdancode.nhom6_app.Dao;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.huongdancode.nhom6_app.Interface.IAfterGetAllObject;
import com.huongdancode.nhom6_app.Interface.IAfterInsertObject;
import com.huongdancode.nhom6_app.Model.GioHang;
import com.huongdancode.nhom6_app.Model.User;

import java.util.ArrayList;
import java.util.List;

public class GioHangDao {
    private static GioHangDao instance;

    private GioHangDao() {
    }

    public static GioHangDao getInstance() {
        if (instance == null) {
            instance = new GioHangDao();
        }
        return instance;
    }

    public void getAllGioHang(User user, IAfterGetAllObject iAfterGetAllObject) {
        FirebaseDatabase.getInstance().getReference().child("user")
                .child(user.getUsername()).child("gio_hang")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        List<GioHang> gioHangList = new ArrayList<>();
                        for (DataSnapshot data : snapshot.getChildren()) {
                            GioHang gioHang = data.getValue(GioHang.class);
                            if (gioHang != null) {
                                gioHangList.add(gioHang);
                            }
                        }
                        iAfterGetAllObject.iAfterGetAllObject(gioHangList);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        iAfterGetAllObject.onError(error);
                    }
                });
    }


    /**
     * Dùng cho cả update và delete
     *
     * @param user
     * @param gioHangList
     * @param iAfterInsertObject
     */
    public void insertGioHang(User user, List<GioHang> gioHangList, IAfterInsertObject iAfterInsertObject) {
        FirebaseDatabase.getInstance().getReference().child("user")
                .child(user.getUsername()).child("gio_hang")
                .setValue(gioHangList, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        if (error == null) {
                            iAfterInsertObject.onSuccess(gioHangList);
                        } else {
                            iAfterInsertObject.onError(error);
                        }
                    }
                });
    }
}
