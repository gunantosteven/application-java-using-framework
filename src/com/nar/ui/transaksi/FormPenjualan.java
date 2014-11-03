/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.ui.transaksi;

import com.nar.Main;
import com.nar.model.Barang;
import com.nar.model.Customer;
import com.nar.model.DetailPenjualan;
import com.nar.model.Employee;
import com.nar.model.JurnalUmum;
import com.nar.model.Penjualan;
import com.nar.ui.MenuUtama;
import com.nar.util.LineNumberTableRowHeader;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
    private JurnalUmum jurnalUmumPenjualan;
    private JurnalUmum jurnalUmumKas;
    /**
     * Creates new form Penjualan
     */
    public FormPenjualan() {
        initComponents();
        tablePenjualan.setAutoCreateColumnsFromModel(false);
        updateNoFaktur();
        lblStatus.setText(MenuUtama.getEmployee().getNik());
        
        LineNumberTableRowHeader tableLineNumber = new LineNumberTableRowHeader(jScrollPane1, tablePenjualan);
        tableLineNumber.setBackground(Color.LIGHT_GRAY);
        jScrollPane1.setRowHeaderView(tableLineNumber);
    }
    
    private void loadFormPenjualanToModel()
    {
        penjualan.setCustomer(Main.getCustomerService().getCustomer(txtKodeCustomer.getText()));
        penjualan.setEmployee(MenuUtama.getEmployee());
        penjualan.setListDetailPenjualan(listDetailPenjualan);
        penjualan.setNoFaktur(txtNoNota.getText());
        penjualan.setTanggalPenjualan(calendarComboBoxTanggal.getDate());
        penjualan.setTotalBayar(Integer.parseInt(txtBayar.getText()));
        
        // set all penjualan variable in detailPenjualan class
        for(DetailPenjualan detailPenjualan : listDetailPenjualan)
            detailPenjualan.setPenjualan(penjualan);
        
        jurnalUmumPenjualan.setDk("K");
        jurnalUmumPenjualan.setEmployee(MenuUtama.getEmployee());
        jurnalUmumPenjualan.setFaktur(txtNoNota.getText());
        jurnalUmumPenjualan.setMasterAkun(Main.getMasterAkunService().getMasterAkun("400"));
        jurnalUmumPenjualan.setSaldo(Integer.parseInt(txtBayar.getText()));
        jurnalUmumPenjualan.setTanggal(calendarComboBoxTanggal.getDate());
        
        jurnalUmumKas.setDk("D");
        jurnalUmumKas.setEmployee(MenuUtama.getEmployee());
        jurnalUmumKas.setFaktur(txtNoNota.getText());
        jurnalUmumKas.setMasterAkun(Main.getMasterAkunService().getMasterAkun("101"));
        jurnalUmumKas.setSaldo(Integer.parseInt(txtBayar.getText()));
        jurnalUmumKas.setTanggal(calendarComboBoxTanggal.getDate());
    }
    
    private void loadFormDetailPenjualanToModel()
    {
        detailPenjualan.setPenjualan(penjualan);   
        detailPenjualan.setBarang(Main.getBarangService().getBarang(txtKodeBarang.getText()));
        detailPenjualan.setHargaSatuan(Integer.parseInt(txtHargaSatuan.getText()));
        detailPenjualan.setJumlahBarang(Integer.parseInt(txtJumlahBarang.getText()));
    }
    
    public void updateNoFaktur()
    {
        txtNoNota.setText((Main.getPenjualanService().getListPenjualan().size() + 1) + "");
    }
    
    private void refreshTable()
    {
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
        long total = 0;
        
        Iterator<DetailPenjualan> iterator = listDetailPenjualan.iterator();
        while(iterator.hasNext())
        {
            DetailPenjualan detailPenjualan = iterator.next();
            total += detailPenjualan.getJumlahBarang() * detailPenjualan.getHargaSatuan();
        }

        txtBayar.setText(total + "");
    }
    
    private void hitungKembali()
    {
        try
        {
            long totalBayar = txtTotalBayar.getText().trim().equals("") ? 0 : Integer.parseInt(txtTotalBayar.getText());
            long bayar = txtBayar.getText().trim().equals("") ? 0 : Integer.parseInt(txtBayar.getText());
            long kembali = totalBayar - bayar;
            txtKembali.setText(String.valueOf(kembali));
        }
        catch(NumberFormatException ex)
        {
            txtKembali.setText("0");
        }
    }
    
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
                    return d.getJumlahBarang() * d.getHargaSatuan();
                default:
                    return "";
                        
            }
        }
    }
    
    private void refresh()
    {
        txtKodeCustomer.setText("");
        txtBayar.setText("");
        txtKembali.setText("");
        txtTotalBayar.setText("");
        
        updateNoFaktur();
        refreshDetailPenjualan();
        
        listDetailPenjualan = new ArrayList<DetailPenjualan>();
        
        refreshTable();
        
        txtKodeCustomer.requestFocusInWindow();
    }
    
    private void refreshDetailPenjualan()
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

        lblNoFaktur = new javax.swing.JLabel();
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
        btnCariCustomer = new javax.swing.JButton();
        btnMasukan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtKodeBarang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNamaBarang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtJumlahBarang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHargaSatuan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTotalHarga = new javax.swing.JTextField();
        btnHapus = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        calendarComboBoxTanggal = new de.wannawork.jcalendar.JCalendarComboBox();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setResizable(true);
        setTitle("Penjualan");

        lblNoFaktur.setText("No Faktur");

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

        btnCariCustomer.setText("Cari");
        btnCariCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariCustomerActionPerformed(evt);
            }
        });

        btnMasukan.setText("Masukan");
        btnMasukan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasukanActionPerformed(evt);
            }
        });

        jLabel2.setText("Kode Barang");

        txtKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeBarangActionPerformed(evt);
            }
        });

        jLabel1.setText("Nama Barang");

        txtNamaBarang.setEditable(false);

        jLabel3.setText("Jumlah Barang");

        txtJumlahBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtJumlahBarangKeyReleased(evt);
            }
        });

        jLabel4.setText("Harga Satuan");

        jLabel8.setText("Total Harga");

        txtTotalHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalHargaActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jButton2.setText("Selesai");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Tanggal Penjualan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNoFaktur)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNoNota, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblKodeCustomer)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtKodeCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtKodeBarang)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCariCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(calendarComboBoxTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblStatusUser)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblStatus))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtHargaSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTotalHarga, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))))
                            .addComponent(jScrollPane1))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnMasukan)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus))
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNoFaktur)
                        .addComponent(txtNoNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblStatusUser)
                        .addComponent(lblStatus)
                        .addComponent(jLabel9))
                    .addComponent(calendarComboBoxTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKodeCustomer)
                    .addComponent(txtKodeCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCariCustomer))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtHargaSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMasukan)
                            .addComponent(btnHapus)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2))
                            .addComponent(jLabel7))))
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private CariCustomer cariCustomer;
    private void btnCariCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariCustomerActionPerformed
        // TODO add your handling code here:
        if(cariCustomer == null)
            cariCustomer = new CariCustomer(null, true);
        cariCustomer.setLocationRelativeTo(null);
        cariCustomer.setVisible(true);
        Customer customer = cariCustomer.getCustomer();
        txtKodeCustomer.setText(cariCustomer.getCustomer().getNip());
    }//GEN-LAST:event_btnCariCustomerActionPerformed

    private void txtTotalBayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalBayarKeyReleased
        // TODO add your handling code here:
        hitungKembali();
    }//GEN-LAST:event_txtTotalBayarKeyReleased

    private void btnMasukanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasukanActionPerformed
        // TODO add your handling code here:
        if(listDetailPenjualan == null)
            listDetailPenjualan = new ArrayList<DetailPenjualan>();
        detailPenjualan = new DetailPenjualan();
        loadFormDetailPenjualanToModel();
        listDetailPenjualan.add(detailPenjualan);
        refreshTable();
        refreshDetailPenjualan();
        hitung();
        hitungKembali();
    }//GEN-LAST:event_btnMasukanActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(!validateForm())
            return;
        
        if(penjualan == null)
            penjualan = new Penjualan();
        
        if(jurnalUmumPenjualan == null)
            jurnalUmumPenjualan = new JurnalUmum();
        
        if(jurnalUmumKas == null)
            jurnalUmumKas = new JurnalUmum();
        
        loadFormPenjualanToModel();
        Main.getPenjualanService().save(penjualan);
        Main.getBarangService().kurangStock(listDetailPenjualan);
        Main.getJurnalUmumService().save(jurnalUmumKas);
        Main.getJurnalUmumService().save(jurnalUmumPenjualan);
        
        jurnalUmumPenjualan.setId(0);
        jurnalUmumKas.setId(0);
        
        refresh();
    }//GEN-LAST:event_jButton2ActionPerformed

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
        txtHargaSatuan.setText(String.valueOf(b.getHargaJual()));
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

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tablePenjualan.getSelectedRow();
        if(selectedIndex >= 0)
            listDetailPenjualan.remove(tablePenjualan.getSelectedRow());
        refreshTable();
        refreshDetailPenjualan();
        hitung();
        hitungKembali();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtTotalHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalHargaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariCustomer;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnMasukan;
    private de.wannawork.jcalendar.JCalendarComboBox calendarComboBoxTanggal;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKodeCustomer;
    private javax.swing.JLabel lblNoFaktur;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatusUser;
    private javax.swing.JTable tablePenjualan;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtHargaSatuan;
    private javax.swing.JTextField txtJumlahBarang;
    private javax.swing.JTextField txtKembali;
    private javax.swing.JTextField txtKodeBarang;
    private javax.swing.JTextField txtKodeCustomer;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtNoNota;
    private javax.swing.JTextField txtTotalBayar;
    private javax.swing.JTextField txtTotalHarga;
    // End of variables declaration//GEN-END:variables
}
