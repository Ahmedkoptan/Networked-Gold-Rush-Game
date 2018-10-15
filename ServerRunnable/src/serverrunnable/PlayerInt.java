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
public interface PlayerInt extends Remote{
    public void start(GameSetting gameSetting) throws RemoteException;

    public void gameOver() throws RemoteException;
    
    public int getWidth() throws RemoteException;
   
    public int getHeight() throws RemoteException;

    public void drawToScene(GameObject gameObject) throws RemoteException;
	

    public void drawToScene(List<GameObject> gameObjects) throws RemoteException;
    

    public void refreshScene() throws RemoteException;

    public void setVisible(boolean b) throws RemoteException;

    //public void moveBoat(int direction) throws RemoteException;
    
    public void selectMove(int direction)throws RemoteException;
    
    public String setDifficulty() throws RemoteException;
    //public void loadGold() throws RemoteException;
}
