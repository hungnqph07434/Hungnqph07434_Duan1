package com.poly.hungnqph07434_duan1.model;

public class NguoiChoi {

    private String ten;
    private int diem;

    public NguoiChoi(String ten, int diem) {
        this.ten = ten;
        this.diem = diem;
    }

    public NguoiChoi() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }
}
