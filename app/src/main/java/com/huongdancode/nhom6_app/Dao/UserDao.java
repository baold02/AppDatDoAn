package com.huongdancode.nhom6_app.Dao;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.huongdancode.nhom6_app.Interface.IAfterGetAllObject;
import com.huongdancode.nhom6_app.Interface.IAfterInsertObject;
import com.huongdancode.nhom6_app.Interface.IAfterUpdateObject;
import com.huongdancode.nhom6_app.Model.DonHang;
import com.huongdancode.nhom6_app.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDao {
    private static UserDao instance;

    private UserDao() {
    }

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }
    public void insertUser(User user, IAfterInsertObject iAfterInsertObject) {
        FirebaseDatabase.getInstance().getReference().child("user").child(user.getUsername())
                .setValue(user, (error, ref) -> {
                    if (error == null) {
                        iAfterInsertObject.onSuccess(user);
                    } else {
                        iAfterInsertObject.onError(error);
                    }
                });
    }

    public void updateUser(User user, Map<String, Object> map, IAfterUpdateObject iAfterUpdateObject) {
        FirebaseDatabase.getInstance().getReference().child("user").child(user.getUsername())
                .updateChildren(map, (error, ref) -> {
                    if (error == null) {
                        iAfterUpdateObject.onSuccess(user); // trả về user đã được update
                    } else {
                        iAfterUpdateObject.onError(error);
                    }
                });
    }

    public void getDonHangByUser(User user, IAfterGetAllObject iAfterGetAllObject) {
        Query query = FirebaseDatabase.getInstance().getReference().child("don_hang")
                .orderByChild("user_id").equalTo(user.getUsername());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<DonHang> donHangList = new ArrayList<>();
                for (DataSnapshot data : snapshot.getChildren()) {
                    DonHang donHang = data.getValue(DonHang.class);
                    if (donHang != null) {
                        donHangList.add(donHang);
                    }
                }
                iAfterGetAllObject.iAfterGetAllObject(donHangList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                iAfterGetAllObject.onError(error);
            }
        });

    }

    public void isDuplicatePhoneNumber(String phone_number, IAfterGetAllObject iAfterGetAllObject) {
        Query query = FirebaseDatabase.getInstance().getReference().child("user").orderByChild("phone_number")
                .equalTo(phone_number);
        query.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DataSnapshot snapshot = task.getResult();
                assert snapshot != null;
                if (snapshot.getChildrenCount() == 0) {
                    iAfterGetAllObject.iAfterGetAllObject(false);
                } else {
                    iAfterGetAllObject.iAfterGetAllObject(true);
                }
            }
        });
    }

    public void getUserByUserName(String userName, IAfterGetAllObject iAfterGetAllObject) {
        FirebaseDatabase.getInstance().getReference().child("user").child(userName)
                .get().addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        DataSnapshot dataSnapshot = task.getResult();
                        if (dataSnapshot != null) {
                            User user = dataSnapshot.getValue(User.class);
                            iAfterGetAllObject.iAfterGetAllObject(user);
                        } else {
                            iAfterGetAllObject.iAfterGetAllObject(null);
                        }
                    } else {
                        iAfterGetAllObject.onError(null);
                    }
                });
    }

    public void isDuplicateUserName(String userName, IAfterGetAllObject iAfterGetAllObject) {
        Query query = FirebaseDatabase.getInstance().getReference().child("user").orderByChild("username")
                .equalTo(userName);
        query.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DataSnapshot snapshot = task.getResult();
                assert snapshot != null;
                if (snapshot.getChildrenCount() == 0) {
                    iAfterGetAllObject.iAfterGetAllObject(false);
                } else {
                    iAfterGetAllObject.iAfterGetAllObject(true);
                }
            } else {
                Log.e("TAG", task.getException().toString() + "");
            }
        });
    }
    public void getUserByUserNameListener(String username, IAfterGetAllObject iAfterGetAllObject) {
        FirebaseDatabase.getInstance().getReference().child("user").child(username)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        User user = snapshot.getValue(User.class);
                        iAfterGetAllObject.iAfterGetAllObject(user);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        iAfterGetAllObject.onError(error);
                    }
                });
    }
}
