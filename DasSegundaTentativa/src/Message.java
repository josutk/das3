/*
 * Nessa interface, s�o colocados os m�todos que ser�o remotos dos do servidor
 * Ele � um extends do Remote do RMI, o que significa que, por causa de heran�a,
 * permite quem utiliz�-la seguir os padr�es de um servidor RMI, limitando ao servidor
 * seguir os padr�es da arquitetura restringida do RMI.
 * */
public interface Message extends java.rmi.Remote {
	
        String getMessage(String text) throws java.rmi.RemoteException;
        void sendMessage(String text) throws java.rmi.RemoteException;

}


