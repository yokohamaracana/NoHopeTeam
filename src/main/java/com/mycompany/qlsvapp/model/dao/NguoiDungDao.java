/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlsvapp.model.dao;

import com.mycompany.qlsvapp.helper.Database;
import com.mycompany.qlsvapp.model.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tuan Tien
 */
public class NguoiDungDao {
    public boolean insert(NguoiDung nd) throws Exception{
        
        String sql = "INSERT INTO [dbo].[NguoiDung]([TenDangNhap],[MatKhau],[Quyen]) values(?,?,?)";
        try (
            Connection con = Database.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ){
            pstmt.setString(1, nd.getTenDangNhap());
            pstmt.setString(2, nd.getMatKhau());
            pstmt.setString(3, nd.getQuyen());
            
            return pstmt.executeUpdate()>0;
            
        }
    }
    public boolean update(NguoiDung nd) throws Exception{
        
        String sql = "UPDATE [dbo].[NguoiDung]" +
                " SET [MatKhau] = ?,[Quyen] = ?" +
                " WHERE [TenDangNhap] = ?";
        try (
            Connection con = Database.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ){
            pstmt.setString(3, nd.getTenDangNhap());
            pstmt.setString(1, nd.getMatKhau());
            pstmt.setString(2, nd.getQuyen());
            
            return pstmt.executeUpdate()>0;
            
        }
    }
    public boolean deleteUser(String tenDangNhap) throws Exception{
        
        String sql = " delete from nguoidung"+
                " Where [TenDangNhap] = ?";
        try (
            Connection con = Database.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ){
            pstmt.setString(1,tenDangNhap);
            
            return pstmt.executeUpdate()>0;
            
        }
    }
    public NguoiDung findById(String tenDangNhap) throws Exception{
        String sql = "select * from nguoidung where [TenDangNhap] =?";
        try (
            Connection con = Database.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ){
            pstmt.setString(1, tenDangNhap);
           try(ResultSet rs = pstmt.executeQuery();){
               if (rs.next()) {
                   NguoiDung nd = createSinhVien(rs);
                   return nd;
               }
           }
            return null;
        }
    }

    private NguoiDung createSinhVien(final ResultSet rs) throws SQLException {
        NguoiDung nd = new NguoiDung();
        nd.setTenDangNhap(rs.getString("TenDangNhap"));
        nd.setMatKhau(rs.getString("MatKhau"));
        nd.setQuyen(rs.getString("Quyen"));
        
        return nd;
    }
    public List< NguoiDung> findAll() throws Exception{
        String sql = "select * from nguoidung";
        try (
            Connection con = Database.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ){
           try(ResultSet rs = pstmt.executeQuery();){
               List<NguoiDung> list = new ArrayList<>();
               while (rs.next()) {
                   NguoiDung nd = createSinhVien(rs);
                   list.add(nd);
               }
               return list;
           }
        }
    }
    public NguoiDung checkLogin(String TenDangNhap, String MatKhau) throws Exception{
        String sql = "select tenDangNhap, matKhau, quyen from nguoidung"
                + " where tendangnhap = ? and matkhau = ?";
        try (
            Connection con = Database.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ){
            pstmt.setString(1, TenDangNhap);
            pstmt.setString(2, MatKhau);
            
            try(ResultSet rs = pstmt.executeQuery();){
                if (rs.next()){
                    NguoiDung nd = new NguoiDung();
                    nd.setTenDangNhap(TenDangNhap);
                    nd.setQuyen(rs.getString("quyen"));
                    return nd;
                }
            }
        }
        return null;
    }
}
