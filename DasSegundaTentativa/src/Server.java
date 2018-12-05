import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;;

public class Server extends UnicastRemoteObject implements Message {
		
		private List <Client> clients = new ArrayList();
	
        public Server() throws java.rmi.RemoteException {
               super();     
        }
        
        public void initList() {
        	this.clients.add(new Client(1));
        }
       
		@Override
		public String getMessage(String text) throws RemoteException {
			// TODO Auto-generated method stub
			return "o cliente enviou "+text;
		}

		@Override
		public void sendMessage(String text) throws RemoteException {
			//Client client = new Client(1);
			System.out.println("o cliente de id 1 recebeu a mensagem"+text);
		}
        public static void main(String[] args) {
        	Registry registry = null;
        	Server server = null;
	        try {
	            registry = LocateRegistry.createRegistry(6867);
	            server = new Server();
	            registry.rebind("server", server);
	            System.out.println("Servidor iniciado!");	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
       }
}

