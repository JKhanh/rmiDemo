import model.User;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientController {
    private String serverHost = "localhost";
    private int serverPort = 8888;
    private LoginInterface rmiServer;
    private Registry registry;
    private String rmiService = "rmiLoginService";

    public ClientController(){
        try{
            registry = LocateRegistry.getRegistry(serverHost, serverPort);
            rmiServer = (LoginInterface) registry.lookup(rmiService);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    public boolean remoteCheckLogin(User user){
        try{
            return rmiServer.checkLogin(user);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }
}
