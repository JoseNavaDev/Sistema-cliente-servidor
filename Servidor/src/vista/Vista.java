//SERVIDOR
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Vista extends JFrame{
    
    //PANEL
    private final JPanel PanelPrincipal = new JPanel();    
    
    //TAMAÑOS Y DISTANCIAS
    public int tamanoImagenX = 80, tamanoImagenY = 80;
    public int tamanoGeneralX = 700, tamanoGeneralY = 480;
    
    //IMAGEN CERRAR
    ImageIcon imagenCerrar = new ImageIcon(getClass().getResource("/imagenes/cruzNegra.png"));
    public JLabel LabelImagenCerrar = new JLabel();
    
    //IMAGEN MINIMIZAR
    ImageIcon imagenMinimizar = new ImageIcon(getClass().getResource("/imagenes/minimizar.png"));
    public JLabel LabelImagenMinimizar = new JLabel();   
    
    //IMAGEN MOVER
    ImageIcon imagenMover = new ImageIcon(getClass().getResource("/imagenes/mover.png"));
    public JLabel LabelImagenMover = new JLabel();
    
    //IMAGEN LINEA HORIZONTAL
    ImageIcon imagenLinea = new ImageIcon(getClass().getResource("/imagenes/linea.png"));
    private final JLabel LabelImagenLinea = new JLabel();
    
    //IMAGEN LINEA VERTICAL
    ImageIcon imagenLineaVertical = new ImageIcon(getClass().getResource("/imagenes/lineaVertical.png"));
    private final JLabel LabelImagenLineaVertical = new JLabel(); 
    
    public JLabel L_SituacionConexion = new JLabel();
    public JLabel L_SituacionConexion_2 = new JLabel();
    
    public JTextField TxfPuerto = new JTextField();
    JLabel L_puerto = new JLabel("Puerto:");
    
    //IMAGEN BOTON CONECTAR
    ImageIcon ImagenbotonActivarServidor = new ImageIcon(getClass().getResource("/imagenes/enter.jpg"));
    public JLabel BotonActivarServidor = new JLabel();
    
    ImageIcon ImagenbotonDesactivarServidor = new ImageIcon(getClass().getResource("/imagenes/enter.jpg"));
    public JLabel BotonDesactivarServidor = new JLabel();
    
    public JLabel L_ActivarServidor = new JLabel();
    
    public Vista(){
        configuracionVentana();
        configuracionPanel();
        configuracionComponentesServidor();
        servidorApagado();
        configuracionEtiquetasOnOff();       
        
        configuracionCamara();
        configuracionComponentesArchivo();
        configuracionComponentesPuertaCerrada(true);
    }

    private void configuracionVentana() {
        this.setUndecorated(true);
        this.setSize(tamanoGeneralX,tamanoGeneralY);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);       
    }
    
    private void configuracionPanel(){
        //PANEL
        PanelPrincipal.setLayout(null);
        PanelPrincipal.setBackground(Color.WHITE);
        PanelPrincipal.setSize(tamanoGeneralX,tamanoGeneralY);  
        this.getContentPane().add(PanelPrincipal);  
        
        //IMAGEN CERRAR
        LabelImagenCerrar.setSize(30,30);
        LabelImagenCerrar.setLocation(650,20);
        LabelImagenCerrar.setIcon(new ImageIcon(imagenCerrar.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH)));
        LabelImagenCerrar.setVisible(true);
        PanelPrincipal.add(LabelImagenCerrar);
        PanelPrincipal.updateUI();
        
        //IMAGEN MINIMIZAR 
        LabelImagenMinimizar.setSize(30,30);
        LabelImagenMinimizar.setLocation(600,20);
        LabelImagenMinimizar.setIcon(new ImageIcon(imagenMinimizar.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH)));
        LabelImagenMinimizar.setVisible(true);
        PanelPrincipal.add(LabelImagenMinimizar);
        PanelPrincipal.updateUI();   
        
        //IMAGEN MOVER 
        LabelImagenMover.setSize(40,40);
        LabelImagenMover.setLocation(13,13);
        LabelImagenMover.setIcon(new ImageIcon(imagenMover.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH)));
        LabelImagenMover.setVisible(true);
        PanelPrincipal.add(LabelImagenMover);
        PanelPrincipal.updateUI();      
        
        //IMAGEN LINEA HORIZONTAL
        LabelImagenLinea.setSize(700,5);
        LabelImagenLinea.setLocation(0,65);
        LabelImagenLinea.setIcon(new ImageIcon(imagenLinea.getImage().getScaledInstance(700,700, Image.SCALE_SMOOTH)));
        LabelImagenLinea.setVisible(true);
        PanelPrincipal.add(LabelImagenLinea);
        PanelPrincipal.updateUI();
        
        //IMAGEN LINEA VERTICAL
        LabelImagenLineaVertical.setSize(5,415);
        LabelImagenLineaVertical.setLocation(200,65);
        LabelImagenLineaVertical.setIcon(new ImageIcon(imagenLinea.getImage().getScaledInstance(700,700, Image.SCALE_SMOOTH)));
        LabelImagenLineaVertical.setVisible(true);
        PanelPrincipal.add(LabelImagenLineaVertical);
        PanelPrincipal.updateUI();
    }
            
    public void configuracionComponentesServidor(){        
        L_SituacionConexion.setSize(150,30);        
        L_SituacionConexion.setLocation(35,100);
        L_SituacionConexion.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 30));
        PanelPrincipal.add(L_SituacionConexion);
        PanelPrincipal.updateUI();
        
        L_SituacionConexion_2.setSize(180,30);        
        L_SituacionConexion_2.setLocation(30,150);
        L_SituacionConexion_2.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 30));
        PanelPrincipal.add(L_SituacionConexion_2);
        PanelPrincipal.updateUI();
        
        L_puerto.setSize(100,20);
        L_puerto.setLocation(30,250);
        L_puerto.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 20));
        PanelPrincipal.add(L_puerto);
        PanelPrincipal.updateUI();
        
        TxfPuerto.setSize(55,20);
        TxfPuerto.setLocation(115,251);        
        TxfPuerto.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 14));
        PanelPrincipal.add(TxfPuerto);
        PanelPrincipal.updateUI(); 
        
        L_ActivarServidor.setSize(200,30);
        L_ActivarServidor.setLocation(35,420);        
        L_ActivarServidor.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 18));
        PanelPrincipal.add(L_ActivarServidor);
        PanelPrincipal.updateUI();
    }
    
    public void servidorApagado(){
        L_SituacionConexion.setText("Servidor");
        L_SituacionConexion_2.setText("apagado");
        TxfPuerto.setText("5000");
        TxfPuerto.setEditable(true);
        L_ActivarServidor.setText("Activar servidor");
        botonConectarServidor(true);
        botonDesconectarServidor(false);
        PanelPrincipal.updateUI();
    }
    
    public void servidorEncendido(){
        L_SituacionConexion.setText("Servidor");
        L_SituacionConexion_2.setLocation(20,150);
        L_SituacionConexion_2.setText("encendido");
        TxfPuerto.setEditable(false);
        L_ActivarServidor.setText("Apagar servidor");
        botonDesconectarServidor(true);
        botonConectarServidor(false);
        PanelPrincipal.updateUI();
    }
    
    public void servidorConectado(){
        L_SituacionConexion.setText("Cliente");
        L_SituacionConexion_2.setText("conectado");
        TxfPuerto.setEditable(false);
        L_ActivarServidor.setLocation(15,420);
        L_ActivarServidor.setText("Desconectar cliente");
        botonDesconectarServidor(true);
        botonConectarServidor(false);
        PanelPrincipal.updateUI();
    }
    
    public void botonConectarServidor(boolean mostrar){
        BotonActivarServidor.setSize(80,80);
        BotonActivarServidor.setLocation(60,330);
        BotonActivarServidor.setIcon(new ImageIcon(ImagenbotonActivarServidor.getImage().
                                           getScaledInstance(80,80,Image.SCALE_SMOOTH)));
        BotonActivarServidor.setVisible(mostrar);
        PanelPrincipal.add(BotonActivarServidor);
        PanelPrincipal.updateUI();        
    }
    
    public void botonDesconectarServidor(boolean mostrar){
        BotonDesactivarServidor.setSize(80,80);
        BotonDesactivarServidor.setLocation(60,330);
        BotonDesactivarServidor.setIcon(new ImageIcon(ImagenbotonDesactivarServidor.getImage().
                                           getScaledInstance(80,80,Image.SCALE_SMOOTH)));
        BotonDesactivarServidor.setVisible(mostrar);
        PanelPrincipal.add(BotonDesactivarServidor);
        PanelPrincipal.updateUI();
    }
    
    


    //***************** COMPONENTES FUNCIONALES CLIENTE *****************************
    
    //ETIQUETAS
    private final JLabel LabelCamara = new JLabel("Cámara:");
    private final JLabel LabelCerradura = new JLabel("Cerradura:");
    private final JLabel LabelSensor = new JLabel("Sensor:");
    private final JLabel LabelAPI = new JLabel("API:");
    private final JLabel LabelMonitor = new JLabel("Monitor:");
    
    //IMAGENES BOTONES ON/OFF
    ImageIcon ImagenBotonON = new ImageIcon(getClass().getResource("/imagenes/ON.png"));
    ImageIcon ImagenBotonOFF = new ImageIcon(getClass().getResource("/imagenes/OFF.png"));
    
    //BOTONES ENCENDIDO PERIFERICOS
    public JLabel BotonCamaraON = new JLabel();
    public JLabel BotonCerraduraON = new JLabel();
    public JLabel BotonSensorON = new JLabel();
    public JLabel BotonAPION = new JLabel();
    public JLabel BotonMonitorON = new JLabel();
    
    //BOTONES APAGADO PERIFERICOS
    public JLabel BotonCamaraOFF = new JLabel();
    public JLabel BotonCerraduraOFF = new JLabel();
    public JLabel BotonSensorOFF = new JLabel();
    public JLabel BotonAPIOFF = new JLabel();
    public JLabel BotonMonitorOFF = new JLabel();
    
    public void configuracionEtiquetasOnOff(){
        LabelCamara.setSize(90,20);
        LabelCamara.setLocation(240,90);        
        LabelCamara.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 18));
        PanelPrincipal.add(LabelCamara);
        PanelPrincipal.updateUI();
        
        LabelCerradura.setSize(110,20);
        LabelCerradura.setLocation(220,127);        
        LabelCerradura.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 18));
        PanelPrincipal.add(LabelCerradura);
        PanelPrincipal.updateUI();
        
        LabelSensor.setSize(80,20);
        LabelSensor.setLocation(256,162);        
        LabelSensor.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 18));
        PanelPrincipal.add(LabelSensor);
        PanelPrincipal.updateUI();
        
        LabelAPI.setSize(80,20);
        LabelAPI.setLocation(285,198);        
        LabelAPI.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 16));
        PanelPrincipal.add(LabelAPI);
        PanelPrincipal.updateUI();
        
        LabelMonitor.setSize(80,20);
        LabelMonitor.setLocation(249,233);        
        LabelMonitor.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 16));
        PanelPrincipal.add(LabelMonitor);
        PanelPrincipal.updateUI();        
        
        botonCamaraOn(true);
        botonCerraduraON(true);
        botonSensorOn(true);
        botonAPIOn(true);
        botonMonitorOn(true);
    }
    
    //METODOS BOTONES ON
    
    public String Periferico_Camara;
    public String Periferico_Cerradura;
    public String Periferico_Sensor;
    public String Periferico_API;
    public String Periferico_Monitor;
    
    public void botonCamaraOn(boolean mostrar){        
        BotonCamaraON.setSize(50,25);
        BotonCamaraON.setLocation(330,88);
        BotonCamaraON.setIcon(new ImageIcon(ImagenBotonON.getImage().getScaledInstance(50,25,Image.SCALE_SMOOTH)));
        PanelPrincipal.add(BotonCamaraON);
        BotonCamaraON.setVisible(mostrar);
        Periferico_Camara = "Activado";
        PanelPrincipal.updateUI();        
    }
    
    public void botonCerraduraON(boolean mostrar){
        BotonCerraduraON.setSize(50,25);
        BotonCerraduraON.setLocation(330,125);
        BotonCerraduraON.setIcon(new ImageIcon(ImagenBotonON.getImage().getScaledInstance(50,25,Image.SCALE_SMOOTH)));
        PanelPrincipal.add(BotonCerraduraON);
        BotonCerraduraON.setVisible(mostrar);
        Periferico_Cerradura = "Activado";
        PanelPrincipal.updateUI();   
    }
    
    public void botonSensorOn(boolean mostrar){
        BotonSensorON.setSize(50,25);
        BotonSensorON.setLocation(330,160);
        BotonSensorON.setIcon(new ImageIcon(ImagenBotonON.getImage().getScaledInstance(50,25,Image.SCALE_SMOOTH)));
        PanelPrincipal.add(BotonSensorON);
        BotonSensorON.setVisible(mostrar);
        Periferico_Sensor = "Activado";
        PanelPrincipal.updateUI();  
    }
    
    public void botonAPIOn(boolean mostrar){
        BotonAPION.setSize(50,25);
        BotonAPION.setLocation(330,195);
        BotonAPION.setIcon(new ImageIcon(ImagenBotonON.getImage().getScaledInstance(50,25,Image.SCALE_SMOOTH)));
        PanelPrincipal.add(BotonAPION);
        BotonAPION.setVisible(mostrar);
        Periferico_API = "Activado";
        PanelPrincipal.updateUI(); 
    }
    
    public void botonMonitorOn(boolean mostrar){
        BotonMonitorON.setSize(50,25);
        BotonMonitorON.setLocation(330,230);
        BotonMonitorON.setIcon(new ImageIcon(ImagenBotonON.getImage().getScaledInstance(50,25,Image.SCALE_SMOOTH)));
        PanelPrincipal.add(BotonMonitorON);
        BotonMonitorON.setVisible(mostrar);
        Periferico_Monitor = "Activado";
        PanelPrincipal.updateUI();
    }
    
    
    
    //MÉTODOS BOTONES OFF
    public void botonCamaraOff(boolean mostrar){
        BotonCamaraOFF.setSize(50,25);
        BotonCamaraOFF.setLocation(330,88);
        BotonCamaraOFF.setIcon(new ImageIcon(ImagenBotonOFF.getImage().getScaledInstance(50,25,Image.SCALE_SMOOTH)));
        PanelPrincipal.add(BotonCamaraOFF);
        BotonCamaraOFF.setVisible(mostrar);
        Periferico_Camara = "Desactivado";
        PanelPrincipal.updateUI();
    }
    
    public void botonCerraduraOff(boolean mostrar){
        BotonCerraduraOFF.setSize(50,25);
        BotonCerraduraOFF.setLocation(330,125);
        BotonCerraduraOFF.setIcon(new ImageIcon(ImagenBotonOFF.getImage().getScaledInstance(50,25,Image.SCALE_SMOOTH)));
        PanelPrincipal.add(BotonCerraduraOFF);
        BotonCerraduraOFF.setVisible(mostrar);
        Periferico_Cerradura = "Desactivado";
        PanelPrincipal.updateUI();   
    }
    
    public void botonSensorOff(boolean mostrar){
        BotonSensorOFF.setSize(50,25);
        BotonSensorOFF.setLocation(330,160);
        BotonSensorOFF.setIcon(new ImageIcon(ImagenBotonOFF.getImage().getScaledInstance(50,25,Image.SCALE_SMOOTH)));
        PanelPrincipal.add(BotonSensorOFF);
        BotonSensorOFF.setVisible(mostrar);
        Periferico_Sensor = "Desactivado";
        PanelPrincipal.updateUI();  
    }
    
    public void botonAPIOff(boolean mostrar){
        BotonAPIOFF.setSize(50,25);
        BotonAPIOFF.setLocation(330,195);
        BotonAPIOFF.setIcon(new ImageIcon(ImagenBotonOFF.getImage().getScaledInstance(50,25,Image.SCALE_SMOOTH)));
        PanelPrincipal.add(BotonAPIOFF);
        BotonAPIOFF.setVisible(mostrar);
        Periferico_API = "Desactivado";
        PanelPrincipal.updateUI(); 
    }
    
    public void botonMonitorOff(boolean mostrar){
        BotonMonitorOFF.setSize(50,25);
        BotonMonitorOFF.setLocation(330,230);
        BotonMonitorOFF.setIcon(new ImageIcon(ImagenBotonOFF.getImage().getScaledInstance(50,25,Image.SCALE_SMOOTH)));
        PanelPrincipal.add(BotonMonitorOFF);
        BotonMonitorOFF.setVisible(mostrar);
        Periferico_Monitor = "Desactivado";
        PanelPrincipal.updateUI();
    }
    
    
    //************************ COMPONENTES CÁMARA *************************************
    
    //IMAGEN CAMARA
    ImageIcon ImagenCamara = new ImageIcon(getClass().getResource("/imagenes/(Camara) Imagen de Catinas en Pixabay .png"));    
    public JLabel LabelVideoCamara = new JLabel();    
    
    public void configuracionCamara(){
        LabelVideoCamara.setSize(180,180);
        LabelVideoCamara.setLocation(460,100);
        LabelVideoCamara.setIcon(new ImageIcon(ImagenCamara.getImage().getScaledInstance(180,180,Image.SCALE_SMOOTH)));
        PanelPrincipal.add(LabelVideoCamara);
        PanelPrincipal.updateUI();
    }
    
    
    
    //************************* COMPONENTES ARCHIVO ************************************
    
    public JLabel ArchivoRecibido = new JLabel();
    public JLabel DireccionArchivo = new JLabel();
    
    public void configuracionComponentesArchivo(){
        ArchivoRecibido.setSize(200,30);
        ArchivoRecibido.setLocation(240,350);
        ArchivoRecibido.setText("Esperando archivo");
        ArchivoRecibido.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 20));
        PanelPrincipal.add(ArchivoRecibido);
        PanelPrincipal.updateUI();
        
        DireccionArchivo.setSize(200,20);
        DireccionArchivo.setLocation(230,410);
        DireccionArchivo.setText("Dirección...");
        DireccionArchivo.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        PanelPrincipal.add(DireccionArchivo);        
        PanelPrincipal.updateUI();
    }
    
    
    //*********************** COMPONENTES PUERTA *******************************************
    
    //IMAGEN PUERTA ABIERTA
    ImageIcon ImagenPuertaAbierta = new ImageIcon(getClass().getResource("/imagenes/(Puerta) imagen de kmicican en Pixabay .png"));    
    public JLabel LabelPuertaAbierta = new JLabel();   
    
    //IMAGEN PUERTA CERRADA
    ImageIcon ImagenPuertaCerrada = new ImageIcon(getClass().getResource("/imagenes/puertaCerrada.png"));    
    public JLabel LabelPuertaCerrada = new JLabel();
    
    public void configuracionComponentesPuertaAbierta(boolean mostrar){
        LabelPuertaAbierta.setSize(150,150);
        LabelPuertaAbierta.setLocation(480,320);
        LabelPuertaAbierta.setIcon(new ImageIcon(ImagenPuertaAbierta.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH)));
        LabelPuertaAbierta.setVisible(mostrar);
        PanelPrincipal.add(LabelPuertaAbierta);
        PanelPrincipal.updateUI();
    }
    
    public void configuracionComponentesPuertaCerrada(boolean mostrar){
        LabelPuertaCerrada.setSize(150,150);
        LabelPuertaCerrada.setLocation(480,310);
        LabelPuertaCerrada.setIcon(new ImageIcon(ImagenPuertaCerrada.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH)));
        LabelPuertaCerrada.setVisible(mostrar);
        PanelPrincipal.add(LabelPuertaCerrada);
        PanelPrincipal.updateUI();        
    }
    
}
