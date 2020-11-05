/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Shanuka
 */
public class Prescription extends javax.swing.JFrame {

    /**
     * Creates new form Patient
     */
    public Prescription() {
        initComponents();
        //setMedicine();
        setPatient();
        jLabel11.setText(validation.docname);

    }

    public void setPatient() {
        String today = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        try {
            PreparedStatement pst = db.con().prepareStatement("SELECT assign.`patid` FROM `assign` INNER JOIN doctor ON assign.clinic=doctor.clinic WHERE assign.date ='" + today + "' AND assign.done='No' AND doctor.name='"+validation.docname+"' ORDER BY assign.date ASC");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                jComboBox2.addItem(rs.getString(1));
                jComboBox3.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Prescription.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setMedicine() {
        String today = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        try {
            PreparedStatement pst = db.con().prepareStatement("SELECT `name` FROM `medicine`");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                jComboBox1.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Prescription.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        days = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1220, 840));
        setMinimumSize(new java.awt.Dimension(1220, 840));
        setPreferredSize(new java.awt.Dimension(1220, 840));
        getContentPane().setLayout(null);

        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 800));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 800));
        jPanel1.setLayout(null);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1200, 800));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1200, 800));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel2.setMaximumSize(new java.awt.Dimension(1200, 800));
        jPanel2.setPreferredSize(new java.awt.Dimension(1200, 800));
        jPanel2.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Patient            :");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(70, 60, 150, 40);

        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jPanel2.add(jComboBox2);
        jComboBox2.setBounds(220, 60, 330, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Qty                   :");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(70, 280, 150, 40);

        jComboBox1.setEditable(true);
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(220, 140, 330, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine", "Dosage", "Qty", "Days"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(70, 420, 1010, 220);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/31.png"))); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(420, 330, 130, 50);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/32.png"))); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(310, 670, 150, 50);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/27.png"))); // NOI18N
        jButton2.setText("HOME");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(70, 670, 150, 50);

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton1.setText("Night");
        jPanel2.add(jRadioButton1);
        jRadioButton1.setBounds(460, 210, 93, 30);

        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton2.setText("Morning");
        jPanel2.add(jRadioButton2);
        jRadioButton2.setBounds(220, 210, 110, 30);

        jRadioButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton3.setText("Day");
        jPanel2.add(jRadioButton3);
        jRadioButton3.setBounds(360, 210, 93, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Medicine         :");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(70, 140, 150, 40);

        days.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                daysKeyTyped(evt);
            }
        });
        jPanel2.add(days);
        days.setBounds(220, 340, 130, 40);

        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qtyKeyTyped(evt);
            }
        });
        jPanel2.add(qty);
        qty.setBounds(220, 280, 130, 40);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Dosage            :");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(70, 210, 150, 30);
        jPanel2.add(jLabel11);
        jLabel11.setBounds(860, 50, 220, 60);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("DOCTOR  :");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(750, 50, 100, 60);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Days                :");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(70, 340, 140, 40);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/36.png"))); // NOI18N
        jButton4.setText("Save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(910, 670, 170, 50);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/3.jpg"))); // NOI18N
        jPanel2.add(jLabel10);
        jLabel10.setBounds(0, 0, 1200, 780);

        jTabbedPane1.addTab("Prescription", jPanel2);

        jPanel3.setMaximumSize(new java.awt.Dimension(1200, 800));
        jPanel3.setPreferredSize(new java.awt.Dimension(1200, 800));
        jPanel3.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Prescription :");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(30, 480, 290, 40);

        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(jComboBox3);
        jComboBox3.setBounds(190, 80, 200, 50);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/34.png"))); // NOI18N
        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5);
        jButton5.setBounds(410, 80, 150, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Patient             :");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(30, 80, 150, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Checkup Details :");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(30, 180, 290, 40);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient", "Tel", "Medicine"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(30, 520, 1130, 210);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient", "Checkup Name", "date", "Description"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(30, 220, 1130, 230);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/27.png"))); // NOI18N
        jButton6.setText("Home");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6);
        jButton6.setBounds(990, 80, 170, 50);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/3.jpg"))); // NOI18N
        jPanel3.add(jLabel9);
        jLabel9.setBounds(0, 0, 1200, 780);

        jTabbedPane1.addTab("Patient History", jPanel3);

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 1200, 800);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1200, 800);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String medi = jComboBox1.getSelectedItem().toString();
        String dos = "";
        if (jRadioButton2.isSelected() && jRadioButton3.isSelected() && jRadioButton1.isSelected()) {
            dos = "morning day night";
        } else if (jRadioButton3.isSelected() && jRadioButton2.isSelected()) {
            dos = "morning day";
        } else if (jRadioButton3.isSelected() && jRadioButton1.isSelected()) {
            dos = "day night";
        } else if (jRadioButton2.isSelected() && jRadioButton1.isSelected()) {
            dos = "morning night";
        } else if (jRadioButton3.isSelected()) {
            dos = "day";
        } else if (jRadioButton1.isSelected()) {
            dos = "night";
        } else if (jRadioButton2.isSelected()) {
            dos = "morning";
        }
        DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
        int quantity = Integer.parseInt(qty.getText());
        int times = Integer.parseInt(days.getText());

        if (medi.equals("") || dos.equals("") || quantity == 0 || times == 0) {
            JOptionPane.showMessageDialog(null, "Pls fill the relevent fields");
        } else {
            tb.addRow(new Object[]{medi, dos, quantity, times});
            jComboBox1.setSelectedIndex(-1);
            jRadioButton2.setSelected(false);
            jRadioButton3.setSelected(false);
            jRadioButton1.setSelected(false);
            qty.setText("");
            days.setText("");

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dashboard d = new dashboard();
        d.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
        tb.setNumRows(0);
    }//GEN-LAST:event_jButton3ActionPerformed

