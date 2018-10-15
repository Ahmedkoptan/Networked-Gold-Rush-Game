/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverrunnable;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.HashMap;

/**
 *
 * @author ahmedkoptanmacbook
 */
public class ServerImpl extends UnicastRemoteObject implements ServerInt{
    
    private static final long serialVersionUID = 5081658822112792121L;
    
    private HashMap<String, PlayerInt> connections = new HashMap<>();
    private HashMap<String, GameSetting> connectionsSettings = new HashMap<>();
    private GameController cont; private String difficulty; boolean setDifficulty=false;
    
    public ServerImpl() throws RemoteException{
        super();
    }
    
    public String getDifficulty(){
        return difficulty;
    }
    
    public HashMap<String,PlayerInt> getConnections(){
        return connections;
    }
    
    public void setConnections(HashMap<String, PlayerInt> connections) {
        this.connections = connections;
    }
    
    @Override
    public void addPlayer(PlayerInt clientInt) throws RemoteException{
        GameSetting gameSetting= new GameSetting();
        if(connections.get(gameSetting.getPlayerName())==null){
            connections.put(gameSetting.getPlayerName(), clientInt);
            connectionsSettings.put(gameSetting.getPlayerName(), gameSetting);
            System.out.println("The following client ["+gameSetting.getPlayerName()+"] has been connected now.");   
        }
        else{
            System.out.println("The following client ["+gameSetting.getPlayerName()+"] is already connected.");
        }
        if(connections.size()==1){
            difficulty=connections.get(gameSetting.getPlayerName()).setDifficulty();
            setDifficulty=true;
        }
        if(connections.size()>= 2 && setDifficulty){
            for(String name:connections.keySet()){
                GameSetting sett= connectionsSettings.get(name);
                connections.get(name).start(sett);
            }
            cont= new GameController(this);
        }
        else{
            System.out.println("Waiting for other player to connect...");
            System.out.println("Please enter 'e' for easy, 'm' for medium, or 'd' for difficult game");   
        }
    }
    
    @Override
    public void removePlayer(String name) throws RemoteException{
        connections.remove(name);
        System.out.println("The following client ["+name+"] has been disconnected now.");
    }
    
    public String showStatistics(){
        return "Server stats:\n [connections: "+connections+"]";
    }
    /*
    @Override
    public void moveBoat(String name, int direction) throws RemoteException{
        int playerId= connectionsSettings.get(name).getPlayerID();
        cont.moveBoat(playerId, direction);
    }*/
    
    @Override
    public void selectMove(String name, int direction) throws RemoteException{
        int playerId=connectionsSettings.get(name).getPlayerID();
        cont.selectMove(playerId, direction);
    }
}
