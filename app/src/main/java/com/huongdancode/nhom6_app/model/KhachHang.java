package com.huongdancode.nhom6_app.model;

public class KhachHang {
    private String username;
    private String password;
    private String phone_number;
    private boolean enable;
    private String hinhanh;

    public KhachHang(String username, String password, String phone_number, boolean enable, String hinhanh) {
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.enable = enable;
        this.hinhanh = hinhanh;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
}
