/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import config.bd.ConectaBd;
import interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;

import modelo.Proveedor;

/**
 *
 * @author sandr
 */
public class ProveedorDAO implements CRUD {
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Proveedor v = new Proveedor();
    
    @Override
    public List listarproveedor() {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        String consulta = " select *  "
                        + "from producto ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while(rs.next()){
                Proveedor proveedor = new Proveedor();
                proveedor.setIdproveedor(rs.getInt("idproveedor"));
             
                proveedor.setNombre(rs.getString("nombre"));                
                proveedor.setRuc(rs.getString("ruc"));
                proveedor.setDireccion(rs.getString("direccion"));
                proveedor.setEstado(rs.getString("Estado"));
                proveedores.add(proveedor);
            }            
        } catch (SQLException v) {
            System.out.println("Error durante el select");
        }
        return proveedores;
    }

    @Override
    public Proveedor buscarproveedor(int idproveedor) {
        String consulta = " select *  "
                        + "from proveedor  "
                        + "where idproveedor = " + idproveedor + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {                
                v.setIdproveedor(rs.getInt("idproducto"));
                
                v.setNombre(rs.getString("nombre"));                
                v.setRuc(rs.getString("ruc"));
                v.setDireccion(rs.getString("direccion"));
                v.setEstado(rs.getString("estado"));
            }
        } catch (SQLException v) {
            System.out.println("Error durante el select");        
        }
        return v;
    }

    @Override
    public boolean agregarproveedor(Proveedor proveedor) {
        String consulta = " insert into proveedor( nombre, ruc, direccion, estado)  "
                        + " values(  "
                       
                        + "'"+ proveedor.getNombre() +"', "
                        + "'"+ proveedor.getRuc() +"',  "
                        + "'"+ proveedor.getDireccion() +"',  "                        
                        + "'"+ proveedor.getEstado() +"'); ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException v) {
            System.out.println("Error durante la insert del nuevo proveedor");
            return true;
        }
        return false;
    }

    @Override
    public boolean editarproveedor(Proveedor proveedor) {
        String consulta = " update producto  "
                        + " set  "
                        
                        + " nombre = '"+ proveedor.getNombre() +"', "
                        + " precio = '"+ proveedor.getRuc() +"', "
                        + " stock = '"+ proveedor.getDireccion() +"', "
                        + " estado = '"+ proveedor.getEstado() +"'  "
                        + " where "
                        + " idproducto = " + proveedor.getIdproveedor() + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException v) {
            System.out.println("Error durante la edición del proveedor");
            return true;
        }
        return false;
    }

    
    public boolean eliminarproveedor( int idproveedor) {
         String consulta = " delete  "
                        + " from proveedor  "
                        + " where "
                        + " idproveedor = " + idproveedor;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException v) {
            System.out.println("Error durante la elimiación del proveedor");
            return true;
        }
        return false;
    }

    @Override
    public List listarproducto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto buscarproducto(int idproducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregarproducto(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editarproducto(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarproducto(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarproveedor(Proveedor proveedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

  

    
}
