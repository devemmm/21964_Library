/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author root
 */
public class InitalConn {
    protected static Connection conn = null;
    protected static PreparedStatement pst = null;
    protected static ResultSet rs = null;
    protected static Statement st = null;
    
    private String url = "jdbc:mysql://localhost:3306/21964_Library";
    private String usr = "root";
    private String password = "";
    
    public void connect(){
        try{
            conn = DriverManager.getConnection(url, usr, password);
            System.out.println("Database Created");
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public void disconnect(){
        try {
            if(conn !=null){
                conn.close();
            }
            if(st !=null){
                st.close();
            }
            if(pst !=null){
                pst.close();
            }
            if(rs !=null){
                rs.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
