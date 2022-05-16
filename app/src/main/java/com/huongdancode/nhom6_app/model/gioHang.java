package com.huongdancode.nhom6_app.model;

public class gioHang {
    private String MaSP;
    private int SoLuong;

    public gioHang(String maSP, int soLuong) {
        MaSP = maSP;
        SoLuong = soLuong;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String maSP) {
        MaSP = maSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }
}
