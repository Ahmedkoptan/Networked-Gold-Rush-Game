/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverrunnable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author ahmedkoptanmacbook
 */
public class Run {
    public static void main(String[] args){
        try{
            
            Registry reg= LocateRegistry.getRegistry("127.0.0.1", 1111);
            ServerInt serverInt= (ServerInt) reg.lookup("serverService");
            PlayerInt player= new PlayerImpl(serverInt);
            serverInt.addPlayer(player);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
