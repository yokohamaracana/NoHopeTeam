/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlsvapp.model.dao;

import com.mycompany.qlsvapp.helper.Database;
import com.mycompany.qlsvapp.model.NguoiDung;
import com.mycompany.qlsvapp.model.SinhVien;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author Tuan Tien
 */
public class SinhVienDao {
    public boolean insert(SinhVien sv) throws Exception{
        String sql = "INSERT INTO dbo.SinhVien(MaSinhVien,HoTen,Email,SoDT,GioiTinh,DiaChi,Hinh)"
                + "values(?,?,?,?,?,?,?)";
        try (
            Connection con = Database.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ){
            pstmt.setString(1, sv.getMaSinhVien());
            pstmt.setString(2, sv.getHoTen());
            pstmt.setString(3, sv.getEmail());
            pstmt.setString(4, sv.getSoDT());
            pstmt.setInt(5, sv.getGioiTinh());
            pstmt.setString(6, sv.getDiaChi());
            
            if (sv.getHinh() != null) {
                Blob hinh = new SerialBlob(sv.getHinh());
                pstmt.setBlob(7, hinh);
            }
            else{
                Blob hinh = null;
                pstmt.setBlob(7, hinh);
            }
            return pstmt.executeUpdate()>0;
        }
    }
    
}
