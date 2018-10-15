/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverrunnable;
import java.io.Serializable;
import java.rmi.Remote;

import javax.swing.ImageIcon;
/**
 *
 * @author ahmedkoptanmacbook
 */
public class GameObject implements Serializable{
    private static final long serialVersionUID = -2638673174925301584L;
    private ImageIcon icon;
    private int width;
    private int height;
    private int posX;
    private int posY;
    
    public GameObject(){
        super();
    }
    public GameObject(String iconURL, int width, int height, int posX, int posY){
        super();
        System.out.println(this.getClass().getResource(iconURL));
        this.icon= new ImageIcon(this.getClass().getResource(iconURL));
        this.width=width;
        this.height=height;
        this.posX=posX;
        this.posY=posY;
    }
    
    public ImageIcon getIcon(){
        return icon;
    }
    
    public void setIcon(ImageIcon icon){
        this.icon= icon;
    }
    
    public int getWidth() {
    	return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }

    public int getPosX() {
        return posX;
    }
    
    public void setPosX(int posX) {
        this.posX = posX;
    }
    
    public int getPosY() {
        return posY;
    }
    
    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
	int result = 1;
        result = prime * result + height;
	result = prime * result + posX;
        result = prime * result + posY;
	result = prime * result + width;
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GameObject other = (GameObject) obj;
        if (height != other.height)
            return false;
        if (posX != other.posX)
            return false;
        if (posY != other.posY)
            return false;
        if (width != other.width)
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "GameObject [width=" + width + ", height=" + height + ", posX=" + posX + ", posY=" + posY + "]";
    }
    
    
}
