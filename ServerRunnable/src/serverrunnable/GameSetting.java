/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverrunnable;
import java.io.Serializable;
import java.rmi.server.UID;

/**
 *
 * @author ahmedkoptanmacbook
 */
public class GameSetting implements Serializable{
    
    private static final long serialVersionUID = 2861568734679532504L;
    private int playerId;
    private String playerName;
    
    private static int idCount=1;
    
    public GameSetting(){
        super();
        this.playerId=idCount;
        this.playerName= new UID().toString();
        idCount++;
    }
    public GameSetting(int playerID, String playerName){
        super();
        this.playerId=playerID;
        this.playerName=playerName;
    }
    
    
    public int getPlayerID(){
        return playerId;
    }
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
    
    
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName; 
    }

}

