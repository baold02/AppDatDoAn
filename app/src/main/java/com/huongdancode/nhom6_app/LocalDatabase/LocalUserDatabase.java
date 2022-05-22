package com.huongdancode.nhom6_app.LocalDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.huongdancode.nhom6_app.Model.User;

@Database(entities = {User.class}, version = 1)
public abstract class LocalUserDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "User.db";
    private static LocalUserDatabase instance;

    public synchronized static LocalUserDatabase getInstance(Context context) {
        if (instance == null) {
            instance =
                    Room.databaseBuilder(context, LocalUserDatabase.class, DATABASE_NAME)
                            .allowMainThreadQueries()
                            .build();
        }
        return instance;
    }

    public abstract LocalUserDao getUserDao();
}
