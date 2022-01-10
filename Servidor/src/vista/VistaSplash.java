package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaSplash extends JFrame{
    
    public JPanel Panel = new JPanel();
    
    Font FuenteGeneral = new Font("Bauhaus 93", Font.CENTER_BASELINE, 40);
    int desplazoX = 10, desplazoY = 20;
    
    public VistaSplash() throws InterruptedException{
        configuracionVentana();
        configuracionPanel();
        configuracionLetras();
    }

    private void configuracionVentana() {
        this.setUndecorated(true);
        this.setSize(700,480);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.white);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void configuracionPanel(){
        Panel.setLayout(null);
        Panel.setBackground(Color.WHITE);
        Panel.setSize(700,480);
        this.getContentPane().add(Panel);
    }
    
    private void configuracionLetras(){
        //PRIMER RENGLON
        JLabel Label_Titulo = new JLabel("Prototipo para monitoreo");
        Label_Titulo.setSize(650,50);
        Label_Titulo.setLocation(90+desplazoX,50+desplazoY);
        Label_Titulo.setFont(FuenteGeneral);
        Panel.add(Label_Titulo);

        //SEGUNDO RENGLÓN
        JLabel Label_Titulo2 = new JLabel("multifuncional de una");
        Label_Titulo2.setSize(650,50);
        Label_Titulo2.setLocation(110+desplazoX,120+desplazoY);
        Label_Titulo2.setFont(FuenteGeneral);
        Panel.add(Label_Titulo2);
        
        //TERCER RENGLÓN
        JLabel Label_Titulo3 = new JLabel("Raspberry Pi basado en");
        Label_Titulo3.setSize(650,50);
        Label_Titulo3.setLocation(110+desplazoX,190+desplazoY);
        Label_Titulo3.setFont(FuenteGeneral);
        Panel.add(Label_Titulo3);
        
        //CUARTO RENGLÓN
        JLabel Label_Titulo4 = new JLabel("cliente/servidor");
        Label_Titulo4.setSize(650,50);
        Label_Titulo4.setLocation(180+desplazoX,260+desplazoY);
        Label_Titulo4.setFont(FuenteGeneral);
        Panel.add(Label_Titulo4);
        
        JLabel Label_TituloServidor = new JLabel("LADO SERVIDOR");
        Label_TituloServidor.setSize(650,50);
        Label_TituloServidor.setLocation(180+desplazoX,360+desplazoY);
        Label_TituloServidor.setFont(FuenteGeneral);
        Label_TituloServidor.setForeground(Color.red);
        Panel.add(Label_TituloServidor);
        Panel.updateUI();
        
    }
        
}
