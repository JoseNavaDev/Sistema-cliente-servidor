package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.Cliente2;
import modelo.ClienteRecibirVideo;
import vista.Vista;

public class Controlador implements MouseListener, MouseMotionListener{

    public Vista Vista;      
    int x,y;
    int puerto;    
    String Ruta = "C:\\Users\\josem\\Desktop\\FR2021A\\OMESmodeloEigenFaceJose100.xml";
    String IP;
    boolean flagServidorConectado = false;
    
    public Controlador(Vista Vista){
        this.Vista = Vista;
        Vista.configuracionPP();        
        oyentes();        
        Vista.setVisible(true);
    }
   
    @Override
    public void mouseClicked(MouseEvent e) {
        //PANEL PRINCIPAL
        if (e.getSource()==Vista.LabelImagenCerrar) {
            System.exit(0);
        }
        if (e.getSource()==Vista.LabelImagenMinimizar) {
            Vista.setState(Vista.ICONIFIED);
        }
        if (e.getSource()==Vista.LabelImagenRegreso) {
            Vista.PanelArchivo.setVisible(false);
            Vista.PanelCamara.setVisible(false);
            Vista.PanelPerifericos.setVisible(false);
            Vista.PanelPuerta.setVisible(false);
            Vista.configuracionPP();
            Vista.PanelPrincipal.setVisible(true);
            Vista.componentesInfoconexionAServidor(false);
            Vista.componentesInfoServidorConectado(true);
        }
        if (e.getSource()==Vista.LabelBotonEnterInfoCS) {
            IP = Vista.TxfIP.getText();
            String Puerto = Vista.TxfPuerto.getText();
            puerto = Integer.parseInt(Puerto);
            Cliente2 c = new Cliente2(Vista);
            c.seter(IP, puerto);            
            try {
                if (c.pruebaConexion()) {
                    Vista.LabelBotonEnterInfoCS.setVisible(false);
                    Vista.LabelBotonEnterDesconectarServidor.setVisible(true);
                    Vista.componentesInfoconexionAServidor(false);
                    Vista.componentesInfoServidorConectado(true);
                    flagServidorConectado = true;
                    Vista.LabelDebajoBotonEnterDesconectarServidor.setVisible(true);
                }               
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Servidor no responde");            }
        }
        if (e.getSource()==Vista.LabelBotonEnterDesconectarServidor) {
            Vista.componentesInfoconexionAServidor(true);
            Vista.componentesInfoServidorConectado(false);
            Vista.LabelDebajoBotonEnterDesconectarServidor.setVisible(false);
        }
        
        //PANEL ARCHIVO
        if (e.getSource()==Vista.LabelImagenCarpeta && flagServidorConectado) {
            Vista.PanelPrincipal.setVisible(false);            
            Vista.configuracionPA();
            Vista.PanelArchivo.setVisible(true);
            Vista.PanelCamara.setVisible(false);
            Vista.PanelPerifericos.setVisible(false);
            Vista.PanelPuerta.setVisible(false);
            Vista.TxFArchivoPA.setText(Ruta);
            Vista.componentesInfoServidorConectado(true);
        }
        if(e.getSource()==Vista.LImagenExaminar){
            JFileChooser fileChoser = new JFileChooser();
            fileChoser.showOpenDialog(null);
            File archivoACapturar = fileChoser.getSelectedFile();
            String TituloArchivo = archivoACapturar.getAbsolutePath(); 
            Ruta = TituloArchivo;
            Vista.TxFArchivoPA.setText(Ruta);
        }        
        if (e.getSource()==Vista.LabelImagenEnter) {
            Cliente2 c = new Cliente2(Vista);
            try {
                c.conexionServidor(Ruta, "BotonEnviarArchivo");
                JOptionPane.showMessageDialog(null, "Archivo enviado");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //PANEL CAMARA
        if (e.getSource()==Vista.LabelImagenCamara && flagServidorConectado) {
            Vista.PanelPrincipal.setVisible(false);
            Vista.cofiguracionPanelPCA();
            Vista.PanelArchivo.setVisible(false);
            Vista.PanelCamara.setVisible(true);
            Vista.PanelPerifericos.setVisible(false);
            Vista.PanelPuerta.setVisible(false);
            Vista.componentesInfoServidorConectado(true);
        }
        if (e.getSource()==Vista.LabelImagenADCamara) {
            ClienteRecibirVideo c = new ClienteRecibirVideo(Vista);            
            c.start();
            Vista.LabelImagenADCamara.setVisible(false);
            Vista.LabelImagenDesactivarCamara.setVisible(true);
            Vista.LabelDescripcionActivarCamara.setVisible(false);
            Vista.LabelDescripcionDesactivarCamara.setVisible(true);
            Vista.bandera = true;
        }
        if (e.getSource()==Vista.LabelImagenDesactivarCamara) {
            Vista.LabelImagenADCamara.setVisible(true);
            Vista.LabelImagenDesactivarCamara.setVisible(false);
            Vista.LabelDescripcionActivarCamara.setVisible(true);
            Vista.LabelDescripcionDesactivarCamara.setVisible(false);
            Vista.bandera = false;
        }
        
        //PANEL PERIFERICOS
        if (e.getSource()==Vista.LabelImagenPerifericos && flagServidorConectado) {
            Vista.PanelPrincipal.setVisible(false);            
            Vista.configuracionPanelPerifericos();
            Vista.PanelArchivo.setVisible(false);
            Vista.PanelCamara.setVisible(false);
            Vista.PanelPerifericos.setVisible(true);
            Vista.PanelPuerta.setVisible(false);
            Vista.componentesInfoServidorConectado(true);
        }
        if (e.getSource()==Vista.LabelImagenChecarPerifericos) {
            Cliente2 c = new Cliente2(Vista);
            try {
                c.conexionServidor(Ruta, "BotonPerifericos");
                Vista.etiquetasPerifericosRespuesta(c.mensajeLlegadaPerifericos[0],c.mensajeLlegadaPerifericos[1],
                        c.mensajeLlegadaPerifericos[2],c.mensajeLlegadaPerifericos[3],c.mensajeLlegadaPerifericos[4]);  
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
                      
            
        }
        
        //PANEL PUERTA
        if (e.getSource()==Vista.LabelImagenPuerta && flagServidorConectado) {
            Vista.PanelPrincipal.setVisible(false);                       
            Vista.PanelArchivo.setVisible(false);
            Vista.PanelCamara.setVisible(false);
            Vista.PanelPerifericos.setVisible(false);            
            Vista.configuracionPanelPuerta();
            Vista.PanelPuerta.setVisible(true);
            Vista.componentesInfoServidorConectado(true);
        }
        if (e.getSource()==Vista.LabelImagenEnterPanelPuerta) {
            Cliente2 c = new Cliente2(Vista);
            try {
                c.conexionServidor(Ruta, "BotonCederAcceso");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        //PANEL PRINCIPAL
        if (e.getSource()==Vista.LabelImagenMover) {
            Vista.LabelImagenMover.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        }     
        if (e.getSource()==Vista.LabelImagenCarpeta) {
            Vista.tamanoImagenX = 100;
            Vista.tamanoImagenY = 100;
            Vista.factorRelativo = 10;
            Vista.imagenCarpetaPP();            
        }
        if (e.getSource()==Vista.LabelImagenCamara) {
            Vista.tamanoImagenX = 100;
            Vista.tamanoImagenY = 100;
            Vista.factorRelativo = 10;
            Vista.imagenCamaraPP();
        }
        if (e.getSource()==Vista.LabelImagenPerifericos) {
            Vista.tamanoImagenX = 100;
            Vista.tamanoImagenY = 100;
            Vista.factorRelativo = 10;
            Vista.imagenPerifericosPP();
        }
        if (e.getSource()==Vista.LabelImagenPuerta) {
            Vista.tamanoImagenX = 100;
            Vista.tamanoImagenY = 100;
            Vista.factorRelativo = 10;
            Vista.imagenPuertaPP();
        }
        if (e.getSource()==Vista.LabelBotonEnterInfoCS) {
            Vista.botonEnterConexionAServidor(10, 5);
        }
        if (e.getSource()==Vista.LabelBotonEnterDesconectarServidor) {
            Vista.botonEnterDesconectarServidor(10,5);
        }
        
        //PANEL ARCHIVO
        if (e.getSource()==Vista.LImagenExaminar) {
            Vista.imagenExaminarPA(10, 5);
        }
        if (e.getSource()==Vista.LabelImagenEnter) {
            Vista.imagenEnterPA(10,5);
        }
        
        //PANEL PERIFERICOS
        if (e.getSource()==Vista.LabelImagenChecarPerifericos) {
            Vista.imagenEnterPerifericos(10, 5);
        }        
        
        //PANEL PUERTA        
        if (e.getSource()==Vista.LabelImagenEnterPanelPuerta) {
            Vista.imagenEnterPanelPuerta(10, 5);
        }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource()==Vista.LabelImagenCarpeta) {
            Vista.tamanoImagenX = 80;
            Vista.tamanoImagenY = 80;
            Vista.factorRelativo = 0;
            Vista.imagenCarpetaPP();            
        }
        if (e.getSource()==Vista.LabelImagenCamara) {
            Vista.tamanoImagenX = 80;
            Vista.tamanoImagenY = 80;
            Vista.factorRelativo = 0;
            Vista.imagenCamaraPP();            
        }
        if (e.getSource()==Vista.LabelImagenPerifericos) {
            Vista.tamanoImagenX = 80;
            Vista.tamanoImagenY = 80;
            Vista.factorRelativo = 00;
            Vista.imagenPerifericosPP();
        }
        if (e.getSource()==Vista.LabelImagenPuerta) {
            Vista.tamanoImagenX = 80;
            Vista.tamanoImagenY = 80;
            Vista.factorRelativo = 0;
            Vista.imagenPuertaPP();
        }
        if (e.getSource()==Vista.LabelBotonEnterInfoCS) {
            Vista.botonEnterConexionAServidor(0, 0);
        }
        if (e.getSource()==Vista.LabelBotonEnterDesconectarServidor) {
            Vista.botonEnterDesconectarServidor(0,0);
            //Vista.LabelDebajoBotonEnterDesconectarServidor.setVisible(false);
            
        }
        
        //PANEL ARCHIVO
        if (e.getSource()==Vista.LImagenExaminar) {
            Vista.imagenExaminarPA(0, 0);
        }
        if (e.getSource()==Vista.LabelImagenEnter) {
            Vista.imagenEnterPA(0,0);
        }
        
        //PANEL PERIERICOS
        if (e.getSource()==Vista.LabelImagenChecarPerifericos) {
            Vista.imagenEnterPerifericos(0, 0);
        }
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
    
    private void oyentes(){       
        Vista.LabelImagenCerrar.addMouseListener(this);
        Vista.LabelImagenCerrar.addMouseMotionListener(this);
        
        Vista.LabelImagenMinimizar.addMouseListener(this);
        Vista.LabelImagenMinimizar.addMouseMotionListener(this);       
        
        Vista.LabelImagenMover.addMouseListener(this);
        Vista.LabelImagenMover.addMouseMotionListener(this);
        
        Vista.LabelImagenCarpeta.addMouseListener(this);
        Vista.LabelImagenCarpeta.addMouseMotionListener(this);
        
        Vista.LabelImagenCamara.addMouseListener(this);
        Vista.LabelImagenCamara.addMouseMotionListener(this);
        
        Vista.LabelImagenPerifericos.addMouseListener(this);
        Vista.LabelImagenPerifericos.addMouseMotionListener(this);
        
        Vista.LabelImagenPuerta.addMouseListener(this);
        Vista.LabelImagenPuerta.addMouseMotionListener(this);
        
        Vista.LabelImagenRegreso.addMouseListener(this);
        
        Vista.LabelImagenRegreso.addMouseListener(this);
        Vista.LabelImagenRegreso.addMouseMotionListener(this);
        
        Vista.LImagenExaminar.addMouseListener(this);
        Vista.LImagenExaminar.addMouseMotionListener(this);
        
        Vista.LabelImagenEnter.addMouseListener(this);
        Vista.LabelImagenEnter.addMouseMotionListener(this);
        
        Vista.LabelImagenChecarPerifericos.addMouseListener(this);
        Vista.LabelImagenChecarPerifericos.addMouseMotionListener(this);
        
        Vista.LabelImagenPuertaCerrada.addMouseListener(this);
        Vista.LabelImagenPuertaCerrada.addMouseMotionListener(this);
        
        Vista.LabelImagenEnterPanelPuerta.addMouseListener(this);
        Vista.LabelImagenEnterPanelPuerta.addMouseMotionListener(this);
        
        Vista.LabelImagenADCamara.addMouseListener(this);
        Vista.LabelImagenADCamara.addMouseMotionListener(this);
        
        Vista.LabelBotonEnterInfoCS.addMouseListener(this);
        Vista.LabelBotonEnterInfoCS.addMouseMotionListener(this);
        
        Vista.LabelBotonEnterDesconectarServidor.addMouseListener(this);
        Vista.LabelBotonEnterDesconectarServidor.addMouseMotionListener(this);
        
        Vista.LabelImagenDesactivarCamara.addMouseListener(this);
        Vista.LabelImagenDesactivarCamara.addMouseMotionListener(this);
    }
}
