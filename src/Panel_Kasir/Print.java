/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panel_Kasir;

import java.awt.print.PrinterException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public final class Print extends javax.swing.JFrame {

    /**
     * Creates new form Print
     */
    public Print() {
        initComponents();
        struk();
    }
public void struk() {
        
        Calendar clr = new GregorianCalendar();
        int tanggal = clr.get(Calendar.DAY_OF_MONTH);
        int bulan = clr.get(Calendar.MONTH)+1;
        int tahun = clr.get(Calendar.YEAR);

        int jam = clr.get(Calendar.HOUR);
        int menit = clr.get(Calendar.MINUTE);
        int detik = clr.get(Calendar.SECOND);
        int am_pm = clr.get(Calendar.AM_PM);
                    
        String siang_malam = "";
        if (am_pm == 1) {
        siang_malam = "PM";
        }
        else {
        siang_malam = "AM";
        }
        
        DefaultTableModel model_table = (DefaultTableModel)Kasir.jTable1.getModel();
        int baris = model_table.getRowCount(), kolom = model_table.getColumnCount();
        Object [][] data = new Object [baris][kolom];
 

        struk_belanja.append(
            "\n\t                 Surya Motor Rowotamtu"
            +"\n\t Jl. Airlangga 218 Rowwotamtu, Kec.Rampibuji, Kab.Jember"
            +"\n\t                 Telp. 085230491335"
            +"\n================================================================\n");

        struk_belanja.append("\t                Tgl. " + tanggal + "/" + bulan + "/" + tahun + 
                "   (" + jam + ":" + menit + ":" + detik + " " + siang_malam + ")");
        struk_belanja.append("\n================================================================\n"
                + "NoTransaksi :" + Kasir.NoTran.getText() +"\n"
                + "Nama Customer :" +Kasir.Customer.getText()
                +"\n================================================================\n"
                + " Nama Barang             "
                + "| Harga Barang           "
                + "| Banyak Barang          "
                + "| Jumlah               \n"
                + "================================================================\n");
            for(int i = 0; i < baris; i++) {
            for(int j = 4; j < kolom; j++) {
                data[i][j] = model_table.getValueAt(i, j);                                                                         
                struk_belanja.append((String) data[i][j] + "                 |                ");
            }
            struk_belanja.append("\n");
        }
        struk_belanja.append("================================================================\n"
                + "\t\t\tTotal            : " + Kasir.jLabel13.getText()
                + "\n\t\t\tTunai          : " + Kasir.Uang.getText()
                + "\n\t\t\tKembalian : " + Kasir.Kembalian.getText()
                + "\n================================================================\n"
                + "\t                           Terima Kasih"
                + "\n\t             Periksa Barang Sebelum Meninggalkan Toko"
                + "\n\t               Tunjukkan Stuk Jika Ada Kesalahan");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        struk_belanja = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        struk_belanja.setColumns(20);
        struk_belanja.setRows(5);
        struk_belanja.setEnabled(false);
        jScrollPane1.setViewportView(struk_belanja);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/PRINT.png"))); // NOI18N
        jButton1.setText("PRINT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            struk_belanja.print();
        } catch (PrinterException ex) {
            Logger.getLogger(Print.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Print().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea struk_belanja;
    // End of variables declaration//GEN-END:variables
}