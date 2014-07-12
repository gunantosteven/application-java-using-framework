/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.ui.master;

import com.nar.Main;
import com.nar.model.Employee;
import com.nar.model.Jabatan;
import com.nar.model.JenisKelamin;
import com.nar.util.ComponentUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author gunanto
 */
public class EmployeePanel extends javax.swing.JInternalFrame {

    private Employee employee;
    private List<Employee> employees;
    private static final Logger log = Logger.getLogger(EmployeePanel.class);
    /**
     * Creates new form EmployeePanel
     */
    public EmployeePanel() {
        initComponents();
        
        tableKaryawan.setAutoCreateColumnsFromModel(false);
        tableKaryawan.getSelectionModel().addListSelectionListener(new EmployeeSelectionListener());
        refreshTable();
    }
    
    private void loadFormToModel()
    {
        employee.setNik(txtNik.getText());
        employee.setNama(txtNama.getText());
        employee.setAlamat(txtAlamat.getText());
        employee.setBirthDate(calendarTanggalLahir.getDate());
        employee.setJenisKelamin(cmbJenisKelamin.getSelectedIndex() == 0 ? JenisKelamin.PRIA : JenisKelamin.WANITA );
        employee.setJabatan(getJabatan());
        employee.setTempatLahir(txtTempatLahir.getText());
        employee.setUserName(txtUsername.getText());
        employee.setPassword(txtPassword.getText());
    }
    
    private void loadModelToForm()
    {
        txtNik.setText(employee.getNik());
        txtNama.setText(employee.getNama());
        txtAlamat.setText(employee.getAlamat());
        txtTempatLahir.setText(employee.getTempatLahir());
        cmbJenisKelamin.setSelectedIndex(employee.getJenisKelamin() == JenisKelamin.PRIA ?  0 : 1);
        cmbJabatan.setSelectedIndex(employee.getJabatan().ordinal());
        calendarTanggalLahir.setDate(employee.getBirthDate());
        txtUsername.setText(employee.getUserName());
        txtPassword.setText(employee.getPassword());
    }
    
    private Jabatan getJabatan()
    {
        switch(cmbJabatan.getSelectedIndex())
        {
            case 0:
                return Jabatan.SUPERVISOR;
            case 1:
                return Jabatan.ADMIN;
            case 2:
                return Jabatan.MARKETING;
            case 3:
                return Jabatan.OPERATOR;
            default:
                return null;
        }
    }
    
    private void refreshTable()
    {
        employees = Main.getEmployeeService().getEmployees();
        tableKaryawan.setModel(new EmployeeTableModel(employees));
    }
    
    private class EmployeeTableModel extends AbstractTableModel
    {
        private List<Employee> employees;
        
        public EmployeeTableModel(List<Employee> employees)
        {
            this.employees = employees;
        }
        
        public int getRowCount()
        {
            return employees.size();
        }
        
        public int getColumnCount()
        {
            return 9;
        }
        
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            Employee e = employees.get(rowIndex);
            
