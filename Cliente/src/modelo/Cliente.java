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

public class Cliente extends Thread{   
    
    DataInputStream dis;
    DataOutputStream dos;
    BufferedInputStream bis;
    BufferedOutputStream bos;
    
    public String CadenaLabelsVistaPrincipal;
    public String[] mensajeLlegadaPerifericos;
    
    String IP = "localhost";
       
    public void conexionServidor(String Ruta, String Selector){         
        //Fichero a transferir
        final String filename = Ruta;
        final File localFile = new File(filename);
        int in;
        byte[] byteArray;
        
        try {            
            Socket client = new Socket(IP, 5000);            
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
                break;
                
                case "BotonCederAcceso":
                    dos.writeUTF(Selector+"_"+localFile.getName()+"_"+IP);
                    String mensajeLlegadaBotonCederAcceso = dis.readUTF();
                    System.out.println(mensajeLlegadaBotonCederAcceso);
                break;
                               
                case "PruebaConexión":
                    dos.writeUTF(Selector+"_"+localFile.getName()+"_"+IP);
                    CadenaLabelsVistaPrincipal = dis.readUTF();
                    System.out.println(CadenaLabelsVistaPrincipal);
                break;    
            }
            JOptionPane.showMessageDialog(null, "Se cerro el cliente...");
            bis.close();
            bos.close();     
        } catch (IOException e) {
            System.err.println(e);
        }
    }
        
   
    
    
   
    
    
}
