import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;;
/*
 * O servidor possui heran�a com o UnicastRemoteObject, que define como
 * ser� sua comunica��o com os clientes, e implementa a interface Message, que possui
 * os m�todos que ser�o remotos, assim ent�o podendo ser gerado os stubs e o skeleton
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
        
        
       /* os m�todos getMessage e sendMessage possuem a implementa��o remota descrita aqui */
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
	        	/* O registry registra onde ser� fornecido o servi�o do servidor, para que os clientes possam encontr�-lo*/
	            registry = LocateRegistry.createRegistry(6867);
	            server = new Server();
	            registry.rebind("server", server);
	            System.out.println("Servidor iniciado!");	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
       }
}

