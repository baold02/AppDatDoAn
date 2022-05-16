package com.huongdancode.nhom6_app.model;

public class LoaiSP {
    private String id;
    private String name;
    private String hinhanh;
    private int soSanPhamThuocLoai;

    public LoaiSP(String id, String name, String hinhanh, int soSanPhamThuocLoai) {
        this.id = id;
        this.name = name;
        this.hinhanh = hinhanh;
        this.soSanPhamThuocLoai = soSanPhamThuocLoai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getSoSanPhamThuocLoai() {
        return soSanPhamThuocLoai;
    }

    public void setSoSanPhamThuocLoai(int soSanPhamThuocLoai) {
        this.soSanPhamThuocLoai = soSanPhamThuocLoai;
    }
}
