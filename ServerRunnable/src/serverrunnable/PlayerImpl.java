/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverrunnable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author ahmedkoptanmacbook
 */
public class PlayerImpl extends UnicastRemoteObject implements PlayerInt{
    
    
    private static final long serialVersionUID = -7657076306307031092L;
    private GameView view;
    private ServerInt serverInt;
    private GameSetting setting;
    private Scanner input= new Scanner(System.in); private String difficulty;
    
    public PlayerImpl(ServerInt serverInt) throws RemoteException{
        super();
        this.serverInt=serverInt;
    }
    
    public void setGameView(GameView view){
        this.view= view;
    }
    
    public GameSetting getSetting(){
        return setting;
    }
    public void setSetting(GameSetting setting){
        this.setting=setting;
    }
    
    @Override 
    public void start(GameSetting gameSetting) throws RemoteException{
        GameView gameView=new GameView("Networked Gold Rush Game", ResourcesUtils.GAME_WIDTH,ResourcesUtils.GAME_HEIGHT);
        setGameView(gameView);
        setSetting(gameSetting);
        gameView.setPlayerInt(this);
        gameView.setVisible(true);
        gameView.setScenebackground();
        gameView.setVisible(true);
        
    }
    
    @Override
    public String setDifficulty() throws RemoteException{
        System.out.println("Please enter difficulty: 'e' for easy, 'm' for medium, and 'd' for difficult.");
        return difficulty=input.next();
    }
    
    @Override
    public void gameOver() throws RemoteException{
        view.showGameOver();
    }
    
    @Override
    public int getWidth() throws RemoteException{
        return view.getWidth();
    }
    
    @Override
    public int getHeight() throws RemoteException{
        return view.getHeight();
    }
    @Override
    public void drawToScene(List<GameObject> objs) throws RemoteException{
        view.drawToScene(objs);
    }
    
    @Override
    public void selectMove(int direction) throws RemoteException{
        serverInt.selectMove(setting.getPlayerName(), direction);
    }
    
    @Override
    public void drawToScene(GameObject obj) throws RemoteException{
        view.drawToScene(obj);
    }
    
    @Override
    public void refreshScene() throws RemoteException{
        view.refreshScene();
    }
    
    @Override
    public void setVisible(boolean b) throws RemoteException{
        view.setVisible(b);
    }
    /*
    @Override
    public void moveBoat(int direction) throws RemoteException{
        serverInt.moveBoat(setting.getPlayerName(),direction);
    }*/
    
    //public void loadGold() throws RemoteException{
     //   serverInt.loadGold(setting.getPlayerName());
    //}
    
}
