/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverrunnable;
import java.io.Serializable;
/**
 *
 * @author ahmedkoptanmacbook
 */
public class StaticGameObject extends GameObject implements Hittable, Serializable{
    
    private static final long serialVersionUID = 4136574207441726112L;
    
    public StaticGameObject(String iconURL, int posX, int posY, int width, int height){
        super(iconURL,posX,posY,width,height);
    }
    
    @Override
    public boolean isHit(GameObject obj){
        return false;
    }
}
