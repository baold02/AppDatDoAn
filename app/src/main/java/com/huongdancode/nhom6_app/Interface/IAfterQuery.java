package com.huongdancode.nhom6_app.Interface;

import com.google.firebase.database.DatabaseError;

public interface IAfterQuery {
    void onResult(Object obj);
    void onError(DatabaseError error);
}
