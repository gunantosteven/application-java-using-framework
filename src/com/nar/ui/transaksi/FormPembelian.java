/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.ui.transaksi;

import com.nar.Main;
import com.nar.model.Barang;
import com.nar.model.DetailPembelian;
import com.nar.model.JurnalUmum;
import com.nar.model.Pembelian;
import com.nar.model.Supplier;
import com.nar.ui.MenuUtama;
import com.nar.util.LineNumberTableRowHeader;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Steven Gunanto
 */
public class FormPembelian extends javax.swing.JInternalFrame {

    private DetailPembelian detailPembelian;
    private List<DetailPembelian> listDetailPembelian;
    private Pembelian pembelian;
    private JurnalUmum jurnalUmumPembelian;
    private JurnalUmum jurnalUmumKas;
    
    /**
     * Creates new form FormPembeliana
     */
    public FormPembelian() {
        initComponents();
        
        tablePembelian.setAutoCreateColumnsFromModel(false);
        
        LineNumberTableRowHeader tableLineNumber = new LineNumberTableRowHeader(jScrollPane1, tablePembelian);
        tableLineNumber.setBackground(Color.LIGHT_GRAY);
        jScrollPane1.setRowHeaderView(tableLineNumber);
        
        updateNoFaktur();
    }
    
    private void loadFormPembelianToModel()
    {
        pembelian.setSupplier(Main.getSupplierService().getSupplier(txtKodeSupplier.getText()));
        pembelian.setEmployee(MenuUtama.getEmployee());
        pembelian.setListDetailPembelian(listDetailPembelian);
        pembelian.setNoFaktur(txtNoFaktur.getText());
        pembelian.setTanggalPembelian(new Date());
        pembelian.setTotalBayar(Integer.parseInt(txtBayar.getText()));
        
        // set all pembelian variable in detailPembelian class
        for(DetailPembelian detailPembelian : listDetailPembelian)
            detailPembelian.setPembelian(pembelian);
        
        jurnalUmumPembelian.setDk("D");
        jurnalUmumPembelian.setEmployee(MenuUtama.getEmployee());
        jurnalUmumPembelian.setFaktur(txtNoFaktur.getText());
        jurnalUmumPembelian.setMasterAkun(Main.getMasterAkunService().getMasterAkun("500"));
        jurnalUmumPembelian.setSaldo(Integer.parseInt(txtBayar.getText()));
        jurnalUmumPembelian.setTanggal(new Date());
        
        jurnalUmumKas.setDk("K");
        jurnalUmumKas.setEmployee(MenuUtama.getEmployee());
        jurnalUmumKas.setFaktur(txtNoFaktur.getText());
        jurnalUmumKas.setMasterAkun(Main.getMasterAkunService().getMasterAkun("101"));
        jurnalUmumKas.setSaldo(Integer.parseInt(txtBayar.getText()));
        jurnalUmumKas.setTanggal(new Date());
    }
    
    private void loadFormDetailPembelianToModel()
    {
        detailPembelian.setPembelian(pembelian);
        detailPembelian.setBarang(Main.getBarangService().getBarang(txtKodeBarang.getText()));
        detailPembelian.setHargaSatuan(Integer.parseInt(txtHargaSatuan.getText()));
        detailPembelian.setJumlahBarang(Integer.parseInt(txtJumlahBarang.getText()));
        detailPembelian.setSubTotal(Integer.parseInt(txtTotalHarga.getText()));
    }
    
    public void updateNoFaktur()
    {
        txtNoFaktur.setText((Main.getPembelianService().getListPembelian().size() + 1) + "");
    }
    
    private void refreshTable()
    {
        tablePembelian.setModel(new PembelianTableModel(listDetailPembelian));
    }
    
    private boolean validateForm()
    {
        if(txtBayar.getText().length() >  0 &&
           txtKodeSupplier.getText().length() > 0 &&
           txtNoFaktur.getText().length() > 0)
            return true;
        else
        {
            JOptionPane.showMessageDialog(null,
                    "Isi semua field!","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    private class PembelianTableModel extends AbstractTableModel
    {
        private List<DetailPembelian> detailPembelian;
        private String[] titles = new String [] {
                "Kode Barang", "Nama Barang", "Jumlah Barang", "Harga Satuan", "Total Harga"
            };
        
        public PembelianTableModel(List<DetailPembelian> detailPembelian) {
            this.detailPembelian = detailPembelian;
        }

        public void setDetailPembelian(List<DetailPembelian> detailPembelian) {
            this.detailPembelian = detailPembelian;
        }
        
        @Override
        public int getRowCount() {
            return detailPembelian.size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }
        
        @Override
        public String getColumnName(int column) {
            return titles[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            DetailPembelian d = detailPembelian.get(rowIndex);
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

    
    private void hitung()
    {
        long total = 0;
        
        Iterator<DetailPembelian> iterator = listDetailPembelian.iterator();
        while(iterator.hasNext())
        {
            DetailPembelian detailPembelian = iterator.next();
            total += detailPembelian.getSubTotal();
        }

        txtBayar.setText(total + "");
    }
    
    private void refresh()
    {
        txtKodeSupplier.setText("");
        txtBayar.setText("");
        
        refreshDetailPembelian();
        
        listDetailPembelian = new ArrayList<DetailPembelian>();
        
        refreshTable();
        
        txtNoFaktur.requestFocusInWindow();
        
        updateNoFaktur();
    }
    
    private void refreshDetailPembelian()
    {
        txtKodeBarang.setText("");
        txtNamaBarang.setText("");
        txtJumlahBarang.setText("");
        txtHargaSatuan.setText("");
        txtTotalHarga.setText("");
        
        txtKodeBarang.requestFocusInWindow();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNoFaktur = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtKodeSupplier = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePembelian = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtKodeBarang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNamaBarang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtJumlahBarang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtHargaSatuan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTotalHarga = new javax.swing.JTextField();
        txtBayar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnMasukan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnSelesai = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Pembelian");

        jLabel1.setText("No Faktur");

        jLabel2.setText("Kode Supplier");

        txtKodeSupplier.setEditable(false);

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        tablePembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Barang", "Nama Barang", "Jumlah Barang", "Harga Satuan", "Total Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablePembelian);

        jLabel3.setText("Kode Barang");

        txtKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeBarangActionPerformed(evt);
            }
        });

        jLabel4.setText("Nama Barang");

        txtNamaBarang.setEditable(false);

        jLabel5.setText("Jumlah Barang");

        txtJumlahBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtJumlahBarangKeyReleased(evt);
            }
        });

