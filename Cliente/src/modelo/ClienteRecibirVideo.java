package modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import vista.Vista;

public class ClienteRecibirVideo extends Thread {
    
    public Vista Vista;    
    
    String IP = "localhost";    
    
    public ClienteRecibirVideo(Vista Vista){
        this.Vista = Vista;
    }
    
    @Override
    public void run(){
        try {
            recibirVideo();
        } catch (IOException ex) {
            Logger.getLogger(ClienteRecibirVideo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void recibirVideo() throws IOException{
        Socket client = new Socket(IP, 5000);        
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("BotonCamara");
        ObjectInputStream Obis = new ObjectInputStream(client.getInputStream());
        Vista.LabelVideoCamara.setVisible(true);
        while (Vista.bandera) {
            try {
                Vista.LabelVideoCamara.setIcon((ImageIcon)Obis.readObject());
                Vista.PanelCamara.updateUI();
                dos.writeBoolean(Vista.bandera);
                System.out.println("Escribiendo:"+Vista.bandera);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Cliente2.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }        
    }
    
}
