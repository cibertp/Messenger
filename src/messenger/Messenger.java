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

    public static void main(String[] args) {
        // TODO code application logic here
        servidor = new Conector();
        ventanaServidor server = new ventanaServidor();

    }

}
