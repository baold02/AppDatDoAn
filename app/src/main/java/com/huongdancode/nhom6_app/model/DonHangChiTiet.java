package com.huongdancode.nhom6_app.model;

public class DonHangChiTiet {
    private Product product;
    private int so_luong;

    public DonHangChiTiet(Product product, int so_luong) {
        this.product = product;
        this.so_luong = so_luong;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }
}
