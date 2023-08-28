package com.mycompany.practica01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexionDB {    
    private static ConexionDB cx=null;
    String bd="empleados";
    String ip="localhost";
    String puerto="5432";
    String cadena="jdbc:postgresql://"+ip+":"+puerto+"/"+bd;
    
    public static ConexionDB getInstance(){
        if(cx==null)
            cx=new ConexionDB();
        return cx;
    }
    
    private Connection con = null;
    
    public Connection ConexionDB() {
        try {
            String url="jdbc:postgresql://localhost:5432/empleados";
            con=DriverManager.getConnection(cadena+"postgres"+"laptophp");
            //Logger.getLogger(ConexionDB.class.getName()).log(Level.INFO,"se conecto");
            JOptionPane.showMessageDialog(null, "Se conectó correctamente");
        } catch (SQLException ex) {
            //Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE,null, ex);
            JOptionPane.showMessageDialog(null, "Error:");
        }
        return con;
    }
    
    public boolean execute(String sql){
        Statement st= null;
        try {
            st=con.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE,null, ex);
            return false;
        }
    }
    
    public ResultSet select(String sql){
        Statement st=null;
        try{
            st=con.createStatement();
            ResultSet reg= st.executeQuery(sql);
            return reg;
        } catch (SQLException ex){
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null,ex);
            return null;
        }
//        finally{
//            if(st!=null){
//                try {
//                    st.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE,null, ex);
//                }
//            if(reg!=null)
//                try{
//                    reg.close();
//                } catch (SQLException ex){
//                    Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE,null, ex);
//                }
//            }
//        }    
    }
    
    
}
