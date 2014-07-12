/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.ui.transaksi;

import com.nar.Main;
import com.nar.model.Barang;
import com.nar.model.DetailPenjualan;
import com.nar.model.Employee;
import com.nar.model.Operator;
import com.nar.model.Penjualan;
import com.nar.model.Supervisor;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gunanto
 */
public class FormDetailPenjualan extends javax.swing.JDialog {

    private DetailPenjualan detailPenjualan;
    private List<DetailPenjualan> listDetailPenjualan;
    private Penjualan penjualan;
    /**
     * Creates new form DetailPenjualan
     */
    public FormDetailPenjualan(Penjualan penjualan) {
        initComponents();
        this.penjualan = penjualan;
        tableDetailPenjualan.setAutoCreateColumnsFromModel(false);
        tableDetailPenjualan.getSelectionModel().addListSelectionListener(new DetailPenjualanSelectionListener());
    }

    public void setPenjualan(Penjualan penjualan) {
        this.penjualan = penjualan;
    }
    
    public void refreshTable()
    {
        listDetailPenjualan = Main.getDetailPenjualanService().getDetailsPenjualan(penjualan.getNoNota());
        tableDetailPenjualan.setModel(new DetailPenjualanTableModel(listDetailPenjualan));
    }
    
    private void kurangStock()
    {
        Barang b = Main.getBarangService().getBarang(detailPenjualan.getBarang().getKodeBarang());
        int kurangStock = b.getStock() - Integer.parseInt(txtJumlahBarang.getText());
        b.setStock(kurangStock);
        Main.getBarangService().save(b);
    }
    
    private void tambahStock()
    {
        Barang b = Main.getBarangService().getBarang(detailPenjualan.getBarang().getKodeBarang());
        int kurangStock = b.getStock() + Integer.parseInt(txtJumlahBarang.getText());
        b.setStock(kurangStock);
        Main.getBarangService().save(b);
    }
    
    private void clear()
    {
        txtJumlahBarang.setText("");
        txtKodeBarang.setText("");
        txtNamaBarang.setText("");
        txtRp.setText("");
        txtStock.setText("");
        txtTotalHarga.setText("");
    }
    
    private void loadFormToModel()
    {
        Employee employee = null;
        if(penjualan.getEmployee().getNik().startsWith("opt"))
        {
            employee = (Employee) Main.getEmployeeService().getEmployee(penjualan.getEmployee().getNik());
        }   
        else if(penjualan.getEmployee().getNik().startsWith("spv"))
        {
            employee = (Employee) Main.getEmployeeService().getEmployee(penjualan.getEmployee().getNik());
        }
        detailPenjualan.setBarang(Main.getBarangService().getBarang(txtKodeBarang.getText()));
        detailPenjualan.setNoNota(penjualan.getNoNota());
        detailPenjualan.setHargaSatuan(Integer.parseInt(txtRp.getText()));
        detailPenjualan.setJumlahBarang(Integer.parseInt(txtJumlahBarang.getText()));
        detailPenjualan.setPenjualan(penjualan);
        detailPenjualan.setSubTotal(Integer.parseInt(txtTotalHarga.getText()));
    }
    
    private void loadModelToForm()
    {
        int stock = detailPenjualan.getBarang().getStock();
        txtStock.setText(String.valueOf(stock));
        txtRp.setText(String.valueOf(detailPenjualan.getHargaSatuan()));
        txtJumlahBarang.setText(String.valueOf(detailPenjualan.getJumlahBarang()));
        txtKodeBarang.setText(detailPenjualan.getBarang().getKodeBarang());
        txtNamaBarang.setText(Main.getBarangService().getBarang(txtKodeBarang.getText()).getNamaBarang());
        txtJumlahBarang.setText(String.valueOf(detailPenjualan.getJumlahBarang()));
        txtTotalHarga.setText(String.valueOf(detailPenjualan.getSubTotal()));
    }
    
    private class DetailPenjualanTableModel extends AbstractTableModel
    {
        private List<DetailPenjualan> listDetailPenjualan;
        
        public DetailPenjualanTableModel(List<DetailPenjualan> listDetailPenjualan)
        {
            this.listDetailPenjualan = listDetailPenjualan;
        }
        
        public int getRowCount()
        {
            return listDetailPenjualan.size();
        }
        
