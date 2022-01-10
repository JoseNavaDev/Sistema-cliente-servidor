package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import modelo.ServidorPruebas;
import vista.Vista;

public class Controlador implements MouseListener, MouseMotionListener{
    
    public Vista Vista;
    
    int x,y;
    
    public Controlador(Vista Vista){
        this.Vista = Vista;
        Vista.setVisible(true);
        oyentes();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==Vista.LabelImagenCerrar) {
            System.exit(0);
        }
        if (e.getSource()==Vista.LabelImagenMinimizar) {
            Vista.setState(Vista.ICONIFIED);
        }
        
        //SERVIDOR
        if (e.getSource()==Vista.BotonActivarServidor) {
            ServidorPruebas sp = new ServidorPruebas(Vista);
            sp.start();
            Vista.servidorEncendido();
        }
        if (e.getSource()==Vista.BotonDesactivarServidor) {
            Vista.servidorApagado();
        }
        
        //PERIFÉRICOS ON
        if (e.getSource()==Vista.BotonCamaraON) {
            Vista.botonCamaraOff(true);
            Vista.botonCamaraOn(false);
            Vista.Periferico_Camara = "Desactivado";
        }
        if (e.getSource()==Vista.BotonCerraduraON) {
            Vista.botonCerraduraOff(true);
            Vista.botonCerraduraON(false);
            Vista.Periferico_Cerradura = "Desactivado";
        }
        if (e.getSource()==Vista.BotonSensorON) {
            Vista.botonSensorOff(true);
            Vista.botonSensorOn(false);
            Vista.Periferico_Sensor = "Desactivado";
        }
        if (e.getSource()==Vista.BotonAPION) {
            Vista.botonAPIOff(true);
            Vista.botonAPIOn(false);
            Vista.Periferico_API = "Desactivado";
        }
        if (e.getSource()==Vista.BotonMonitorON) {
            Vista.botonMonitorOff(true);
            Vista.botonMonitorOn(false);
            Vista.Periferico_Monitor = "Desactivado";
        }
        
        //PERIFÉRICOS OFF
        if (e.getSource()==Vista.BotonCamaraOFF) {
            Vista.botonCamaraOff(false);
            Vista.botonCamaraOn(true);
            Vista.Periferico_Camara = "Activado";
        }
        if (e.getSource()==Vista.BotonCerraduraOFF) {
            Vista.botonCerraduraOff(false);
            Vista.botonCerraduraON(true);
            Vista.Periferico_Cerradura = "Activado";
        }
        if (e.getSource()==Vista.BotonSensorOFF) {
            Vista.botonSensorOff(false);
            Vista.botonSensorOn(true);
            Vista.Periferico_Sensor = "Activado";
        }
        if (e.getSource()==Vista.BotonAPIOFF) {
            Vista.botonAPIOff(false);
            Vista.botonAPIOn(true);
            Vista.Periferico_API = "Activado";
        }
        if (e.getSource()==Vista.BotonMonitorOFF) {
            Vista.botonMonitorOff(false);
            Vista.botonMonitorOn(true);
            Vista.Periferico_Monitor = "Activado";
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource()==Vista.LabelImagenMover) {
            x=e.getX(); // Obtiene las coordenadas en X y Y
            y=e.getY();            
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource()==Vista.LabelImagenMover) {
            Vista.LabelImagenMover.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    

    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.getSource()==Vista.LabelImagenMover) {
            Vista.setLocation(Vista.getLocation().x+e.getX()-x,
                                    Vista.getLocation().y+e.getY()-y);                        
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
    
    private void oyentes() {
        Vista.LabelImagenMover.addMouseListener(this);
        Vista.LabelImagenMover.addMouseMotionListener(this);
        
        Vista.LabelImagenCerrar.addMouseListener(this);
        Vista.LabelImagenCerrar.addMouseMotionListener(this);
        
        Vista.LabelImagenMinimizar.addMouseListener(this);
        Vista.LabelImagenMinimizar.addMouseMotionListener(this);
        
        Vista.BotonActivarServidor.addMouseListener(this);
        Vista.BotonActivarServidor.addMouseMotionListener(this);
        
        Vista.BotonDesactivarServidor.addMouseListener(this);
        Vista.BotonDesactivarServidor.addMouseMotionListener(this);  
        
        Vista.BotonCamaraON.addMouseListener(this);
        Vista.BotonCamaraON.addMouseMotionListener(this);
        Vista.BotonCamaraOFF.addMouseListener(this);
        Vista.BotonCamaraOFF.addMouseMotionListener(this);
        
        Vista.BotonCerraduraON.addMouseListener(this);
        Vista.BotonCerraduraON.addMouseMotionListener(this);
        Vista.BotonCerraduraOFF.addMouseListener(this);
        Vista.BotonCerraduraOFF.addMouseMotionListener(this);
        
        Vista.BotonSensorON.addMouseListener(this);
        Vista.BotonSensorON.addMouseMotionListener(this);
        Vista.BotonSensorOFF.addMouseListener(this);
        Vista.BotonSensorOFF.addMouseMotionListener(this);
        
        Vista.BotonAPION.addMouseListener(this);
        Vista.BotonAPION.addMouseMotionListener(this);
        Vista.BotonAPIOFF.addMouseListener(this);
        Vista.BotonAPIOFF.addMouseMotionListener(this);
        
        Vista.BotonMonitorON.addMouseListener(this);
        Vista.BotonMonitorON.addMouseMotionListener(this);
        Vista.BotonMonitorOFF.addMouseListener(this);
        Vista.BotonMonitorOFF.addMouseMotionListener(this);
                
    }
    
}
