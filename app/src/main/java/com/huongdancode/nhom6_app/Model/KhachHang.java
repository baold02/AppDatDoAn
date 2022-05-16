package com.huongdancode.nhom6_app.Model;

public class KhachHang {
    private String maKH;
    private String user;
    private String password;
    private String tenKH;
    private String diaChi;
    private String hinhAnh;
    private String sdt;
    private boolean enable;

    public KhachHang() {
    }

    public KhachHang(String maKH, String user, String password, String tenKH, String diaChi, String hinhAnh, String sdt, boolean enable) {
        this.maKH = maKH;
        this.user = user;
        this.password = password;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.hinhAnh = hinhAnh;
        this.sdt = sdt;
        this.enable = enable;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
