package com.huongdancode.nhom6_app.Model;

public class LoaiSP {
    private String maLoai;
    private String tenLoai;
    private String hinhanh;

    public LoaiSP() {
    }

    public LoaiSP(String maLoai, String tenLoai, String hinhanh) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.hinhanh = hinhanh;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
}
