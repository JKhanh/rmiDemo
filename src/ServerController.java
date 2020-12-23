import model.User;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerController extends UnicastRemoteObject implements LoginInterface {
    private int serverPort = 8888;
    private Registry registry;
    private String rmiService = "rmiLoginService";

    protected ServerController() throws RemoteException {
        try{
            registry = LocateRegistry.createRegistry(serverPort);
            registry.rebind(rmiService, this);
        } catch (RemoteException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public Boolean checkLogin(User user) throws RemoteException {
        return (user.getUsername().equals("admin") && user.getPassword().equals("dmlam"));
    }
}
