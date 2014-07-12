/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.ui.transaksi;

import com.nar.Main;
import com.nar.model.Customer;
import com.nar.model.DetailPenjualan;
import com.nar.model.Penjualan;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gunanto
 */
public class FormPenjualan extends javax.swing.JInternalFrame {

    private DetailPenjualan detailPenjualan;
    private List<DetailPenjualan> listDetailPenjualan;
    private Penjualan penjualan; 
    /**
     * Creates new form Penjualan
     */
    public FormPenjualan(String user) {
        initComponents();
        tablePenjualan.setAutoCreateColumnsFromModel(false);
        updateNoNota();
        lblStatus.setText(user);
    }
    
    private void loadFormToModel()
    {
        penjualan.setBayar(Integer.parseInt(txtBayar.getText()));
        penjualan.setKembali(Integer.parseInt(txtKembali.getText()));
    }
    
    public void updateNoNota()
    {
        txtNoNota.setText((Main.getPenjualanService().getListPenjualan().size() + 1) + "");
    }
    
    private void refreshTable()
    {
        listDetailPenjualan = Main.getDetailPenjualanService().getDetailsPenjualan(penjualan.getNoNota());
        tablePenjualan.setModel(new PenjualanTableModel(listDetailPenjualan));
    }
    
    private boolean validateForm()
    {
        if(txtBayar.getText().length() >  0 &&
           txtKembali.getText().length() > 0 &&
           txtKodeCustomer.getText().length() > 0 &&
           txtNoNota.getText().length() > 0)
            return true;
        else
        {
            JOptionPane.showMessageDialog(null,
                    "Isi semua field!","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    private void hitung()
    {
        List a = Main.getDetailPenjualanService().sum(penjualan.getNoNota());
        if(a.get(0) == null)
        {
            txtBayar.setText("");
            return;
        }
        txtBayar.setText(a.get(0).toString());
    }
    
    private Action loadAction = new AbstractAction("Load") {

        @Override
        public void actionPerformed(ActionEvent e) {
            refreshTable();
            hitung();
        }
    };
    
    private class PenjualanTableModel extends AbstractTableModel
    {
        private List<DetailPenjualan> detailPenjualan;
        
        public PenjualanTableModel(List<DetailPenjualan> detailPenjualan)
        {
            this.detailPenjualan = detailPenjualan;
        }

        public void setDetailPenjualan(List<DetailPenjualan> detailPenjualan) {
            this.detailPenjualan = detailPenjualan;
        }

        public int getRowCount()
        {
            return detailPenjualan.size();
        }
        
        public int getColumnCount()
        {
            return 5;
        }
        
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            DetailPenjualan d = detailPenjualan.get(rowIndex);
            switch(columnIndex)
            {
                case 0:
                    return d.getBarang().getKodeBarang();
                case 1:
                    return d.getBarang().getNamaBarang();
                case 2:
                    return d.getJumlahBarang();
                case 3:
                    return d.getHargaSatuan();
                case 4:
                    return d.getSubTotal();
                default:
                    return "";
                        
            }
        }
    }
    
    private void waktujalan()
    {
        Timer waktu = new Timer(1000, loadAction);
        waktu.start(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNoNota = new javax.swing.JLabel();
        txtNoNota = new javax.swing.JTextField();
        lblStatusUser = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblKodeCustomer = new javax.swing.JLabel();
        txtTotalBayar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBayar = new javax.swing.JTextField();
        txtKembali = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePenjualan = new javax.swing.JTable();
        txtKodeCustomer = new javax.swing.JTextField();
        btnDetailBarang = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnCariCustomer = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Penjualan");

        lblNoNota.setText("No Nota");

        lblStatusUser.setText("Status User :");

        lblStatus.setText("Status");

        lblKodeCustomer.setText("Kode Customer ");

        txtTotalBayar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txtTotalBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTotalBayarKeyReleased(evt);
            }
        });

        jLabel5.setText("Total Bayar");

        jLabel6.setText("Bayar");

        jLabel7.setText("Kembali");

        txtBayar.setEditable(false);
        txtBayar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        txtKembali.setEditable(false);
        txtKembali.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        tablePenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Barang", "Nama Barang", "Jumlah Barang", "Harga Satuan", "Total Harga"
            }
        ));
        jScrollPane1.setViewportView(tablePenjualan);

        txtKodeCustomer.setEditable(false);

        btnDetailBarang.setText("...");
        btnDetailBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailBarangActionPerformed(evt);
            }
        });

        jLabel1.setText("Detail Barang");

        btnCariCustomer.setText("Cari");
        btnCariCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariCustomerActionPerformed(evt);
            }
        });

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNoNota)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNoNota, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblKodeCustomer)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnDetailBarang)
                                    .addComponent(txtKodeCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCariCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(477, 613, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblStatusUser)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblStatus))
                                    .addComponent(btnCetak, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNoNota)
                    .addComponent(txtNoNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatusUser)
                    .addComponent(lblStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKodeCustomer)
                    .addComponent(txtKodeCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCariCustomer))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDetailBarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(btnCetak)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6))
                    .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    FormDetailPenjualan fdp;
    private void btnDetailBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailBarangActionPerformed
        // TODO add your handling code here:
        if(penjualan == null)
        {
            penjualan = new Penjualan();
            waktujalan();
        }
        if(!(txtNoNota.getText().length() > 0 && txtKodeCustomer.getText().length() > 0))
        {
            JOptionPane.showMessageDialog(null,
                    "Field No Nota dan Kode Customer harus diisi!","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        penjualan.setNoNota(Integer.parseInt(txtNoNota.getText()));
        penjualan.setCustomer(Main.getCustomerService().getCustomer(txtKodeCustomer.getText()));
        penjualan.setEmployee(Main.getEmployeeService().getEmployee(lblStatus.getText()));
        penjualan.setTanggalPenjualan(new Date());
        Main.getPenjualanService().save(penjualan);
        if(fdp == null)
            fdp = new FormDetailPenjualan(penjualan);
        fdp.setVisible(true);
    }//GEN-LAST:event_btnDetailBarangActionPerformed

    private CariCustomer cariCustomer;
    private void btnCariCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariCustomerActionPerformed
        // TODO add your handling code here:
        if(cariCustomer == null)
            cariCustomer = new CariCustomer(null, true);
        cariCustomer.setVisible(true);
        Customer customer = cariCustomer.getCustomer();
        txtKodeCustomer.setText(cariCustomer.getCustomer().getNip());
    }//GEN-LAST:event_btnCariCustomerActionPerformed

    private void txtTotalBayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalBayarKeyReleased
        // TODO add your handling code here:
        try
        {
            int kembali = Integer.parseInt(txtTotalBayar.getText()) - Integer.parseInt(txtBayar.getText());
            txtKembali.setText(String.valueOf(kembali));
        }
        catch(NumberFormatException ex)
        {
            txtKembali.setText("");
        }
    }//GEN-LAST:event_txtTotalBayarKeyReleased

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        if(!validateForm())
            return;
        penjualan.setBayar(Integer.parseInt(txtBayar.getText()));
        penjualan.setKembali(Integer.parseInt(txtKembali.getText()));
        penjualan.setCustomer(Main.getCustomerService().getCustomer(txtKodeCustomer.getText()));
        penjualan.setEmployee(Main.getEmployeeService().getEmployee(lblStatus.getText()));
        penjualan.setListDetailPenjualan(listDetailPenjualan);
        penjualan.setNoNota(Integer.parseInt(txtNoNota.getText()));
        penjualan.setTanggalPenjualan(new Date());
        penjualan.setTotalBayar(Integer.parseInt(txtTotalBayar.getText()));
        Main.getPenjualanService().save(penjualan);
        txtKodeCustomer.setText("");
        txtBayar.setText("");
        txtKembali.setText("");
        txtTotalBayar.setText("");
        updateNoNota();
        penjualan = new Penjualan();
        fdp = null;
        penjualan.setNoNota(Integer.parseInt(txtNoNota.getText()));
    }//GEN-LAST:event_btnCetakActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariCustomer;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnDetailBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKodeCustomer;
    private javax.swing.JLabel lblNoNota;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatusUser;
    private javax.swing.JTable tablePenjualan;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtKembali;
    private javax.swing.JTextField txtKodeCustomer;
    private javax.swing.JTextField txtNoNota;
    private javax.swing.JTextField txtTotalBayar;
    // End of variables declaration//GEN-END:variables
}
