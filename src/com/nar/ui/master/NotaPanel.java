/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.ui.master;

import com.nar.Main;
import com.nar.model.Admin;
import com.nar.model.Employee;
import com.nar.model.Nota;
import com.nar.model.Supervisor;
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
public class NotaPanel extends javax.swing.JInternalFrame {

    private Nota nota;
    private List<Nota> listNota;
    private String user;
    private static final Logger log = Logger.getLogger(NotaPanel.class);
    /**
     * Creates new form NotaPanel
     */
    public NotaPanel(String user) {
        initComponents();
        this.user = user;
        tableNota.setAutoCreateColumnsFromModel(false);
        tableNota.getSelectionModel().addListSelectionListener(new NotaSelectionListener());
        refreshTable();
    }
    
    private void loadFormToModel()
    {
        Employee employee = null;
        employee = Main.getEmployeeService().getEmployee(user);
        nota.setNoNota(Integer.parseInt(txtNoNota.getText()));
        nota.setEmployee(employee);
    }
    
    private void loadModelToForm()
    {
        txtNoNota.setText(String.valueOf(nota.getNoNota()));
    }
    
    private void refreshTable()
    {
        listNota = Main.getNotaService().getListNota();
        tableNota.setModel(new NotaTableModel(listNota));
    }
    
    private class NotaTableModel extends AbstractTableModel
     {
        private List<Nota> listNota;
        
        public NotaTableModel(List<Nota> listNota)
        {
            this.listNota = listNota;
        }
        
        public int getRowCount()
        {
            return listNota.size();
        }
        
        public int getColumnCount()
        {
            return 1;
        }
        
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            Nota n =  listNota.get(rowIndex);
            
            switch(columnIndex)
            {
                case 0:
                    return n.getNoNota();
                default:
                    return "";
            }
        }
    }
    
    private class NotaSelectionListener implements ListSelectionListener
    {
        public void valueChanged(ListSelectionEvent  e)
        {
            if(tableNota.getSelectedRow() >= 0)
            {
                nota = listNota.get(tableNota.getSelectedRow());
                nota = Main.getNotaService().getNota(nota.getNoNota());
                loadModelToForm();
            }
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

        lblNoNota = new javax.swing.JLabel();
        txtNoNota = new javax.swing.JTextField();
        btnMasukan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableNota = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Nota");

        lblNoNota.setText("No Nota");

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

        tableNota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nota"
            }
        ));
        jScrollPane3.setViewportView(tableNota);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMasukan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHapus)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNoNota)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNoNota)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNoNota)
                    .addComponent(txtNoNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMasukan)
                    .addComponent(btnHapus))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMasukanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasukanActionPerformed
        // TODO add your handling code here:
        if(txtNoNota.getText().length() > 0)
        {
            if(nota == null)
            {
                nota = new Nota();
            }
            loadFormToModel();
            try
            {
                Main.getNotaService().save(nota);
                refreshTable();
            }
            catch(Exception ex)
            {
                log.error(ex);
                JOptionPane.showMessageDialog(this, "Data gagal disimpan!"
                        ,"Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnMasukanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        if(nota != null)
        {
            try
            {
                Main.getNotaService().delete(nota);
                nota = null;
                refreshTable();
            }
            catch(Exception ex)
            {
                log.error(ex);
                JOptionPane.showMessageDialog(this, "Data masih digunakan tidak bisa dihapus!"
                        ,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnMasukan;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblNoNota;
    private javax.swing.JTable tableNota;
    private javax.swing.JTextField txtNoNota;
    // End of variables declaration//GEN-END:variables
}
