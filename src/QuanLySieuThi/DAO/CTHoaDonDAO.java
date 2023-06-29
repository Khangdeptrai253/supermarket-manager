/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLySieuThi.DAO;

import QuanLySieuThi.DTO.CTHoaDon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class CTHoaDonDAO {

    public ArrayList<CTHoaDon> getListCTHoaDon() {
        ArrayList<CTHoaDon> dscthd = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cthoadon";
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                CTHoaDon cthd = new CTHoaDon();
                cthd.setMaHD(rs.getInt(1));
                cthd.setMaSP(rs.getInt(2));
                cthd.setSoLuong(rs.getInt(3));
                cthd.setDonGia(rs.getInt(4));
                cthd.setThanhTien(rs.getInt(5));
                dscthd.add(cthd);
            }
        } catch(SQLException ex) {
        }
        return dscthd;
    }

    public ArrayList<CTHoaDon> getListCTHoaDonTheoMaHD(int maHD) {
        ArrayList<CTHoaDon> dscthd = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cthoadon WHERE MaHD="+maHD;
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                CTHoaDon cthd = new CTHoaDon();
                cthd.setMaHD(rs.getInt(1));
                cthd.setMaSP(rs.getInt(2));
                cthd.setSoLuong(rs.getInt(3));
                cthd.setDonGia(rs.getInt(4));
                cthd.setThanhTien(rs.getInt(5));
                dscthd.add(cthd);
            }
        } catch(SQLException ex) {
            return null;
        }
        return dscthd;
    }

    public ArrayList<CTHoaDon> getListCTHoaDonTheoMaSP(int maSP) {
        ArrayList<CTHoaDon> dscthd = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cthoadon WHERE MaSP="+maSP;
            Statement stmt = MyConnect.conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                CTHoaDon cthd = new CTHoaDon();
                cthd.setMaHD(rs.getInt(1));
                cthd.setMaSP(rs.getInt(2));
                cthd.setSoLuong(rs.getInt(3));
                cthd.setDonGia(rs.getInt(4));
                cthd.setThanhTien(rs.getInt(5));
                dscthd.add(cthd);
            }
        } catch(SQLException ex) {
            return null;
        }
        return dscthd;
    }

    public boolean addCTHoaDon(CTHoaDon cthd) {
        boolean result = false;
        try {
            String sql = "INSERT INTO cthoadon VALUES(?,?,?,?,?)";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, cthd.getMaHD());
            prep.setInt(2, cthd.getMaSP());
            prep.setInt(3, cthd.getSoLuong());
            prep.setInt(4, cthd.getDonGia());
            prep.setInt(5, cthd.getThanhTien());
            result = prep.executeUpdate() > 0;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return result;
    }

    public boolean deleteCTHoaDon(int maHD, int maSP) {
        boolean result = false;
        try {
            String sql = "DELETE FROM cthoadon WHERE MaHD="+maHD+" AND MaSP="+maSP;
            Statement stmt = MyConnect.conn.createStatement();
            result = stmt.executeUpdate(sql) > 0;
        } catch(SQLException ex) {
            return false;
        }
        return result;
    }

    public boolean deleteCTHoaDon(int maHD) {
        boolean result = false;
        try {
            String sql = "DELETE FROM cthoadon WHERE MaHD="+maHD;
            Statement stmt = MyConnect.conn.createStatement();
            result = stmt.executeUpdate(sql) > 0;
        } catch(SQLException ex) {
            return false;
        }
        return result;
    }

    public boolean updateCTHoaDon(int maHD, int maSP, CTHoaDon cthd) {
        boolean result = false;
        try {
            String sql = "UPDATE cthoadon SET MaHD=?, MaSP=?, SoLuong=?, DonGia=? ThanhTien=? "
                    + "WHERE MaHD=? AND MaSP=?";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, cthd.getMaHD());
            prep.setInt(2, cthd.getMaSP());
            prep.setInt(3, cthd.getSoLuong());
            prep.setInt(4, cthd.getDonGia());
            prep.setInt(5, cthd.getThanhTien());
            prep.setInt(6, maHD);
            prep.setInt(7, maSP);
            result = prep.executeUpdate() > 0;
        } catch(SQLException ex) {
            return false;
        }
        return result;
    }
}
