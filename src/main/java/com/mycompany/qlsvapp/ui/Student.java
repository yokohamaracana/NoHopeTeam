package com.mycompany.qlsvapp.ui;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mycompany.qlsvapp.helper.DataValidator;
import com.mycompany.qlsvapp.helper.ImageHelper;
import com.mycompany.qlsvapp.helper.MessageDialog;
import com.mycompany.qlsvapp.model.SinhVien;
import com.mycompany.qlsvapp.model.dao.SinhVienDao;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tuan Tien, Phuc Toan, Trung Hau, Anh Tri, Duc Duy
 */
public class Student extends javax.swing.JPanel {
    private MainForm parentForm;
    private DefaultTableModel tblModel;
    private byte[] personalImage;
    /**
     * Creates new form Student
     */
    public Student() {
        initComponents();
	initTable();
       	loadDataToTable();
    }
    
    private void initTable(){
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"Mã sinh viên", "Họ tên", "Email", "Số ĐT", "Giới tính", "Địa chỉ"});
        tblStudent.setModel(tblModel);
    }
    
    private void loadDataToTable(){
        try {
            SinhVienDao dao = new SinhVienDao();
            List<SinhVien> list = dao.findAll();
            tblModel.setRowCount(0);
            for(SinhVien it: list){
                tblModel.addRow(new Object[]{
                    it.getMaSinhVien(), it.getHoTen(), it.getEmail(), it.getSoDT(),
                    it.getGioiTinh()==1?"Nam" : "Nữ", it.getDiaChi()
                });
            }
            tblModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialog.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtStudentId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        rdbMaie = new javax.swing.JRadioButton();
        rdbFemale = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        btnBrowse = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        btnNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        INDSSV = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Quản Lý Sinh Viên");

        jLabel2.setText("Mã sinh viên:");

        jLabel3.setText("Họ tên:");

        jLabel4.setText("Email:");

        jLabel5.setText("Số điện thoại:");

        jLabel6.setText("Giới tính:");

        jLabel7.setText("Địa chỉ:");

        txtStudentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIdActionPerformed(evt);
            }
        });

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbMaie);
        rdbMaie.setText("Nam");

        buttonGroup1.add(rdbFemale);
        rdbFemale.setText("Nữ");

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlsvapp/icons/10207-man-student-light-skin-tone-icon-64.png"))); // NOI18N

        btnBrowse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlsvapp/icons/open-file-icon-16.png"))); // NOI18N
        btnBrowse.setText("Mở hình");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(btnBrowse)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(btnBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane1.setViewportView(txtAddress);

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlsvapp/icons/new-icon-16.png"))); // NOI18N
        btnNew.setText("Tạo mới");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlsvapp/icons/Actions-document-edit-icon-16.png"))); // NOI18N
        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlsvapp/icons/Save-icon.png"))); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlsvapp/icons/Actions-edit-delete-icon-16.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblStudent);

        INDSSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/qlsvapp/icons/open-file-icon-16.png"))); // NOI18N
        INDSSV.setText("Xuất PDF");
        INDSSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INDSSVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jSeparator4)
                        .addContainerGap())
                    .addComponent(jSeparator3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnNew)
                                .addGap(90, 90, 90)
                                .addComponent(btnSave)
                                .addGap(37, 37, 37)
                                .addComponent(btnUpdate)
                                .addGap(31, 31, 31)
                                .addComponent(btnDelete)
                                .addGap(37, 37, 37)
                                .addComponent(INDSSV))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel7))
                                                .addGap(25, 25, 25)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                                    .addComponent(txtEmail)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(rdbMaie)
                                                        .addGap(42, 42, 42)
                                                        .addComponent(rdbFemale))
                                                    .addComponent(txtPhone))))))
                                .addGap(22, 22, 22)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(37, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jSeparator5)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rdbMaie)
                            .addComponent(rdbFemale))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel7)))
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNew)
                            .addComponent(btnSave)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete)
                            .addComponent(INDSSV))))
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtStudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentIdActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtStudentId.setText("");
        txtName.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtAddress.setText("");
        personalImage = null;
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/mycompany/qlsvapp/icons/10207-man-student-light-skin-tone-icon-64.png"));
        lblImage.setIcon(icon);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtStudentId, sb, "Mã sinh viên không được để trống");
        DataValidator.validateEmpty(txtName, sb, "Tên sinh viên không được để trống");
        if (sb.length()>0) {
            MessageDialog.showErrorDialog(parentForm, sb.toString(), "Lỗi");
            return;
        }
        try {
            SinhVien sv = new SinhVien();
            sv.setMaSinhVien(txtStudentId.getText());
            sv.setHoTen(txtName.getText());
            sv.setEmail(txtEmail.getText());
            sv.setSoDT(txtPhone.getText());
            sv.setDiaChi(txtAddress.getText());
            sv.setGioiTinh(rdbMaie.isSelected()?1: 0);
            sv.setHinh(personalImage);
            SinhVienDao dao = new SinhVienDao();
            if (dao.findById(txtStudentId.getText()) != null) {
                MessageDialog.showErrorDialog(parentForm, "Trùng mã sinh viên", "Cảnh báo");
            }else{
                if (dao.insert(sv)) {
                MessageDialog.showMessageDialog(parentForm, "Sinh viên đã được lưu", "Thông báo");
                loadDataToTable();
            }else{
                MessageDialog.showErrorDialog(parentForm, "Sinh viên chưa được lưu", "Cảnh báo");
            }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialog.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnSaveActionPerformed
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtStudentId, sb, "Mã sinh viên không được để trống");
        DataValidator.validateEmpty(txtName, sb, "Tên sinh viên không được để trống");
        if (sb.length()>0) {
            MessageDialog.showErrorDialog(parentForm, sb.toString(), "Lỗi");
            return;
        }
        if (MessageDialog.showConfirmDialog(parentForm, 
                "Bạn có muốn cập nhật sinh viên không ?", "Hỏi")== JOptionPane.NO_OPTION){
            return;
        }
        try {
            SinhVien sv = new SinhVien();
            sv.setMaSinhVien(txtStudentId.getText());
            sv.setHoTen(txtName.getText());
            sv.setEmail(txtEmail.getText());
            sv.setSoDT(txtPhone.getText());
            sv.setDiaChi(txtAddress.getText());
            sv.setGioiTinh(rdbMaie.isSelected()?1: 0);
            sv.setHinh(personalImage);
            SinhVienDao dao = new SinhVienDao();
            if (dao.update(sv)) {
                MessageDialog.showMessageDialog(parentForm, "Sinh viên đã được cập nhật", "Thông báo");
                loadDataToTable();
            }else{
                MessageDialog.showErrorDialog(parentForm, "Sinh viên chưa được cập nhật", "Cảnh báo");
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialog.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        StringBuilder sb = new StringBuilder();
        DataValidator.validateEmpty(txtStudentId, sb, "Mã sinh viên không được để trống");
        if (sb.length()>0) {
            MessageDialog.showErrorDialog(parentForm, sb.toString(), "Lỗi");
            return;
        }
        if (MessageDialog.showConfirmDialog(parentForm, 
                "Bạn có muốn xóa sinh viên không ?", "Hỏi")== JOptionPane.NO_OPTION){
            return;
        }
        try {
            SinhVienDao dao = new SinhVienDao();
            if (dao.delete(txtStudentId.getText())) {
                MessageDialog.showMessageDialog(parentForm, "Sinh viên đã được xóa", "Thông báo");
                btnNewActionPerformed(evt);
                loadDataToTable();
            }else{
                MessageDialog.showErrorDialog(parentForm, "Sinh viên chưa được xóa", "Cảnh báo");
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialog.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentMouseClicked
        try {
            int row = tblStudent.getSelectedRow();
            
            if(row >= 0){
                String id = (String) tblStudent.getValueAt(row, 0);
                SinhVienDao dao = new SinhVienDao();
                SinhVien sv = dao.findById(id);
                if(sv != null){
                    txtStudentId.setText(sv.getMaSinhVien());
                    txtName.setText(sv.getHoTen());
                    txtEmail.setText(sv.getEmail());
                    txtPhone.setText(sv.getSoDT());
                    txtAddress.setText(sv.getDiaChi());
                    rdbMaie.setSelected(sv.getGioiTinh()==1?true:false);
                    if (sv.getHinh() != null) {
                        Image img = ImageHelper.createImageFromByteArray(sv.getHinh(), "jpg");
                        lblImage.setIcon(new ImageIcon(img));
                        personalImage = sv.getHinh();
                    }else{
                        personalImage = sv.getHinh();
                        ImageIcon icon = new ImageIcon(getClass().getResource(
                                "/com/mycompany/qlsvapp/icons/10207-man-student-light-skin-tone-icon-64.png"));
                        lblImage.setIcon(icon);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialog.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_tblStudentMouseClicked
    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if(f.isDirectory()){
                    return true;
                }else{
                    return f.getName().toLowerCase().endsWith(".jpg");
                }
            }

            @Override
            public String getDescription() {
                return "Image File (*.jpg)";
            }
        });
        if (chooser.showOpenDialog(parentForm) == JFileChooser.CANCEL_OPTION) {
            return;
        }
        File file = chooser.getSelectedFile();
        try {
            ImageIcon icon = new ImageIcon(file.getPath());
            Image img = ImageHelper.resize(icon.getImage(), 160, 200);
            ImageIcon resizeIcon = new ImageIcon(img);
            lblImage.setIcon(resizeIcon);
            personalImage = ImageHelper.toByteArray(img, "jpg");
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialog.showMessageDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void INDSSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INDSSVActionPerformed
        String path = "";
        JFileChooser j =  new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);
        
        if(x == JFileChooser.APPROVE_OPTION){
            path = j.getSelectedFile().getPath();
        }
        Document doc = new Document();
        
     
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path+"SV.pdf"));
            
            doc.open();
            Paragraph paragraph1 = new Paragraph("Danh sách Sinh Viên");
            paragraph1.setIndentationLeft(80);
            paragraph1.setIndentationRight(80);
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            paragraph1.setSpacingAfter(15);
            doc.add(paragraph1);
            PdfPTable tbl = new PdfPTable(6);
            
            tbl.addCell("ID");
            tbl.addCell("Name");
            tbl.addCell("Email");
            tbl.addCell("Phone");
            tbl.addCell("Gender");
            tbl.addCell("Address");
            
            for (int i = 0; i < tblStudent.getRowCount(); i++) {
                String ID = tblStudent.getValueAt(i, 0).toString();
                String Name = tblStudent.getValueAt(i, 1).toString();
                String Email = tblStudent.getValueAt(i, 2).toString();
                String Phone = tblStudent.getValueAt(i, 3).toString();
                String GT = tblStudent.getValueAt(i, 4).toString();
                String Diachi = tblStudent.getValueAt(i, 5).toString();
                
                tbl.addCell(ID);
                tbl.addCell(Name);
                tbl.addCell(Email);
                tbl.addCell(Phone);
                tbl.addCell(GT);
                tbl.addCell(Diachi);
                
            }
            
            doc.add(tbl);
            
            JOptionPane.showMessageDialog(null, "Xuất thành công", "ALERT MESSAGE", JOptionPane.WARNING_MESSAGE);
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    
        doc.close();
    }//GEN-LAST:event_INDSSVActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton INDSSV;
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblImage;
    private javax.swing.JRadioButton rdbFemale;
    private javax.swing.JRadioButton rdbMaie;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtStudentId;
    // End of variables declaration//GEN-END:variables
}
