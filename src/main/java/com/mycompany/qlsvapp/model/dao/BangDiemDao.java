/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlsvapp.model.dao;

import com.mycompany.qlsvapp.helper.Database;
import com.mycompany.qlsvapp.model.BangDiem;
import com.mycompany.qlsvapp.model.SinhVien;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author Phuc Toan, Trung Hau, Duc Duy, Anh Tri
 */
public class BangDiemDao {
    public boolean insert(BangDiem bd) throws Exception{
        
        String sql = "INSERT INTO [dbo].[BangDiem]([MaSinhVien],[Toan],[NgoaiNgu],[TinHoc],[TrietHoc]) values(?,?,?,?,?)";
        try (
            Connection con = Database.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ){
            pstmt.setString(1, bd.getMaSinhVien());
            pstmt.setFloat(2, bd.getToan());
            pstmt.setFloat(3, bd.getNgoaiNgu());
            pstmt.setFloat(4, bd.getTinHoc());
            pstmt.setFloat(5, bd.getTrietHoc());
            
            return pstmt.executeUpdate()>0;
            
        }
    }
 	public boolean deleteMaSinhVien(String maSinhVien) throws Exception{
        
        String sql = "delete from bangdiem"+
                " Where [MaSinhVien] = ?";
        try (
            Connection con = Database.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ){
            pstmt.setString(1,maSinhVien);
            
            return pstmt.executeUpdate()>0;
            
        }
    }
    
}
