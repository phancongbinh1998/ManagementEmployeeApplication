/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.registration;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sample.utils.DBUtils;

/**
 *
 * @author Mochi
 */
public class RegistrationDAO implements Serializable{
    public boolean checkLogin(String username, String password)throws SQLException, NamingException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Open connection
            conn = DBUtils.makeConnection();
            if(conn != null){
                //2. create SQL Statement
                String sql = "Select * From Login Where username = ? And password = ?";
                //3. Create Statement& pass parameters
                stm = conn.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4. Thực thi câu lệnh, excute query
                rs = stm.executeQuery();
                if(rs.next()){
                    return true;
                }
            }//end if
        } finally {
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        
        return false;
    }
    
    private List<RegistrationDTO> listAccounts;

    public List<RegistrationDTO> getListAccounts() {
        return listAccounts;
    }
    
    private int count = 0;
    public int returnCount(){
        return count;
    }
    public void searchLastname(String searchValue)throws SQLException, NamingException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Open connection
            conn = DBUtils.makeConnection();
            if(conn != null){
                //2. create SQL Statement
                String sql = "Select * From Login Where username = ? And password = ?";
                //3. Create Statement& pass parameters
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                //4. Thực thi câu lệnh, excute query
                rs = stm.executeQuery();
                while(rs.next()){
                    this.count++;
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String lastname = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");
                    
                    RegistrationDTO dto = new RegistrationDTO(username, password, lastname, role);
                    if(this.listAccounts == null){
                        this.listAccounts = new ArrayList<>();
                    }
                    this.listAccounts.add(dto);
                }//end while
            }//end if
        } finally {
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
    }
    
    public boolean deleteAcount(String username)throws SQLException, NamingException{
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            //1. Open connection
            conn = DBUtils.makeConnection();
            if(conn != null){
                //2. create SQL Statement
                String sql = "Delete From Login Where username = ?";
                //3. Create Statement& pass parameters
                stm = conn.prepareStatement(sql);
                stm.setString(0, sql);
                int row = stm.executeUpdate();
                if(row > 0){
                    return true;
                }

            }//end if
        } finally {
           
            if(stm != null){
                stm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        
        return false;
        
    }
    
    public boolean updatePassRole(String username, String password, boolean role)throws SQLException, NamingException{
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            //1. Open connection
            conn = DBUtils.makeConnection();
            if(conn != null){
                //2. create SQL Statement
                String sql = "Update Login Set password = ?, isAdmin = ? Where username = ?";
                //3. Create Statement& pass parameters
                stm = conn.prepareStatement(sql);
                stm.setString(1, password);
                stm.setBoolean(2, role);
                stm.setString(3, username);
                int row = stm.executeUpdate();
                if(row > 0){
                    return true;
                }

            }//end if
        } finally {
           
            if(stm != null){
                stm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        
        return false;
    }
    public boolean createAccount(String username, String password, String fullname, boolean role) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        //1. open connection
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                //2.tao 
                String sql = "Insert Into Registration(username, password, lastname, isAdmin) Values(?,?,?,?)";

                //3. thuc hien truy van
                stm = con.prepareStatement(sql);
                stm.setString(1,username);
                stm.setString(2, password);
                stm.setString(3, fullname);
                stm.setBoolean(4, role);
                int row = stm.executeUpdate();

                if (row > 0) {
                    return true;
                }

            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
        
    }
}
