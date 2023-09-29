/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chucvu;

/**
 *
 * @author 24dom
 */
public class thongtin {

    private String maNV, hoTen, ngaySinh, gioiTinh;
    private CHUCVU maChucvu;

    public thongtin() {
    }

    public thongtin(String maNV, String hoTen, String ngaySinh, String gioiTinh, CHUCVU maChucvu) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.maChucvu = maChucvu;
    }
    

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public CHUCVU getMaChucvu() {
        return maChucvu;
    }

    public void setMaChucvu(CHUCVU maChucvu) {
        this.maChucvu = maChucvu;
    }

    public Object[] toData() {
        return new Object[]{
            this.maNV, this.hoTen, this.ngaySinh, this.gioiTinh
        };
    }
}
