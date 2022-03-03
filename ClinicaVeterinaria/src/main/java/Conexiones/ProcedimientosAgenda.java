/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

/**
 *
 * @author Oscar Andrade
 */
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.time.LocalTime;

import java.sql.Time;
import javax.swing.table.DefaultTableModel;
//import java.sql.Date;

public class ProcedimientosAgenda {
    public static void IngresoDatosCita (String dni, String fecha, LocalTime hora,int empleado,String mascota)throws SQLException
    {
        LocalTime now = hora;
        Time tiempo = Time.valueOf(now);
        
        CallableStatement entrada = Conexiones.Conexion.getConnection().prepareCall("{call AgendarCita(?,?,?,?,?)}");
        entrada.setString(1, dni);
        entrada.setString(2, fecha);
        entrada.setTime(3, tiempo);
        entrada.setInt(4, empleado);
        entrada.setString(5, mascota);
        entrada.execute();
         
    }
    
    public static void BuscarNombreCliente (String dni)throws SQLException
    {
        CallableStatement entrada = Conexiones.Conexion.getConnection().prepareCall("{call NombreCliente(?)}");
        entrada.setString(1, dni);
        entrada.execute();
    }
    
    
}
