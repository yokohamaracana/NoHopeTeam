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
    public boolean update(BangDiem bd) throws Exception{
        
        String sql = "UPDATE [dbo].[BangDiem]" +
                " SET [Toan] = ?,[NgoaiNgu] = ?,[TinHoc] = ?,[TrietHoc] = ?" +
                " WHERE [MaSinhVien] = ?";
        try (
            Connection con = Database.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ){
            pstmt.setString(5, bd.getMaSinhVien());
            pstmt.setFloat(1, bd.getToan());
            pstmt.setFloat(2, bd.getNgoaiNgu());
            pstmt.setFloat(3, bd.getTinHoc());
            pstmt.setFloat(4, bd.getTrietHoc());
            
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
    public List<BangDiem> findAll() throws Exception{
        String sql = "select * from bangdiem";
        try (
            Connection con = Database.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ){
            try(ResultSet rs = pstmt.executeQuery();){
                List<BangDiem> list = new ArrayList<>();
                while(rs.next()) {
                    BangDiem bd = creatBangDiem(rs);
                    list.add(bd);
                }
                return list;
            }
        }
    }
    public List<BangDiem> findTop(int top) throws Exception{
        String sql = "select top "+ top +" *, (Toan + NgoaiNgu + TinHoc + TrietHoc)/4 as DTB" +
                    " from BangDiem order by DTB desc";
        try (
            Connection con = Database.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ){
            try(ResultSet rs = pstmt.executeQuery();){
                List<BangDiem> list = new ArrayList<>();
                while(rs.next()) {
                    BangDiem bd = creatBangDiem(rs);
                    list.add(bd);
                }
                return list;
            }
        }
    }

    private BangDiem creatBangDiem(final ResultSet rs) throws SQLException {
        BangDiem bd = new BangDiem();
        bd.setMa(rs.getInt("Ma"));
        bd.setMaSinhVien(rs.getString("maSinhVien"));
        bd.setToan(rs.getFloat("Toan"));
        bd.setNgoaiNgu(rs.getFloat("NgoaiNgu"));
        bd.setTinHoc(rs.getFloat("TinHoc"));
        bd.setTrietHoc(rs.getFloat("TrietHoc"));
        return bd;
    }

    public BangDiem findByMaSinhVien(String maSinhVien) throws Exception{
        
        String sql = "select * from bangdiem where [MaSinhVien] = ?";
        try (
            Connection con = Database.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ){
            pstmt.setString(1,maSinhVien);
            
            try(ResultSet rs = pstmt.executeQuery();){
                if(rs.next()) {
                    BangDiem bd = creatBangDiem(rs);
                    return bd;
                }
            }
            return null;
        }
    }
    
}
