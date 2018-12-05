/*
 * Nessa interface, são colocados os métodos que serão remotos dos do servidor
 * Ele é um extends do Remote do RMI, o que significa que, por causa de herança,
 * permite quem utilizá-la seguir os padrões de um servidor RMI, limitando ao servidor
 * seguir os padrões da arquitetura restringida do RMI.
 * */
public interface Message extends java.rmi.Remote {
	
        String getMessage(String text) throws java.rmi.RemoteException;
        void sendMessage(String text) throws java.rmi.RemoteException;

}


