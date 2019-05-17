package attendance;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class TeacherAttd extends javax.swing.JFrame {
    Connection conn;
    ResultSet rs,rs1,rs2,rs3;
    PreparedStatement psd,psd1,psd2,psd3,psd4,psd5;
    /**
     * Creates new form TeacherAttd
     */
    public TeacherAttd() {
        initComponents();
        conn = javaconnectDataBase.ConnectDB();
        set();
    }

    public void set(){
        Subjects.disable();
        SubjectsS.setEnabled(false);
        String usnn=Login.USN1;
        String sql = "SELECT * FROM teacher WHERE Teacher_id='"+usnn+"'";
        try{
            psd=conn.prepareStatement(sql);
            rs=psd.executeQuery();
            teacherid.setText(rs.getString(1));
            name.setText(rs.getString(2));
            int i=0;
               String arr[]=new String[10];
            while(rs.next()){            
             arr[i]=rs.getString(4);
             i++;
             //Subjects.addItem(rs.getString(7));
            }
            int length=i;
           length = removeDuplicateElements(arr, length);  
           for (int j=0; j<length; j++){
                          Class.addItem(arr[j]);
           }  
           try {
            // TODO add your handling code here:
           conn.close();
           System.out.println("Connection Closed");
           } catch (SQLException ex) {
           Logger.getLogger(StudentDetailsDisplay.class.getName()).log(Level.SEVERE, null, ex);
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public static int removeDuplicateElements(String arr[], int n){  
        if (n==0 || n==1){  
            return n;  
        }  
        String[] temp = new String[n];  
        int j = 0;  
        for (int i=0; i<n-1; i++){  
            if (!arr[i].equals(arr[i+1])){  
                temp[j++] = arr[i];  
            }  
         }  
        temp[j++] = arr[n-1];     
        // Changing original array  
        for (int i=0; i<j; i++){  
            arr[i] = temp[i];  
        }  
        return j;  
    }  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Subjects = new javax.swing.JComboBox<>();
        teacherid = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Class = new javax.swing.JComboBox<>();
        submit = new javax.swing.JButton();
        back = new javax.swing.JButton();
        selectall = new javax.swing.JButton();
        deselectall = new javax.swing.JButton();
        ClassS = new javax.swing.JButton();
        SubjectsS = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Attendance", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        teacherid.setEditable(false);
        teacherid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacheridActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "USN", "Name", "Attd."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        name.setEditable(false);

        jLabel3.setText("Name");

        jLabel1.setText("Teacher ID");

        jLabel2.setText("Class");

        jLabel4.setText("Subjects");

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        selectall.setText("Select All");
        selectall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectallActionPerformed(evt);
            }
        });

        deselectall.setText("Deselect All");
        deselectall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deselectallActionPerformed(evt);
            }
        });

        ClassS.setText("SELECT");
        ClassS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClassSActionPerformed(evt);
            }
        });

        SubjectsS.setText("SELECT");
        SubjectsS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubjectsSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(teacherid, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Class, 0, 81, Short.MAX_VALUE)
                            .addComponent(Subjects, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ClassS)
                            .addComponent(SubjectsS))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(selectall)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deselectall)
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submit)
                .addGap(33, 33, 33)
                .addComponent(back)
                .addGap(139, 139, 139))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(teacherid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Class, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(ClassS)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(Subjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubjectsS))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectall)
                    .addComponent(deselectall))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(submit))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void teacheridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacheridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teacheridActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        TeacherDetailsDisplay ob = new TeacherDetailsDisplay();
        ob.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void selectallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectallActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();
        for(int i=0;i<model.getRowCount();i++)
        {
            jTable1.setValueAt(true, i, 2);
        }
    }//GEN-LAST:event_selectallActionPerformed

    private void deselectallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deselectallActionPerformed
        // TODO add your handling code here:
                DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();
        for(int i=0;i<model.getRowCount();i++)
        {
            jTable1.setValueAt(false, i, 2);
        }
    }//GEN-LAST:event_deselectallActionPerformed

    private void ClassSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClassSActionPerformed
        // TODO add your handling code here:
        conn=javaconnectDataBase.ConnectDB();
        String usnn=Login.USN1;
        Subjects.removeAllItems();
        String sql="SELECT Subject FROM teacher WHERE Teacher_id='"+usnn+"'"+" AND Class='"+Class.getSelectedItem()+"'";
        try{
            psd=conn.prepareStatement(sql);
            rs=psd.executeQuery();
            while(rs.next()){
                Subjects.addItem(rs.getString(1));
            }
            Subjects.enable();
            Class.disable();
            ClassS.setEnabled(false);
            SubjectsS.setEnabled(true);
            try {
            // TODO add your handling code here:
           conn.close();
           System.out.println("Connection Closed");
           } catch (SQLException ex) {
           Logger.getLogger(StudentDetailsDisplay.class.getName()).log(Level.SEVERE, null, ex);
           }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_ClassSActionPerformed

    private void SubjectsSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubjectsSActionPerformed
        // TODO add your handling code here:
        conn=javaconnectDataBase.ConnectDB();
        Subjects.disable();
        SubjectsS.setEnabled(false);
        String ElectiveFlag = null;
        String sql = "";
        String sql1="SELECT ElectiveFlag FROM teacher WHERE Class='"+Class.getSelectedItem()+"'"+" AND Subject='"+Subjects.getSelectedItem()+"'";
try{
    psd1=conn.prepareStatement(sql1);
    rs1=psd1.executeQuery();
    while(rs1.next()){
        ElectiveFlag=rs1.getString(1);
    }
    if("0".equals(ElectiveFlag)){
        sql="SELECT USN,Name FROM student WHERE SemSec='"+Class.getSelectedItem()+"'";
    }else{
      sql="SELECT USN,Name FROM student WHERE SemSec='"+Class.getSelectedItem()+"'"+" AND Elective='"+Subjects.getSelectedItem()+"'";
    }
        try{
            psd=conn.prepareStatement(sql);
            rs=psd.executeQuery();
            int i=0;
            DefaultTableModel model;
                model = (DefaultTableModel) jTable1.getModel();;
           while(rs.next()){
               model.setRowCount(i+1);
               rs.getString(1);
               jTable1.setValueAt(rs.getString(1),i,0);
               
                 jTable1.setValueAt(rs.getString(2),i,1);
                 i++;
           }
           try {
            // TODO add your handling code here:
           conn.close();
           System.out.println("Connection Closed");
           } catch (SQLException ex) {
           Logger.getLogger(StudentDetailsDisplay.class.getName()).log(Level.SEVERE, null, ex);
           }
        }catch(Exception e){
            e.printStackTrace();
            
        
    }
}catch(Exception e1){
    e1.printStackTrace();
        
}
    }//GEN-LAST:event_SubjectsSActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
