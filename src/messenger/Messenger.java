package messenger;

import messenger.Connector.Conector;

/**
 *
 * @author alumno
 */
public class Messenger {

    /**
     * @param args the command line arguments
     */
    public static Conector servidor;
    public static Conector cliente;

    public static void main(String[] args) {
        // TODO code application logic here

        ventanaServidor server = new ventanaServidor();
        server.setVisible(true);

    }

    public static void initServer() {
        servidor = new Conector();
    }

    public static void initCliente(String ip){
        cliente= new Conector(ip);
    }

    void initCliene() {

    }

}
