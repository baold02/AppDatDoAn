package com.huongdancode.nhom6_app.model;

public class Product {
    private String id;
    private String name;
    private String image;
    private String bao_quan;
    private String thong_tin_bao_quan;
    private String mota;
    private String loai_sp;
    private int thoiGianCheBien;
    private int gia_ban;
    private float khuyen_mai;
    private int rate;
    private String khau_phan;
    private int so_luong_da_ban;
    private String trang_thai;

    public Product(String id, String name, String image, String bao_quan, String thong_tin_bao_quan, String mota, String loai_sp, int thoiGianCheBien, int gia_ban, float khuyen_mai, int rate, String khau_phan, int so_luong_da_ban, String trang_thai) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.bao_quan = bao_quan;
        this.thong_tin_bao_quan = thong_tin_bao_quan;
        this.mota = mota;
        this.loai_sp = loai_sp;
        this.thoiGianCheBien = thoiGianCheBien;
        this.gia_ban = gia_ban;
        this.khuyen_mai = khuyen_mai;
        this.rate = rate;
        this.khau_phan = khau_phan;
        this.so_luong_da_ban = so_luong_da_ban;
        this.trang_thai = trang_thai;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBao_quan() {
        return bao_quan;
    }

    public void setBao_quan(String bao_quan) {
        this.bao_quan = bao_quan;
    }

    public String getThong_tin_bao_quan() {
        return thong_tin_bao_quan;
    }

    public void setThong_tin_bao_quan(String thong_tin_bao_quan) {
        this.thong_tin_bao_quan = thong_tin_bao_quan;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getLoai_sp() {
        return loai_sp;
    }

    public void setLoai_sp(String loai_sp) {
        this.loai_sp = loai_sp;
    }

    public int getThoiGianCheBien() {
        return thoiGianCheBien;
    }

    public void setThoiGianCheBien(int thoiGianCheBien) {
        this.thoiGianCheBien = thoiGianCheBien;
    }

    public int getGia_ban() {
        return gia_ban;
    }

    public void setGia_ban(int gia_ban) {
        this.gia_ban = gia_ban;
    }

    public float getKhuyen_mai() {
        return khuyen_mai;
    }

    public void setKhuyen_mai(float khuyen_mai) {
        this.khuyen_mai = khuyen_mai;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getKhau_phan() {
        return khau_phan;
    }

    public void setKhau_phan(String khau_phan) {
        this.khau_phan = khau_phan;
    }

    public int getSo_luong_da_ban() {
        return so_luong_da_ban;
    }

    public void setSo_luong_da_ban(int so_luong_da_ban) {
        this.so_luong_da_ban = so_luong_da_ban;
    }

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }
}