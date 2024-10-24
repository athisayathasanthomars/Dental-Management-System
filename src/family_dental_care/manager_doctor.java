/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package family_dental_care;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author thoma
 */
public class manager_doctor extends javax.swing.JFrame {

    /**
     * Creates new form manager_doctor
     */
    public manager_doctor() {
        initComponents();
        autoID();
        RefrushTable();
        
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
    }
    private void autoID(){
        try{
        connection mysql=new connection();
        Connection con=mysql.connectDB();
        PreparedStatement selectdata=con.prepareStatement("SELECT doctorid FROM doctor ORDER BY doctorid DESC LIMIT 1");
        ResultSet rs=selectdata.executeQuery();
        if(rs.next()){
           String rnno=rs.getString("doctorid");
           int co=rnno.length();
           String txt= rnno.substring(0, 3);
           String num=rnno.substring(3, co);
           int n=Integer.parseInt(num);
           n++;
           String snum=Integer.toString(n);
           String ftxt=txt+snum;
           doctorid.setText(ftxt);
        }
        else{
           doctorid.setText("D001");
        }
        }
        catch(Exception ex){
         
        }
    }
    private void RefrushTable(){
    try{
         connection mysql=new connection();
         Connection con=mysql.connectDB();
         PreparedStatement ps1=con.prepareStatement("SELECT * FROM doctor");
         ResultSet rs=ps1.executeQuery();
         DefaultTableModel model=(DefaultTableModel)doctor_table.getModel();
         model.setRowCount(0);
         while(rs.next()){  
           String doctor_id=rs.getString("doctorid");
           String doctor_name=rs.getString("doctorname");
           String doctor_address=rs.getString("doctoraddress");
           String contact=rs.getString("doctorcontactno");
           String mail=rs.getString("doctor_mailaddress");
           String quali=rs.getString("qualification");
           String experi=rs.getString("yearofexperiance");
           String doctor_type=rs.getString("doctortype");
           String gender=rs.getString("gender");
           //create array for store data into patient_table
           String tbData[]={doctor_id,doctor_name,doctor_address,contact,mail,quali,experi,doctor_type,gender};
           DefaultTableModel tb1Model=(DefaultTableModel)doctor_table.getModel();
           //add string array data to table
           tb1Model.addRow(tbData);                    
         }
         
        }
        catch(Exception ex){
            System.out.println(ex);
         JOptionPane.showMessageDialog(null,"hi");
         autoID();
        }
    
    }
    //Sort table
    private void sort(){
       DefaultTableModel model1=(DefaultTableModel)doctor_table.getModel();    
       TableRowSorter sorter=new TableRowSorter(model1);
       doctor_table.setRowSorter(sorter);
    }
    //Filter table with sorting object
    private void filter(String query){
       //sorting the table values
       DefaultTableModel model1=(DefaultTableModel)doctor_table.getModel();    
       TableRowSorter sorter=new TableRowSorter(model1);
       doctor_table.setRowSorter(sorter);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        gender_male = new javax.swing.JRadioButton();
        gender_female = new javax.swing.JRadioButton();
        doctorid = new javax.swing.JTextField();
        doctor_phonenumber = new javax.swing.JTextField();
        doctoraddress = new javax.swing.JTextField();
        doctorname = new javax.swing.JTextField();
        clear_doctor = new javax.swing.JButton();
        search_doctor = new javax.swing.JButton();
        insert_doctor = new javax.swing.JButton();
        update_doctor = new javax.swing.JButton();
        delete_doctor = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        doctor_mailaddress = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        experience = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        qualification = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        doctor_table = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        doctortype = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(87, 194, 213));

