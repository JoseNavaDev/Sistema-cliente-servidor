//CLIENTE
package principal;

import controlador.Controlador;
import controlador.ControladorVistaSplash;
import vista.Vista;
import vista.VistaSplash;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        VistaSplash v = new VistaSplash();
        ControladorVistaSplash c = new ControladorVistaSplash(v);
    }    
}