String p="";
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

        String patient = jComboBox2.getSelectedItem().toString();
        p=patient;
        PreparedStatement pst;
        ResultSet rs;
        TableModel tb = jTable1.getModel();

        PreparedStatement pst1;
        if (!(patient.equals("") || jTable1.getModel().getRowCount() == 0)) {
            try {
                pst1 = db.con().prepareStatement("UPDATE `assign` SET `done`='Yes' WHERE `patid`='" + patient + "' AND`date`='" + date + "'");
                pst1.execute();
            } catch (SQLException ex) {
                Logger.getLogger(Prescription.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                for (int i = 0; i < jTable1.getRowCount(); i++) {

                    pst = db.con().prepareStatement("INSERT INTO `issued_to` (`medid`, `patid`, `dosage`, `days`, `qty`,date) values (?,?,?,?,?,?)");

                    pst.setString(1, (String) tb.getValueAt(i, 0));
                    pst.setString(2, patient);
                    pst.setString(3, (String) tb.getValueAt(i, 1));
                    pst.setString(4, tb.getValueAt(i, 3).toString());
                    pst.setString(5, tb.getValueAt(i, 2).toString());
                    pst.setString(6, date);
                    pst.execute();

                    PreparedStatement ps1 = db.con().prepareStatement("update doctor set assigned=(assigned-1) where clinic='" + validation.usid + "'");
                    ps1.execute();
                    print();

                    JOptionPane.showMessageDialog(null, "Done!");
                    setPatient();
                    jComboBox1.setSelectedIndex(-1);
                    jRadioButton2.setSelected(false);
                    jRadioButton3.setSelected(false);
                    jRadioButton1.setSelected(false);
                    qty.setText("");
                    days.setText("");
                    jComboBox2.setSelectedIndex(-1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Prescription.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "pls add medicines and patient ID");
        }
      
    }//GEN-LAST:event_jButton4ActionPerformed

    public void print() {
        String today = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        JFileChooser dialog = new JFileChooser();
        dialog.setSelectedFile(new File("prescription " + p + " - " + today + ".pdf"));
        int dialogResult = dialog.showSaveDialog(null);
        if (dialogResult == JFileChooser.APPROVE_OPTION) {
            String filePath = dialog.getSelectedFile().getPath();

            try {

                Document myDocument = new Document();

                PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
                myDocument.open();
                myWriter.setPageEvent(new MyPdfPageEventHelper("report1.png"));
                myDocument.add(new Paragraph("\n\n\n\n\n\n"));
                myDocument.add(new Paragraph("PRESCRIPTION", FontFactory.getFont(FontFactory.TIMES_BOLD, 20, Font.BOLD)));
                myDocument.add(new Paragraph("Patient ID : " + jComboBox2.getSelectedItem().toString(), FontFactory.getFont(FontFactory.TIMES_BOLD, 16, Font.PLAIN)));
                myDocument.add(new Paragraph("Doctor : " + jLabel11.getText(), FontFactory.getFont(FontFactory.TIMES_BOLD, 16, Font.PLAIN)));

                PdfPTable table = new PdfPTable(4);

                table.setWidthPercentage(100);
                float[] columnWidths = new float[]{5, 5, 5, 5};
                table.setWidths(columnWidths);

                myDocument.add(new Paragraph(today));
                myDocument.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------------"));
                table.addCell(new PdfPCell(new Paragraph("Medicine", FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, Font.BOLD))));
                table.addCell(new PdfPCell(new Paragraph("Dosage", FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, Font.BOLD))));
                table.addCell(new PdfPCell(new Paragraph("Qty", FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, Font.BOLD))));
                table.addCell(new PdfPCell(new Paragraph("Days", FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, Font.BOLD))));

                for (int i = 0; i < jTable1.getRowCount(); i++) {

                    table.addCell(new PdfPCell(new Paragraph(jTable1.getValueAt(i, 0).toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 8, Font.PLAIN))));
                    table.addCell(new PdfPCell(new Paragraph(jTable1.getValueAt(i, 1).toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 8, Font.PLAIN))));
                    table.addCell(new PdfPCell(new Paragraph(jTable1.getValueAt(i, 2).toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 8, Font.PLAIN))));
                    table.addCell(new PdfPCell(new Paragraph(jTable1.getValueAt(i, 3).toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 8, Font.PLAIN))));

                }

                myDocument.add(table);

                myDocument.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------------"));

                myDocument.close();

                JOptionPane.showMessageDialog(null, "Report was successfully generated");

            } catch (DocumentException ex) {
                Logger.getLogger(Prescription.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Prescription.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    String cus = "";
    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        try{
        cus = jComboBox2.getSelectedItem().toString();
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        jComboBox3.setSelectedItem(cus);
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        try {
            PreparedStatement pst = db.con().prepareStatement("SELECT `patid` as 'Patient ID',`checkupName`, `date`, `description` FROM `do` WHERE patid='" + jComboBox3.getSelectedItem().toString() + "'");
            ResultSet rs = pst.executeQuery();
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            jTable3.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        } catch (SQLException ex) {
            Logger.getLogger(Prescription.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement pst;
        try {
            pst = db.con().prepareStatement("SELECT `patid` as 'Patient ID',`medid` as Medicine ,`date` FROM `issued_to` WHERE patid='" + jComboBox3.getSelectedItem().toString() + "'");
            ResultSet rs = pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        } catch (SQLException ex) {
            Logger.getLogger(Prescription.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        dashboard d = new dashboard();
        d.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void qtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyTyped
        char c = evt.getKeyChar();

        if (c == 43) {
            evt.consume();
        }
        if (!Character.isDigit(c) && c != 8 && c != 43) {
            evt.consume();
        }

    }//GEN-LAST:event_qtyKeyTyped

    private void daysKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_daysKeyTyped
        char c = evt.getKeyChar();

        if (c == 43) {
            evt.consume();
        }
        if (!Character.isDigit(c) && c != 8 && c != 43) {
            evt.consume();
        }

    }//GEN-LAST:event_daysKeyTyped

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
            java.util.logging.Logger.getLogger(Prescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prescription().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField days;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField qty;
    // End of variables declaration//GEN-END:variables
}