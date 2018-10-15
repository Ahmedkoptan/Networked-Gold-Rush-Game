/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverrunnable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author ahmedkoptanmacbook
 */
public interface ServerInt extends Remote{
    public void addPlayer(PlayerInt clientInt) throws RemoteException;
    public void removePlayer(String name) throws RemoteException;
    //public void moveBoat(String name, int direction) throws RemoteException;
    //public void loadGold(String name) throws RemoteException;
    public void selectMove(String name, int direction) throws RemoteException;

}

