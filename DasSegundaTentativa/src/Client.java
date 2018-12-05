import java.awt.*;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.applet.Applet;

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
                Registry registry = LocateRegistry.getRegistry("192.168.1.36", 6867);
                message = (Message) registry.lookup("server");
                System.out.println("conectou");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (message != null) {
                try {
                    message.sendMessage(text);
                    System.out.println(message.getMessage(text));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
}