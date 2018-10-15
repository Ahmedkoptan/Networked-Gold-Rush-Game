/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverrunnable;
import java.awt.Rectangle;
import java.io.Serializable;
import java.security.SecureRandom;
/**
 *
 * @author ahmedkoptanmacbook
 */
public class MovableGameObject extends GameObject implements Hittable, Movable, Serializable{
    
    private static final long serialVersionUID = -6286372472399398027L;
    private static SecureRandom rand= new SecureRandom();
    private int xMinBound;
    private int xMaxBound;  
    private int yMinBound;
    private int yMaxBound;
    
    private int direction=0;
    
    private int dx;
    private int dy;
    
    public static final int Move_X=2;
    public static final int Move_Y=0;
    public static final int Move_XY=1;
    
    private transient Thread mover;
    
    public MovableGameObject(String iconURL, int width, int height, int posX, int posY, int xMinBound, int xMaxBound,
			int yMinBound, int yMaxBound){
        super(iconURL,width,height,posX,posY);
        this.xMaxBound=xMaxBound;
        this.yMaxBound=yMaxBound;
        this.xMinBound=xMinBound;
        this.yMinBound=yMinBound;
        dx=1;
        dy=1;
    }
    
    public Thread getMover(){
        return mover;
    }
    
    public void setMover(Thread mover){
        this.mover=mover;
    }
    
    public void startMoving(){
        this.getMover().start();
    }
    
    public void suspendMoving(){
        this.getMover().suspend();
    }
    
    public void resumeMoving(){
        this.getMover().resume();
    }
    private void setDx(int dx){
        this.dx=dx;
    }
    private void setDy(int dy){
        this.dy=dy;
    }
    private int getDx(){
        return dx;
    }
    private int getDy(){
        return dy;
    }
    public int getXMaxBound(){
        return xMaxBound;
    }
    public int getXMinBound(){
        return xMinBound;
    }
    public int getYMaxBound(){
        return yMaxBound;
    }
    public int getYMinBound(){
        return yMinBound;
    }
    
    
    private void moveX(int step){
        if((getPosX()+getWidth()+(step* getDx()))>xMaxBound || (getPosX()+(step* getDx())<xMinBound)){
            setPosX(getPosX());
        }   
        else
            setPosX(getPosX()+(step* getDx()));
    }
    private void moveY(int step){
        if((getPosY()+getHeight()+(step* getDy()))> yMaxBound || (getPosY()+(step* getDy())<yMinBound)){
            setPosY(getPosY());
        }
        else
            setPosY(getPosY()+(step* getDy()));
    }
    
    private void moveXY(int step){
        moveX(step);
        moveY(step);
    }
    public void randMove(int step){
        direction=rand.nextInt(3);
        int x=rand.nextInt(2); int y=rand.nextInt(2);
        if(x==0){
            setDx(-1);
        }
        else{
            setDx(1);
        }
        if(y==0){
            setDy(-1);
        }
        else{
            setDy(1);
        }
        move(step);
    }
    public void selectMove(int step, int d){
        switch(d){
            case 0: {
                setDx(-1);
                moveX(step);
                break;
            }
            case 1:{
                setDx(1);
                moveX(step);
                break;
            }
            case 2:{
                setDy(1);
                moveY(step);
                break;
            }
            case 3:{
                setDy(-1);
                moveY(step);
                break;
            }
        }
    }
    @Override
    public void move(int step){
        if(direction==MovableGameObject.Move_X){
            moveX(step);
        }
        else if(direction==MovableGameObject.Move_Y){
            moveY(step);
        }
        else if(direction== MovableGameObject.Move_XY){
            moveXY(step);
        }
        
    }
    
    @Override
    public boolean isHit(GameObject obj){
        Rectangle rect1= new Rectangle(getPosX(),getPosY(),getWidth(),getHeight());
        Rectangle rect2= new Rectangle(obj.getPosX(),obj.getPosY(),obj.getWidth(),obj.getHeight());
        return rect1.intersects(rect2);
    }
    
    
    
}
