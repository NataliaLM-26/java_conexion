package com.mycompany.practica01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOEmpleado implements IDAOGeneral<Empleado, Long> {

    @Override
    public Empleado save(Empleado pojo) {
        ConexionDB con = ConexionDB.getInstance();
        String sql = "INSERT INTO empleado (nombre,direccion,telefono) VALUES " + "('"+ pojo.getNombre() + "','" + pojo.getDireccion() + "','" + pojo.getTelefono() + "')";
        return null;
    }

    @Override
    public Empleado update(Empleado pojo, Long id) {
        ConexionDB con = ConexionDB.getInstance();
        String sql = "UPDATE empleado SET clave = '" + pojo.getClave() + "', nombre = '" + pojo.getNombre() +
                     "', direccion = '" + pojo.getDireccion() + "', telefono = '" + pojo.getTelefono() + "' WHERE clave = " + id;

        boolean res = con.execute(sql);
        if (res) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.INFO, "se ha actualizado correctamente");
        } else {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, "ERROR");
        }
        return pojo;
    }

    @Override
    public boolean delete(Long id) {
        ConexionDB con = ConexionDB.getInstance();
        String sql = "DELETE FROM empleado WHERE clave = " + id;

        boolean res = con.execute(sql);
        if (res) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.INFO, "Se ha eliminado correctamente");
        } else {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, "ERROR");
        }
        return res;
    }

    @Override
    public Empleado findById(Long id) {
        Empleado empleado = null;
        String sql = "SELECT * FROM empleado WHERE id = ?";
    
        try (Connection con = ConexionDB.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setLong(1, id);
                ResultSet reg = pstmt.executeQuery();
         
            if (reg.next()) {
                empleado = new Empleado();
                empleado.setClave(reg.getInt("clave"));
                empleado.setNombre(reg.getString("nombre"));
                empleado.setDireccion(reg.getString("direccion"));
                empleado.setTelefono(reg.getString("telefono"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return empleado;
    }

    @Override
    public List<Empleado> findAll() {
        try {
            ConexionDB con = ConexionDB.getInstance();
            String sql = "";
            sql="select * from empleado;";
            Statement st;
            st=con.ConexionDB().createStatement();
            ResultSet reg = st.executeQuery(sql);
            List<Empleado> lstEmpleado = new ArrayList<>();
            while (reg.next()) {
                Empleado emp = new Empleado();
                emp.setClave(reg.getInt(1));
                emp.setNombre(reg.getString(2));
                emp.setDireccion(reg.getString(3));
                emp.setTelefono(reg.getString(4));
                lstEmpleado.add(emp);
            }
            return lstEmpleado;
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