        public int getColumnCount()
        {
            return 6;
        }
        
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            DetailPenjualan d = listDetailPenjualan.get(rowIndex);
            switch(columnIndex)
            {
                case 0:
                    return d.getId();
                case 1:
                    return d.getBarang().getKodeBarang();
                case 2:
                    return d.getBarang().getNamaBarang();
                case 3:
                    return d.getJumlahBarang();
                case 4:
                    return d.getHargaSatuan();
                case 5:
                    return d.getSubTotal();
                default:
                    return "";
                        
            }
        }
    }
    
    private class DetailPenjualanSelectionListener implements ListSelectionListener
    {
        public void valueChanged(ListSelectionEvent e)
        {
            if(tableDetailPenjualan.getSelectedRow()>=0)
            {
                detailPenjualan = listDetailPenjualan.get(tableDetailPenjualan.getSelectedRow());
                detailPenjualan = Main.getDetailPenjualanService().getDetailPenjualan(detailPenjualan.getId());
                loadModelToForm();
            }
        }
    }
    
    private boolean validateForm()
    {
        if(txtKodeBarang.getText().length() > 0 &&
           txtJumlahBarang.getText().length() > 0)
            return true;
        else
            return false;
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
        txtKodeBarang = new javax.swing.JTextField();
        lblStock = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        lblJumlahBarang = new javax.swing.JLabel();
        txtJumlahBarang = new javax.swing.JTextField();
        lblRp = new javax.swing.JLabel();
        txtRp = new javax.swing.JTextField();
        lblTotalHarga = new javax.swing.JLabel();
        txtTotalHarga = new javax.swing.JTextField();
        btnCariBarang = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDetailPenjualan = new javax.swing.JTable();
        lblNamaBarang = new javax.swing.JLabel();
        txtNamaBarang = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();

        setTitle("Detail Penjualan");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblKodeBarang.setText("Kode Barang");

        txtKodeBarang.setEditable(false);

        lblStock.setText("Stock");

        txtStock.setEditable(false);

        lblJumlahBarang.setText("Jumlah Barang");

        txtJumlahBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtJumlahBarangKeyReleased(evt);
            }
        });

        lblRp.setText("@ \"Rp\"");

        txtRp.setEditable(false);

        lblTotalHarga.setText("Total Harga");

        txtTotalHarga.setEditable(false);

        btnCariBarang.setText("Cari Barang");
        btnCariBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariBarangActionPerformed(evt);
            }
        });

        tableDetailPenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Kode Barang", "Nama Barang", "Jumlah Barang", "Harga Satuan", "Total Harga"
            }
        ));
        jScrollPane1.setViewportView(tableDetailPenjualan);

        lblNamaBarang.setText("Nama Barang");

        txtNamaBarang.setEditable(false);

        btnSimpan.setText("Tambah");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
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
                        .addComponent(lblKodeBarang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCariBarang))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStock)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblJumlahBarang))
                            .addComponent(lblNamaBarang))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSimpan)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblRp, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblTotalHarga, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtRp, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addComponent(txtTotalHarga))
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKodeBarang)
                    .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCariBarang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStock)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJumlahBarang)
                    .addComponent(txtJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRp, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalHarga)
                            .addComponent(txtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNamaBarang)
                            .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus))
                .addContainerGap(180, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(151, 151, 151)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(15, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    CariBarang cariBarang;
    private void btnCariBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariBarangActionPerformed
        // TODO add your handling code here:
        if(cariBarang == null)
             cariBarang = new CariBarang(null, true);
        cariBarang.setVisible(true);
        Barang b = cariBarang.getBarang();
        txtStock.setText(String.valueOf(b.getStock()));
        txtKodeBarang.setText(b.getKodeBarang());
        txtNamaBarang.setText(b.getNamaBarang());
        txtRp.setText(String.valueOf(b.getHargaJual()));
        detailPenjualan = null;
    }//GEN-LAST:event_btnCariBarangActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(validateForm())
        {
            if(detailPenjualan == null)
                detailPenjualan = new DetailPenjualan();
            loadFormToModel();
            kurangStock();
            Main.getDetailPenjualanService().save(detailPenjualan); 
            refreshTable();
            clear();
        }
        else
            JOptionPane.showMessageDialog(null, "Jumlah Barang belum diisi");
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        if(validateForm())
        {
            loadFormToModel();
            Main.getDetailPenjualanService().delete(detailPenjualan);
            tambahStock();
            detailPenjualan = null;         
            refreshTable();
            clear();
        }
        else
            JOptionPane.showMessageDialog(null, "Jumlah Barang belum diisi");
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtJumlahBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahBarangKeyReleased
        // TODO add your handling code here:
        try
        {
            int total = Integer.parseInt(txtJumlahBarang.getText()) * Integer.parseInt(txtRp.getText());
            txtTotalHarga.setText(String.valueOf(total));
        }
        catch(NumberFormatException ex)
        {
            txtTotalHarga.setText("");
        }
        
    }//GEN-LAST:event_txtJumlahBarangKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        refreshTable();
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariBarang;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblJumlahBarang;
    private javax.swing.JLabel lblKodeBarang;
    private javax.swing.JLabel lblNamaBarang;
    private javax.swing.JLabel lblRp;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblTotalHarga;
    private javax.swing.JTable tableDetailPenjualan;
    private javax.swing.JTextField txtJumlahBarang;
    private javax.swing.JTextField txtKodeBarang;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtRp;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTotalHarga;
    // End of variables declaration//GEN-END:variables
}
