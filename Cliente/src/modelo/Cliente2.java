package modelo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import vista.Vista;

public class Cliente2 extends Thread{
    
    public Vista Vista;
    
    DataInputStream dis;
    DataOutputStream dos;
    BufferedInputStream bis;
    BufferedOutputStream bos;
    
    Socket client;
    public String CadenaLabelsVistaPrincipal;
    public String[] mensajeLlegadaPerifericos;
    public boolean puertaAcceso;    
    
    String IP;
    int puerto;
    
    public Cliente2(Vista Vista){
        this.Vista = Vista;
    }
    
    public void seter(String IP, int puerto){
        this.IP = IP;
        this.puerto = puerto;
    }
    
    public void conexionServidor(String Ruta, String Selector) throws ClassNotFoundException{         
        //Fichero a transferir
        final String filename = Ruta;
        final File localFile = new File(filename);
        int in;
        byte[] byteArray;
        
        boolean bandera = true;
        
        try {            
            client = new Socket(IP, 5000);            
            bis = new BufferedInputStream(new FileInputStream(localFile));
            dos = new DataOutputStream(client.getOutputStream());
            bos = new BufferedOutputStream(client.getOutputStream());  
            dis = new DataInputStream(client.getInputStream());            
            
            //ENVIO DE ARCHIVO
            switch(Selector){                
                case "BotonEnviarArchivo": //CASO BOTON ENVIAR ARCHIVO
                    //Enviamos el nombre del fichero 
                    Selector = Selector + "_" + localFile.getName() + IP;
                    dos.writeUTF(Selector);

                    //Enviamos el fichero
                    byteArray = new byte[8192];
                    while ((in = bis.read(byteArray)) != -1) {
                        bos.write(byteArray, 0, in);
                    }                                   
                break;
                
                case "BotonPerifericos": //CASO BOTON PERIFÉRICOS
                    dos.writeUTF(Selector+"_"+localFile.getName()+"_"+IP);
                    String CadenaCruda = dis.readUTF();                    
                    mensajeLlegadaPerifericos = CadenaCruda.split("_");
                    setearPerifericos();
                break;
                
                case "BotonCederAcceso":
                    dos.writeUTF(Selector+"_"+localFile.getName()+"_"+IP);
                    puertaAcceso = dis.readBoolean();     
                    if (puertaAcceso) {
                        Vista.LabelImagenPuertaCerrada.setVisible(false);
                        Vista.LabelImagenPuertaAbierta.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Acceso concedido");
                    }else{
                        JOptionPane.showMessageDialog(null, "Acceso negado");
                    }
                break;
                
                case "BotonCamara":
                    //dos.writeUTF(Selector+"_"+localFile.getName()+"_"+IP);                    
                                       
                break;
                
                case "PruebaConexión":
                    dos.writeUTF(Selector+"_"+localFile.getName()+"_"+IP);
                    CadenaLabelsVistaPrincipal = dis.readUTF();
                    System.out.println(CadenaLabelsVistaPrincipal);
                break; 
                               
            }
            //JOptionPane.showMessageDialog(null, "Se cerro el cliente...");
            bis.close();
            bos.close();     
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
    @Override
    public void run(){
        try {
            recibirVideo();
        } catch (IOException ex) {
            Logger.getLogger(Cliente2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void recibirVideo() throws IOException{
        client = new Socket(IP, 5000);
        ObjectInputStream Obis = new ObjectInputStream(client.getInputStream());       
        Vista.LabelVideoCamara.setVisible(true);
        while (true) {
            try {
                Vista.LabelVideoCamara.setIcon((ImageIcon)Obis.readObject());
                Vista.PanelCamara.updateUI();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Cliente2.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }        
    }
    
    public boolean pruebaConexion() throws IOException{
        client = new Socket(IP, puerto);
        dos = new DataOutputStream(client.getOutputStream());
        dis = new DataInputStream(client.getInputStream());
        dos.writeUTF("Prueba");
        boolean conexionEfectiva = dis.readBoolean();
        return conexionEfectiva;
    }
    
    private void setearPerifericos(){
        Vista.LabelPerifericoCamaraRespuesta.setText(mensajeLlegadaPerifericos[0]);
        Vista.LabelPerifericoCerraduraRespuesta.setText(mensajeLlegadaPerifericos[1]);
        Vista.LabelPerifericoSensorRespuesta.setText(mensajeLlegadaPerifericos[2]);
        Vista.LabelPerifericoAPIRespuesta.setText(mensajeLlegadaPerifericos[3]);
        Vista.LabelPerifericoMonitorRespuesta.setText(mensajeLlegadaPerifericos[4]);
    }
    
    
   
    
    
}
