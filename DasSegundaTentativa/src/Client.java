import java.awt.*;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.applet.Applet;

/* o Cliente acessa remotamente os servi�os providos pelo servidor*/
public class Client  {

		public int id;
		public String message;
	
        public Client(int id, String message) {
			this.id = id;
			this.message = message;
		}
        public Client(int id) {
			this.id = id;
	
		}
        public static void main(String[] args) {

            String text = "Mensagem para o servidor";
            Message message = null;

            try {
            	/* o registry permite localizar o servidor, por meio do endere�o e porta onde ele � provido */
                Registry registry = LocateRegistry.getRegistry("192.168.1.36", 6867);
                /* utilizando a interface message e o registry, o stub para o servidor � criado e armazenado na vari�vel message
                 * que agora consegue fazer chamadas dos m�todos remotos, que n�o ser�o executados no cliente, mas sim
                 * por comunica��o com o skeleton do servidor*/
                message = (Message) registry.lookup("server");
                System.out.println("conectou");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (message != null) {
                try {
                	/*chamada remota de m�todo */
                    message.sendMessage(text);
                    System.out.println(message.getMessage(text));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
}