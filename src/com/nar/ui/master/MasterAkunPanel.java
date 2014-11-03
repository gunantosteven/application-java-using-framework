/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.ui.master;

import com.nar.Main;
import com.nar.model.MasterAkun;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author Steven Gunanto
 */
public class MasterAkunPanel extends javax.swing.JInternalFrame {

    private MasterAkun masterAkun;
    private List<MasterAkun> listMasterAkun;
    
    private static final Logger log = Logger.getLogger(MasterAkunPanel.class);
    
    /**
     * Creates new form MasterAkunPanel
     */
    public MasterAkunPanel() {
        initComponents();
        
        tableMasterAkun.setAutoCreateColumnsFromModel(false);
        tableMasterAkun.getSelectionModel().addListSelectionListener(new MasterAkunSelectionListener());
        refreshTable();
    }
    
    private void loadFormToModel()
    {
        masterAkun.setKodeAkun(txtNomerAkun.getText());
        masterAkun.setNamaAkun(txtNamaAkun.getText());
    }
    
    private void loadModelToForm()
    {
        txtNomerAkun.setText(masterAkun.getKodeAkun());
        txtNamaAkun.setText(masterAkun.getNamaAkun());
    }

    private class MasterAkunTableModel extends AbstractTableModel
    {
        private List<MasterAkun> listMasterAkun;
        
        public MasterAkunTableModel(List<MasterAkun> listMasterAkun)
        {
            this.listMasterAkun = listMasterAkun;
        }
        
        public int getRowCount()
        {
            return listMasterAkun.size();
        }
        
        public int getColumnCount()
        {
            return 2;
        }
        
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            MasterAkun m =  listMasterAkun.get(rowIndex);
            
            switch(columnIndex)
            {
                case 0:
                    return m.getKodeAkun();
                case 1:
                    return m.getNamaAkun();
                default:
                    return "";
            }
        }
    }
    private void refreshTable()
    {
        listMasterAkun = Main.getMasterAkunService().getListMasterAkun();
        tableMasterAkun.setModel(new MasterAkunTableModel(listMasterAkun));
    }
    
    
    private class MasterAkunSelectionListener implements ListSelectionListener
    {
        public void valueChanged(ListSelectionEvent  e)
        {
            if(tableMasterAkun.getSelectedRow() >= 0)
            {
                masterAkun = listMasterAkun.get(tableMasterAkun.getSelectedRow());
                masterAkun = Main.getMasterAkunService().getMasterAkun(masterAkun.getKodeAkun());
                loadModelToForm();
            }
        }
    }
    
    private boolean validateForm()
    {
        if(txtNomerAkun.getText().length() > 0 &&
           txtNamaAkun.getText().length() > 0 )
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
        txtNomerAkun.setText("");
        txtNamaAkun.setText("");
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
        jLabel2 = new javax.swing.JLabel();
        txtNomerAkun = new javax.swing.JTextField();
        txtNamaAkun = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMasterAkun = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Master Akun");

        jLabel1.setText("Nomer Akun");

        jLabel2.setText("Nama AKun");

        tableMasterAkun.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nomer Akun", "Nama Akun"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableMasterAkun);

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNamaAkun, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomerAkun, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSimpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomerAkun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtNamaAkun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnDelete))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(validateForm())
        {
            if(masterAkun == null)
            {
                masterAkun = new MasterAkun();
            }
            loadFormToModel();
            try
            {
                Main.getMasterAkunService().save(masterAkun);
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

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:        
        if(masterAkun != null)
        {
            try
            {
                Main.getMasterAkunService().delete(masterAkun);
                masterAkun = null;
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
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMasterAkun;
    private javax.swing.JTextField txtNamaAkun;
    private javax.swing.JTextField txtNomerAkun;
    // End of variables declaration//GEN-END:variables
}
