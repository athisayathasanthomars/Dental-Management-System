/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package family_dental_care;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class ManagerSignin extends UserSignin{

    @Override
    public ResultSet signin(String username, String password) {
        ResultSet s=null;
        try {
            connection mysql=new connection();
            Connection con=mysql.connectDB();
            String sql="select * from login where username=? and password=?";
            PreparedStatement st1=con.prepareStatement(sql);
            st1.setString(1,username);
            st1.setString(2,password);
            s=st1.executeQuery();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerSignin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
}
