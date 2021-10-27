package pranav;

import pranav.RmiServer;
import java.rmi.*;
import java.util.*; 

public class RmiServerImpl extends java.rmi.server.UnicastRemoteObject implements RmiServer {
    private String id = "This is server machine";

    public RmiServerImpl() throws RemoteException { }

    public Date getDate() throws RemoteException {
        return new Date();
    }

    public void setId( String id ) throws RemoteException {
        this.id = id;
    }

    public String getId( ) throws RemoteException {
        return this.id;
    }

    public static void main( String ar[] ) {
        try{ 
            // System.setProperty("java.rmi.server.hostname","127.0.0.1");

            RmiServer server = new RmiServerImpl();
            Naming.rebind( "NiftyServer", server );    

            System.out.println("press any key.. (0 to exit)");

            // creating new object of Scanner for taking user input 
            Scanner sc = new Scanner( System.in );

            while( sc.nextInt() != 0 ) {
                System.out.println( server.getId() );
            }
        }
        catch( Exception re ){
            // problem registering server
            re.printStackTrace();
        }
    }
}