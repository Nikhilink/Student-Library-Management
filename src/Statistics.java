
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Statistics extends javax.swing.JFrame {
 Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    Thread t;
    DefaultTableModel model;
    Cryptography ch = new Cryptography();
    /**
     * Creates new form Statistics
     */
    public Statistics() {
     try {
         initComponents();
          setExtendedState(JFrame.MAXIMIZED_BOTH);
         conn = javaconnect.ConnecrDb();
         jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
         jScrollPane2.getVerticalScrollBar().setUnitIncrement(16);
         jScrollPane3.getVerticalScrollBar().setUnitIncrement(16);
         setStudentDetails();
         setIssueDetails();
         setReturnDetails();
     } catch (InstantiationException ex) {
         Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IllegalAccessException ex) {
         Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
     }
        IssueDetails.setPreferredScrollableViewportSize(Toolkit.getDefaultToolkit().getScreenSize());
       
    }
 @SuppressWarnings("empty-statement")
 public void setStudentDetails()
{
    try{
        String sql = "select * from Student";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        DefaultTableModel model = (DefaultTableModel) StudentContents.getModel();
        model.setRowCount(0);
        while(rs.next())
        {
            int ID = rs.getInt("Student_ID");
            String name = ch.StringDecrypt(rs.getString("Name"),3);
            int Rollno = rs.getInt("Roll_no");
            String Branch = ch.StringDecrypt(rs.getString("Branch"),3);
            String sem = ch.StringDecrypt(rs.getString("Sem"),3);
            String year = ch.StringDecrypt(rs.getString("Year"),3);
           long number = rs.getLong(7);
            String add = ch.StringDecrypt(rs.getString("Address"), 3);
            String surname = ch.StringDecrypt(rs.getString("Surname"),3);
            String institute = ch.StringDecrypt(rs.getString("Institute"),3);
            int instituteC = rs.getInt("InstituteC");
            String fullname = name+" "+surname;
            Object o[] = {ID,fullname,institute,instituteC,Rollno,Branch,sem,year,number,add};
            model.addRow(o);
           
        }
    }catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e);
    }
}
 public void setIssueDetails()
 {
     try{
         String sql = "select * from Issue";
         pst = conn.prepareStatement(sql);
         rs = pst.executeQuery();
          DefaultTableModel model = (DefaultTableModel) IssueDetails.getModel();
        model.setRowCount(0);
        while(rs.next())
        {
            int BookID = rs.getInt("Book_ID");
            String BookN = ch.StringDecrypt(rs.getString("Name"),3);
            int Edition = rs.getInt("Edition");
            String Publisher = ch.StringDecrypt(rs.getString("Publisher"),3);
            int Price = rs.getInt("Price");
            int Pages = rs.getInt("Pages");
            String SID = ch.StringDecrypt(rs.getString("Student_ID"),3);
            String Name = ch.StringDecrypt(rs.getString("SName"),3);
            String Year = ch.StringDecrypt(rs.getString("Year"),3);
            String Address = ch.StringDecrypt(rs.getString("Address"),3);
            String DOI = ch.StringDecrypt(rs.getString("DateOfIssue"),3);
            String surname = ch.StringDecrypt(rs.getString("Surname"),3);
            String name = Name+" "+surname;
            String institute = ch.StringDecrypt(rs.getString("Institute"),3);
            int instituteC = rs.getInt("InstituteC");
            String sem = ch.StringDecrypt(rs.getString("Semester"),3);
            long phoneno = rs.getLong("Phone_no");
            String Author = ch.StringDecrypt(rs.getString("Author"), 3);
            String type = ch.StringDecrypt(rs.getString("Type"),3);
            String Branch = ch.StringDecrypt(rs.getString("Branch"),3);
            int rollno = rs.getInt("Roll_no");
            String yearsem = Year+" "+sem;
            String Institute = institute+" "+instituteC;
            Object o[] = {SID,name,Institute,yearsem,phoneno,Address,Branch,rollno,BookID,BookN,Edition,Publisher,Author,type,DOI};
            model.addRow(o);
        }
        }catch(Exception e)
           {
                JOptionPane.showMessageDialog(null,e);
            }
 }
 public void setReturnDetails()
 {
     try{
         String sql = "select * from Return";
         pst = conn.prepareStatement(sql);
         rs = pst.executeQuery();
          DefaultTableModel model = (DefaultTableModel) ReturnData.getModel();
        model.setRowCount(0);
        while(rs.next())
        {
             int BookID = rs.getInt("Book_ID");
            String BookN = ch.StringDecrypt(rs.getString("BName"),3);
            int Edition = rs.getInt("Edition");
            String Publisher = ch.StringDecrypt(rs.getString("Publisher"),3);
            int Price = rs.getInt("Price");
            int Pages = rs.getInt("Pages");
            String SID = ch.StringDecrypt(rs.getString("Student_ID"),3);
            String Name = ch.StringDecrypt(rs.getString("SName"),3);
            String Year = ch.StringDecrypt(rs.getString("Year"),3);
            String Address = ch.StringDecrypt(rs.getString("Address"),3);
            String DOI = ch.StringDecrypt(rs.getString("DateOfIssue"),3);
            String surname = ch.StringDecrypt(rs.getString("Surname"),3);
            String institute = ch.StringDecrypt(rs.getString("Institute"),3);
            int instituteC = rs.getInt("InstituteC");
            String sem = ch.StringDecrypt(rs.getString("Sem"),3);
            long phoneno = rs.getLong("PhoneNo");
            String Author = ch.StringDecrypt(rs.getString("Author"), 3);
            String type = ch.StringDecrypt(rs.getString("Type"),3);
            String Branch = ch.StringDecrypt(rs.getString("Branch"),3);
            int rollno = rs.getInt("RollNo");
            String DOR = ch.StringDecrypt(rs.getString("DateOfReturn"), 3);
            String name = Name+" "+surname;
            String Institute = institute+" "+instituteC;
            String yearsem = Year + " "+ sem;
            Object o[] = {SID,Name,Institute,yearsem,phoneno,Address,Branch,rollno,BookID,BookN,Edition,Publisher,Author,type,Price,Pages,DOI,DOR};
            model.addRow(o);
        }
     }catch(Exception e)
     {
         String ee = e.toString();
         JOptionPane.showMessageDialog(null, e);
          JOptionPane.showMessageDialog(null, ee);
         
         e.printStackTrace();
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        StudentContents = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        IssueDetails = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ReturnData = new javax.swing.JTable();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jTabbedPane1.setToolTipText("Search for Return Details By Entering (Required Data String)");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 0), 2, true), "Student Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(204, 0, 0))); // NOI18N

        StudentContents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Student Name", "Institute", "Institute Code", "Roll No", "Branch", "Sem", "Year", "Phone No", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        StudentContents.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(StudentContents);
        if (StudentContents.getColumnModel().getColumnCount() > 0) {
            StudentContents.getColumnModel().getColumn(0).setResizable(false);
            StudentContents.getColumnModel().getColumn(0).setPreferredWidth(30);
            StudentContents.getColumnModel().getColumn(1).setResizable(false);
            StudentContents.getColumnModel().getColumn(1).setPreferredWidth(90);
            StudentContents.getColumnModel().getColumn(2).setResizable(false);
            StudentContents.getColumnModel().getColumn(3).setResizable(false);
            StudentContents.getColumnModel().getColumn(4).setResizable(false);
            StudentContents.getColumnModel().getColumn(4).setPreferredWidth(30);
            StudentContents.getColumnModel().getColumn(5).setResizable(false);
            StudentContents.getColumnModel().getColumn(5).setPreferredWidth(70);
            StudentContents.getColumnModel().getColumn(6).setResizable(false);
            StudentContents.getColumnModel().getColumn(7).setResizable(false);
            StudentContents.getColumnModel().getColumn(8).setResizable(false);
            StudentContents.getColumnModel().getColumn(9).setResizable(false);
        }

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
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
                        .addComponent(jButton2)
                        .addGap(80, 80, 80)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1293, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Student Details", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 2, true), "Library Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 0, 0))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 0), 2, true), "Isssue Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 51, 204))); // NOI18N

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Search");

        IssueDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Student Name", "Institute", "Year", "Phone No", "Address", "Branch", "Roll No", "Book ID", "Book Name", "Edition", "Publisher", "Author", "Type", "Date of Issue"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Long.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        IssueDetails.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(IssueDetails);
        if (IssueDetails.getColumnModel().getColumnCount() > 0) {
            IssueDetails.getColumnModel().getColumn(0).setMaxWidth(65);
            IssueDetails.getColumnModel().getColumn(2).setPreferredWidth(200);
            IssueDetails.getColumnModel().getColumn(2).setMaxWidth(200);
            IssueDetails.getColumnModel().getColumn(3).setMaxWidth(70);
            IssueDetails.getColumnModel().getColumn(7).setMaxWidth(50);
            IssueDetails.getColumnModel().getColumn(10).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1301, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Issue Details", jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 2, true), "Return Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 204, 0))); // NOI18N

        ReturnData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Student Name", "Institute", "Year", "Phone no", "Address", "Branch", "Roll no", "Book  ID", "Book Name", "Edition", "Publisher", "Author", "Type", "Date Of Issue", "Date Of Return"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ReturnData.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(ReturnData);
        if (ReturnData.getColumnModel().getColumnCount() > 0) {
            ReturnData.getColumnModel().getColumn(0).setPreferredWidth(65);
            ReturnData.getColumnModel().getColumn(2).setPreferredWidth(160);
            ReturnData.getColumnModel().getColumn(3).setPreferredWidth(70);
            ReturnData.getColumnModel().getColumn(6).setPreferredWidth(70);
            ReturnData.getColumnModel().getColumn(7).setPreferredWidth(50);
            ReturnData.getColumnModel().getColumn(10).setPreferredWidth(50);
        }

        jTextField3.setToolTipText("Search for Return Details By Entering (Required Data String)");
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Search");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1293, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Return Details", jPanel4);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        setSize(new java.awt.Dimension(1346, 685));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Home ob = new Home();
        ob.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // TODO add your handling code here:
        String search = jTextField3.getText();
        model = (DefaultTableModel) ReturnData.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
        ReturnData.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
        String search = jTextField2.getText();
        model = (DefaultTableModel) IssueDetails.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
        IssueDetails.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        String search = jTextField1.getText();
        model = (DefaultTableModel) StudentContents.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
        StudentContents.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(search));
       
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) StudentContents.getModel();
        model.fireTableDataChanged();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Statistics().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable IssueDetails;
    private javax.swing.JTable ReturnData;
    private javax.swing.JTable StudentContents;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
   
}
