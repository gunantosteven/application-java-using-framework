/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.ui.master;

import com.nar.Main;
import com.nar.model.Barang;
import com.nar.util.ComponentUtils;
import java.util.ArrayList;
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
public class BarangPanel extends javax.swing.JInternalFrame {
    private Barang barang;
    private List<Barang> barangs;
    private static final Logger log = Logger.getLogger(BarangPanel.class);
    /**
     * Creates new form BarangPanel
     */
    public BarangPanel() {
        initComponents();
        
        tableBarang.setAutoCreateColumnsFromModel(false);
        tableBarang.getSelectionModel().addListSelectionListener(new BarangSelectionListener());
        refreshTable();
    }
    
    private void loadFormToModel()
    {
        barang.setKodeBarang(txtKodeBarang.getText());
        barang.setNamaBarang(txtNamaBarang.getText());
        barang.setDeskripsi(txtDeskripsi.getText());
        barang.setSatuan(txtSatuan.getText());
        barang.setHargaBeli(Integer.parseInt(txtHargaBeli.getText()));
        barang.setHargaJual(Integer.parseInt(txtHargaJual.getText()));
        barang.setStock(Integer.parseInt(txtJumlahBarang.getText()));
    }
    
    private void loadModelToForm()
    {
        txtKodeBarang.setText(barang.getKodeBarang());
        txtNamaBarang.setText(barang.getNamaBarang());
        txtDeskripsi.setText(barang.getDeskripsi());
        txtSatuan.setText(barang.getSatuan());
        txtHargaBeli.setText(String.valueOf(barang.getHargaBeli()));
        txtHargaJual.setText(String.valueOf(barang.getHargaJual()));
        txtJumlahBarang.setText(String.valueOf(barang.getStock()));
    }
    
    private void refreshTable()
    {
        barangs = Main.getBarangService().getBarangs();
        tableBarang.setModel(new BarangTableModel(barangs));
    }
    
    private class BarangTableModel extends AbstractTableModel
    {
        private List<Barang> barangs;
        
        public BarangTableModel(List<Barang> barangs)
        {
            this.barangs = barangs;
        }
        
        public int getRowCount()
        {
            return barangs.size();
        }
        
