/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.ui.master;

import com.nar.Main;
import com.nar.model.Customer;
import com.nar.util.ComponentUtils;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author gunanto
 */
public class CustomerPanel extends javax.swing.JInternalFrame {

    private Customer customer;
    private List<Customer> customers;
    private static final Logger log = Logger.getLogger(CustomerPanel.class);
    /**
     * Creates new form CustomerPanel
     */
    public CustomerPanel() {
        initComponents();
        
        tableCustomer.setAutoCreateColumnsFromModel(false);
        tableCustomer.getSelectionModel().addListSelectionListener(new CustomerSelectionListener());
        refreshTable();
    }
    
    private void loadFormToModel()
    {
        customer.setNip(txtNip.getText());
        customer.setNama(txtNama.getText());
        customer.setAlamat(txtAlamat.getText());
        customer.setNoTelp(txtNoTelp.getText());
    }
    
    private void loadModelToForm()
    {
        txtNip.setText(customer.getNip());
        txtNama.setText(customer.getNama());
        txtAlamat.setText(customer.getAlamat());
        txtNoTelp.setText(customer.getNoTelp());
    }
    
    private void refreshTable()
    {
        customers = Main.getCustomerService().getCustomers();
        tableCustomer.setModel(new CustomerTableModel(customers));
    }
    
     private class CustomerTableModel extends AbstractTableModel
     {
        private List<Customer> customers;
        
        public CustomerTableModel(List<Customer> customers)
        {
            this.customers = customers;
        }
        
        public int getRowCount()
        {
            return customers.size();
        }
        
        public int getColumnCount()
        {
            return 4;
        }
        
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            Customer c = customers.get(rowIndex);
            
            switch(columnIndex)
            {
                case 0:
                    return c.getNip();
                case 1:
                    return c.getNama();
                case 2:
                    return c.getAlamat();
                case 3:
                    return c.getNoTelp();
                default:
                    return "";
            }
        }
    }
     
    private class CustomerSelectionListener implements ListSelectionListener
    {
        public void valueChanged(ListSelectionEvent  e)
        {
            if(tableCustomer.getSelectedRow() >= 0)
            {
                customer = customers.get(tableCustomer.getSelectedRow());
                customer = Main.getCustomerService().getCustomer(customer.getNip());
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
           txtNip.getText().length() > 0 &&
           txtNoTelp.getText().length() > 0)
        {
            if(!Pattern.compile("[A-Z|a-z]+").matcher(txtNama.getText().subSequence(0, txtNama.getText().length())).matches())
            {
                JOptionPane.showMessageDialog(null, "Nama Mengandung Angka","WARNING",WIDTH);
                return false;
            }
            
            try
            {
                Integer.parseInt(txtNoTelp.getText());
                if(Integer.parseInt(txtNoTelp.getText())<0)
                {
                    JOptionPane.showMessageDialog(null, "Error Nomor Telepon tidak boleh negatif","WARNING",WIDTH);
                    return false;
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error harus angka !!! " ,"WARNING" , WIDTH);
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
        txtAlamat.setText("");
        txtNama.setText("");
        txtNip.setText("");
        txtNoTelp.setText("");
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

        lblNip = new javax.swing.JLabel();
        txtNip = new javax.swing.JTextField();
        lblNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        lblAlamat = new javax.swing.JLabel();
        lblNoTelp = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        txtNoTelp = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblCariBerdasarkan = new javax.swing.JLabel();
        txtCariBerdasarkan = new javax.swing.JTextField();
        cmbCariBerdasarkan = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomer = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Customer");

        lblNip.setText("NIP");

        lblNama.setText("Nama ");

        lblAlamat.setText("Alamat");

        lblNoTelp.setText("No Telp");

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

        lblCariBerdasarkan.setText("Cari Berdasarkan");

        txtCariBerdasarkan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariBerdasarkanKeyReleased(evt);
            }
        });

        cmbCariBerdasarkan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NIP", "Nama" }));

        tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIP", "Nama", "Alamat", "No Telp"
            }
        ));
        jScrollPane1.setViewportView(tableCustomer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNama)
                                    .addComponent(lblNip)
                                    .addComponent(lblAlamat)
                                    .addComponent(lblNoTelp))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNoTelp, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                    .addComponent(txtNip, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNama)
                                    .addComponent(txtAlamat)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCariBerdasarkan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCariBerdasarkan, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCariBerdasarkan, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 423, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNip)
                    .addComponent(txtNip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNama)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlamat)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNoTelp)
                    .addComponent(txtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCariBerdasarkan)
                    .addComponent(txtCariBerdasarkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCariBerdasarkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(validateForm())
        {
            if(customer == null)
            {
                customer = new Customer();
            }
            loadFormToModel();
            try
            {
                Main.getCustomerService().save(customer);
                clearForm();
            }
            catch(Exception ex)
            {
                log.error(ex);
                JOptionPane.showMessageDialog(this, "Data gagal disimpan!"
                        ,"Error", JOptionPane.ERROR_MESSAGE);
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
                Main.getCustomerService().update(tableCustomer.getValueAt(tableCustomer.getSelectedRow(), 0).toString(), customer);
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
        if(customer != null)
        {
            try
            {
                Main.getCustomerService().delete(customer);
                customer = null;
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
        for(int i = 0; i < tableCustomer.getRowCount(); i++)
        {
            String val = tableCustomer.getValueAt(i, column).toString();
            if(val!=null && val.startsWith(txtCariBerdasarkan.getText()))
            {
                tableCustomer.getSelectionModel().setSelectionInterval(i, i);
                ComponentUtils.scrollToRect(tableCustomer, i);
                break;
            }
        }
    }//GEN-LAST:event_txtCariBerdasarkanKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cmbCariBerdasarkan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblCariBerdasarkan;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNip;
    private javax.swing.JLabel lblNoTelp;
    private javax.swing.JTable tableCustomer;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtCariBerdasarkan;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNip;
    private javax.swing.JTextField txtNoTelp;
    // End of variables declaration//GEN-END:variables
}
