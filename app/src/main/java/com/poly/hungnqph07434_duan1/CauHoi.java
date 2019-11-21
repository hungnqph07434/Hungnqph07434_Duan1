package com.poly.hungnqph07434_duan1;

public class CauHoi {

    private String cauHoi, dapAnA, dapAnB, dapAnC, dapAnD, dapAnDung;

    public CauHoi() {
    }

    public CauHoi(String cauHoi, String dapAnA, String dapAnB, String dapAnC, String dapAnD, String dapAnDung) {
        this.cauHoi = cauHoi;
        this.dapAnA = dapAnA;
        this.dapAnB = dapAnB;
        this.dapAnC = dapAnC;
        this.dapAnD = dapAnD;
        this.dapAnDung = dapAnDung;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getDapAnA() {
        return dapAnA;
    }

    public void setDapAnA(String dapAnA) {
        this.dapAnA = dapAnA;
    }

    public String getDapAnB() {
        return dapAnB;
    }

    public void setDapAnB(String dapAnB) {
        this.dapAnB = dapAnB;
    }

    public String getDapAnC() {
        return dapAnC;
    }

    public void setDapAnC(String dapAnC) {
        this.dapAnC = dapAnC;
    }

    public String getDapAnD() {
        return dapAnD;
    }

    public void setDapAnD(String dapAnD) {
        this.dapAnD = dapAnD;
    }

    public String getDapAnDung() {
        return dapAnDung;
    }

    public void setDapAnDung(String dapAnDung) {
        this.dapAnDung = dapAnDung;
    }

    @Override
    public String toString() {
        return "CauHoi{" +
                "cauHoi='" + cauHoi + '\'' +
                ", dapAnA='" + dapAnA + '\'' +
                ", dapAnB='" + dapAnB + '\'' +
                ", dapAnC='" + dapAnC + '\'' +
                ", dapAnD='" + dapAnD + '\'' +
                ", dapAnDung='" + dapAnDung + '\'' +
                '}';
    }
}
