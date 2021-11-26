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

/**
 *
 * @author Tuan Tien
 */
public class NguoiDungDao {
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
