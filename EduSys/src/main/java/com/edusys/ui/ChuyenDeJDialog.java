/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.edusys.ui;

import com.edusys.dao.ChuyenDeDAO;
import com.edusys.entity.NhanVien;
import com.edusys.util.MsgBox;
import com.edusys.util.XImage;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import com.edusys.dao.NhanVienDAO;
import com.edusys.entity.ChuyenDe;
import com.edusys.util.Auth;
import com.sun.source.tree.BreakTree;
import java.awt.Image;
import javax.swing.JOptionPane;

/**
 *
 * @author 24dom
 */
public class ChuyenDeJDialog extends javax.swing.JDialog {

    String str = null;
    ChuyenDeDAO dao = new ChuyenDeDAO();
    JFileChooser fileChoose = new JFileChooser();
    int row = 0;

    /**
     * Creates new form ChuyenDeJDialog
     */
    public ChuyenDeJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        init();
    }

    void init() {
        setIconImage((XImage.getAppIcon()));
        setLocationRelativeTo(null);
        setTitle("Quan ly nhan vien");
        updateStatus();
        fillTable();

    }

    boolean check() {

        if (txtMaCD.getText().isEmpty() || txtTenCD.getText().isEmpty() || txtMoTa.getText().isEmpty()
                || txtHocPhi.getText().isEmpty() || txtThoiLuong.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui long k de trong");
            return false;

        } else {
            try {
                if (Double.parseDouble(txtHocPhi.getText()) < 0 && Integer.parseInt(txtThoiLuong.getText()) < 0) {
                    JOptionPane.showMessageDialog(this, "K the <0");
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Du kieu k phu hop");
                return false;
            }
        }
        if (lblHinhAnh.getIcon() == null) {
            JOptionPane.showMessageDialog(this, "vui long chon anh");
            return false;
        }
        return true;

    }

    void chonAnh() {
        if (fileChoose.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChoose.getSelectedFile();
            if (XImage.save(file)) {
                ImageIcon icon = XImage.read(file.getName());
                lblHinhAnh.setIcon(icon);
                lblHinhAnh.setToolTipText(file.getName());
            }
        }
    }

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblChuyenDe.getModel();
        model.setRowCount(0);
        try {
            List<ChuyenDe> list = dao.selectAll();
            for (ChuyenDe cd : list) {
                Object[] row = {cd.getMaCD(), cd.getTenCD(), cd.getHocPhi(), cd.getThoiLuong(), cd.getHinh(), cd.getMoTa()};
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Loi truy van");
        }
    }

    void edit() {
        try {
            String maCd = (String) tblChuyenDe.getValueAt(this.row, 0);
            ChuyenDe model = dao.selectById(maCd);
            if (model != null) {
                setForm(model);
                updateStatus();
                tabs.setSelectedIndex(0);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "loi truy van");
        }
    }

//    void setForm(ChuyenDe model) {
//        txtMaCD.setText(model.getMaCD());
//        txtTenCD.setText(model.getTenCD());
//        txtHocPhi.setText(String.valueOf(model.getHocPhi()));
//        txtThoiLuong.setText(String.valueOf(model.getThoiLuong()));
//        txtMoTa.setText(model.getMoTa());
//        String image = model.getHinh();
//        if (!image.equals("")) {
//            lblHinhAnh.setIcon(XImage.read(model.getHinh()));
//            lblHinhAnh.setToolTipText(model.getHinh());
//        } else {
//            lblHinhAnh.setIcon(null);
//            lblHinhAnh.setToolTipText(null);
//        }
//
//    }
    void setForm(ChuyenDe cd) {
        txtMaCD.setText(cd.getMaCD());
        txtTenCD.setText(cd.getTenCD());
        txtHocPhi.setText(String.valueOf(cd.getHocPhi()));
        txtThoiLuong.setText(String.valueOf(cd.getThoiLuong()));
        txtMoTa.setText(cd.getMoTa());
        if (cd.getHinh() != null) {
            lblHinhAnh.setToolTipText(cd.getHinh());
            lblHinhAnh.setIcon(XImage.read(cd.getHinh()));
        }

    }

    void reset() {
        txtMaCD.setText("");
        txtTenCD.setText("");
        txtHocPhi.setText("");
        txtThoiLuong.setText("");
        txtMoTa.setText("");
        lblHinhAnh.setIcon(XImage.read(""));

    }

    ChuyenDe getForm() {
        ChuyenDe model = new ChuyenDe();
        model.setMaCD(txtMaCD.getText());
        model.setTenCD(txtTenCD.getText());
        model.setThoiLuong(Integer.parseInt(txtThoiLuong.getText()));
        model.setHocPhi(Double.parseDouble(txtHocPhi.getText()));
        model.setMoTa(txtMoTa.getText());
        model.setHinh(lblHinhAnh.getToolTipText());
        return model;
    }

    void updateStatus() {
        boolean edit = this.row > 0;
        boolean first = this.row == 0;
        boolean last = this.row == tblChuyenDe.getRowCount() - 1;
        txtMaCD.setEditable(!edit);
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);
        btnfirst.setEnabled(edit && !first);
        btnPrev.setEnabled(edit && !first);
        btnNext.setEnabled(edit && !last);
        btnLast.setEnabled(edit && !last);
    }

    void clearForm() {
        lblHinhAnh.setIcon(null);
        this.setForm(new ChuyenDe());

        this.updateStatus();
        row = -1;
        updateStatus();
    }

    void insert() {
        ChuyenDe cd = getForm();
        try {
            dao.insert(cd);
            this.fillTable();
            this.clearForm();
            MsgBox.alert(this, "Insert Successfully!");
        } catch (Exception e) {
            MsgBox.alert(this, "Insert Unsuccessfully!");
        }

    }

    void update() {
        ChuyenDe model = getForm();

        try {
            dao.update(model);
            this.fillTable();
            updateStatus();
            MsgBox.alert(this, "Cap nhap thanh cong");
        } catch (Exception e) {
            MsgBox.alert(this, "Cap nhap 0 thanh cong");
        }
    }

    void delete() {
        if (!Auth.isManager()) {
            MsgBox.alert(this, "Ban k co quyen xoa");
        } else {
            if (MsgBox.confirm(this, "Ban muon xoa nhan vien nay")) {
                String macd = txtMaCD.getText();
                try {
                    dao.delete(macd);
                    this.fillTable();
                    this.clearForm();
                    MsgBox.alert(this, "Xoa thanh cong");
                } catch (Exception e) {
                    MsgBox.alert(this, "Xoa thanh 0 cong");
                }
            }
        }
    }

    void first() {
        row = 0;
        edit();
    }

    void prev() {
        if (row > 0) {
            row--;
            edit();
        }
    }

    void next() {
        if (row < tblChuyenDe.getRowCount() - 1) {
            row++;
            edit();
        }
    }

    void last() {
        row = tblChuyenDe.getRowCount() - 1;
        edit();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblHinhAnh = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaCD = new javax.swing.JTextField();
        txtTenCD = new javax.swing.JTextField();
        txtThoiLuong = new javax.swing.JTextField();
        txtHocPhi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnfirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChuyenDe = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Quản lý chuyên đề");

        jLabel2.setText("Hình Logo'");

        lblHinhAnh.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblHinhAnhMousePressed(evt);
            }
        });

        jLabel3.setText("Mã CD");

        jLabel4.setText("Tên CD");

        jLabel5.setText("Thời Lượng");

        jLabel6.setText("Học Phí");

        jLabel7.setText("Mô tả");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnfirst.setText("|<");
        btnfirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfirstActionPerformed(evt);
            }
        });

        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaCD)
                            .addComponent(txtTenCD)
                            .addComponent(txtThoiLuong)
                            .addComponent(txtHocPhi)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(txtMoTa)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoa)
                        .addGap(18, 18, 18)
                        .addComponent(btnMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnfirst)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLast)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMaCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(7, 7, 7)
                        .addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(5, 5, 5)
                        .addComponent(txtHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnMoi)
                    .addComponent(btnfirst)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        tabs.addTab("Cập nhật", jPanel1);

        tblChuyenDe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ CD", "TÊN CD", "HỌC PHÍ", "THỜI LƯỢNG", "HÌNH"
            }
        ));
        tblChuyenDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChuyenDeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblChuyenDeMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblChuyenDe);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tabs.addTab("Danh sách", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabs)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabs)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblHinhAnhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            chonAnh();
        }
    }//GEN-LAST:event_lblHinhAnhMousePressed

    private void tblChuyenDeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChuyenDeMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.row = tblChuyenDe.rowAtPoint(evt.getPoint());
            edit();
        }
    }//GEN-LAST:event_tblChuyenDeMousePressed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:

        if (check()) {
            insert();
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        update();

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        clearForm();
        //reset();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnfirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfirstActionPerformed
        // TODO add your handling code here:
        first();
    }//GEN-LAST:event_btnfirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        prev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void tblChuyenDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChuyenDeMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblChuyenDeMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChuyenDeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChuyenDeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChuyenDeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChuyenDeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChuyenDeJDialog dialog = new ChuyenDeJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnfirst;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblChuyenDe;
    private javax.swing.JTextField txtHocPhi;
    private javax.swing.JTextField txtMaCD;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtTenCD;
    private javax.swing.JTextField txtThoiLuong;
    // End of variables declaration//GEN-END:variables
}
