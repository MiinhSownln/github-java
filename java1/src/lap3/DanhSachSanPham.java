/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lap3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.util.Scanner;

/**
 *
 * @author 24dom
 */
public class DanhSachSanPham {
    
    Scanner sc = new Scanner(System.in);
    List<SanPham> list = new ArrayList<>();
    
    public void menu() {
        
        Scanner sc = new Scanner(System.in);
        int choose;
        do {
            System.out.println("Danh sach menu");
            System.out.println("1.Nhap danh sach");
            System.out.println("2.Xuat danh sach");
            System.out.println("0.Exit");
            System.out.println("Moi ban nhap: ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    input();
                    break;
                case 2:
                    output();
                    break;
                case 3:
                    sapXepNgauNhien();
                    break;
                case 4:
                    sapXep();
                    break;
                case 5:
                    find();
                    break;
                    
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Moi ban chon dung");
            }
        } while (choose != 0);
    }
    
    public void input() {
        while (true) {
            System.out.println("Moi ban nhap ma: ");
            String ma = sc.nextLine();
            System.out.println("Nhap ten: ");
            String name = sc.nextLine();
            System.out.println("Nhap gia: ");
            double price = Double.parseDouble(sc.nextLine());
            System.out.println("ban muon nhap tiep k(y/n): ");
            
            SanPham sp = new SanPham(ma, name, price);
            list.add(sp);
            if (sc.nextLine().equalsIgnoreCase("n")) {
                break;
            }
        }
    }
    
    public void output() {
        for (SanPham sp : list) {
            System.out.println("Ma san pham la: " + sp.getMaSp());
            System.out.println("Ten san pham la: " + sp.getTenSp());
            System.out.println("Gia cua san pham la: " + sp.getGia());
            System.out.println("Thue: " + sp.thue());
        }
    }
    
    public void sapXepNgauNhien() {
        Collections.shuffle(list);
        output();
    }

    public void sapXep() {
        Comparator<SanPham> comp = new Comparator<SanPham>() {
            @Override
            public int compare(SanPham o1, SanPham o2) {
                return Double.compare(o1.getGia(), o2.getGia());
            }
        };
        Collections.sort(list, comp);
        output();
    }
    public void find(){
        System.out.println("Nhap ma muon tim: ");
        String id=sc.nextLine();
        for(SanPham sp:list){
            if(id.equals(sp.getMaSp())){
                sp.xuat();
            }
        }
                
    }
    
}
