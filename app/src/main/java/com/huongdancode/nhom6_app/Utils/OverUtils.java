package com.huongdancode.nhom6_app.Utils;

import static android.content.Context.MODE_PRIVATE;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import com.huongdancode.nhom6_app.LocalDatabase.LocalUserDatabase;
import com.huongdancode.nhom6_app.Model.User;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class OverUtils {
    public static final String HOAT_DONG = "HOAT_DONG";
    public static final String DUNG_KINH_DOANH = "DUNG_KINH_DOANH";
    public static final String HET_HANG = "HET_HANG";
    public static final String SAP_RA_MAT = "SAP_RA_MAT";

    public static final String FROM_SHOW_PRODUCT = "FROM_SHOW_PRODUCT";

    private static SharedPreferences sharedPreferences;

    public static final String PASS_FILE = "PASS_FILE";
    public static final String ACCOUNT_FILE = "ACCOUNT_FILE";

    public static final String PASS_LOGIN_ACTIVITY = "PASS_LOGIN";
    public static final String NO_PASS = "NO_PASS";
    public static final String PASS_FLASH_ACTIVITY = "PASS_FLASH_ACTIVITY";

    public final static int TYPE_PHO_BIEN_ADAPTER = 0;
    public final static int TYPE_KHUYEN_MAI_ADAPTER = 1;
    public final static int TYPE_SP_MOI_ADAPTER = 2;

    public final static String GO_TO_ORDER_FROFILE_FRAGMENT="GO TO FROFILE FRAMENT";
    public final static String GO_TO_ORDER_FRAGMENT = "GO TO ORDER FRAGMENT";

    private static Locale locale = new Locale("vi", "VN");
    public static NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
    public static NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
    public static final String ERROR_MESSAGE = "Lỗi thực hiện";

    private static SimpleDateFormat simpleDateFormat;

    public static SimpleDateFormat getSimpleDateFormat() {
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat("hh:mm * dd/MM/yyyy");
        }
        return simpleDateFormat;
    }
    public static SharedPreferences getSPInstance(Context context, String nameFile) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(nameFile, MODE_PRIVATE);
        }
        return sharedPreferences;
    }

    public static void makeToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
    public static String getExtensionFile(Context context, Uri uri) {
        ContentResolver cr = context.getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(uri));
    }
    public static User getUserLogin(Context context) {
        List<User> userList = LocalUserDatabase.getInstance(context).getUserDao().getAll();
        return userList.get(0);
    }
}
