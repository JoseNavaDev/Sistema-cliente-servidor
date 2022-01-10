package modelo;

import com.github.sarxos.webcam.Webcam;
import java.net.Socket;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ServidorEnvioImagen {
    
    static Socket socket;
    
    public static void main(String[] args) {
        
        Webcam webcam = Webcam.getDefault();
        webcam.open();
        //192.168.100.150
        
        try {
            ServerSocket servidor = new ServerSocket(5000);
            System.out.println("Esperando");
            Socket socket = servidor.accept();
            System.out.println("Conectado");
            
            BufferedImage bm = webcam.getImage();
            
            ObjectOutputStream dout = new ObjectOutputStream(socket.getOutputStream());
            ImageIcon im = new ImageIcon(bm);
            
            JFrame frame = new JFrame("Cliente");
            frame.setSize(640,360);
            frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
            
            JLabel l = new JLabel();
            l.setVisible(true);
            
            frame.add(l);
            frame.setVisible(true);
            
            while (true) {                
                bm = webcam.getImage();
                im = new ImageIcon(bm);
                dout.writeObject(im);
                l.setIcon(im);
                dout.flush();
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
    
    
}
