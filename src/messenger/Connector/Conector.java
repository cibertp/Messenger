package messenger.Connector;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class Conector {

    private Socket s;
    private ServerSocket ss;
    private InputStreamReader entradaSoket;
    private DataOutputStream salida;
    private BufferedReader entrada;
    final int puerto = 4314;

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

}
