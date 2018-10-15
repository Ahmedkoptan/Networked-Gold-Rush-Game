/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverrunnable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.security.SecureRandom;
import java.time.Instant;
import java.time.Duration;
/**
 *
 * @author ahmedkoptanmacbook
 */
public class GameController extends UnicastRemoteObject implements Remote{
    
    private static final long serialVersionUID = 4149799855643600977L;
    private List<GameObject> gameObjects;
    private List<MovableGameObject> movableGameObjects;
    private MovableGameObject boat1;
    private MovableGameObject boat2;
    private MovableGameObject mine1;
    private MovableGameObject mine2;
    private MovableGameObject mine3;
    private MovableGameObject mine4;
    private MovableGameObject mine5;
    private StaticGameObject island1;
    private StaticGameObject island2;
    private MovableGameObject goldIconOne;
    private MovableGameObject goldIconTwo;
    private StaticGameObject islandGold;
    private StaticGameObject sea;
    private MovableGameObject movableGoldBoat1;
    private MovableGameObject movableGoldBoat2;
    private int numberOfMines;
    private ServerImpl server;
    private static final SecureRandom rand= new SecureRandom();
    private static final int step=20;
    private static final int threadSleepTime=50;
    private Instant timeStampLoadBoat1Start,timeStampLoadBoat1End,timeStampUnloadBoat1Start,timeStampUnloadBoat1End,
            timeStampLoadBoat2Start,timeStampLoadBoat2End,timeStampUnloadBoat2Start,timeStampUnloadBoat2End;
    private double goldUnloadedBoat1=0,goldOnBoat1=0;
    private double goldUnloadedBoat2=0,goldOnBoat2=0;
    private int boat1Condition; private int boat2Condition; //goldUnloaded=0,loadingGold=1,GoldLoaded=2,unloadingGold=3
    
