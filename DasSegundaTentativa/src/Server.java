import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;;
/*
 * O servidor possui herança com o UnicastRemoteObject, que define como
 * será sua comunicação com os clientes, e implementa a interface Message, que possui
 * os métodos que serão remotos, assim então podendo ser gerado os stubs e o skeleton
 * desse servidor
 * */
public class Server extends UnicastRemoteObject implements Message {
		
		private List <Client> clients = new ArrayList();
	
        public Server() throws java.rmi.RemoteException {
               super();     
        }
        
        public void initList() {
        	this.clients.add(new Client(1));
        }
        
        
       /* os métodos getMessage e sendMessage possuem a implementação remota descrita aqui */
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
	        	/* O registry registra onde será fornecido o serviço do servidor, para que os clientes possam encontrá-lo*/
	            registry = LocateRegistry.createRegistry(6867);
	            server = new Server();
	            registry.rebind("server", server);
	            System.out.println("Servidor iniciado!");	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
       }
}

