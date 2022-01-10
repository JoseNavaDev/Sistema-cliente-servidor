//Servidor del lado de la Raspberry Pi

package modelo;

import com.github.sarxos.webcam.Webcam;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import vista.Vista;

public class ServidorPruebas extends Thread {
    
    ServerSocket server;
    Socket connection;
    Webcam webcam;
    DataOutputStream dos;
    DataInputStream dis;
    BufferedInputStream bis;
    BufferedOutputStream bos;   

    byte[] receivedData;
    int in;
    String file, selector;  
    boolean bandera = true;
    
    int puerto = 5000;
    
    public Vista Vista;
    
    public ServidorPruebas(Vista Vista){
        this.Vista = Vista;
    }
    
    /*          
    public void seter(int puerto){
        this.puerto = puerto;
    }
    */  
    
    @Override
    public void run(){
        try {
            //Servidor Socket en el puerto 5000
            server = new ServerSocket(puerto);
        } catch (IOException ex) {
            Logger.getLogger(ServidorPruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
            //Aceptar conexiones           
            while (bandera) {      
            try {
                //Aceptar conexiones
                System.out.println("Esperando cliente");
                connection = server.accept();
                Vista.servidorConectado();
            } catch (IOException ex) {
                Logger.getLogger(ServidorPruebas.class.getName()).log(Level.SEVERE, null, ex);
            }
                //VistaPrincipal.LabelEstadoServidor.setText("Cliente conectado");
                //VistaPrincipal.LabelServidorConectado.setText("Puerto: 5000");
            try {
                dis = new DataInputStream(connection.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(ServidorPruebas.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                dos = new DataOutputStream(connection.getOutputStream());
            } catch (IOException ex) {
                Logger.getLogger(ServidorPruebas.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                
                selector = dis.readUTF();
                
            } catch (IOException ex) {
                Logger.getLogger(ServidorPruebas.class.getName()).log(Level.SEVERE, null, ex);
            }
                String[] cadenaSeparada = selector.split("_");                
                
                switch(cadenaSeparada[0]){
                    
                    case "Prueba":
            {
                try {
                    dos.writeBoolean(true);
                } catch (IOException ex) {
                    Logger.getLogger(ServidorPruebas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;
                    
                    case "BotonEnviarArchivo":                        
                        //Buffer de 1024 bytes
                        receivedData = new byte[1024];
            {
                try {
                    bis = new BufferedInputStream(connection.getInputStream());
                } catch (IOException ex) {
                    Logger.getLogger(ServidorPruebas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

                        //Recibimos el nombre del fichero
                        file = cadenaSeparada[1];
                        file = file.substring(file.indexOf('\\') + 1, file.length());
                        //Vista.TxFArchivoPA.setText(file);

            {
                try {
                    //Para guardar fichero recibido
                    bos = new BufferedOutputStream(new FileOutputStream(file));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ServidorPruebas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            {
                try {
                    while ((in = bis.read(receivedData)) != -1) {
                        bos.write(receivedData, 0, in);
                    }
                    Vista.ArchivoRecibido.setText("Archivo recibido");
                    Vista.DireccionArchivo.setText(file);
                } catch (IOException ex) {
                    Logger.getLogger(ServidorPruebas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                        //VistaPrincipal.LAbelArchivoRecibidoRespuesta.setText(cadenaSeparada[1]);
                                                
                break;
                
                    case "BotonPerifericos":
                        
            {
                try {
                    dos.writeUTF(perifericos());
                } catch (IOException ex) {
                    Logger.getLogger(ServidorPruebas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                        
                        break;
                        
                    case "BotonCederAcceso":
            {
                try {
                    dos.writeBoolean(true);
                    Vista.configuracionComponentesPuertaCerrada(false);
                    Vista.configuracionComponentesPuertaAbierta(true);
                } catch (IOException ex) {
                    Logger.getLogger(ServidorPruebas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
                        //VistaPrincipal.LabelEstadoCerradura.setText("Cerradura abierta");                       
                        
                        break;
                        
                    case "BotonCamara":
            {
                try {
                    hiloEnvioImagenes();                   
                } catch (IOException ex) {
                    Logger.getLogger(ServidorPruebas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                                        
                        break;
                        
                    case "PruebaConexión":
            {
                try {
                    dos.writeUTF("Servidor conectado_"+cadenaSeparada[2]);
                } catch (IOException ex) {
                    Logger.getLogger(ServidorPruebas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                        System.out.println(cadenaSeparada[2]);                        
                        break;
                    
                    case "Salir":
                        bandera = false;                       
                        break;
                }                
            }
                
    }

    /*
    public String creacionCadenaPerifericos(){
        String Cadena = VistaPrincipal.LabelPCamaraRespuesta.getText() + "_" + VistaPrincipal.LabelPCerraduraRespuesta.getText() +
                "_" + VistaPrincipal.LabelPSensorRespuesta.getText() + "_" + VistaPrincipal.LabelP_APIRestRespuesta.getText() + 
                "_" + VistaPrincipal.LabelP_PantallaRespuesta.getText();
        return Cadena;
    }
    */
    private void hiloEnvioImagenes() throws IOException{
        
        webcam = Webcam.getDefault();
        webcam.open();
        BufferedImage bm = webcam.getImage();
        DataInputStream dis = new DataInputStream(connection.getInputStream());
        boolean bandera = true;
        ObjectOutputStream dout = new ObjectOutputStream(connection.getOutputStream());
        ImageIcon im = new ImageIcon(bm);
        
        /*
        JFrame frame = new JFrame("Cliente");
        frame.setSize(640, 360);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        JLabel l = new JLabel();
        l.setVisible(true);
        frame.add(l);
        frame.setVisible(true);
        */
        
        while (bandera) {
            bm = webcam.getImage();
            im = new ImageIcon(bm);
            dout.writeObject(im);
            Vista.LabelVideoCamara.setIcon(im);
            dout.flush();
            bandera = dis.readBoolean(); //BANDERA PARA FINALIZAR VIDEO
            System.out.println("Leyendo:"+bandera);
        }
        ImageIcon ImagenCamara = new ImageIcon(getClass().getResource("/imagenes/(Camara) Imagen de Catinas en Pixabay .png"));  
        Vista.LabelVideoCamara.setIcon(new ImageIcon(ImagenCamara.getImage().getScaledInstance(180,180,Image.SCALE_SMOOTH)));
        webcam.close();
    }
    
    private String perifericos(){
        String cadenaPeriféricos = Vista.Periferico_Camara+"_"+Vista.Periferico_Cerradura+"_"+Vista.Periferico_Sensor+"_"+
                Vista.Periferico_API+"_"+Vista.Periferico_Monitor;       
        return cadenaPeriféricos;
    }
    
    
    
}
