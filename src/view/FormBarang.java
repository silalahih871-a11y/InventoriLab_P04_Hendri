
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Barang;

/**
 *
 * @author ASUS
 */
public class FormBarang extends javax.swing.JFrame {
    
    private static final long serialVersionUID = 1L;
    private final List<Barang> daftarBarang = new ArrayList<Barang>();
    private DefaultTableModel modelTabel;

    /**
     * Creates new form FormBarang
     */
    public FormBarang() {
        initComponents();
        siapkanTabel();
    isiDataContoh();
    setLocationRelativeTo(null);
    }

    private void siapkanTabel() {
    modelTabel = new DefaultTableModel(
        new Object[]{"Kode", "Nama Barang", "Tersedia"}, 0) {

        private static final long serialVersionUID = 1L;

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    tblBarang.setModel(modelTabel);

    tblBarang.setRowHeight(26);
    tblBarang.getTableHeader().setReorderingAllowed(false);
}
    private void isiDataContoh() {
        daftarBarang.add(new Barang("BRG-001", "Keyboard USB",10));
        daftarBarang.add(new Barang("BRG-002", "Mouse USB",8));
        perbaruiTabel();
    lblStatus.setText("Siap. Dua data contoh dimuat di memori.");
}

private void perbaruiTabel() {
    modelTabel.setRowCount(0);
    for (Barang barang : daftarBarang) {
        modelTabel.addRow(new Object[]{
            barang.getKode(),
            barang.getNama(),
            barang.getJumlahTersedia()
        });
    }
}

private void bersihkanInput() {
    txtKode.setText("");
    txtNama.setText("");
    txtJumlah.setText("");
    txtKode.requestFocusInWindow();
}

private void tambahDemo() {
    String kode = txtKode.getText().trim();
    String nama = txtNama.getText().trim();
    String teksJumlah = txtJumlah.getText().trim();

    try {
        if (kode.isEmpty() || nama.isEmpty() || teksJumlah.isEmpty()) {
            throw new IllegalArgumentException(
                    "Kode, nama, dan jumlah wajib diisi.");
        }

        int jumlah = Integer.parseInt(teksJumlah);
        Barang barang = new Barang(kode, nama, jumlah);
        daftarBarang.add(barang);
        perbaruiTabel();
        bersihkanInput();
        lblStatus.setText("Barang " + barang.getNama()
                + " ditambahkan ke daftar sementara.");
    } catch (NumberFormatException e) {
        lblStatus.setText("Jumlah belum valid. Data tidak ditambahkan.");
        JOptionPane.showMessageDialog(this,
                "Jumlah harus bilangan bulat antara 0 dan 2147483647.",
                "Input jumlah", JOptionPane.WARNING_MESSAGE);
        txtJumlah.requestFocusInWindow();
        txtJumlah.selectAll();
    } catch (IllegalArgumentException e) {
        lblStatus.setText("Data tidak ditambahkan: " + e.getMessage());
        JOptionPane.showMessageDialog(this, e.getMessage(),
                "Periksa data barang", JOptionPane.WARNING_MESSAGE);
       
    }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblInfo = new javax.swing.JLabel();
        lblJudul1 = new javax.swing.JLabel();
        pnlInput = new javax.swing.JPanel();
        lblNama = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        lblKode1 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        lblNama1 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        btnBersihkan = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        lblStatus = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventori Laboratotium - Data Barang");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInfo.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        lblInfo.setText("Latihan antarmuka - data tersimpan sementara.");
        getContentPane().add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 280, -1));

        lblJudul1.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        lblJudul1.setText("INVENTORI LABORATORIUM");
        getContentPane().add(lblJudul1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        pnlInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Barang"));
        pnlInput.setPreferredSize(new java.awt.Dimension(720, 210));
        pnlInput.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNama.setText("Jumlah Tersedia ");
        pnlInput.add(lblNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));
        pnlInput.add(txtJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 520, -1));

        lblKode1.setText("Kode Barang");
        pnlInput.add(lblKode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));
        pnlInput.add(txtKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 520, -1));

        lblNama1.setText("Nama Barang");
        pnlInput.add(lblNama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));
        pnlInput.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 520, -1));

        btnBersihkan.setText("Bersikan Input");
        btnBersihkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBersihkanActionPerformed(evt);
            }
        });
        pnlInput.add(btnBersihkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));

        btnTutup.setText("Tutup");
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });
        pnlInput.add(btnTutup, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        btnTambah.setText("Tambah Demo");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        pnlInput.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        getContentPane().add(pnlInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane2.setViewportView(tblBarang);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 750, 180));

        lblStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 470, 30));

        setBounds(0, 0, 786, 628);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        tambahDemo();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnBersihkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBersihkanActionPerformed
        // TODO add your handling code here:
        bersihkanInput();
        lblStatus.setText("Input dibersihkan. Daftar barang tetap.");
    }//GEN-LAST:event_btnBersihkanActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnTutupActionPerformed

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
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBersihkan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTutup;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblJudul1;
    private javax.swing.JLabel lblKode1;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNama1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