    public GameController(ServerImpl server) throws RemoteException{
        super();
        this.server=server;
        gameObjects=new ArrayList<>();
        movableGameObjects= new ArrayList<>();
        switch (server.getDifficulty()){
            case "e":{
                numberOfMines=2;
                break;
            }
            case "m":{
                numberOfMines=3;
                break;
            }
            case "d":{
                numberOfMines=5;
            }
        }
        initializeGameObjects();
    }
    public void initializeGameObjects() throws RemoteException{
        int islandWidth=300;int islandHeight=300; int boatWidth=250; int boatHeight=220;
        int mineWidth=50; int mineHeight=50; int goldWidth=150; int goldHeight=150;
        switch (numberOfMines){
            case 2:{
                mine1=new MovableGameObject(ResourcesUtils.MINE, mineWidth, 
                    mineHeight, islandWidth+50,50, islandWidth, ResourcesUtils.GAME_WIDTH-islandWidth-mineWidth, 0, 
                    ResourcesUtils.GAME_HEIGHT-mineHeight);
                mine1.setMover(new Thread(new Runnable(){
                    @Override
                    public void run(){
                        while(true){
                            mine1.randMove(step);
                            try{
                                Thread.sleep(threadSleepTime);
                            }
                            catch(InterruptedException e){
                                e.printStackTrace();
                            }
                            try{
                                updateUI(gameObjects);
                            }
                            catch(RemoteException e){
                                e.printStackTrace();
                            }
                        }
                    }
                    }));
                mine1.startMoving();
                gameObjects.add(mine1);
                movableGameObjects.add(mine1);
                
                mine2=new MovableGameObject(ResourcesUtils.MINE, mineWidth, 
                    mineHeight, islandWidth+50,50, islandWidth, ResourcesUtils.GAME_WIDTH-islandWidth-mineWidth, 0, 
                    ResourcesUtils.GAME_HEIGHT-mineHeight);
                mine2.setMover(new Thread(new Runnable(){
                    @Override
                    public void run(){
                        while(true){
                            mine2.randMove(step);
                            try{
                                Thread.sleep(threadSleepTime);
                            }
                            catch(InterruptedException e){
                                e.printStackTrace();
                            }
                            try{
                                updateUI(gameObjects);
                            }
                            catch(RemoteException e){
                                e.printStackTrace();
                            }
                        }
                    }
                    }));
                mine2.startMoving();
                gameObjects.add(mine2);
                movableGameObjects.add(mine2);
                break;
            }
            case 3:{
                mine1=new MovableGameObject(ResourcesUtils.MINE, mineWidth, 
                    mineHeight, islandWidth+50,50, islandWidth, ResourcesUtils.GAME_WIDTH-islandWidth-mineWidth, 0, 
                    ResourcesUtils.GAME_HEIGHT-mineHeight);
                mine1.setMover(new Thread(new Runnable(){
                    @Override
                    public void run(){
                        while(true){
                            mine1.randMove(step);
                            try{
                                Thread.sleep(threadSleepTime);
                            }
                            catch(InterruptedException e){
                                e.printStackTrace();
                            }
                            try{
                                updateUI(gameObjects);
                            }
                            catch(RemoteException e){
                                e.printStackTrace();
                            }
                        }
                    }
                    }));
                mine1.startMoving();
                gameObjects.add(mine1);
                movableGameObjects.add(mine1);
                
                mine2=new MovableGameObject(ResourcesUtils.MINE, mineWidth, 
                    mineHeight, islandWidth+50,50, islandWidth, ResourcesUtils.GAME_WIDTH-islandWidth-mineWidth, 0, 
                    ResourcesUtils.GAME_HEIGHT-mineHeight);
                mine2.setMover(new Thread(new Runnable(){
                    @Override
                    public void run(){
                        while(true){
                            mine2.randMove(step);
                            try{
                                Thread.sleep(threadSleepTime);
                            }
                            catch(InterruptedException e){
                                e.printStackTrace();
                            }
                            try{
                                updateUI(gameObjects);
                            }
                            catch(RemoteException e){
                                e.printStackTrace();
                            }
                        }
                    }
                    }));
                mine2.startMoving();
                gameObjects.add(mine2);
                movableGameObjects.add(mine2);
                
                mine3=new MovableGameObject(ResourcesUtils.MINE, mineWidth, 
                    mineHeight, islandWidth+50,50, islandWidth, ResourcesUtils.GAME_WIDTH-islandWidth-mineWidth, 0, 
                    ResourcesUtils.GAME_HEIGHT-mineHeight);
                mine3.setMover(new Thread(new Runnable(){
                    @Override
                    public void run(){
                        while(true){
                            mine3.randMove(step);
                            try{
                                Thread.sleep(threadSleepTime);
                            }
                            catch(InterruptedException e){
                                e.printStackTrace();
                            }
                            try{
                                updateUI(gameObjects);
                            }
                            catch(RemoteException e){
                                e.printStackTrace();
                            }
                        }
                    }
                    }));
                mine3.startMoving();
                gameObjects.add(mine3);
                movableGameObjects.add(mine3);
                break;
            }
            case 5:{
                mine1=new MovableGameObject(ResourcesUtils.MINE, mineWidth, 
                    mineHeight, islandWidth+50,50, islandWidth, ResourcesUtils.GAME_WIDTH-islandWidth-mineWidth, 0, 
                    ResourcesUtils.GAME_HEIGHT-mineHeight);
                mine1.setMover(new Thread(new Runnable(){
                    @Override
                    public void run(){
                        while(true){
                            mine1.randMove(step);
                            try{
                                Thread.sleep(threadSleepTime);
                            }
                            catch(InterruptedException e){
                                e.printStackTrace();
                            }
                            try{
                                updateUI(gameObjects);
                            }
                            catch(RemoteException e){
                                e.printStackTrace();
                            }
                        }
                    }
                    }));
                mine1.startMoving();
                gameObjects.add(mine1);
                movableGameObjects.add(mine1);
                
                mine2=new MovableGameObject(ResourcesUtils.MINE, mineWidth, 
                    mineHeight, islandWidth+50,50, islandWidth, ResourcesUtils.GAME_WIDTH-islandWidth-mineWidth, 0, 
                    ResourcesUtils.GAME_HEIGHT-mineHeight);
                mine2.setMover(new Thread(new Runnable(){
                    @Override
                    public void run(){
                        while(true){
                            mine2.randMove(step);
                            try{
                                Thread.sleep(threadSleepTime);
                            }
                            catch(InterruptedException e){
                                e.printStackTrace();
                            }
                            try{
                                updateUI(gameObjects);
                            }
                            catch(RemoteException e){
                                e.printStackTrace();
                            }
                        }
                    }
                    }));
                mine2.startMoving();
                gameObjects.add(mine2);
                movableGameObjects.add(mine2);
                
                mine3=new MovableGameObject(ResourcesUtils.MINE, mineWidth, 
                    mineHeight, islandWidth+50,50, islandWidth, ResourcesUtils.GAME_WIDTH-islandWidth-mineWidth, 0, 
                    ResourcesUtils.GAME_HEIGHT-mineHeight);
                mine3.setMover(new Thread(new Runnable(){
                    @Override
                    public void run(){
                        while(true){
                            mine3.randMove(step);
                            try{
                                Thread.sleep(threadSleepTime);
                            }
                            catch(InterruptedException e){
                                e.printStackTrace();
                            }
                            try{
                                updateUI(gameObjects);
                            }
                            catch(RemoteException e){
                                e.printStackTrace();
                            }
                        }
                    }
                    }));
                mine3.startMoving();
                gameObjects.add(mine3);
                movableGameObjects.add(mine3);
                
                mine4=new MovableGameObject(ResourcesUtils.MINE, mineWidth, 
                    mineHeight, islandWidth+50,50, islandWidth, ResourcesUtils.GAME_WIDTH-islandWidth-mineWidth, 0, 
                    ResourcesUtils.GAME_HEIGHT-mineHeight);
                mine4.setMover(new Thread(new Runnable(){
                    @Override
                    public void run(){
                        while(true){
                            mine4.randMove(step);
                            try{
                                Thread.sleep(threadSleepTime);
                            }
                            catch(InterruptedException e){
                                e.printStackTrace();
                            }
                            try{
                                updateUI(gameObjects);
                            }
                            catch(RemoteException e){
                                e.printStackTrace();
                            }
                        }
                    }
                    }));
                mine4.startMoving();
                gameObjects.add(mine4);
                movableGameObjects.add(mine4);
                
                mine5=new MovableGameObject(ResourcesUtils.MINE, mineWidth, 
                    mineHeight, islandWidth+50,50, islandWidth, ResourcesUtils.GAME_WIDTH-islandWidth-mineWidth, 0, 
                    ResourcesUtils.GAME_HEIGHT-mineHeight);
                mine5.setMover(new Thread(new Runnable(){
                    @Override
                    public void run(){
                        while(true){
                            mine5.randMove(step);
                            try{
                                Thread.sleep(threadSleepTime);
                            }
                            catch(InterruptedException e){
                                e.printStackTrace();
                            }
                            try{
                                updateUI(gameObjects);
                            }
                            catch(RemoteException e){
                                e.printStackTrace();
                            }
                        }
                    }
                    }));
                mine5.startMoving();
                gameObjects.add(mine5);
                movableGameObjects.add(mine5);
                break;
            }
        }
        
        island1 = new StaticGameObject(ResourcesUtils.ISLAND, islandWidth, islandHeight, 0, (ResourcesUtils.GAME_HEIGHT/2)-(islandHeight/2));
        island2 = new StaticGameObject(ResourcesUtils.ISLAND, islandWidth, islandHeight, ResourcesUtils.GAME_WIDTH-islandWidth, (ResourcesUtils.GAME_HEIGHT/2)-(islandHeight/2));
        islandGold= new StaticGameObject(ResourcesUtils.GOLD, goldWidth, goldHeight, (ResourcesUtils.GAME_WIDTH)-(islandWidth/2)-(goldWidth/2), (ResourcesUtils.GAME_HEIGHT/2)-(goldHeight/2));
        sea=new StaticGameObject(ResourcesUtils.SEA,ResourcesUtils.GAME_WIDTH,ResourcesUtils.GAME_HEIGHT,0,0);
        goldIconOne=new MovableGameObject (ResourcesUtils.GOLD, goldWidth,goldHeight, 0,0,
                ResourcesUtils.GAME_WIDTH*-1,ResourcesUtils.GAME_WIDTH,ResourcesUtils.GAME_HEIGHT*-1,ResourcesUtils.GAME_HEIGHT);
        goldIconTwo=new MovableGameObject (ResourcesUtils.GOLD, goldWidth,goldHeight, 0,0,
                ResourcesUtils.GAME_WIDTH*-1,ResourcesUtils.GAME_WIDTH,ResourcesUtils.GAME_HEIGHT*-1,ResourcesUtils.GAME_HEIGHT);
        boat1 = new MovableGameObject(ResourcesUtils.BOAT, boatWidth, boatHeight, islandWidth+50, (ResourcesUtils.GAME_HEIGHT/3)-(boatHeight/2),
                islandWidth, ResourcesUtils.GAME_WIDTH-islandWidth, 0, 
                ResourcesUtils.GAME_HEIGHT);
        boat2 = new MovableGameObject(ResourcesUtils.BOAT, boatWidth, boatHeight, islandWidth+50,(2*ResourcesUtils.GAME_HEIGHT/3)-(boatHeight/2), 
                islandWidth, ResourcesUtils.GAME_WIDTH-islandWidth, 0, 
                ResourcesUtils.GAME_HEIGHT);
        boat1Condition=0;boat2Condition=0;
        
        
        boat1.setMover(new Thread(new Runnable(){
            @Override
            public void run(){
                while(true){
                    //boat1.selectMove(step,direction);
                switch (numberOfMines){
                    case 2:{
                        if(boat1.isHit(mine1)|| boat1.isHit(mine2)){
                            System.out.println("Boat 1 is hit by a mine.");
                            try{
                                gameOver();
                            }
                            catch(RemoteException e){
                                e.printStackTrace();
                            }
                        }
                        break;
                    }
                    case 3:{
                        if(boat1.isHit(mine1)|| boat1.isHit(mine2)|| boat1.isHit(mine3)){
                            System.out.println("Boat 1 is hit by a mine.");
                            try{
                                gameOver();
                            }
                            catch(RemoteException e){
                                e.printStackTrace();
                            }
                        }
                        break;
                    }
                    case 5:{
                        if(boat1.isHit(mine1)|| boat1.isHit(mine2)||boat1.isHit(mine3)|| boat1.isHit(mine4)|| boat1.isHit(mine5)){
                            System.out.println("Boat 1 is hit by a mine.");
                            try{
                                gameOver();
                            }
                            catch(RemoteException e){
                                e.printStackTrace();
                            }
                        }
                        break;
                    }
                }
                if(boat1.isHit(boat2)){
                    System.out.println("Boats crashed into each other");
                    try{
                        gameOver();
                    }
                    catch(RemoteException e){
                        e.printStackTrace();
                    }
                }
                
                
                try{
                    Thread.sleep(threadSleepTime);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                
                }
            }
        }));
        boat1.startMoving();

        boat2.setMover(new Thread(new Runnable(){
            @Override
            public void run(){
                //boat2.selectMove(step,direction);
                while(true){
                    switch (numberOfMines){
                    case 2:{
                        if(boat2.isHit(mine1)|| boat2.isHit(mine2)){
                            System.out.println("Boat 2 is hit by a mine.");
                            try{
                                gameOver();
                            }
                            catch(RemoteException e){
                                e.printStackTrace();
                            }
                        }
                        break;
                    }
                    case 3:{
                        if(boat2.isHit(mine1)|| boat2.isHit(mine2)|| boat2.isHit(mine3)){
                            System.out.println("Boat 2 is hit by a mine.");
                            try{
                                gameOver();
                            }
                            catch(RemoteException e){
                                e.printStackTrace();
                            }
                        }
                        break;
                    }
                    case 5:{
                        if(boat2.isHit(mine1)|| boat2.isHit(mine2)||boat2.isHit(mine3)|| boat2.isHit(mine4)|| boat2.isHit(mine5)){
                            System.out.println("Boat 2 is hit by a mine.");
                            try{
                                gameOver();
                            }
                            catch(RemoteException e){
                                e.printStackTrace();
                            }
                        }
                        break;
                    }
                }
                if(boat2.isHit(boat1)){
                    System.out.println("Boats crashed into each other");
                    try{
                        gameOver();
                    }
                    catch(RemoteException e){
                        e.printStackTrace();
                    }
                }
                try{
                    Thread.sleep(threadSleepTime);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                
                
                }
                
            }
        }));
        
        boat2.startMoving();
        
        goldIconOne.setMover(new Thread(new Runnable(){
            @Override
            public void run(){
                while(true){
                    switch(boat1Condition){ //goldUnloaded=0,loadingGold=1,GoldLoaded=2,unloadingGold=3
                    case 0:{ //unloaded
                        if(goldOnBoat1>0){ //still has gold
                            goldIconOne.setPosX(boat1.getPosX());goldIconOne.setPosY(boat1.getPosY());
                            if(boat1.getPosX()-(2*step)<=boat1.getXMinBound()){ //unloading
                                timeStampUnloadBoat1Start=Instant.now();
                                boat1Condition=3;
                            }
                        }
                        else{
                            goldIconOne.setPosX(-100);goldIconOne.setPosY(-100);
                        }
                        if(boat1.getPosX()+boat1.getWidth()+(2*step)>=boat1.getXMaxBound()){ //starting to load
                            timeStampLoadBoat1Start= Instant.now();
                            boat1Condition=1;
                        }
                        break;
                    }
                    case 1:{ //loading gold
                        if(goldOnBoat1>0){
                            goldIconOne.setPosX(boat1.getPosX());goldIconOne.setPosY(boat1.getPosY());
                        }
                        if(boat1.getPosX()+boat1.getWidth()+(2*step)<boat1.getXMaxBound()){
                            timeStampLoadBoat1End=Instant.now();
                            Duration duration1=Duration.between(timeStampLoadBoat1Start, timeStampLoadBoat1End);
                            long ms1=duration1.toMillis();
                            if(ms1>=3000){
                                goldOnBoat1++;
                            }
                            else{
                                goldOnBoat1+=(ms1/3000);
                            }
                            goldIconOne.setPosX(boat1.getPosX());goldIconOne.setPosY(boat1.getPosY());
                            boat1Condition=2;
                        }
                        break;
                    }
                    case 2:{ //gold loaded
                        goldIconOne.setPosX(boat1.getPosX());goldIconOne.setPosY(boat1.getPosY());
                        if(boat1.getPosX()-(2*step)<= boat1.getXMinBound()){ //started unloading
                            timeStampUnloadBoat1Start=Instant.now();
                            boat1Condition=3;
                        }
                        break;
                    }
                    case 3:{ //unloadingGold
                        goldIconOne.setPosX(boat1.getPosX());goldIconOne.setPosY(boat1.getPosY());
                        if(boat1.getPosX()-(2*step)>boat1.getXMinBound()){
                            timeStampUnloadBoat1End=Instant.now();
                            Duration duration2=Duration.between(timeStampUnloadBoat1Start, timeStampUnloadBoat1End);
                            long ms2=duration2.toMillis();
                            if(ms2>=3000){
                                goldUnloadedBoat1+=goldOnBoat1;
                                goldOnBoat1=0;
                            }
                            else{
                                goldUnloadedBoat1+=(ms2/3000)*goldOnBoat1;
                                goldOnBoat1-=goldUnloadedBoat1;
                            }
                            boat1Condition=0;
                        }
                        break;
                    }
                }
                if(goldUnloadedBoat1>=3){
                    System.out.println("Boat 1 wins.");
                    try{
                        gameOver();
                    }
                    catch(RemoteException e){
                        e.printStackTrace();
                    }
                }
                try{
                    updateUI(gameObjects);
                }
                catch(RemoteException e){
                    e.printStackTrace();
                }
                }
            }
            
        }));
        goldIconOne.startMoving();
        
        goldIconTwo.setMover(new Thread(new Runnable(){
            @Override
            public void run(){
                while(true){
                    switch(boat2Condition){ //goldUnloaded=0,loadingGold=1,GoldLoaded=2,unloadingGold=3
                    case 0:{ //unloaded
                        if(goldOnBoat2>0){ //stil has gold
                            goldIconTwo.setPosX(boat2.getPosX());goldIconTwo.setPosY(boat2.getPosY());
                            if(boat2.getPosX()-(2*step)<=boat2.getXMinBound()){//unloading
                                timeStampUnloadBoat2Start=Instant.now();
                                boat2Condition=3;
                            }
                        }
                        else{//no gold on boat
                            goldIconTwo.setPosX(-100);goldIconTwo.setPosY(-100);
                        }
                        if(boat2.getPosX()+boat2.getWidth()+(2*step)>=boat2.getXMaxBound()){ //started loading
                            timeStampLoadBoat2Start= Instant.now();
                            boat2Condition=1;
                        }
                        break;
                    }
                    case 1:{ //loading gold
                        if(goldOnBoat2>0){
                            goldIconTwo.setPosX(boat2.getPosX());goldIconTwo.setPosY(boat2.getPosY());
                        }
                        if(boat2.getPosX()+boat2.getWidth()+(2*step)<boat2.getXMaxBound()){ //stopped loading
                            timeStampLoadBoat2End=Instant.now();
                            Duration duration1=Duration.between(timeStampLoadBoat2Start, timeStampLoadBoat2End);
                            long ms1=duration1.toMillis();
                            if(ms1>=3000){
                                goldOnBoat2++;
                            }
                            else{
                                goldOnBoat2+=(ms1/3000);
                            }
                            goldIconTwo.setPosX(boat2.getPosX());goldIconTwo.setPosY(boat2.getPosY());
                            boat2Condition=2;
                        }
                        break;
                    }
                    case 2:{ //gold loaded
                        goldIconTwo.setPosX(boat2.getPosX());goldIconTwo.setPosY(boat2.getPosY());
                        if(boat2.getPosX()-(2*step)<= boat2.getXMinBound()){//started unloading
                            timeStampUnloadBoat2Start=Instant.now();
                            boat2Condition=3;
                        }
                        break;
                    }
                    case 3:{ //unloadingGold
                        goldIconTwo.setPosX(boat2.getPosX());goldIconTwo.setPosY(boat2.getPosY());
                        if(boat2.getPosX()-(2*step)>boat2.getXMinBound()){//stopped unloading
                            timeStampUnloadBoat2End=Instant.now();
                            Duration duration2=Duration.between(timeStampUnloadBoat2Start, timeStampUnloadBoat2End);
                            long ms2=duration2.toMillis();
                            if(ms2>=3000){
                                goldUnloadedBoat2+=goldOnBoat2;
                                goldOnBoat2=0;
                            }
                            else{
                                goldUnloadedBoat2+=(ms2/3000)*goldOnBoat2;
                                goldOnBoat2-=goldUnloadedBoat2;
                            }
                            boat2Condition=0;
                        }
                        break;
                    }
                }
                if(goldUnloadedBoat2>=3){
                    System.out.println("Boat 2 wins.");
                    try{
                        gameOver();
                    }
                    catch(RemoteException e){
                        e.printStackTrace();
                    }
                }
                try{
                    updateUI(gameObjects);
                }
                catch(RemoteException e){
                    e.printStackTrace();
                }
                }
            }
        }));
        goldIconTwo.startMoving();
        
        
        gameObjects.add(goldIconOne);
        gameObjects.add(goldIconTwo);
        gameObjects.add(islandGold);
        gameObjects.add(island1);
        gameObjects.add(island2);
        gameObjects.add(boat1);
        gameObjects.add(boat2);
        movableGameObjects.add(goldIconOne);
        movableGameObjects.add(goldIconTwo);
        movableGameObjects.add(boat1);
        movableGameObjects.add(boat2);
        gameObjects.add(sea);
	updateUI(gameObjects);
    }
    
    private void updateUI ( List<GameObject> objs) throws RemoteException{
        for(String name : server.getConnections().keySet()){
            server.getConnections().get(name).drawToScene(objs);
            server.getConnections().get(name).refreshScene();
        }	
    }
    
        
    private void updateUI(GameObject obj) throws RemoteException{
        for(String name:server.getConnections().keySet()){
            server.getConnections().get(name).drawToScene(obj);
            server.getConnections().get(name).refreshScene();
        }
    }
        
    
    public void selectMove(int playerId, int direction) throws RemoteException{
        if(playerId==1){
            boat1.selectMove(step, direction);
        }
        else{
            boat2.selectMove(step, direction);
        }
    }
    
    
    /*public void moveBoat(int playerId, int direction) throws RemoteException{
       if(playerId==1){
            
       }
       else{
           
       }
       updateUI(gameObjects);
    }*/
    
    
    public void gameOver() throws RemoteException{
        System.out.println("The game over is called..");
        for(MovableGameObject obj:movableGameObjects){
            obj.suspendMoving();
            for(String name : server.getConnections().keySet()){
                server.getConnections().get(name).gameOver();
            }
        }
        for(String name : server.getConnections().keySet()){
            server.getConnections().get(name).gameOver();
        }
    }
}

