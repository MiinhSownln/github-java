/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 24dom
 */
public class XeMay {
    private String maXe,loaiXe,mauXe;
    private int soPhanKhoi;
    private float giaBan;

    public XeMay() {
    }

    public XeMay(String maXe, String loaiXe, int soPhanKhoi, String mauXe, float giaBan) {
        this.maXe = maXe;
        this.loaiXe = loaiXe;
        this.mauXe = mauXe;
        this.soPhanKhoi = soPhanKhoi;
        this.giaBan = giaBan;
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public String getMauXe() {
        return mauXe;
    }

    public void setMauXe(String mauXe) {
        this.mauXe = mauXe;
    }

    public int getSoPhanKhoi() {
        return soPhanKhoi;
    }

    public void setSoPhanKhoi(int soPhanKhoi) {
        this.soPhanKhoi = soPhanKhoi;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }
    
    public Object[] toDaTaRow(){
        return new Object[]{
            this.maXe,this.loaiXe,this.soPhanKhoi,this.mauXe,this.giaBan
        };
    }
    
            
}
