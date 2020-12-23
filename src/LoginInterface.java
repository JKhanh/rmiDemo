import model.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginInterface extends Remote {
    Boolean checkLogin(User user) throws RemoteException;
}
