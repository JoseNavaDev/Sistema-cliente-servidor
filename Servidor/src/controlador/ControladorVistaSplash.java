package controlador;

import vista.Vista;
import vista.VistaSplash;

public class ControladorVistaSplash {
    
    public VistaSplash VistaSplash;
    
    public ControladorVistaSplash(VistaSplash VistaSplash) throws InterruptedException{
        this.VistaSplash = VistaSplash;
        VistaSplash.setVisible(true);
        desvanecimientoSplash(3);
        ejecucionVentanaPrincipal();
    }
    
    private void desvanecimientoSplash(int segundos) throws InterruptedException{
        Thread.sleep(segundos*1000);
        float restador;
        for (int i = 100; i >= 0; i--) {
            Thread.sleep(20);
            restador = (float) i / 100;   
            VistaSplash.setOpacity(restador);
        }             
    }
    
    private void ejecucionVentanaPrincipal(){
        VistaSplash.setVisible(false);
        Vista v = new Vista();
        Controlador c = new Controlador(v);
    }
    
    

    
    
}
