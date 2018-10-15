/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverrunnable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author ahmedkoptanmacbook
 */
public class ServerRunnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        try{
            ServerImpl serverImpl= new ServerImpl();
            Registry reg= LocateRegistry.createRegistry(1111);
            reg.rebind("serverService", serverImpl);
            System.out.println("The Server is running...");
        }
        catch(RemoteException e){
            e.printStackTrace();
        }
    }
    
}
