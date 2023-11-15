package com.huongdancode.nhom6_app.LocalDatabase;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.huongdancode.nhom6_app.Model.GioHang;
import com.huongdancode.nhom6_app.Model.User;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class LocalUserDao_Impl implements LocalUserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  private final GioHangTypeConverter __gioHangTypeConverter = new GioHangTypeConverter();

  private final EntityDeletionOrUpdateAdapter<User> __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __updateAdapterOfUser;

  public LocalUserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `User` (`username`,`password`,`phone_number`,`enable`,`hinhanh`,`ma_sp_da_thich`,`gio_hang`,`address`,`name`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getUsername() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUsername());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPassword());
        }
        if (value.getPhone_number() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPhone_number());
        }
        final int _tmp;
        _tmp = value.isEnable() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        if (value.getHinhanh() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getHinhanh());
        }
        final String _tmp_1;
        _tmp_1 = StringTypeConverter.someObjectListToString(value.getMa_sp_da_thich());
        if (_tmp_1 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp_1);
        }
        final String _tmp_2;
        _tmp_2 = __gioHangTypeConverter.gioHangToJson(value.getGio_hang());
        if (_tmp_2 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp_2);
        }
        if (value.getAddress() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getAddress());
        }
        if (value.getName() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getName());
        }
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `User` WHERE `username` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getUsername() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUsername());
        }
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `User` SET `username` = ?,`password` = ?,`phone_number` = ?,`enable` = ?,`hinhanh` = ?,`ma_sp_da_thich` = ?,`gio_hang` = ?,`address` = ?,`name` = ? WHERE `username` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getUsername() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUsername());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPassword());
        }
        if (value.getPhone_number() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPhone_number());
        }
        final int _tmp;
        _tmp = value.isEnable() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        if (value.getHinhanh() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getHinhanh());
        }
        final String _tmp_1;
        _tmp_1 = StringTypeConverter.someObjectListToString(value.getMa_sp_da_thich());
        if (_tmp_1 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp_1);
        }
        final String _tmp_2;
        _tmp_2 = __gioHangTypeConverter.gioHangToJson(value.getGio_hang());
        if (_tmp_2 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp_2);
        }
        if (value.getAddress() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getAddress());
        }
        if (value.getName() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getName());
        }
        if (value.getUsername() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUsername());
        }
      }
    };
  }

  @Override
  public void insert(final User users) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int delete(final User user) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int update(final User user) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<User> getAll() {
    final String _sql = "SELECT * FROM User";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_number");
      final int _cursorIndexOfEnable = CursorUtil.getColumnIndexOrThrow(_cursor, "enable");
      final int _cursorIndexOfHinhanh = CursorUtil.getColumnIndexOrThrow(_cursor, "hinhanh");
      final int _cursorIndexOfMaSpDaThich = CursorUtil.getColumnIndexOrThrow(_cursor, "ma_sp_da_thich");
      final int _cursorIndexOfGioHang = CursorUtil.getColumnIndexOrThrow(_cursor, "gio_hang");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item;
        _item = new User();
        final String _tmpUsername;
        if (_cursor.isNull(_cursorIndexOfUsername)) {
          _tmpUsername = null;
        } else {
          _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        }
        _item.setUsername(_tmpUsername);
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        _item.setPassword(_tmpPassword);
        final String _tmpPhone_number;
        if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
          _tmpPhone_number = null;
        } else {
          _tmpPhone_number = _cursor.getString(_cursorIndexOfPhoneNumber);
        }
        _item.setPhone_number(_tmpPhone_number);
        final boolean _tmpEnable;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEnable);
        _tmpEnable = _tmp != 0;
        _item.setEnable(_tmpEnable);
        final String _tmpHinhanh;
        if (_cursor.isNull(_cursorIndexOfHinhanh)) {
          _tmpHinhanh = null;
        } else {
          _tmpHinhanh = _cursor.getString(_cursorIndexOfHinhanh);
        }
        _item.setHinhanh(_tmpHinhanh);
        final List<String> _tmpMa_sp_da_thich;
        final String _tmp_1;
        if (_cursor.isNull(_cursorIndexOfMaSpDaThich)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getString(_cursorIndexOfMaSpDaThich);
        }
        _tmpMa_sp_da_thich = StringTypeConverter.stringToSomeObjectList(_tmp_1);
        _item.setMa_sp_da_thich(_tmpMa_sp_da_thich);
        final List<GioHang> _tmpGio_hang;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfGioHang)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfGioHang);
        }
        _tmpGio_hang = __gioHangTypeConverter.jsonToGioHang(_tmp_2);
        _item.setGio_hang(_tmpGio_hang);
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        _item.setAddress(_tmpAddress);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public User getUser(final String id) {
    final String _sql = "SELECT * FROM User WHERE username LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_number");
      final int _cursorIndexOfEnable = CursorUtil.getColumnIndexOrThrow(_cursor, "enable");
      final int _cursorIndexOfHinhanh = CursorUtil.getColumnIndexOrThrow(_cursor, "hinhanh");
      final int _cursorIndexOfMaSpDaThich = CursorUtil.getColumnIndexOrThrow(_cursor, "ma_sp_da_thich");
      final int _cursorIndexOfGioHang = CursorUtil.getColumnIndexOrThrow(_cursor, "gio_hang");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final User _result;
      if(_cursor.moveToFirst()) {
        _result = new User();
        final String _tmpUsername;
        if (_cursor.isNull(_cursorIndexOfUsername)) {
          _tmpUsername = null;
        } else {
          _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        }
        _result.setUsername(_tmpUsername);
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        _result.setPassword(_tmpPassword);
        final String _tmpPhone_number;
        if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
          _tmpPhone_number = null;
        } else {
          _tmpPhone_number = _cursor.getString(_cursorIndexOfPhoneNumber);
        }
        _result.setPhone_number(_tmpPhone_number);
        final boolean _tmpEnable;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEnable);
        _tmpEnable = _tmp != 0;
        _result.setEnable(_tmpEnable);
        final String _tmpHinhanh;
        if (_cursor.isNull(_cursorIndexOfHinhanh)) {
          _tmpHinhanh = null;
        } else {
          _tmpHinhanh = _cursor.getString(_cursorIndexOfHinhanh);
        }
        _result.setHinhanh(_tmpHinhanh);
        final List<String> _tmpMa_sp_da_thich;
        final String _tmp_1;
        if (_cursor.isNull(_cursorIndexOfMaSpDaThich)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getString(_cursorIndexOfMaSpDaThich);
        }
        _tmpMa_sp_da_thich = StringTypeConverter.stringToSomeObjectList(_tmp_1);
        _result.setMa_sp_da_thich(_tmpMa_sp_da_thich);
        final List<GioHang> _tmpGio_hang;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfGioHang)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfGioHang);
        }
        _tmpGio_hang = __gioHangTypeConverter.jsonToGioHang(_tmp_2);
        _result.setGio_hang(_tmpGio_hang);
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        _result.setAddress(_tmpAddress);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _result.setName(_tmpName);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