        jLabel6.setText("Harga Satuan");

        jLabel8.setText("Total Harga");

        txtBayar.setEditable(false);
        txtBayar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        jLabel7.setText("Bayar");

        btnMasukan.setText("Masukan");
        btnMasukan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasukanActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnSelesai.setText("Selesai");
        btnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelesaiActionPerformed(evt);
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
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMasukan)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKodeBarang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHargaSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNoFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtKodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCari)))
                        .addGap(576, 652, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSelesai)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNoFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtHargaSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMasukan)
                        .addComponent(btnHapus)))
                .addGap(18, 18, 18)
                .addComponent(btnSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    CariBarang cariBarang;
    private void txtKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeBarangActionPerformed
        // TODO add your handling code here:
        if(cariBarang == null)
             cariBarang = new CariBarang(null, true);
        cariBarang.setLocationRelativeTo(null);
        cariBarang.setVisible(true);
        Barang b = cariBarang.getBarang();
        txtKodeBarang.setText(b.getKodeBarang());
        txtNamaBarang.setText(b.getNamaBarang());
        txtHargaSatuan.setText(String.valueOf(b.getHargaBeli()));
    }//GEN-LAST:event_txtKodeBarangActionPerformed

    private void txtJumlahBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahBarangKeyReleased
        // TODO add your handling code here:
        try
        {
            int total = Integer.parseInt(txtJumlahBarang.getText()) * Integer.parseInt(txtHargaSatuan.getText());
            txtTotalHarga.setText(String.valueOf(total));
        }
        catch(NumberFormatException ex)
        {
            txtTotalHarga.setText("");
        }
    }//GEN-LAST:event_txtJumlahBarangKeyReleased

    private void btnMasukanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasukanActionPerformed
        // TODO add your handling code here:
        if(listDetailPembelian == null)
            listDetailPembelian = new ArrayList<DetailPembelian>();
        detailPembelian = new DetailPembelian();
        loadFormDetailPembelianToModel();
        listDetailPembelian.add(detailPembelian);
        refreshTable();
        refreshDetailPembelian();
        hitung();
    }//GEN-LAST:event_btnMasukanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tablePembelian.getSelectedRow();
        if(selectedIndex >= 0)
            listDetailPembelian.remove(tablePembelian.getSelectedRow());
        refreshTable();
        refreshDetailPembelian();
        hitung();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelesaiActionPerformed
        // TODO add your handling code here:
        if(!validateForm())
            return;
        
        if(pembelian == null)
            pembelian = new Pembelian();
        
        if(jurnalUmumPembelian == null)
            jurnalUmumPembelian = new JurnalUmum();
        
        if(jurnalUmumKas == null)
            jurnalUmumKas = new JurnalUmum();
        
        loadFormPembelianToModel();
        Main.getPembelianService().save(pembelian);
        Main.getBarangService().tambahStock(listDetailPembelian);
        Main.getJurnalUmumService().save(jurnalUmumKas);
        Main.getJurnalUmumService().save(jurnalUmumPembelian);
        
        jurnalUmumKas.setId(0);
        jurnalUmumPembelian.setId(0);
        
        refresh();
    }//GEN-LAST:event_btnSelesaiActionPerformed

    private CariSupplier cariSupplier;
    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        if(cariSupplier == null)
            cariSupplier = new CariSupplier(null, true);
        cariSupplier.setLocationRelativeTo(null);
        cariSupplier.setVisible(true);
        Supplier supplier = cariSupplier.getSupplier();
        txtKodeSupplier.setText(cariSupplier.getSupplier().getKodeSupplier());
    }//GEN-LAST:event_btnCariActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnMasukan;
    private javax.swing.JButton btnSelesai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePembelian;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtHargaSatuan;
    private javax.swing.JTextField txtJumlahBarang;
    private javax.swing.JTextField txtKodeBarang;
    private javax.swing.JTextField txtKodeSupplier;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtNoFaktur;
    private javax.swing.JTextField txtTotalHarga;
    // End of variables declaration//GEN-END:variables
}
