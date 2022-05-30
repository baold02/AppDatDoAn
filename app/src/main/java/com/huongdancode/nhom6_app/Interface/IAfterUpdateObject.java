package com.huongdancode.nhom6_app.Interface;

import com.google.firebase.database.DatabaseError;

public interface IAfterUpdateObject {
    void onSuccess(Object obj);
    void onError(DatabaseError error);
}
