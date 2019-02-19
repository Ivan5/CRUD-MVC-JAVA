
package Controlador;

import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.frmProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan Jaramillo
 */
public class CtrProducto implements ActionListener{
    private Producto prod;
    private ConsultasProducto consultas;
    private frmProducto frm;
    
    public CtrProducto(Producto prod, ConsultasProducto consultas, frmProducto frm){
        this.prod = prod;
        this.consultas = consultas;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }
    
    public void iniciar(){
        frm.setTitle("Productos");
        frm.setLocationRelativeTo(null);
        frm.txtID.setVisible(false);
    }
    
    public void limpiar(){
        frm.txtID.setText(null);
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtPrecio.setText(null);
        frm.txtCantidad.setText(null);
    }
    
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frm.btnGuardar){
            prod.setCodigo(frm.txtCodigo.getText());
            prod.setNombre(frm.txtNombre.getText());
            prod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            prod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            if(consultas.registrar(prod)){
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }
        
        if(e.getSource() == frm.btnModificar){
            prod.setId(Integer.parseInt(frm.txtID.getText()));
            prod.setCodigo(frm.txtCodigo.getText());
            prod.setNombre(frm.txtNombre.getText());
            prod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            prod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            if(consultas.modificar(prod)){
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        
        if(e.getSource() == frm.btnEliminar){
            prod.setCodigo(frm.txtCodigo.getText());
            if(consultas.eliminar(prod)){
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }
        
        if(e.getSource() == frm.btnBuscar){
            prod.setCodigo(frm.txtCodigo.getText());
            if(consultas.buscar(prod)){
                frm.txtID.setText(String.valueOf(prod.getId()));
                frm.txtCodigo.setText(prod.getCodigo());
                frm.txtNombre.setText(prod.getNombre());
                frm.txtPrecio.setText(String.valueOf(prod.getPrecio()));
                frm.txtCantidad.setText(String.valueOf(prod.getCantidad()));
            }else{
                JOptionPane.showMessageDialog(null, "No se encontraron registros");
                limpiar();
            }
        }
        
        if(e.getSource() == frm.btnLimpiar){
            limpiar();
        }
    }
    
    
}
