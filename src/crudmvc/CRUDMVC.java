
package crudmvc;

import Controlador.CtrProducto;
import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.frmProducto;

/**
 *
 * @author Ivan Jaramillo
 */
public class CRUDMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Producto prod = new Producto();
        ConsultasProducto consultas = new ConsultasProducto();
        frmProducto frm = new frmProducto();
        
        CtrProducto ctrl = new CtrProducto(prod, consultas, frm);
        
        ctrl.iniciar();
        frm.setVisible(true);
    }
    
}