        jLabel29.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel29.setText("            Doctor");
        jLabel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel30.setText("            Patient");
        jLabel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel31.setText("      Appointment");
        jLabel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel32.setText("              Staff");
        jLabel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel33.setText("         Treatment");
        jLabel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel34.setText("             Room");
        jLabel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel35.setText("    Treatment Book");
        jLabel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel36.setText("        Room Book");
        jLabel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel36MouseClicked(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel37.setText("           Payment");
        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel1.setText("Doctor");

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

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jLabel2.setText("DoctorID");

        jLabel3.setBackground(new java.awt.Color(87, 194, 213));
        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jLabel3.setText("Doctor Name");

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jLabel4.setText("Address");

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jLabel5.setText("Phone Number");

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jLabel9.setText("Qualification");

        buttonGroup1.add(gender_male);
        gender_male.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        gender_male.setText("Male");

        buttonGroup1.add(gender_female);
        gender_female.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        gender_female.setText("Female");

        doctorid.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        doctorid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctoridActionPerformed(evt);
            }
        });
        doctorid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                doctoridKeyReleased(evt);
            }
        });

        doctor_phonenumber.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N

        doctoraddress.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        doctoraddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctoraddressActionPerformed(evt);
            }
        });

        doctorname.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        doctorname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctornameActionPerformed(evt);
            }
        });
        doctorname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                doctornameKeyReleased(evt);
            }
        });

        clear_doctor.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        clear_doctor.setText("clear");
        clear_doctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear_doctorMouseClicked(evt);
            }
        });
        clear_doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_doctorActionPerformed(evt);
            }
        });

        search_doctor.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        search_doctor.setText("search");
        search_doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_doctorActionPerformed(evt);
            }
        });

        insert_doctor.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        insert_doctor.setText("insert");
        insert_doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_doctorActionPerformed(evt);
            }
        });

        update_doctor.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        update_doctor.setText("update");
        update_doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_doctorActionPerformed(evt);
            }
        });

        delete_doctor.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        delete_doctor.setText("delete");
        delete_doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_doctorActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jLabel6.setText("Email Address");

        doctor_mailaddress.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jLabel10.setText("Gender");

        experience.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jLabel11.setText("Experience");

        qualification.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N

        doctor_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "DoctorID", "Doctor_Name", "Doctor_Address", "Mobile Number", "Email", "Qualification", "Experience", "Doctor Type", "Gender"
            }
        ));
        doctor_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doctor_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(doctor_table);

        jLabel12.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jLabel12.setText("Doctor Type");

        doctortype.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        doctortype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinary", "Consultant" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gender_male, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gender_female)))
                        .addGap(7, 7, 7)
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(doctortype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(doctor_mailaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(doctoraddress, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(doctorname, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(doctorid, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(doctor_phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(qualification, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(experience, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clear_doctor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search_doctor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insert_doctor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update_doctor, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(delete_doctor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clear_doctor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(search_doctor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(insert_doctor)
                        .addGap(12, 12, 12)
                        .addComponent(update_doctor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete_doctor))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(doctorid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doctorname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(doctoraddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(doctor_phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(doctor_mailaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(qualification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(experience, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(doctortype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gender_male)
                            .addComponent(gender_female))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        // TODO add your handling code here:
        new patient().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel30MouseClicked

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        // TODO add your handling code here:
        new manager_dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void doctoraddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctoraddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doctoraddressActionPerformed

    private void doctornameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctornameActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_doctornameActionPerformed

    private void doctornameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_doctornameKeyReleased
        //String query=doctorid.getText();
        //filter(query);
    }//GEN-LAST:event_doctornameKeyReleased

    private void clear_doctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear_doctorMouseClicked
        // TODO add your handling code here:
        doctorname.setText(null);
        doctoraddress.setText(null);
        doctor_phonenumber.setText(null);
        doctor_mailaddress.setText(null);
        qualification.setText(null);
        experience.setText(null);
        gender_male.setSelected(false);
        gender_female.setSelected(false);
        autoID();
    }//GEN-LAST:event_clear_doctorMouseClicked

    private void clear_doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_doctorActionPerformed
        // TODO add your handling code here:
        doctorid.setText(null);
        doctorname.setText(null);
        doctoraddress.setText(null);
        doctor_phonenumber.setText(null);
        doctor_mailaddress.setText(null);
        qualification.setText(null);
        experience.setText(null);
        gender_male.setSelected(false);
        gender_female.setSelected(false);
        autoID();
        RefrushTable();
    }//GEN-LAST:event_clear_doctorActionPerformed

    private void search_doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_doctorActionPerformed
        // TODO add your handling code here:
        String doctor_id=doctorid.getText();
        if(doctorid.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter ID to search..");
        }
        else{
            try{
                connection mysql=new connection();
                Connection con=mysql.connectDB();
                //String doctor_type=doctortype.getSelectedItem().toString();
                PreparedStatement selectdata=con.prepareStatement("select * from doctor where doctorid=?");
                selectdata.setString(1,doctor_id);
                ResultSet rs=selectdata.executeQuery();
                if(rs.next()){
                    doctorname.setText(rs.getString("doctorname"));
                    doctoraddress.setText(rs.getString("doctoraddress"));
                    doctor_phonenumber.setText(rs.getString("doctorcontactno"));
                    doctor_mailaddress.setText(rs.getString("doctor_mailaddress"));
                    qualification.setText(rs.getString("qualification"));
                    experience.setText(rs.getString("yearofexperiance"));
                    experience.setText(rs.getString("yearofexperiance"));
                    if(rs.getString("doctortype").equals("Ordinary")){
                        doctortype.setSelectedItem("Ordinary");
                    }
                    else if(rs.getString("doctortype").equals("Ordinary"))
                    {
                        doctortype.setSelectedItem("Consultant");
                    }
                    if(rs.getString("gender").equals("Male")){
                        gender_male.setSelected(true);
                        gender_female.setSelected(false);
                        
                    }
                    else if(rs.getString("gender").equals("Female")){
                        gender_female.setSelected(true);
                        gender_male.setSelected(false);
                        
                    }

                }
                else{
                    doctorname.setText(null);
                    doctoraddress.setText(null);
                    doctor_phonenumber.setText(null);
                    doctorid.setText(null);

                    JOptionPane.showMessageDialog(null,"no records are there!!");
                    autoID();
                }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,"error happen.please try again..");
                autoID();
            }
        }

    }//GEN-LAST:event_search_doctorActionPerformed

    private void insert_doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_doctorActionPerformed
        if(doctorid.getText().equals("") || doctorname.getText().equals("") || doctoraddress.getText().equals("") || doctor_mailaddress.getText().equals("") || qualification.getText().equals("") || experience.getText().equals("")){
            JOptionPane.showMessageDialog(null,"All the fields are requried..");
        }
        else{
            try{
                connection mysql=new connection();
                Connection con=mysql.connectDB();
                
                String doctor_id=doctorid.getText();
                String doctor_name=doctorname.getText();
                String doctor_address=doctoraddress.getText();
                String doctorphonenumber=doctor_phonenumber.getText();
                String doctor_mail=doctor_mailaddress.getText();
                String qualifi=qualification.getText();
                String experi=experience.getText();
                String doctor_type=doctortype.getSelectedItem().toString();
                //if((patientid.getText().equals("")) || (patientname.getText().equals("")) || (patientaddress.getText().equals(""))){
                    // JOptionPane.showMessageDialog(null,"please fillout all the fields!!");
                    //}
                //else{
                    PreparedStatement ps1=con.prepareStatement("INSERT INTO doctor(doctorid,doctorname,doctoraddress,doctorcontactno,doctor_mailaddress,qualification,yearofexperiance,doctortype,gender) VALUES(?,?,?,?,?,?,?,?,?)");
                    ps1.setString(1,doctor_id);
                    ps1.setString(2,doctor_name);
                    ps1.setString(3,doctor_address);
                    ps1.setString(4,doctorphonenumber);
                    ps1.setString(5,doctor_mail);
                    ps1.setString(6,qualifi);
                    ps1.setString(7,experi);
                    ps1.setString(8,doctor_type);
                    if(gender_male.isSelected()){
                        ps1.setString(9,gender_male.getText());
                        ps1.executeUpdate();
                    }
                    else{
                        ps1.setString(9,gender_female.getText());
                        ps1.executeUpdate();
                    }

                    JOptionPane.showMessageDialog(null,"Inserted suncessfully..");
                    autoID();
                    RefrushTable();
                    doctorid.setText(null);
                    doctorname.setText(null);
                    doctoraddress.setText(null);
                    doctor_phonenumber.setText(null);
                    doctor_mailaddress.setText(null);
                    qualification.setText(null);
                    experience.setText(null);
                    doctortype.setSelectedItem(false);
                    gender_male.setSelected(false);
                    gender_female.setSelected(false);
                    autoID();
                    //}
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"Please enter details..");
                autoID();
            }
        }
    }//GEN-LAST:event_insert_doctorActionPerformed

    private void update_doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_doctorActionPerformed
        // TODO add your handling code here:
        
        if(doctorid.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter id to update!!");
            autoID();
        }
        else{
            try{

                connection mysql=new connection();
                Connection con=mysql.connectDB();

                String doctor_id=doctorid.getText();
                String doctor_name=doctorname.getText();
                String doctor_address=doctoraddress.getText();
                String doctorphonenumber=doctor_phonenumber.getText();
                String doctor_mail=doctor_mailaddress.getText();
                String qualifi=qualification.getText();
                String experi=experience.getText();
                String doctor_type=doctortype.getSelectedItem().toString();
                String doctor_gender;
                if(gender_male.isSelected()){
                    doctor_gender=gender_male.getText();
                }
                else{
                    doctor_gender=gender_female.getText();
                }
                if(doctorid.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter id to update!!");
                    autoID();
                }
                else{
                    PreparedStatement ps=con.prepareStatement("UPDATE doctor SET doctorname=?,doctoraddress=?,doctorcontactno=?,doctor_mailaddress=?,qualification=?,yearofexperiance=?,doctortype=?,gender=? WHERE doctorid=?");

                    ps.setString(1,doctor_name);
                    ps.setString(2,doctor_address);
                    ps.setString(3,doctorphonenumber);
                    ps.setString(4, doctor_mail);
                    ps.setString(5,qualifi);
                    ps.setString(6,experi);
                    ps.setString(7,doctor_type);
                    ps.setString(8,doctor_gender);
                    ps.setString(9,doctor_id);
                    ps.executeUpdate();
                    doctorid.setText(null);
                    doctorname.setText(null);
                    doctoraddress.setText(null);
                    doctor_phonenumber.setText(null);
                    doctor_mailaddress.setText(null);
                    qualification.setText(null);
                    experience.setText(null);
                    doctortype.setSelectedItem(false);
                    gender_male.setSelected(false);
                    gender_female.setSelected(false);
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

    }//GEN-LAST:event_update_doctorActionPerformed

    private void delete_doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_doctorActionPerformed
        // TODO add your handling code here:

        try{
            connection mysql=new connection();
            Connection con=mysql.connectDB();
            String doctor_id=doctorid.getText();
            if(doctorid.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter ID to delete..");
                autoID();
            }
            else{
                PreparedStatement ps=con.prepareStatement("DELETE from doctor WHERE doctorid=?");
                ps.setString(1,doctor_id);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"deleted suncessfully..");
                autoID();
                RefrushTable();
                doctorname.setText(null);
                doctoraddress.setText(null);
                doctor_phonenumber.setText(null);
                doctor_mailaddress.setText(null);
                qualification.setText(null);
                experience.setText(null);
                gender_male.setSelected(false);
                gender_female.setSelected(false);
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"error happen.please try again..");
            autoID();
        }
    }//GEN-LAST:event_delete_doctorActionPerformed

    private void doctor_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctor_tableMouseClicked
        // TODO add your handling code here:
        int i=doctor_table.getSelectedRow();
        TableModel model=doctor_table.getModel();
        doctorid.setText((String) model.getValueAt(i,0));
        doctorname.setText((String) model.getValueAt(i,1));
        doctoraddress.setText((String) model.getValueAt(i,2));
        doctor_phonenumber.setText((String) model.getValueAt(i,3));
        doctor_mailaddress.setText((String)model.getValueAt(i,4));
        qualification.setText((String)model.getValueAt(i,5));
        experience.setText((String)model.getValueAt(i,6));
        String doctor_type=model.getValueAt(i,7).toString();
        if(doctor_type.equals("Ordinary")){
                      doctortype.setSelectedItem("Ordinary");
        }
        else if(doctor_type.equals("Consultant")){
                      doctortype.setSelectedItem("Consultant");
        }           
        String gender=model.getValueAt(i,8).toString();
        if(gender.equals("Male")){
            gender_male.setSelected(true);
            gender_female.setSelected(false);
        }
        else if(gender.equals("Female")){
            gender_female.setSelected(true);
            gender_male.setSelected(false);
        }
        
    }//GEN-LAST:event_doctor_tableMouseClicked

    private void doctoridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctoridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doctoridActionPerformed

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        // TODO add your handling code here:
        new manager_staff().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel32MouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        // TODO add your handling code here:
        new manager_doctor().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel29MouseClicked

    private void doctoridKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_doctoridKeyReleased
        // TODO add your handling code here:
        String query=doctorid.getText();
        filter(query);
        
    }//GEN-LAST:event_doctoridKeyReleased

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        // TODO add your handling code here:
        new manager_appointment().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        // TODO add your handling code here:
        new manager_treatment().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel33MouseClicked

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked
        // TODO add your handling code here:
        new manager_room().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel34MouseClicked

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
        // TODO add your handling code here:
        new manager_treatment_book().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel35MouseClicked

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
        // TODO add your handling code here:
        new manager_room_book().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel36MouseClicked

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
            java.util.logging.Logger.getLogger(manager_doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manager_doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manager_doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manager_doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manager_doctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clear_doctor;
    private javax.swing.JLabel close;
    private javax.swing.JButton delete_doctor;
    private javax.swing.JTextField doctor_mailaddress;
    private javax.swing.JTextField doctor_phonenumber;
    private javax.swing.JTable doctor_table;
    private javax.swing.JTextField doctoraddress;
    private javax.swing.JTextField doctorid;
    private javax.swing.JTextField doctorname;
    private javax.swing.JComboBox<String> doctortype;
    private javax.swing.JTextField experience;
    private javax.swing.JRadioButton gender_female;
    private javax.swing.JRadioButton gender_male;
    private javax.swing.JLabel home;
    private javax.swing.JButton insert_doctor;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField qualification;
    private javax.swing.JButton search_doctor;
    private javax.swing.JButton update_doctor;
    // End of variables declaration//GEN-END:variables
}
