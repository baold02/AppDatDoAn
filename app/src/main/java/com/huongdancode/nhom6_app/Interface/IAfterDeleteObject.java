package com.huongdancode.nhom6_app.Interface;

import com.google.firebase.database.DatabaseError;

public interface IAfterDeleteObject {
    void onSuccess(Object obj);
    void onError(DatabaseError error);
}