        public int getColumnCount()
        {
            return 6;
        }
        
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            Barang b = barangs.get(rowIndex);
            switch(columnIndex)
            {
                case 0:
                    return b.getKodeBarang();
                case 1:
                    return b.getNamaBarang();
                case 2:
                    return b.getDeskripsi();
                case 3:
                    return b.getSatuan();
                case 4:
                    return b.getStock();
                case 5:
                    return b.getHargaBeli();
                case 6:
                    return b.getHargaJual();
                default:
                    return "";
                        
            }
        }
    }
    
    private class BarangSelectionListener implements ListSelectionListener
    {
        public void valueChanged(ListSelectionEvent e)
        {
            if(tableBarang.getSelectedRow()>=0)
            {
                barang = barangs.get(tableBarang.getSelectedRow());
                barang = Main.getBarangService().getBarang(barang.getKodeBarang());
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
        if(txtKodeBarang.getText().length() > 0
        && txtNamaBarang.getText().length() > 0
        && txtDeskripsi.getText().length() > 0
        && txtHargaBeli.getText().length() > 0
        && txtHargaJual.getText().length()> 0 
        && txtJumlahBarang.getText().length() > 0
        && txtSatuan.getText().length() > 0)
        
        { 
            try
            {
                Integer.parseInt(txtJumlahBarang.getText());
                if(Integer.parseInt(txtJumlahBarang.getText())<0)
                {
                    JOptionPane.showMessageDialog(null, "Error Jumlah Barang tidak boleh negatif");
                    return false;
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error Jumlah Barang harus angka  !!! " ,"Warning" , WIDTH);
                return false;
            }
            
            try
            {
                Integer.parseInt(txtHargaBeli.getText());
                if(Integer.parseInt(txtHargaBeli.getText())<0)
                {
                    JOptionPane.showMessageDialog(null, "Error Harga Beli tidak boleh negatif");
                    return false;
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error Harga Beli harus angka !!! " ,"Warning" , WIDTH);
                return false;
            }
            
            try
            {
                Integer.parseInt(txtHargaJual.getText());
                if(Integer.parseInt(txtHargaJual.getText())<0)
                {
                    JOptionPane.showMessageDialog(null, "Error Harga Jual tidak boleh negatif");
                    return false;
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error Harga Jual harus angka !!! " ,"Warning" , WIDTH);
                return false;
            }    
        }
        else
        {
            JOptionPane.showMessageDialog(null,
                    "Isi semua field!","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
        
    }
    
    private void clearForm()
    {
        refreshTable();
        txtCariBerdasarkan.setText("");
        txtDeskripsi.setText("");
        txtHargaBeli.setText("");
        txtHargaJual.setText("");
        txtJumlahBarang.setText("");
        txtKodeBarang.setText("");
        txtNamaBarang.setText("");
        txtSatuan.setText("");
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

        lblKodeBarang = new javax.swing.JLabel();
        lblNamaBarang = new javax.swing.JLabel();
        txtKodeBarang = new javax.swing.JTextField();
        txtNamaBarang = new javax.swing.JTextField();
        lblDeskripsi = new javax.swing.JLabel();
        txtDeskripsi = new javax.swing.JTextField();
        lblSatuan = new javax.swing.JLabel();
        txtSatuan = new javax.swing.JTextField();
        lblJumlahBarang = new javax.swing.JLabel();
        txtJumlahBarang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtHargaJual = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBarang = new javax.swing.JTable();
        lblCariBerdasarkan = new javax.swing.JLabel();
        txtCariBerdasarkan = new javax.swing.JTextField();
        cmbCariBerdasarkan = new javax.swing.JComboBox();
        btnSimpan = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtHargaBeli = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Barang");

        lblKodeBarang.setText("Kode Barang : ");

        lblNamaBarang.setText("Nama Barang :");

        lblDeskripsi.setText("Deskripsi :");

        lblSatuan.setText("Satuan :");

        lblJumlahBarang.setText("Jumlah Barang :");

        jLabel6.setText("Harga Jual :");

        tableBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama Barang", "Deskripsi", "Satuan", "Jumlah Barang", "Harga Beli", "Harga Jual"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableBarang);

        lblCariBerdasarkan.setText("Cari Berdasarkan ");

        txtCariBerdasarkan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariBerdasarkanKeyReleased(evt);
            }
        });

        cmbCariBerdasarkan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kode Barang", "Nama Barang" }));

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

        jLabel1.setText("Harga Beli :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCariBerdasarkan)
                        .addGap(4, 4, 4)
                        .addComponent(cmbCariBerdasarkan, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCariBerdasarkan, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDeskripsi)
                            .addComponent(lblNamaBarang)
                            .addComponent(lblSatuan)
                            .addComponent(lblJumlahBarang)
                            .addComponent(lblKodeBarang)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNamaBarang)
                                .addComponent(txtDeskripsi, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtJumlahBarang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                .addComponent(txtSatuan, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtHargaJual, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKodeBarang)
                    .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamaBarang)
                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeskripsi)
                    .addComponent(txtDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSatuan)
                    .addComponent(txtSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJumlahBarang)
                    .addComponent(txtJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCariBerdasarkan)
                    .addComponent(txtCariBerdasarkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCariBerdasarkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCariBerdasarkanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariBerdasarkanKeyReleased
        // TODO add your handling code here:
        int column = 0;
        if(cmbCariBerdasarkan.getSelectedIndex() == 0)
            column = 0;
        else
            column = 1;
        for(int i = 0; i < tableBarang.getRowCount(); i++)
        {
            String val = tableBarang.getValueAt(i, column).toString();
            if(val!=null && val.startsWith(txtCariBerdasarkan.getText()))
            {
                tableBarang.getSelectionModel().setSelectionInterval(i, i);
                ComponentUtils.scrollToRect(tableBarang, i);
                break;
            }
        }
    }//GEN-LAST:event_txtCariBerdasarkanKeyReleased

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(validateForm())
        {
            if(barang == null)
            {
                barang = new Barang();
            }
            loadFormToModel();
            try
            {
                Main.getBarangService().save(barang);
                clearForm();
            } catch(Exception ex){
                log.error(ex);
                JOptionPane.showMessageDialog(this, "Data gagal disimpan!"
                        ,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if(validateForm())
        {
            loadFormToModel();
            try
            {
                Main.getBarangService().update(tableBarang.getValueAt(tableBarang.getSelectedRow(), 0).toString(), barang);
                clearForm();
            } catch(Exception ex){
                log.error(ex);
                JOptionPane.showMessageDialog(this, "Data gagal disimpan!"
                        ,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if(barang!=null)
        {
            try
            {
                Main.getBarangService().delete(barang);
                barang = null;
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cmbCariBerdasarkan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCariBerdasarkan;
    private javax.swing.JLabel lblDeskripsi;
    private javax.swing.JLabel lblJumlahBarang;
    private javax.swing.JLabel lblKodeBarang;
    private javax.swing.JLabel lblNamaBarang;
    private javax.swing.JLabel lblSatuan;
    private javax.swing.JTable tableBarang;
    private javax.swing.JTextField txtCariBerdasarkan;
    private javax.swing.JTextField txtDeskripsi;
    private javax.swing.JTextField txtHargaBeli;
    private javax.swing.JTextField txtHargaJual;
    private javax.swing.JTextField txtJumlahBarang;
    private javax.swing.JTextField txtKodeBarang;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtSatuan;
    // End of variables declaration//GEN-END:variables
}
