package messenger.Connector;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
import messenger.VentanaCliente;
import messenger.ventanaServidor;

/**
 *
 * @author alumno
 */
public class Conector extends Thread{

    private Socket s;
    private ServerSocket ss;
    private InputStreamReader entradaSoket;
    private DataOutputStream salida;
    private BufferedReader entrada;
    final int puerto = 8080;

    public Conector() {
        try {
            ss = new ServerSocket(puerto);
            s = ss.accept();

            entradaSoket = new InputStreamReader(s.getInputStream());
            entrada = new BufferedReader(entradaSoket);
            salida = new DataOutputStream(salida);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al conector" + e.getMessage());
        }
    }

    public Conector(String ip) {
        super(ip);///el nonmbre de la pc
    }

    public void enviarMSG(String msg) {
        try {
            salida.writeUTF(msg);
        } catch (Exception e) {
        }

    }

    public String leerMSG() {
        try {
           return entrada.readLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"erro al leermsg"+ e.getMessage());
            return null;
            
        }
     
    }
    public void desconectar(){
        try {
            s.close();
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        }
        
        try {
            ss.close();//este es para q el servidor
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("empty-statement")
   public void run(){
       String text="test";
       try {
           this.ss= new ServerSocket(puerto);
           this.s= ss.accept();
           
           //resive mensaje
           this.entradaSoket = new InputStreamReader(s.getInputStream());
           this.entrada= new BufferedReader(entrada);
           //envia mensaje
           this.salida= new DataOutputStream(s.getOutputStream());
           
           while (true) {               
               text = this.entrada.readLine();
               JOptionPane.showMessageDialog(null, text);
               System.out.println(text);
                 VentanaCliente.listaCliente.setText(VentanaCliente.listaCliente.getText()+"\n"+ text);
           } 
       } catch (Exception e) {
       JOptionPane.showMessageDialog(null,"error  en run "+ e.getMessage());
       }
   }
    
}
