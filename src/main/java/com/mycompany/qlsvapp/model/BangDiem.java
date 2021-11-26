/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlsvapp.model;

/**
 *
 * @author Tuan Tien
 */
public class BangDiem {
    private int ma;
    private String MaSinhVien;
    private float Toan, NgoaiNgu, TinHoc, TrietHoc;

    public BangDiem() {
    }

    public BangDiem(int ma, String MaSinhVien, float Toan, float NgoaiNgu, float TinHoc, float TrietHoc) {
        this.ma = ma;
        this.MaSinhVien = MaSinhVien;
        this.Toan = Toan;
        this.NgoaiNgu = NgoaiNgu;
        this.TinHoc = TinHoc;
        this.TrietHoc = TrietHoc;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getMaSinhVien() {
        return MaSinhVien;
    }

    public void setMaSinhVien(String MaSinhVien) {
        this.MaSinhVien = MaSinhVien;
    }

    public float getToan() {
        return Toan;
    }

    public void setToan(float Toan) {
        this.Toan = Toan;
    }

    public float getNgoaiNgu() {
        return NgoaiNgu;
    }

    public void setNgoaiNgu(float NgoaiNgu) {
        this.NgoaiNgu = NgoaiNgu;
    }

    public float getTinHoc() {
        return TinHoc;
    }

    public void setTinHoc(float TinHoc) {
        this.TinHoc = TinHoc;
    }

    public float getTrietHoc() {
        return TrietHoc;
    }

    public void setTrietHoc(float TrietHoc) {
        this.TrietHoc = TrietHoc;
    }
    
}
