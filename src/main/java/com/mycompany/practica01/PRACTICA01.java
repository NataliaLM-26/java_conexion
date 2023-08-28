package com.mycompany.practica01;

import java.util.Iterator;
import java.util.List;

public class PRACTICA01 {

    public static void main(String[] args) {
        Empleado emp= new Empleado();
        emp.setClave(1);
        emp.setNombre("Natalia");
        emp.setDireccion("calle 1");
        emp.setTelefono("263");
        DAOEmpleado dao=new DAOEmpleado();
       
        System.out.println("Clave:"+emp.getClave()+"Nombre:"+emp.getNombre()+"Direccion:"+emp.getDireccion()+"Telefono:"+emp.getTelefono());
      
        ConexionDB conexion = new ConexionDB();
          

//        List<Empleado> lstEmpleado=dao.findAll();
//        for (Iterator<Empleado> iterator = lstEmpleado.iterator();
//                  iterator.hasNext();){
//              emp = iterator.next();
//              System.out.println("Clave:"+emp.getClave()+"Nombre:"+emp.getNombre()+"Direccion:"+emp.getDireccion()+"Telefono:"+emp.getTelefono());
//////          }


    }
}