            switch(columnIndex)
            {
                case 0:
                    return e.getNik();
                case 1:
                    return e.getNama();
                case 2:
                    return e.getAlamat();
                case 3:
                    return e.getJenisKelamin();
                case 4:
                    return e.getTempatLahir();
                case 5:
                    return e.getBirthDate();
                case 6:
                    return e.getJabatan();
                case 7:
                    return e.getUserName();
                case 8:
                    return e.getPassword();
                default:
                    return "";
            }
        }
    }
    
    private class EmployeeSelectionListener implements ListSelectionListener
    {
        public void valueChanged(ListSelectionEvent  e)
        {
            if(tableKaryawan.getSelectedRow() >= 0)
            {
                employee = employees.get(tableKaryawan.getSelectedRow());
                employee = Main.getEmployeeService().getEmployee(employee.getNik());
                loadModelToForm();
                btnSimpan.setEnabled(false);
                btnUpdate.setEnabled(true);
                btnDelete.setEnabled(true);
            }
            else
            {
                btnSimpan.setEnabled(true);
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(false);
            }
        }
    }
    
    private boolean validateForm()
    {
        if(txtAlamat.getText().length() > 0 &&
           txtNama.getText().length() > 0 &&
           txtNik.getText().length() > 0 &&
           txtPassword.getText().length() > 0 &&
           txtTempatLahir.getText().length() > 0 &&
           txtUsername.getText().length() > 0)
            return true;
        else
        {
            JOptionPane.showMessageDialog(null,
                    "Isi semua field!","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    private void clearForm()
    {
        refreshTable();
        txtAlamat.setText("");
        txtCariBerdasarkan.setText("");
        txtNama.setText("");
        txtNik.setText("");
        txtPassword.setText("");
        txtTempatLahir.setText("");
        txtUsername.setText("");
        calendarTanggalLahir.setDate(new Date());
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnSimpan.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNik = new javax.swing.JLabel();
        txtNik = new javax.swing.JTextField();
        lblNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        lblAlamat = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        lblJenisKelamin = new javax.swing.JLabel();
        cmbJenisKelamin = new javax.swing.JComboBox();
        lblTempatLahir = new javax.swing.JLabel();
        txtTempatLahir = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        calendarTanggalLahir = new de.wannawork.jcalendar.JCalendarComboBox();
        lblJabatan = new javax.swing.JLabel();
        panelDaftarLogin = new javax.swing.JPanel();
        txtPassword = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblCariBerdasarkan = new javax.swing.JLabel();
        cmbCariBerdasarkan = new javax.swing.JComboBox();
        txtCariBerdasarkan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKaryawan = new javax.swing.JTable();
        cmbJabatan = new javax.swing.JComboBox();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Karyawan");

        lblNik.setText("NIK");

        lblNama.setText("Nama");

        lblAlamat.setText("Alamat");

        lblJenisKelamin.setText("Jenis Kelamin");

        cmbJenisKelamin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pria", "Wanita" }));

        lblTempatLahir.setText("Tempat Lahir");

        jLabel1.setText("Tanggal Lahir");

        lblJabatan.setText("Jabatan");

        panelDaftarLogin.setBorder(javax.swing.BorderFactory.createTitledBorder("Daftar Login"));

        lblUsername.setText("Username ");

        lblPassword.setText("Password");

        javax.swing.GroupLayout panelDaftarLoginLayout = new javax.swing.GroupLayout(panelDaftarLogin);
        panelDaftarLogin.setLayout(panelDaftarLoginLayout);
        panelDaftarLoginLayout.setHorizontalGroup(
            panelDaftarLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDaftarLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsername)
                .addContainerGap(160, Short.MAX_VALUE))
            .addGroup(panelDaftarLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDaftarLoginLayout.createSequentialGroup()
                    .addContainerGap(18, Short.MAX_VALUE)
                    .addComponent(lblPassword)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panelDaftarLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtUsername)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap()))
        );
        panelDaftarLoginLayout.setVerticalGroup(
            panelDaftarLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDaftarLoginLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblUsername)
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(panelDaftarLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelDaftarLoginLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(panelDaftarLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPassword)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(26, Short.MAX_VALUE)))
        );

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        lblCariBerdasarkan.setText("Cari Berdasarkan ");

        cmbCariBerdasarkan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NIK", "NAMA" }));

        txtCariBerdasarkan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariBerdasarkanKeyReleased(evt);
            }
        });

        tableKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NIK", "Nama", "Alamat", "Jenis Kelamin", "Tempat Lahir", "Tanggal Lahir", "Jabatan", "Username", "Password"
            }
        ));
        jScrollPane1.setViewportView(tableKaryawan);

        cmbJabatan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Supervisor", "Admin", "Marketing", "Operator" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblTempatLahir)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblNik)
                                .addComponent(lblJenisKelamin)
                                .addComponent(lblNama)
                                .addComponent(lblAlamat))
                            .addComponent(lblJabatan, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmbJenisKelamin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNik, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNama, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAlamat, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTempatLahir, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(calendarTanggalLahir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                        .addComponent(panelDaftarLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnSimpan)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnUpdate)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnDelete)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnClear))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtCariBerdasarkan)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblCariBerdasarkan)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(cmbCariBerdasarkan, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                            .addComponent(cmbJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 32, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNik)
                            .addComponent(txtNik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNama)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAlamat))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblJenisKelamin)
                            .addComponent(cmbJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelDaftarLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTempatLahir)
                            .addComponent(txtTempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(calendarTanggalLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblJabatan)
                            .addComponent(cmbJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCariBerdasarkan)
                            .addComponent(cmbCariBerdasarkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtCariBerdasarkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete)
                            .addComponent(btnClear))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(validateForm())
        {
            if(employee == null)
            {
                employee = new Employee();
            }
            loadFormToModel();
            try
            {
                Main.getEmployeeService().save(employee);
                clearForm();
            }
            catch(Exception ex)
            {
                log.error(ex);
                JOptionPane.showMessageDialog(this, "Data gagal disimpan!"
                        ,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if(validateForm())
        {
            loadFormToModel();
            try
            {
                Main.getEmployeeService().update(tableKaryawan.getValueAt(tableKaryawan.getSelectedRow(), 0).toString(), employee);
                clearForm();
            }
            catch(Exception ex)
            {
                log.error(ex);
                JOptionPane.showMessageDialog(this, "Data gagal disimpan!"
                        ,"Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if(employee != null)
        {
            try
            {
                Main.getEmployeeService().delete(employee);
                employee = null;
                clearForm();
            }
            catch(Exception ex)
            {
                log.error(ex);
                JOptionPane.showMessageDialog(this, "Data masih digunakan tidak bisa dihapus!"
                        ,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtCariBerdasarkanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariBerdasarkanKeyReleased
        // TODO add your handling code here:
        int column = cmbCariBerdasarkan.getSelectedIndex();
        for(int i = 0; i < tableKaryawan.getRowCount(); i++)
        {
            String val = tableKaryawan.getValueAt(i, column).toString();
            if(val!=null && val.startsWith(txtCariBerdasarkan.getText()))
            {
                tableKaryawan.getSelectionModel().setSelectionInterval(i, i);
                ComponentUtils.scrollToRect(tableKaryawan, i);
                break;
            }
        }
    }//GEN-LAST:event_txtCariBerdasarkanKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private de.wannawork.jcalendar.JCalendarComboBox calendarTanggalLahir;
    private javax.swing.JComboBox cmbCariBerdasarkan;
    private javax.swing.JComboBox cmbJabatan;
    private javax.swing.JComboBox cmbJenisKelamin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblCariBerdasarkan;
    private javax.swing.JLabel lblJabatan;
    private javax.swing.JLabel lblJenisKelamin;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNik;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTempatLahir;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel panelDaftarLogin;
    private javax.swing.JTable tableKaryawan;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtCariBerdasarkan;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNik;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtTempatLahir;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
