/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.ui.master;

import com.nar.Main;
import com.nar.model.Supplier;
import com.nar.util.ComponentUtils;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author Steven Gunanto
 */
public class SupplierPanel extends javax.swing.JInternalFrame {
    private Supplier supplier;
    private List<Supplier> suppliers;
    private static final Logger log = Logger.getLogger(BarangPanel.class);
    /**
     * Creates new form SupplierPanel
     */
    public SupplierPanel() {
        initComponents();
        
        tableSupplier.setAutoCreateColumnsFromModel(false);
        tableSupplier.getSelectionModel().addListSelectionListener(new SupplierSelectionListener());
        refreshTable();
    }
    
    private void loadFormToModel()
    {
        supplier.setKodeSupplier(txtKodeSupplier.getText());
        supplier.setNamaSupplier(txtNamaSupplier.getText());
        supplier.setAlamat(txtAlamat.getText());
        supplier.setNoTelepon(txtNoTelepon.getText());
    }
    
    private void loadModelToForm()
    {
        txtKodeSupplier.setText(supplier.getKodeSupplier());
        txtNamaSupplier.setText(supplier.getNamaSupplier());
        txtAlamat.setText(supplier.getAlamat());
        txtNoTelepon.setText(supplier.getNoTelepon());
    }
    
    private void refreshTable()
    {
        suppliers = Main.getSupplierService().getSuppliers();
        tableSupplier.setModel(new SupplierTableModel(suppliers));
    }
    
    private class SupplierTableModel extends AbstractTableModel
    {
        private List<Supplier> suppliers;
        
        public SupplierTableModel(List<Supplier> suppliers)
        {
            this.suppliers = suppliers;
        }
        
        public int getRowCount()
        {
            return suppliers.size();
        }
        
        public int getColumnCount()
        {
            return 4;
        }
        
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            Supplier s = suppliers.get(rowIndex);
            switch(columnIndex)
            {
                case 0:
                    return s.getKodeSupplier();
                case 1:
                    return s.getNamaSupplier();
                case 2:
                    return s.getAlamat();
                case 3:
                    return s.getNoTelepon();
                default:
                    return "";
                        
            }
        }
    }
    
    private class SupplierSelectionListener implements ListSelectionListener
    {
        public void valueChanged(ListSelectionEvent e)
        {
            if(tableSupplier.getSelectedRow()>=0)
            {
                supplier = suppliers.get(tableSupplier.getSelectedRow());
                supplier = Main.getSupplierService().getSupplier(supplier.getKodeSupplier());
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
        if(txtKodeSupplier.getText().length() > 0
        && txtNamaSupplier.getText().length() > 0
        && txtAlamat.getText().length() > 0
        && txtNoTelepon.getText().length() > 0)
        {
            if(!Pattern.compile("[A-Z|a-z]+").matcher(txtNamaSupplier.getText().subSequence(0, txtNamaSupplier.getText().length())).matches())
            {
                JOptionPane.showMessageDialog(null, "Nama Mengandung Angka","WARNING",WIDTH);
                return false;
            }
            
            if(!Pattern.compile("[0-9]+").matcher(txtNoTelepon.getText().subSequence(0, txtNoTelepon.getText().length())).matches())
            {
                JOptionPane.showMessageDialog(null, "No Telepon Harus Angka","WARNING",WIDTH);
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
        txtAlamat.setText("");
        txtKodeSupplier.setText("");
        txtNamaSupplier.setText("");
        txtNoTelepon.setText("");
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

        jLabel1 = new javax.swing.JLabel();
        txtKodeSupplier = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNamaSupplier = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtNoTelepon = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSupplier = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbCariBerdasarkan = new javax.swing.JComboBox();
        txtCariBerdasarkan = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Supplier");
        setToolTipText("");

        jLabel1.setText("Kode Supplier");

        jLabel2.setText("Nama Supplier");

        jLabel3.setText("Alamat");

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane1.setViewportView(txtAlamat);

        jLabel4.setText("No Telepon");

        tableSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Supplier", "Nama Supplier", "Alamat", "No Telepon"
            }
        ));
        jScrollPane2.setViewportView(tableSupplier);

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

        jLabel5.setText("Cari Berdasarkan");

        cmbCariBerdasarkan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kode Supplier", "Nama Supplier", "Alamat", "No Telepon" }));

        txtCariBerdasarkan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariBerdasarkanKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClear))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCariBerdasarkan, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCariBerdasarkan, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNoTelepon, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNamaSupplier)
                                        .addComponent(txtKodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNoTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbCariBerdasarkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCariBerdasarkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if(validateForm())
        {
            loadFormToModel();
            try
            {
                Main.getSupplierService().update(tableSupplier.getValueAt(tableSupplier.getSelectedRow(), 0).toString(), supplier);
                clearForm();
            } catch(Exception ex){
                log.error(ex);
                JOptionPane.showMessageDialog(this, "Data gagal disimpan!"
                        ,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtCariBerdasarkanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariBerdasarkanKeyReleased
        // TODO add your handling code here:
        int column = 0;
        if(cmbCariBerdasarkan.getSelectedIndex() == 0)
            column = 0;
        else
            column = 1;
        for(int i = 0; i < tableSupplier.getRowCount(); i++)
        {
            String val = tableSupplier.getValueAt(i, column).toString();
            if(val!=null && val.startsWith(txtCariBerdasarkan.getText()))
            {
                tableSupplier.getSelectionModel().setSelectionInterval(i, i);
                ComponentUtils.scrollToRect(tableSupplier, i);
                break;
            }
        }
    }//GEN-LAST:event_txtCariBerdasarkanKeyReleased

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(validateForm())
        {
            if(supplier == null)
            {
                supplier = new Supplier();
            }
            loadFormToModel();
            try
            {
                Main.getSupplierService().save(supplier);
                clearForm();
            } catch(Exception ex){
                log.error(ex);
                JOptionPane.showMessageDialog(this, "Data gagal disimpan!"
                        ,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if(supplier!=null)
        {
            try
            {
                Main.getSupplierService().delete(supplier);
                supplier = null;
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cmbCariBerdasarkan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableSupplier;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtCariBerdasarkan;
    private javax.swing.JTextField txtKodeSupplier;
    private javax.swing.JTextField txtNamaSupplier;
    private javax.swing.JTextField txtNoTelepon;
    // End of variables declaration//GEN-END:variables
}
