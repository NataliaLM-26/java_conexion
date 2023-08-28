package com.mycompany.practica01;

import java.util.Iterator;
import java.util.List;

public class PRACTICA01 {

    public static void main(String[] args) {
        Empleado emp= new Empleado();
        emp.setClave(11);
        emp.setNombre("Natalia");
        emp.setDireccion("calle 1");
        emp.setTelefono("263");
//        System.out.print(emp);
//        
        System.out.println("Clave:"+emp.getClave()+"Nombre:"+emp.getNombre());
//        
        
        DAOEmpleado dao=new DAOEmpleado();
        Empleado empr=dao.save(emp);
        ConexionDB conexion = new ConexionDB();
          
          //DAOEmpleado dao=new DAOEmpleado();
//          List<Empleado> lstEmpleado=dao.findAll();
//          for (Iterator<Empleado> iterator = lstEmpleado.iterator();
//                  iterator.hasNext();){
//              emp = iterator.next();
//              System.out.println("Clave:"+emp.getClave()+"Nombre:"+emp.getNombre());
//          }


    }
}
