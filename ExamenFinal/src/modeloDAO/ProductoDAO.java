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
public class ProductoDAO implements CRUD{
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Producto t = new Producto();
    
    @Override
    public List listarproducto() {
        ArrayList<Producto> productos = new ArrayList<>();
        String consulta = " select *  "
                        + "from producto ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while(rs.next()){
                Producto producto = new Producto();
                producto.setIdproducto(rs.getInt("idproducto"));
                producto.setCodigo(rs.getString("codigo"));
                producto.setNombre(rs.getString("nombre"));                
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getString("Estado"));
                productos.add(producto);
            }            
        } catch (SQLException t) {
            System.out.println("Error durante el select");
        }
        return productos;
    }

    @Override
    public Producto buscarproducto(int idproducto) {
         String consulta = " select *  "
                        + "from producto  "
                        + "where idproducto = " + idproducto + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {                
                t.setIdproducto(rs.getInt("idproducto"));
                t.setCodigo(rs.getString("codigo"));
                t.setNombre(rs.getString("nombre"));                
                t.setPrecio(rs.getDouble("precio"));
                t.setStock(rs.getInt("stock"));
                t.setEstado(rs.getString("estado"));
            }
        } catch (SQLException t) {
            System.out.println("Error durante el select");        
        }
        return t;
    }

    @Override
    public boolean agregarproducto(Producto producto) {
        String consulta = " insert into producto(codigo, nombre, precio, stock, estado)  "
                        + " values(  "
                        + "'"+ producto.getCodigo() +"',  "
                        + "'"+ producto.getNombre() +"', "
                        + "'"+ producto.getPrecio() +"',  "
                        + "'"+ producto.getStock() +"',  "                        
                        + "'"+ producto.getEstado() +"'); ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException t) {
            System.out.println("Error durante la insert del nuevo producto");
            return true;
        }
        return false;
    }

    @Override
    public boolean editarproducto(Producto producto) {
         String consulta = " update producto  "
                        + " set  "
                        + " codigo = '"+ producto.getCodigo()+"', "
                        + " nombre = '"+ producto.getNombre() +"', "
                        + " precio = '"+ producto.getPrecio() +"', "
                        + " stock = '"+ producto.getStock() +"', "
                        + " estado = '"+ producto.getEstado() +"'  "
                        + " where "
                        + " idproducto = " + producto.getIdproducto() + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException t) {
            System.out.println("Error durante la edición del producto");
            return true;
        }
        return false;
    }

   
    public boolean eliminarproducto(int idproducto) {
       String consulta = " delete  "
                        + " from producto  "
                        + " where "
                        + " idprducto = " + idproducto;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException t) {
            System.out.println("Error durante la elimiación del producto");
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarproducto(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listarproveedor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Proveedor buscarproveedor(int idproveedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregarproveedor(Proveedor proveedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editarproveedor(Proveedor proveedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarproveedor(Proveedor proveedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
