package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class Vista extends JFrame{    
    //PANEL
    public JPanel PanelPrincipal = new JPanel();    
    
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
    public JLabel LabelImagenLinea = new JLabel();
    
    //IMAGEN LINEA VERTICAL
    ImageIcon imagenLineaVertical = new ImageIcon(getClass().getResource("/imagenes/lineaVertical.png"));
    public JLabel LabelImagenLineaVertical = new JLabel();
    
    //IMAGEN CARPETA
    ImageIcon imagenCarpeta = new ImageIcon(getClass().getResource("/imagenes/Carpeta.png"));
    public JLabel LabelImagenCarpeta = new JLabel();
    
    //IMAGEN CAMARA
    ImageIcon imagenCamara = new ImageIcon(getClass().getResource("/imagenes/(Camara) Imagen de Catinas en Pixabay .png"));
    public JLabel LabelImagenCamara = new JLabel();
    
    //IMAGEN PERIFERICOS
    ImageIcon imagenPerifericos = new ImageIcon(getClass().getResource("/imagenes/(Perifericos) Imagen de Clker-Free-Vector-Images en Pixabay .png"));
    public JLabel LabelImagenPerifericos = new JLabel();
    
    //IMAGEN PUERTA
    ImageIcon imagenPuerta = new ImageIcon(getClass().getResource("/imagenes/(Puerta) imagen de kmicican en Pixabay .png"));
    public JLabel LabelImagenPuerta = new JLabel();
    
    //IMAGEN ON
    ImageIcon imagenON = new ImageIcon(getClass().getResource("/imagenes/ON.png"));
    JLabel LabelImagenON = new JLabel();
    
    //IMAGEN OFF
    ImageIcon imagenOFF = new ImageIcon(getClass().getResource("/imagenes/OFF.png"));
    JLabel LabelImagenOFF = new JLabel();
    
    public boolean bandera;
    
    //ETIQUETAS
    public JLabel LArchivo = new JLabel();
    public JLabel LCamara = new JLabel();
    public JLabel LPerifericos = new JLabel();
    public JLabel LPuerta = new JLabel();    
    private final JLabel LUdeG = new JLabel();
    
    //COMPONENTES INFORMACION CLIENTE/SERVIDOR
    public JLabel LabelInformacionCSDireccionIP_1 = new JLabel(); 
    public JLabel LabelInformacionCSDireccionIP_2 = new JLabel();
    public JLabel LabelInformacionCSDireccionIP_3 = new JLabel();
    public JLabel LabelBotonEnterInfoCS = new JLabel();
    public JLabel LabelInformacionCS_EstadoServidor = new JLabel();
    
    public JTextField TxfIP = new JTextField();
    public JTextField TxfPuerto = new JTextField();
    JLabel L_IP = new JLabel("IP:");
    JLabel L_puerto = new JLabel("Puerto:");
    
    public JLabel LabelBotonEnterDesconectarServidor = new JLabel();
    public JLabel LabelDebajoBotonEnterDesconectarServidor = new JLabel("Desconectarse");
    
    //FUENTES
    Font letraEtiquetas = new Font("Bauhaus 93", Font.CENTER_BASELINE, 20);
    
    //TAMAÑOS Y DISTANCIAS
    public int tamanoImagenX = 80, tamanoImagenY = 80;
    public int tamanoGeneralX = 700, tamanoGeneralY = 480;
    int desplazo = 200;
    
    public int factorRelativo;
    
    public Vista(){
        configuracionVentana(); 
        imagenCarpetaPP();
        imagenCamaraPP();
        imagenPerifericosPP();
        imagenPuertaPP();
    }
    
    public void configuracionVentana(){
        //VENTANA PRINCIPAL
        this.setUndecorated(true);
        this.setSize(tamanoGeneralX,tamanoGeneralY);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    //****************   PANEL PRINCIPAL   ***************************
    
    public JLabel LabelServidorConectadoA_1 = new JLabel();
    public JLabel LabelServidorConectadoA_2 = new JLabel();
    public JLabel LabelServidorConectadoA_3 = new JLabel();
    
    public void componentesVentanas(JPanel Panel){
        //IMAGEN CERRAR
        LabelImagenCerrar.setSize(30,30);
        LabelImagenCerrar.setLocation(450+desplazo,20);
        LabelImagenCerrar.setIcon(new ImageIcon(imagenCerrar.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH)));
        LabelImagenCerrar.setVisible(true);
        Panel.add(LabelImagenCerrar);
        Panel.updateUI();
        
        //IMAGEN MINIMIZAR 
        LabelImagenMinimizar.setSize(30,30);
        LabelImagenMinimizar.setLocation(400+desplazo,20);
        LabelImagenMinimizar.setIcon(new ImageIcon(imagenMinimizar.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH)));
        LabelImagenMinimizar.setVisible(true);
        Panel.add(LabelImagenMinimizar);
        Panel.updateUI();   
        
        //IMAGEN MOVER 
        LabelImagenMover.setSize(40,40);
        LabelImagenMover.setLocation(13,13);
        LabelImagenMover.setIcon(new ImageIcon(imagenMover.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH)));
        LabelImagenMover.setVisible(true);
        Panel.add(LabelImagenMover);
        Panel.updateUI();      
        
        //IMAGEN LINEA HORIZONTAL
        LabelImagenLinea.setSize(700,5);
        LabelImagenLinea.setLocation(0,65);
        LabelImagenLinea.setIcon(new ImageIcon(imagenLinea.getImage().getScaledInstance(700,700, Image.SCALE_SMOOTH)));
        LabelImagenLinea.setVisible(true);
        Panel.add(LabelImagenLinea);
        Panel.updateUI();
        
        //IMAGEN LINEA VERTICAL
        LabelImagenLineaVertical.setSize(5,415);
        LabelImagenLineaVertical.setLocation(200,65);
        LabelImagenLineaVertical.setIcon(new ImageIcon(imagenLinea.getImage().getScaledInstance(700,700, Image.SCALE_SMOOTH)));
        LabelImagenLineaVertical.setVisible(true);
        Panel.add(LabelImagenLineaVertical);
        Panel.updateUI();
    }
    
    public void configuracionPP(){       
        //PANEL
        PanelPrincipal.setLayout(null);
        PanelPrincipal.setBackground(Color.WHITE);
        PanelPrincipal.setSize(tamanoGeneralX,tamanoGeneralY);  
        this.getContentPane().add(PanelPrincipal);              
        
        //ETIQUETA ARCHIVO
        LArchivo.setSize(150,20);
        LArchivo.setLocation(60+desplazo,205);
        LArchivo.setText("Enviar archivo");
        LArchivo.setFont(letraEtiquetas);
        PanelPrincipal.add(LArchivo);
        PanelPrincipal.updateUI();
        
        //ETIQUETA CAMARA
        LCamara.setSize(150,20);
        LCamara.setLocation(335+desplazo,175+30);
        LCamara.setText("Cámara");
        LCamara.setFont(letraEtiquetas);
        PanelPrincipal.add(LCamara);
        PanelPrincipal.updateUI();
        
        //ETIQUETA PERIFERICOS
        LPerifericos.setSize(150,20);
        LPerifericos.setLocation(75+desplazo,380);
        LPerifericos.setText("Periféricos");
        LPerifericos.setFont(letraEtiquetas);
        PanelPrincipal.add(LPerifericos);
        PanelPrincipal.updateUI();
                
        //ETIQUETA PUERTA
        LPuerta.setSize(150,20);
        LPuerta.setLocation(343+desplazo,380);
        LPuerta.setText("Puerta");
        LPuerta.setFont(letraEtiquetas);
        PanelPrincipal.add(LPuerta);
        PanelPrincipal.updateUI();
               
        //ETIQUETA UdeG
        LUdeG.setSize(480,20);
        LUdeG.setLocation(10+desplazo,420+30);
        LUdeG.setText("Imágenes de Catinas(Cámara), OpenClipart-Vectors(Carpeta), Clker-Free-Vector-Images(Periféricos) y kmician(Puerta) en Pixabay.com");
        LUdeG.setFont(new Font("Verdana", Font.PLAIN, 7));
        PanelPrincipal.add(LUdeG);
        PanelPrincipal.updateUI(); 
               
        componentesVentanas(PanelPrincipal);
        componentesInfoconexionAServidor(true);
    }
    
    public void componentesInfoconexionAServidor(boolean mostrar){
        //ETIQUETA INFORMACION CLIENTE/SERVIDOR
        LabelInformacionCSDireccionIP_1.setSize(160,30);
        LabelInformacionCSDireccionIP_1.setLocation(20,100);
        LabelInformacionCSDireccionIP_1.setText("Ingrese los");
        LabelInformacionCSDireccionIP_1.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 28));
        PanelPrincipal.add(LabelInformacionCSDireccionIP_1);
        LabelInformacionCSDireccionIP_1.setVisible(mostrar);
        PanelPrincipal.updateUI();
        
        LabelInformacionCSDireccionIP_2.setSize(140,30);
        LabelInformacionCSDireccionIP_2.setLocation(35,145);
        LabelInformacionCSDireccionIP_2.setText("datos del");
        LabelInformacionCSDireccionIP_2.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 28));
        PanelPrincipal.add(LabelInformacionCSDireccionIP_2);
        LabelInformacionCSDireccionIP_2.setVisible(mostrar);
        PanelPrincipal.updateUI();
        
        LabelInformacionCSDireccionIP_3.setSize(140,30);
        LabelInformacionCSDireccionIP_3.setLocation(45,190);
        LabelInformacionCSDireccionIP_3.setText("servidor");
        LabelInformacionCSDireccionIP_3.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 28));
        PanelPrincipal.add(LabelInformacionCSDireccionIP_3);
        LabelInformacionCSDireccionIP_3.setVisible(mostrar);
        PanelPrincipal.updateUI();
        
        //TEXTFIELD IP
        TxfIP.setSize(100,20);
        TxfIP.setLocation(90,250);
        TxfIP.setText("localhost");
        PanelPrincipal.add(TxfIP);
        PanelPrincipal.updateUI();
        TxfIP.setVisible(mostrar);
        
        //ETIQUETA IP        
        L_IP.setSize(30,20);
        L_IP.setLocation(52,249);
        L_IP.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 20));
        PanelPrincipal.add(L_IP);
        L_IP.setVisible(mostrar);
        
        //TEXTFIELD PUERTO        
        TxfPuerto.setSize(100,20);
        TxfPuerto.setLocation(90,280);
        TxfPuerto.setText("5000");
        PanelPrincipal.add(TxfPuerto);
        PanelPrincipal.updateUI();
        TxfPuerto.setVisible(mostrar);
        
        //ETIQUETA PUERTO        
        L_puerto.setSize(90,20);
        L_puerto.setLocation(10,279);
        L_puerto.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 20));
        PanelPrincipal.add(L_puerto);
        L_puerto.setVisible(mostrar);                
        
        botonEnterConexionAServidor(0,0); 
        LabelBotonEnterInfoCS.setVisible(mostrar);
        
        //ETIQUETA CONECTAR
        LabelInformacionCS_EstadoServidor.setSize(100,30);
        LabelInformacionCS_EstadoServidor.setLocation(50,410);
        LabelInformacionCS_EstadoServidor.setText("Conectar");
        LabelInformacionCS_EstadoServidor.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 22));
        PanelPrincipal.add(LabelInformacionCS_EstadoServidor);
        LabelInformacionCS_EstadoServidor.setVisible(mostrar);
        PanelPrincipal.updateUI();             
    }   
    
    public void componentesInfoServidorConectado(boolean mostrar){
        LabelServidorConectadoA_1.setText("Cliente");
        LabelServidorConectadoA_1.setSize(140,30);
        LabelServidorConectadoA_1.setLocation(40,100);
        LabelServidorConectadoA_1.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 28));
        PanelPrincipal.add(LabelServidorConectadoA_1);
        LabelServidorConectadoA_1.setVisible(mostrar);
        PanelPrincipal.updateUI();
        
        LabelServidorConectadoA_2.setText("conectado");
        LabelServidorConectadoA_2.setSize(180,30);
        LabelServidorConectadoA_2.setLocation(20,140);
        LabelServidorConectadoA_2.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 28));
        PanelPrincipal.add(LabelServidorConectadoA_2);
        LabelServidorConectadoA_2.setVisible(mostrar);
        PanelPrincipal.updateUI();
                
        LabelServidorConectadoA_3.setText("a servidor");
        LabelServidorConectadoA_3.setSize(160,30);
        LabelServidorConectadoA_3.setLocation(25,180);
        LabelServidorConectadoA_3.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 28));
        PanelPrincipal.add(LabelServidorConectadoA_3);
        LabelServidorConectadoA_3.setVisible(mostrar);
        PanelPrincipal.updateUI();
        
        L_IP.setVisible(true);
        L_puerto.setVisible(true);
        PanelPrincipal.add(L_IP);
        PanelPrincipal.add(L_puerto);
        
        TxfIP.setVisible(true);
        TxfIP.setEditable(false);
        TxfIP.setForeground(Color.blue);
        PanelPrincipal.add(TxfIP);
        
        TxfPuerto.setVisible(true);
        TxfPuerto.setEditable(false);
        TxfPuerto.setForeground(Color.blue);
        PanelPrincipal.add(TxfPuerto);        
        botonEnterDesconectarServidor(0, 0);
                
    }
    
    public void botonEnterConexionAServidor(int x, int fR){
        LabelBotonEnterInfoCS.setSize(tamanoImagenX+x,tamanoImagenY+x);
        LabelBotonEnterInfoCS.setLocation(60-fR,320-fR);
        LabelBotonEnterInfoCS.setIcon(new ImageIcon(imagenEnter.getImage().getScaledInstance(tamanoImagenX+x,tamanoImagenY+x, Image.SCALE_SMOOTH)));
        PanelPrincipal.add(LabelBotonEnterInfoCS);
        PanelPrincipal.updateUI();        
    }
    
    public void botonEnterDesconectarServidor(int x, int fR){        
        LabelBotonEnterDesconectarServidor.setSize(tamanoImagenX+x,tamanoImagenY+x);
        LabelBotonEnterDesconectarServidor.setLocation(60-fR,320-fR);
        LabelBotonEnterDesconectarServidor.setIcon(new ImageIcon(imagenEnter.getImage().getScaledInstance(tamanoImagenX+x,tamanoImagenY+x, Image.SCALE_SMOOTH)));
        PanelPrincipal.add(LabelBotonEnterDesconectarServidor);
        PanelPrincipal.updateUI();               
        
        LabelDebajoBotonEnterDesconectarServidor.setSize(150,30);
        LabelDebajoBotonEnterDesconectarServidor.setLocation(25,410);
        LabelDebajoBotonEnterDesconectarServidor.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 20));
        PanelPrincipal.add(LabelDebajoBotonEnterDesconectarServidor);
        PanelPrincipal.updateUI();
        
    }
    
    public void imagenCarpetaPP(){        
        LabelImagenCarpeta.setSize(tamanoImagenX,tamanoImagenY);
        LabelImagenCarpeta.setLocation(85-factorRelativo+desplazo,110-factorRelativo);
        LabelImagenCarpeta.setIcon(new ImageIcon(imagenCarpeta.getImage().getScaledInstance(tamanoImagenX,tamanoImagenY, Image.SCALE_SMOOTH)));
        LabelImagenCarpeta.setVisible(true);
        PanelPrincipal.add(LabelImagenCarpeta);
        PanelPrincipal.updateUI();        
    }
    
    public void imagenCamaraPP(){
        LabelImagenCamara.setSize(tamanoImagenX,tamanoImagenY);
        LabelImagenCamara.setLocation(335-factorRelativo+desplazo,110-factorRelativo);
        LabelImagenCamara.setIcon(new ImageIcon(imagenCamara.getImage().getScaledInstance(tamanoImagenX,tamanoImagenY, Image.SCALE_SMOOTH)));
        LabelImagenCamara.setVisible(true);
        PanelPrincipal.add(LabelImagenCamara);
        PanelPrincipal.updateUI();        
    }
    
    public void imagenPerifericosPP(){
        LabelImagenPerifericos.setSize(tamanoImagenX,tamanoImagenY);
        LabelImagenPerifericos.setLocation(85-factorRelativo+desplazo,280-factorRelativo);
        LabelImagenPerifericos.setIcon(new ImageIcon(imagenPerifericos.getImage().getScaledInstance(tamanoImagenX,tamanoImagenY, Image.SCALE_SMOOTH)));
        LabelImagenPerifericos.setVisible(true);
        PanelPrincipal.add(LabelImagenPerifericos);
        PanelPrincipal.updateUI();
    }
    
    public void imagenPuertaPP(){
        LabelImagenPuerta.setSize(tamanoImagenX,tamanoImagenY);
        LabelImagenPuerta.setLocation(335-factorRelativo+desplazo,280-factorRelativo);
        LabelImagenPuerta.setIcon(new ImageIcon(imagenPuerta.getImage().getScaledInstance(tamanoImagenX,tamanoImagenY, Image.SCALE_SMOOTH)));
        LabelImagenPuerta.setVisible(true);
        PanelPrincipal.add(LabelImagenPuerta);
        PanelPrincipal.updateUI();
    }
    
    
    //****************   PANEL ARCHIVO   ***************************
    
    //PANEL ARCHIVO
    public JPanel PanelArchivo = new JPanel();
    
    //ETIQUETAS
    public JLabel LArchivoPA = new JLabel();
    public JLabel LImagenExaminar = new JLabel();
    
    //TEXTAREA
    public JTextField TxFArchivoPA = new JTextField();
    
    //IMAGEN ENTER
    ImageIcon imagenEnter = new ImageIcon(getClass().getResource("/imagenes/enter.jpg"));
    public JLabel LabelImagenEnter = new JLabel();
    
    //IMAGEN REGRESO
    ImageIcon imagenRegreso = new ImageIcon(getClass().getResource("/imagenes/return.png"));
    public JLabel LabelImagenRegreso = new JLabel();
    
    
    public void configuracionPA(){
        //PANEL ARCHIVO
        PanelArchivo.setLayout(null);
        PanelArchivo.setBackground(Color.WHITE);
        PanelArchivo.setSize(tamanoGeneralX,tamanoGeneralY);
        this.getContentPane().add(PanelArchivo);
        PanelArchivo.setVisible(false);
                
        //ETIQUETA ENVIAR ARCHIVO
        LArchivoPA.setSize(300,30);
        LArchivoPA.setLocation(100+desplazo,140);
        LArchivoPA.setText("Archivo a enviar:");
        LArchivoPA.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 35));
        PanelArchivo.add(LArchivoPA);
        
        //TEXTAREA ARCHIVO
        TxFArchivoPA.setSize(300,20);
        TxFArchivoPA.setLocation(95+desplazo,250);
        PanelArchivo.add(TxFArchivoPA);
                
        componentesVentanas(PanelArchivo);
        imagenExaminarPA(0,0);
        imagenEnterPA(0,0);
        imagenRegreso(PanelArchivo);
        
    }
    
    public void imagenExaminarPA(int x, int fR){
        LImagenExaminar.setSize(20+x,20+x);
        LImagenExaminar.setLocation(403-fR+desplazo,250-fR);
        LImagenExaminar.setIcon(new ImageIcon(imagenMinimizar.getImage().getScaledInstance(20+x,20+x, Image.SCALE_SMOOTH)));
        //LImagenExaminar.setVisible(true);
        PanelArchivo.add(LImagenExaminar);
        PanelArchivo.updateUI();        
    }
    
    public void imagenEnterPA(int x, int fR){
        LabelImagenEnter.setSize(100+x,100+x);
        LabelImagenEnter.setLocation(200-fR+desplazo,330-fR);
        LabelImagenEnter.setIcon(new ImageIcon(imagenEnter.getImage().getScaledInstance(100+x,100+x, Image.SCALE_SMOOTH)));
        LabelImagenEnter.setVisible(true);
        PanelArchivo.add(LabelImagenEnter);
        PanelArchivo.updateUI();
    }
    
    public void imagenRegreso(JPanel Panel){
        LabelImagenRegreso.setSize(30,30);
        LabelImagenRegreso.setLocation(350+desplazo,20);
        LabelImagenRegreso.setIcon(new ImageIcon(imagenRegreso.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH)));
        LabelImagenRegreso.setVisible(true);
        Panel.add(LabelImagenRegreso);
        Panel.updateUI();        
    }
    
    
    //****************   PANEL CÁMARA   ***************************
    
    //PANEL CÁMARA
    public JPanel PanelCamara = new JPanel();
    
    //ETIQUETA DESCRIPCIÓN CAMARA
    public JLabel LabelDescripcionCamara = new JLabel();
    
    //ETIQUETA VIDEO CAMARA
    public JLabel LabelVideoCamara = new JLabel();
    
    //ETIQUETA ACTIVAR/DESACTIVAR CAMARA
    public JLabel LabelImagenADCamara = new JLabel();
    public JLabel LabelImagenDesactivarCamara = new JLabel();
    
    //ETIQUETA DESCRIPCION ACTIVAR CAMARA
    public JLabel LabelDescripcionActivarCamara = new JLabel();
    
    //ETIQUETA DESCRIPCION DESACTIVA CAMARA
    public JLabel LabelDescripcionDesactivarCamara = new JLabel();
    
    
    public void cofiguracionPanelPCA(){
        //PANEL CAMARA
        PanelCamara.setLayout(null);
        PanelCamara.setBackground(Color.WHITE);
        PanelCamara.setSize(tamanoGeneralX,tamanoGeneralY);
        this.getContentPane().add(PanelCamara);
        PanelCamara.setVisible(false);
        PanelCamara.updateUI();
        
        //ETIQUETA DESCRIPCIÓN CÁMARA
        LabelDescripcionCamara.setSize(400,30);
        LabelDescripcionCamara.setLocation(60+desplazo,90);
        LabelDescripcionCamara.setText("Cámara Raspberry Pi");
        LabelDescripcionCamara.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 35));
        PanelCamara.add(LabelDescripcionCamara); 
        PanelCamara.updateUI();
        
        //ETIQUETA SIMULACION CÁMARA
        LabelVideoCamara.setSize(180,180);
        LabelVideoCamara.setLocation(160+desplazo,150);
        //LabelVideoCamara.setIcon(new ImageIcon(imagenCamara.getImage().getScaledInstance(180,180, Image.SCALE_SMOOTH)));
        LabelVideoCamara.setVisible(true);
        PanelCamara.add(LabelVideoCamara);
        PanelCamara.updateUI();
        
        //IMAGEN ACTIVAR CAMARA
        LabelImagenADCamara.setSize(50,50);
        LabelImagenADCamara.setLocation(225+desplazo,365);
        LabelImagenADCamara.setIcon(new ImageIcon(imagenCamara.getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH)));
        LabelImagenADCamara.setVisible(true);
        PanelCamara.add(LabelImagenADCamara);
        PanelCamara.updateUI();
        
        //IMAGEN DESACTIVAR CAMARA
        LabelImagenDesactivarCamara.setSize(50,50);
        LabelImagenDesactivarCamara.setLocation(225+desplazo,365);
        LabelImagenDesactivarCamara.setIcon(new ImageIcon(imagenCamara.getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH)));
        LabelImagenDesactivarCamara.setVisible(false);
        PanelCamara.add(LabelImagenDesactivarCamara);
        PanelCamara.updateUI();
        
        //ETIQUETA DESCRIPCION ACTIVAR CAMARA
        LabelDescripcionActivarCamara.setSize(200,25);
        LabelDescripcionActivarCamara.setLocation(175+desplazo,425); 
        LabelDescripcionActivarCamara.setText("Activar cámara");
        LabelDescripcionActivarCamara.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 20));
        LabelDescripcionActivarCamara.setVisible(true);
        PanelCamara.add(LabelDescripcionActivarCamara);
        PanelCamara.updateUI();
        
        LabelDescripcionDesactivarCamara.setSize(200,25);
        LabelDescripcionDesactivarCamara.setLocation(155+desplazo,425);
        LabelDescripcionDesactivarCamara.setText("Desactivar cámara");
        LabelDescripcionDesactivarCamara.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 20));
        LabelDescripcionDesactivarCamara.setVisible(false);
        PanelCamara.add(LabelDescripcionDesactivarCamara);
        PanelCamara.updateUI();
        
        componentesVentanas(PanelCamara);
        imagenRegreso(PanelCamara);
        
    }
       
    //****************   PANEL PERIFÉRICOS   ***************************
    
    //PANEL
    public JPanel PanelPerifericos = new JPanel();
    
    //ETIQUETA DESCRICIÓN PERIFÉRICOS
    private final JLabel LabelDescripcionPerifericos = new JLabel();
    
    //ETIQUETAS PERIFERICOS
    private final JLabel LabelPerifericoCamara = new JLabel("Cámara");
    private final JLabel LabelPerifericoCerradura = new JLabel("Cerradura");
    private final JLabel LabelPerifericoSensor = new JLabel("Sensor");
    private final JLabel LabelPerifericoAPI = new JLabel("API");
    private final JLabel LabelPerifericoMonitor = new JLabel("Monitor");
    
    //ETIQUETAS PERIFERICOS RESPUESTA    
    public JLabel LabelPerifericoCamaraRespuesta = new JLabel();
    public JLabel LabelPerifericoCerraduraRespuesta = new JLabel();
    public JLabel LabelPerifericoSensorRespuesta = new JLabel();
    public JLabel LabelPerifericoAPIRespuesta = new JLabel();
    public JLabel LabelPerifericoMonitorRespuesta = new JLabel();
    
    //ETIQUETA IMAGEN CHECAR PERIFERICOS Y DESCRIPCIÒN
    public JLabel LabelImagenChecarPerifericos = new JLabel();
    private final JLabel LabelChecarPerifericos = new JLabel("Checar Periféricos");
        
    
    public void configuracionPanelPerifericos(){        
        int posicionX = 140, posicionY = 165, factor = 30 ;
        
        //PANEL PERIFÉRICOS
        PanelPerifericos.setLayout(null);
        PanelPerifericos.setBackground(Color.WHITE);
        PanelPerifericos.setSize(tamanoGeneralX,tamanoGeneralY);
        this.getContentPane().add(PanelPerifericos);
        PanelPerifericos.setVisible(false);
        PanelPerifericos.updateUI();
        
        //ETIQUETA DESCRIPCIÓN PERIFERICOS
        LabelDescripcionPerifericos.setSize(200,30);
        LabelDescripcionPerifericos.setLocation(150+desplazo,100);
        LabelDescripcionPerifericos.setText("Periféricos");
        LabelDescripcionPerifericos.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 35));
        PanelPerifericos.add(LabelDescripcionPerifericos); 
        PanelPerifericos.updateUI();
        
        //ETIQUETAS PERIFERICOS CAMARA
        LabelPerifericoCamara.setSize(120,25);
        LabelPerifericoCamara.setLocation(posicionX+desplazo,posicionY+(factor*0)); 
        LabelPerifericoCamara.setText("Cámara");
        LabelPerifericoCamara.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 20));
        LabelPerifericoCamara.setVisible(true);
        PanelPerifericos.add(LabelPerifericoCamara);
        PanelPerifericos.updateUI();
        
        //ETIQUETAS PERIFERICOS CERRADURA
        LabelPerifericoCerradura.setSize(120,25);
        LabelPerifericoCerradura.setLocation(posicionX+desplazo,posicionY+(factor*1)); 
        LabelPerifericoCerradura.setText("Cerradura");
        LabelPerifericoCerradura.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 20));
        LabelPerifericoCerradura.setVisible(true);
        PanelPerifericos.add(LabelPerifericoCerradura);
        PanelPerifericos.updateUI();
        
        //ETIQUETAS PERIFERICOS SENSOR
        LabelPerifericoSensor.setSize(120,25);
        LabelPerifericoSensor.setLocation(posicionX+desplazo,posicionY+(factor*2)); 
        LabelPerifericoSensor.setText("Sensor");
        LabelPerifericoSensor.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 20));
        LabelPerifericoSensor.setVisible(true);
        PanelPerifericos.add(LabelPerifericoSensor);
        PanelPerifericos.updateUI();
        
        //ETIQUETAS PERIFERICOS API
        LabelPerifericoAPI.setSize(120,25);
        LabelPerifericoAPI.setLocation(posicionX+desplazo,posicionY+(factor*3)); 
        LabelPerifericoAPI.setText("Sensor");
        LabelPerifericoAPI.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 20));
        LabelPerifericoAPI.setVisible(true);
        PanelPerifericos.add(LabelPerifericoAPI);
        PanelPerifericos.updateUI();
        
        //ETIQUETAS PERIFERICOS MONITOR
        LabelPerifericoMonitor.setSize(120,25);
        LabelPerifericoMonitor.setLocation(posicionX+desplazo,posicionY+(factor*4)); 
        LabelPerifericoMonitor.setText("Monitor");
        LabelPerifericoMonitor.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 20));
        LabelPerifericoMonitor.setVisible(true);
        PanelPerifericos.add(LabelPerifericoMonitor);
        PanelPerifericos.updateUI();
                
        componentesVentanas(PanelPerifericos);
        imagenRegreso(PanelPerifericos);
        imagenEnterPerifericos(0,0);
        
    }
    
    public void etiquetasPerifericosRespuesta(String Camara, String Cerradura, String Sensor, String Api, String Monitor){
        int posicionX = 270, posicionY = 165, factor = 30 ;
        
        //ETIQUETAS PERIFERICOS CAMARA RESPUESTA
        LabelPerifericoCamaraRespuesta.setSize(120,25);
        LabelPerifericoCamaraRespuesta.setLocation(posicionX+desplazo,posicionY+(factor*0));        
        LabelPerifericoCamaraRespuesta.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 20));
        if (Camara.equals("Activado")) {
            LabelPerifericoCamaraRespuesta.setText("Encendida");
            LabelPerifericoCamaraRespuesta.setForeground(Color.BLUE);
        } else {
            LabelPerifericoCamaraRespuesta.setText("Apagada");
            LabelPerifericoCamaraRespuesta.setForeground(Color.RED);
        }
        LabelPerifericoCamaraRespuesta.setVisible(true);
        PanelPerifericos.add(LabelPerifericoCamaraRespuesta);
        PanelPerifericos.updateUI();
        
        
        
        //ETIQUETAS PERIFERICOS CERRADURA RESPUESTA
        LabelPerifericoCerraduraRespuesta.setSize(120,25);
        LabelPerifericoCerraduraRespuesta.setLocation(posicionX+desplazo,posicionY+(factor*1));         
        LabelPerifericoCerraduraRespuesta.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 20));
        if (Cerradura.equals("Activado")) {
            LabelPerifericoCerraduraRespuesta.setText("Encendida");
            LabelPerifericoCerraduraRespuesta.setForeground(Color.BLUE);
        } else {
            LabelPerifericoCerraduraRespuesta.setText("Apagada");
            LabelPerifericoCerraduraRespuesta.setForeground(Color.RED);
        }
        LabelPerifericoCerraduraRespuesta.setVisible(true);
        PanelPerifericos.add(LabelPerifericoCerraduraRespuesta);
        PanelPerifericos.updateUI();
        
        
        
        //ETIQUETAS PERIFERICOS SENSOR RESPUESTA
        LabelPerifericoSensorRespuesta.setSize(120,25);
        LabelPerifericoSensorRespuesta.setLocation(posicionX+desplazo,posicionY+(factor*2));
        LabelPerifericoSensorRespuesta.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 20));
        if (Sensor.equals("Activado")) {
            LabelPerifericoSensorRespuesta.setText("Encendido");
            LabelPerifericoSensorRespuesta.setForeground(Color.BLUE);
        } else {
            LabelPerifericoSensorRespuesta.setText("Apagado");
            LabelPerifericoSensorRespuesta.setForeground(Color.RED);
        }
        LabelPerifericoSensorRespuesta.setVisible(true);
        PanelPerifericos.add(LabelPerifericoSensorRespuesta);
        PanelPerifericos.updateUI();
        
        
        //ETIQUETAS PERIFERICOS API RESPUESTA
        LabelPerifericoAPIRespuesta.setSize(120,25);
        LabelPerifericoAPIRespuesta.setLocation(posicionX+desplazo,posicionY+(factor*3));        
        LabelPerifericoAPIRespuesta.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 20));
        if (Api.equals("Activado")) {
            LabelPerifericoAPIRespuesta.setText("Encendida");
            LabelPerifericoAPIRespuesta.setForeground(Color.BLUE);
        } else {
            LabelPerifericoAPIRespuesta.setText("Apagada");
            LabelPerifericoAPIRespuesta.setForeground(Color.RED);
        }
        LabelPerifericoAPIRespuesta.setVisible(true);
        PanelPerifericos.add(LabelPerifericoAPIRespuesta);
        PanelPerifericos.updateUI();
        
                
        //ETIQUETAS PERIFERICOS MONITOR RESPUESTA
        LabelPerifericoMonitorRespuesta.setSize(120,25);
        LabelPerifericoMonitorRespuesta.setLocation(posicionX+desplazo,posicionY+(factor*4)); 
        LabelPerifericoMonitorRespuesta.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 20));
        if (Monitor.equals("Activado")) {
            LabelPerifericoMonitorRespuesta.setText("Encendido");
            LabelPerifericoMonitorRespuesta.setForeground(Color.BLUE);
        } else {
            LabelPerifericoMonitorRespuesta.setText("Apagado");
            LabelPerifericoMonitorRespuesta.setForeground(Color.RED);
        }
        LabelPerifericoMonitorRespuesta.setVisible(true);
        PanelPerifericos.add(LabelPerifericoMonitorRespuesta);
        PanelPerifericos.updateUI();
    }
    
    public void imagenEnterPerifericos(int x, int fR){
        LabelImagenChecarPerifericos.setSize(80+x,80+x);
        LabelImagenChecarPerifericos.setLocation(225-fR+desplazo,330-fR);
        LabelImagenChecarPerifericos.setIcon(new ImageIcon(imagenEnter.getImage().getScaledInstance(80+x,80+x, Image.SCALE_SMOOTH)));
        LabelImagenChecarPerifericos.setVisible(true);
        PanelPerifericos.add(LabelImagenChecarPerifericos);
        PanelPerifericos.updateUI();
        
        //ETIQUETA CHECAR PERIFERICOS        
        LabelChecarPerifericos.setSize(160,25);
        LabelChecarPerifericos.setLocation(190+desplazo,425);         
        LabelChecarPerifericos.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 16));
        LabelChecarPerifericos.setVisible(true);
        PanelPerifericos.add(LabelChecarPerifericos);
        PanelPerifericos.updateUI();
    }
    
    
    //****************   PANEL PUERTA   ***************************
    
    //PANEL
    public JPanel PanelPuerta = new JPanel();
    
    //IMAGEN PUERTA CERRADA
    ImageIcon imagenPuertaCerrada = new ImageIcon(getClass().getResource("/imagenes/puertaCerrada.png"));
    
    //ETIQUETA SITUACIÓN PUERTA
    public JLabel LabelSistuacionPuertaPanelPuerta = new JLabel();
    
    //IMAGEN PUERTA ABIERTA
    ImageIcon imagenPuertaAbierta = new ImageIcon(getClass().getResource("/imagenes/(Puerta) imagen de kmicican en Pixabay .png"));
    
    //ETIQUETA IMAGEN PUERTA CERRADA
    public JLabel LabelImagenPuertaCerrada = new JLabel();
    
    //ETIQUETA IMAGEN PUERTA ABIERTA
    public JLabel LabelImagenPuertaAbierta = new JLabel();
    
    //ETIQUETA ENTER PANEL PUERTA
    public JLabel LabelImagenEnterPanelPuerta = new JLabel();
    
    //ETIQUETA CEDER ACCESO
    public JLabel LabelCederAcceso = new JLabel();
    
    
    public void configuracionPanelPuerta(){
        //PANEL
        PanelPuerta.setLayout(null);
        PanelPuerta.setBackground(Color.WHITE);
        PanelPuerta.setSize(tamanoGeneralX,tamanoGeneralY);
        this.getContentPane().add(PanelPuerta);
        PanelPuerta.setVisible(false);
        PanelPuerta.updateUI();
        
        //ETIQUETA CEDER ACCESO
        LabelCederAcceso.setSize(200,25);
        LabelCederAcceso.setLocation(195+desplazo,420);         
        LabelCederAcceso.setFont(new Font("Bauhaus 93", Font.CENTER_BASELINE, 20));
        LabelCederAcceso.setText("Ceder acceso");
        LabelCederAcceso.setVisible(true);
        PanelPuerta.add(LabelCederAcceso);
        PanelPuerta.updateUI();
        
        imagenEnterPanelPuerta(0,0);
        componentesVentanas(PanelPuerta);
        imagenRegreso(PanelPuerta);
        imagenPuertaCerradaPanelPuerta(0, 0);
        imagenPuertaAbiertaPanelPuerta(0, 0);
        
    }
    
    public void imagenPuertaAbiertaPanelPuerta(int x, int fR){
        //ETIQUETA PUERTA CERRADA
        LabelImagenPuertaAbierta.setSize(150+x,150+x);
        LabelImagenPuertaAbierta.setLocation(175+fR+desplazo,135+fR);
        LabelImagenPuertaAbierta.setIcon(new ImageIcon(imagenPuertaAbierta.getImage().getScaledInstance(150+x,150+x, Image.SCALE_SMOOTH)));
        LabelImagenPuertaAbierta.setVisible(false);
        PanelPuerta.add(LabelImagenPuertaAbierta);
        PanelPuerta.updateUI();        
    }
    
    public void imagenPuertaCerradaPanelPuerta(int x, int fR){
        //ETIQUETA PUERTA CERRADA
        LabelImagenPuertaCerrada.setSize(150+x,150+x);
        LabelImagenPuertaCerrada.setLocation(175+fR+desplazo,135+fR);
        LabelImagenPuertaCerrada.setIcon(new ImageIcon(imagenPuertaCerrada.getImage().getScaledInstance(150+x,150+x, Image.SCALE_SMOOTH)));
        LabelImagenPuertaCerrada.setVisible(true);
        PanelPuerta.add(LabelImagenPuertaCerrada);
        PanelPuerta.updateUI();        
    }
    
    public void imagenEnterPanelPuerta(int x, int fR){
        LabelImagenEnterPanelPuerta.setSize(80+x,80+x);
        LabelImagenEnterPanelPuerta.setLocation(220-fR+desplazo,330-fR);
        LabelImagenEnterPanelPuerta.setIcon(new ImageIcon(imagenEnter.getImage().getScaledInstance(80+x,80+x, Image.SCALE_SMOOTH)));
        LabelImagenEnterPanelPuerta.setVisible(true);
        PanelPuerta.add(LabelImagenEnterPanelPuerta);
        PanelPuerta.updateUI();
    }

   
    
        
   
    
    
}
