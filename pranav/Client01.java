package pranav;

import pranav.RmiServer;
import java.rmi.*;
import java.util.*; 

public class Client01 { 
    public static void main( String ar[] ) throws RemoteException {
        new Client01( ar[0] );
    }

    public Client01( String host ) {
        try{ 
            // creating new object of RmiServer
            RmiServer server = (RmiServer) Naming.lookup( "rmi://" + host + "/NiftyServer" );

            System.out.println("press any key to change the object properties...");

            try { 
                // changing the ID of the object we got over the network
                server.setId( "This is client machine" );
            }
            catch( Exception e ) {
                e.toString();
            }
        }
        catch( java.io.IOException e ) {
            // I/O error or bad URL 
            e.printStackTrace();
        }
        catch( NotBoundException e ) {
            //NiftyServer isn't registered
            e.printStackTrace();
        }
    }
}