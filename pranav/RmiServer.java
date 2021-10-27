package pranav; 

import java.rmi.*;  
import java.util.*;

public interface RmiServer extends Remote {
    Date getDate() throws RemoteException;
    void execute( ) throws RemoteException;
    public void setId( String id) throws RemoteException;
    public String getId() throws RemoteException;  
}
