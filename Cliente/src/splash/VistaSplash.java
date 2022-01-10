package splash;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaSplash extends JFrame{
    
    public JPanel Panel = new JPanel();
    
    Font FuenteGeneral = new Font("Bauhaus 93", Font.CENTER_BASELINE, 40);
    int desplazoX = 10, desplazoY = 60;
    
    public VistaSplash() throws InterruptedException{
        configuracionVentana();
        //configuracionPanel();
        configuracionLetras();
        desvanecimientoSplash(3);
    }

    private void configuracionVentana() {
        this.setUndecorated(true);
        this.setSize(700,480);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.white);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
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
        this.add(Label_Titulo);

        //SEGUNDO RENGLÓN
        JLabel Label_Titulo2 = new JLabel("multifuncional de una");
        Label_Titulo2.setSize(650,50);
        Label_Titulo2.setLocation(110+desplazoX,120+desplazoY);
        Label_Titulo2.setFont(FuenteGeneral);
        this.add(Label_Titulo2);
        
        //TERCER RENGLÓN
        JLabel Label_Titulo3 = new JLabel("Raspberry Pi basado en");
        Label_Titulo3.setSize(650,50);
        Label_Titulo3.setLocation(110+desplazoX,190+desplazoY);
        Label_Titulo3.setFont(FuenteGeneral);
        this.add(Label_Titulo3);
        
        //CUARTO RENGLÓN
        JLabel Label_Titulo4 = new JLabel("cliente/servidor");
        Label_Titulo4.setSize(650,50);
        Label_Titulo4.setLocation(180+desplazoX,260+desplazoY);
        Label_Titulo4.setFont(FuenteGeneral);
        this.add(Label_Titulo4);
        
    }
    
    private void desvanecimientoSplash(int segundos) throws InterruptedException{
        Thread.sleep(segundos*1000);
        float restador;
        for (int i = 100; i >= 0; i--) {
            Thread.sleep(20);
            restador = (float) i / 100;   
            this.setOpacity(restador);
        }             
    }
    
    public static void main(String[] args) throws InterruptedException {
        VistaSplash v = new VistaSplash();
    }
    
    
    
}
