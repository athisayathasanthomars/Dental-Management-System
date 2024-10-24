/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package family_dental_care;
import java.awt.Dimension;
import java.awt.Image;
import java.io.*;
import java.awt.Toolkit;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author thoma
 */
public class patient extends javax.swing.JFrame {

    private Object contentPane;

    /**
     * Creates new form patient
     */
    public patient() {
        initComponents();
    
    //center the frame
    Toolkit toolkit=getToolkit();
    Dimension size=toolkit.getScreenSize();
    setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
    //reszize the image logo
    ImageIcon logo_im=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
    Image img1_logo=logo_im.getImage();
    Image img2_logo=img1_logo.getScaledInstance(logo.getWidth(),logo.getHeight(),Image.SCALE_SMOOTH);
    ImageIcon a=new ImageIcon(img2_logo);
    logo.setIcon(a);
    
    //resize home button
    ImageIcon home_im=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("home.png")));
    Image img1_home=home_im.getImage();
    Image img2_home=img1_home.getScaledInstance(home.getWidth(),home.getHeight(),Image.SCALE_SMOOTH);
    ImageIcon b=new ImageIcon(img2_home);
    home.setIcon(b);
    
    
    //resize close button 
    ImageIcon close_img=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("close.png")));
    Image img1_close=close_img.getImage();
    Image img2_close=img1_close.getScaledInstance(close.getWidth(),close.getHeight(),Image.SCALE_SMOOTH);
    ImageIcon c=new ImageIcon(img2_close);
    close.setIcon(c);
    
        
    autoID();//call function to increase id
    RefrushTable();//call function to refresh table
    sort();// call function to sort table    
    
    }
    //auto increment id
    private void autoID(){
        try{
        connection mysql=new connection();
        Connection con=mysql.connectDB();
        PreparedStatement selectdata=con.prepareStatement("SELECT patientid FROM patient ORDER BY patientid DESC LIMIT 1");
        ResultSet rs=selectdata.executeQuery();
        if(rs.next()){
           String rnno=rs.getString("patientid");
           int co=rnno.length();
           String txt= rnno.substring(0, 3);
           String num=rnno.substring(3, co);
           int n=Integer.parseInt(num);
           n++;
           String snum=Integer.toString(n);
           String ftxt=txt+snum;
           patientid.setText(ftxt);
        }
        else{
           patientid.setText("P001");
        }
        }
        catch(Exception ex){
           JOptionPane.showMessageDialog(null,"no id is there..");
        }
    }
    
    //LOAD DATA TO TABLE
    private void RefrushTable(){
    try{
         connection mysql=new connection();
         Connection con=mysql.connectDB();
         PreparedStatement ps1=con.prepareStatement("SELECT * FROM patient");
         ResultSet rs=ps1.executeQuery();
         DefaultTableModel model=(DefaultTableModel)patient_table.getModel();
         model.setRowCount(0);
         while(rs.next()){
           String patient_id=rs.getString("patientid");
           String patient_name=rs.getString("patientname");
           String patient_address=rs.getString("patientaddress");
           String patient_mobilenumber=String.valueOf(rs.getInt("patientmobilenumber"));
           String patient_gender=rs.getString("gender");
           String register_fees=rs.getString("registerfees");
           //create array for store data into patient_table
           String tbData[]={patient_id,patient_name,patient_address,patient_mobilenumber,patient_gender,register_fees};
           DefaultTableModel tb1Model=(DefaultTableModel)patient_table.getModel();
           //add string array data to table
           tb1Model.addRow(tbData);                   
         }
         
        }
        catch(Exception ex){
         JOptionPane.showMessageDialog(null,"error happen.please try again..");
         autoID();
        }
    }
    //Sort table
    private void sort(){
       DefaultTableModel model=(DefaultTableModel)patient_table.getModel();    
       TableRowSorter sorter=new TableRowSorter(model);
       patient_table.setRowSorter(sorter);
    }
    //Filter table with sorting object
    private void filter(String query){
       //sorting the table values
       DefaultTableModel model=(DefaultTableModel)patient_table.getModel();    
       TableRowSorter sorter=new TableRowSorter(model);
       patient_table.setRowSorter(sorter);
       sorter.setRowFilter(RowFilter.regexFilter(query));
       
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
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        insertpatient = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        search_patient = new javax.swing.JButton();
        patientid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        patientname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        patientaddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        patientphonenumber = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        gender_male = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        gender_female = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        patient_table = new javax.swing.JTable();
        search_patient1 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        registerfees = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(87, 194, 213));

        insertpatient.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        insertpatient.setText("insert");
        insertpatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertpatientActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jButton1.setText("update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jButton2.setText("delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        search_patient.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        search_patient.setText("search");
        search_patient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_patientActionPerformed(evt);
            }
        });

        patientid.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        patientid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientidActionPerformed(evt);
            }
        });
        patientid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                patientidKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jLabel2.setText("patientID");

        jLabel3.setBackground(new java.awt.Color(87, 194, 213));
        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jLabel3.setText("Name");

        patientname.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        patientname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientnameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jLabel4.setText("Address");

        patientaddress.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jLabel5.setText("Phone Number");

        patientphonenumber.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(87, 194, 213));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel1.setText("patient");

        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });

        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 365, Short.MAX_VALUE)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(home, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        buttonGroup1.add(gender_male);
        gender_male.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        gender_male.setText("Male");

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jLabel9.setText("Gender");

        buttonGroup1.add(gender_female);
        gender_female.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        gender_female.setText("Female");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        patient_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "PatientID", "Patient_name", "Patient_Address", "Mobile Number", "Gender", "Register Fees"
            }
        ));
        patient_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patient_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(patient_table);

        search_patient1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        search_patient1.setText("clear");
        search_patient1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search_patient1MouseClicked(evt);
            }
        });
        search_patient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_patient1ActionPerformed(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel74.setText("            Doctor");
        jLabel74.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel74MouseClicked(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel75.setText("            Patient");
        jLabel75.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel75.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel75MouseClicked(evt);
            }
        });

        jLabel76.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel76.setText("      Appointment");
        jLabel76.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel76.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel76MouseClicked(evt);
            }
        });

        jLabel77.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel77.setText("              Staff");
        jLabel77.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel77MouseClicked(evt);
            }
        });

        jLabel78.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel78.setText("         Treatment");
        jLabel78.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel78.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel78MouseClicked(evt);
            }
        });

        jLabel79.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel79.setText("             Room");
        jLabel79.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel79.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel79MouseClicked(evt);
            }
        });

        jLabel80.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel80.setText("    Treatment Book");
        jLabel80.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel80.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel80MouseClicked(evt);
            }
        });

        jLabel81.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel81.setText("        Room Book");
        jLabel81.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel81.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel81MouseClicked(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel82.setText("           Payment");
        jLabel82.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel82.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel82MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
            .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jLabel10.setText("Register Fees");

        registerfees.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gender_male, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(gender_female)
                                        .addGap(11, 11, 11))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(patientphonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(patientaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3))
                                            .addGap(60, 60, 60)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(patientname, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(patientid, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(insertpatient, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(search_patient, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)
                                    .addComponent(search_patient1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(registerfees, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(patientid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(search_patient1, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(patientname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(patientaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(patientphonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gender_female)
                            .addComponent(gender_male)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(search_patient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insertpatient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(8, 8, 8)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(registerfees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        // TODO add your handling code here:
        new manager_dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeMouseClicked

    private void patientnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientnameActionPerformed

    private void patientidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientidActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_patientidActionPerformed

    private void search_patientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_patientActionPerformed
        // TODO add your handling code here:
        String patient_id=patientid.getText();
        if(patientid.getText().equals("")){
           JOptionPane.showMessageDialog(null,"Please enter ID to search..");
        }
        else{
          try{
            connection mysql=new connection();
            Connection con=mysql.connectDB();
            
            PreparedStatement selectdata=con.prepareStatement("select * from patient where patientid=?");
            selectdata.setString(1,patient_id);
            ResultSet rs=selectdata.executeQuery();
            if(rs.next()){
                patientname.setText(rs.getString("patientname"));
                patientaddress.setText(rs.getString("patientaddress"));
                patientphonenumber.setText(rs.getString("patientmobilenumber"));
                if(rs.getString("gender").equals("Male")){
                    gender_male.setSelected(true);
                    gender_female.setSelected(false);
                    autoID();
                }
                else if(rs.getString("gender").equals("Female")){
                    gender_female.setSelected(true);
                    gender_male.setSelected(false);
                    autoID();
                }
                registerfees.setText(rs.getString("registerfees"));

            }
            else{
                patientid.setText(null);
                patientname.setText(null);
                patientaddress.setText(null);
                patientphonenumber.setText(null);

                JOptionPane.showMessageDialog(null,"no records are there!!");
                autoID();
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"error happen.please try again..");
            autoID();
        }
        }
        
        
    }//GEN-LAST:event_search_patientActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       String patient_id=patientid.getText();
       if(patientid.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter id to update!!");
            autoID();
       }
       else{
            try{

             connection mysql=new connection();
             Connection con=mysql.connectDB();
            
             String patient_name=patientname.getText();
             String patient_address=patientaddress.getText();
             int patient_phonenumber=Integer.parseInt(patientphonenumber.getText());
             String patient_gender;
             String register_fees=registerfees.getText();
             if(gender_male.isSelected()){
                patient_gender=gender_male.getText();
             }
             else{
                patient_gender=gender_female.getText();
             }
             if(patientid.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please enter id to update!!");
                autoID();
             }
             else{
                PreparedStatement ps=con.prepareStatement("UPDATE patient SET patientname=?,patientaddress=?,patientmobilenumber=?,gender=?,registerfees=? WHERE patientid=?");

                ps.setString(1,patient_name);
                ps.setString(2,patient_address);
                ps.setInt(3,patient_phonenumber);
                ps.setString(4, patient_gender);
                ps.setString(5,register_fees);
                ps.setString(6,patient_id);
                ps.executeUpdate();
                patientname.setText(null);
                patientaddress.setText(null);
                patientphonenumber.setText(null);
                registerfees.setText(null);
                JOptionPane.showMessageDialog(null,"updated suncessfully..");
                autoID();
                RefrushTable();
             }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"Please enter id and details to update!!");
                autoID();
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void insertpatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertpatientActionPerformed
        if(patientid.getText().equals("") || patientname.getText().equals("") || patientaddress.getText().equals("") || patientphonenumber.getText().equals("") || registerfees.getText().equals("")){
           JOptionPane.showMessageDialog(null,"All the fields are requried..");
        }
        else{
           try{
            connection mysql=new connection();
            Connection con=mysql.connectDB();

            String patient_id=patientid.getText();
            String patient_name=patientname.getText();
            String patient_address=patientaddress.getText();
            int patient_phonenumber=Integer.parseInt(patientphonenumber.getText());
            String register_fees=registerfees.getText();

            //if((patientid.getText().equals("")) || (patientname.getText().equals("")) || (patientaddress.getText().equals(""))){
                // JOptionPane.showMessageDialog(null,"please fillout all the fields!!");
                //}
            //else{
                PreparedStatement ps1=con.prepareStatement("INSERT INTO patient(patientid,patientname,patientaddress,patientmobilenumber,gender,registerfees) VALUES(?,?,?,?,?,?)");
                ps1.setString(1,patient_id);
                ps1.setString(2,patient_name);
                ps1.setString(3,patient_address);
                ps1.setInt(4,patient_phonenumber);
                if(gender_male.isSelected()){
                    ps1.setString(5,gender_male.getText());
                    ps1.setString(6,register_fees);
                    ps1.executeUpdate();
                }
                else{
                    ps1.setString(5,gender_female.getText());
                    ps1.setString(6,register_fees);
                    ps1.executeUpdate();
                }
                

                JOptionPane.showMessageDialog(null,"Inserted suncessfully..");
                autoID();
                RefrushTable();
                patientname.setText(null);
                patientaddress.setText(null);
                patientphonenumber.setText(null);
                registerfees.setText(null);
                //}
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Please enter details..");
            autoID();
        } 
        }
    }//GEN-LAST:event_insertpatientActionPerformed

    private void patient_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patient_tableMouseClicked
        // TODO add your handling code here:
        int i=patient_table.getSelectedRow();
        TableModel model=patient_table.getModel();
        patientid.setText((String) model.getValueAt(i,0));
        patientname.setText((String) model.getValueAt(i,1));
        patientaddress.setText((String) model.getValueAt(i,2));
        patientphonenumber.setText((String) model.getValueAt(i,3));
        String gender=model.getValueAt(i,4).toString();
        if(gender.equals("Male")){
                    gender_male.setSelected(true);
                    gender_female.setSelected(false);
        }
        else if(gender.equals("Female")){
                    gender_female.setSelected(true);
                    gender_male.setSelected(false);
       }
        registerfees.setText((String) model.getValueAt(i,5));
    }//GEN-LAST:event_patient_tableMouseClicked

    private void patientidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_patientidKeyReleased
        String query=patientid.getText();
        filter(query);
    }//GEN-LAST:event_patientidKeyReleased

    private void search_patient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_patient1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_patient1ActionPerformed

    private void search_patient1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_patient1MouseClicked
        // TODO add your handling code here:
        autoID();
        patientname.setText(null);
        patientaddress.setText(null);
        patientphonenumber.setText(null);
        gender_male.setSelected(false);
        gender_female.setSelected(false);
        registerfees.setText(null);
    }//GEN-LAST:event_search_patient1MouseClicked

    private void jLabel74MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel74MouseClicked
        // TODO add your handling code here:
        new manager_doctor().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel74MouseClicked

    private void jLabel75MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel75MouseClicked
        // TODO add your handling code here:
        new patient().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel75MouseClicked

    private void jLabel77MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel77MouseClicked
        // TODO add your handling code here:
        new manager_staff().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel77MouseClicked

    private void jLabel76MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel76MouseClicked
        // TODO add your handling code here:
        new manager_appointment().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel76MouseClicked

    private void jLabel78MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel78MouseClicked
        // TODO add your handling code here:
        new manager_treatment().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel78MouseClicked

    private void jLabel79MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel79MouseClicked
        // TODO add your handling code here:
        new manager_room().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel79MouseClicked

    private void jLabel80MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel80MouseClicked
        // TODO add your handling code here:
        new manager_treatment_book().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel80MouseClicked

    private void jLabel81MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel81MouseClicked
        // TODO add your handling code here:
        new manager_room_book().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel81MouseClicked

    private void jLabel82MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel82MouseClicked
        // TODO add your handling code here:
        new manager_payment().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel82MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        try{
            connection mysql=new connection();
            Connection con=mysql.connectDB();
            String patient_id=patientid.getText();
            if(patientid.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter ID to delete..");
                autoID();
            }
            else{
                PreparedStatement ps=con.prepareStatement("DELETE from patient WHERE patientid=?");
                ps.setString(1,patient_id);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"deleted suncessfully..");
                autoID();
                RefrushTable();
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"error happen.please try again..");
            autoID();
        }
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
            java.util.logging.Logger.getLogger(patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new patient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel close;
    private javax.swing.JRadioButton gender_female;
    private javax.swing.JRadioButton gender_male;
    private javax.swing.JLabel home;
    private javax.swing.JButton insertpatient;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel logo;
    private javax.swing.JTable patient_table;
    private javax.swing.JTextField patientaddress;
    private javax.swing.JTextField patientid;
    private javax.swing.JTextField patientname;
    private javax.swing.JTextField patientphonenumber;
    private javax.swing.JTextField registerfees;
    private javax.swing.JButton search_patient;
    private javax.swing.JButton search_patient1;
    // End of variables declaration//GEN-END:variables
}
