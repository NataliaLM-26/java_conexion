package com.mycompany.practica01;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOEmpleado implements IDAOGeneral<Empleado, Long> {

    @Override
    public Empleado save(Empleado pojo) {
        ConexionDB con = ConexionDB.getInstance();
        String sql = "insert into ejemplo (nombre,direccion,telefono) values " + " ('" + pojo.getClave() + "','" + pojo.getNombre() + "','" + pojo.getDireccion() + "','" + pojo.getTelefono() + "')";
        return null;
    }

    @Override
    public Empleado update(Empleado pojo, Long id) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Empleado findById(Long id) {
        return null;
    }

    @Override
    public List<Empleado> findAll() {
//        try {
//            ConexionDB con = ConexionDB.getInstance();
//            ResultSet reg = con.select("Select * from ejemplo");
//            List<Empleado> lstEmpleado = new ArrayList<>();
//            while (reg.next()) {
//                Empleado emp = new Empleado();
//                emp.setClave(reg.getInt(1));
//                emp.setNombre(reg.getString(2));
//                emp.setDireccion(reg.getString(3));
//                emp.setTelefono(reg.getString(4));
//                lstEmpleado.add(emp);
//            }
//            return lstEmpleado;
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

//}
