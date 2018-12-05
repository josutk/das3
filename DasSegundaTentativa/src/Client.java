import java.awt.*;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.applet.Applet;

/* o Cliente acessa remotamente os serviços providos pelo servidor*/
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
            	/* o registry permite localizar o servidor, por meio do endereço e porta onde ele é provido */
                Registry registry = LocateRegistry.getRegistry("192.168.1.36", 6867);
                /* utilizando a interface message e o registry, o stub para o servidor é criado e armazenado na variável message
                 * que agora consegue fazer chamadas dos métodos remotos, que não serão executados no cliente, mas sim
                 * por comunicação com o skeleton do servidor*/
                message = (Message) registry.lookup("server");
                System.out.println("conectou");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (message != null) {
                try {
                	/*chamada remota de método */
                    message.sendMessage(text);
                    System.out.println(message.getMessage(text));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
}