//        for(int j=0;j<jTable1.getRowCount();j++){
//            if((boolean)jTable1.getValueAt(j,2)==true)
//                jTable1.setValueAt(false, j, 2);
//        }
conn=javaconnectDataBase.ConnectDB();
    int flag=0;
//            int row = jTable1.getSelectedRow();
//            String usn = jTable1.getModel().getValueAt(row, column).toString();
     DefaultTableModel model;
                model = (DefaultTableModel) jTable1.getModel();
try{ 
    for(int i=0;i<model.getRowCount();i++){
           String usn = jTable1.getModel().getValueAt(i, 0).toString();
        String sql2="SELECT * FROM attendance WHERE USN='"+usn+"'"+" AND Subject='"+Subjects.getSelectedItem()+"'";
try{
        psd1=conn.prepareStatement(sql2);
        rs1=psd1.executeQuery();
        if(rs1.next()){
            System.out.println(jTable1.getValueAt(i,2));
           // String sql3="UPDATE attendance SET Classes_Att= "+(rs1.getInt(5)+1)+" , Classes_Total="+(rs1.getInt(6)+1)+" WHERE USN='"+usn+"' AND Subject= '"+Subjects.getSelectedItem()+"'";
           //CHECK THIS CODE
           //if(jTable1.getValueAt(i,2)!=null||(boolean)jTable1.getValueAt(i,2)!=false)
           if(jTable1.getValueAt(i,2)!=null){
               if((boolean)jTable1.getValueAt(i,2)!=false){
               flag=1;
               //System.out.println("Hello");
           String sql3="UPDATE attendance SET Classes_Att= "+(rs1.getInt(5)+1)+" WHERE USN='"+usn+"' AND Subject= '"+Subjects.getSelectedItem()+"'"; 
           //conn=javaconnectDataBase.ConnectDB();
           psd3=conn.prepareStatement(sql3);
            psd3.executeUpdate();
           }
           }
            String sql7="UPDATE attendance SET Classes_Total="+(rs1.getInt(6)+1)+" WHERE Subject= '"+Subjects.getSelectedItem()+"' AND USN = '"+usn+"'";
            psd5=conn.prepareStatement(sql7);
            psd5.executeUpdate();
        }else{
            LocalDate today = LocalDate.now();
            LocalTime time = LocalTime.now();
                String sql="INSERT into attendance(Teacher_id,Subject,USN,SemSec,Classes_Att,Classes_Total,datetime) VALUES(?,?,?,?,?,?,?) " ; 
        try {
            psd = conn.prepareStatement(sql);
            psd.setString(1,Login.USN1);
            psd.setString(2, (String) Subjects.getSelectedItem());
            psd.setString(3,usn);
            psd.setString(4, (String) Class.getSelectedItem());
            psd.setString(5,"1");
            String today1=today.toString();
            String time1=time.toString();
            time1=time1.substring(0,6);
            psd.setString(7,today1+" -- "+time1);
            String sql1="SELECT Classes_Total,datetime from attendance WHERE Subject='"+Subjects.getSelectedItem()+"'";
            try{
                psd2=conn.prepareStatement(sql1);
                rs2=psd2.executeQuery();
                if(rs2.next()){
                    if(rs2.getString(2).equals(today1+" -- "+ time1)){
                        psd.setInt(6,1);
                        
                    }else{ String sql5="UPDATE attendance SET Classes_Total="+(rs2.getInt(1)+1)+" WHERE Subject='"+Subjects.getSelectedItem()+"'";
              psd.setInt(6, rs2.getInt(1)+1);
             
                psd4=conn.prepareStatement(sql5);   
                psd4.executeUpdate();
                }}else{
                    psd.setInt(6,1);
                }
                psd.execute();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TeacherAttd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
        
                //agar rs.nect nahi hai toh insert else update the table
}       catch (SQLException ex) { //carch 1
            Logger.getLogger(TeacherAttd.class.getName()).log(Level.SEVERE, null, ex);
        }
        // end of if
       
    }
        }catch(Exception e){
                e.printStackTrace();
                flag=0;
             JOptionPane.showMessageDialog(null, "No student selected!");
        }
                if(flag==1)
                    JOptionPane.showMessageDialog(null, "Attendance Taken");
                else
                    JOptionPane.showMessageDialog(null, "No students Selected");
                setVisible(false);
                TeacherDetailsDisplay ob= new TeacherDetailsDisplay();
                ob.setVisible(true);
                try {
            // TODO add your handling code here:
           conn.close();
           System.out.println("Connection Closed **********");
           } catch (SQLException ex) {
           Logger.getLogger(StudentDetailsDisplay.class.getName()).log(Level.SEVERE, null, ex);
           }
    }//GEN-LAST:event_submitActionPerformed

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
            java.util.logging.Logger.getLogger(TeacherAttd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherAttd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherAttd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherAttd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherAttd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Class;
    private javax.swing.JButton ClassS;
    private javax.swing.JComboBox<String> Subjects;
    private javax.swing.JButton SubjectsS;
    private javax.swing.JButton back;
    private javax.swing.JButton deselectall;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField name;
    private javax.swing.JButton selectall;
    private javax.swing.JButton submit;
    private javax.swing.JTextField teacherid;
    // End of variables declaration//GEN-END:variables
}
