
public interface Message extends java.rmi.Remote {
	
        String getMessage(String text) throws java.rmi.RemoteException;
        void sendMessage(String text) throws java.rmi.RemoteException;

}


