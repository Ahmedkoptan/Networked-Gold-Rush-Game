/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverrunnable;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author ahmedkoptanmacbook
 */
public class GameView extends JFrame implements KeyListener, Serializable{
    
    private static final long serialVersionUID = 7526509833400624229L;
    private JPanel scene;
    private PlayerInt playerInt;
    private static boolean gameOver=false;
    //private JLabel seaLabel= new JLabel(new ImageIcon(this.getClass().getResource(ResourcesUtils.SEA)));
    
    public GameView(String title, int width, int height){
        super(title);
        setSize(width,height);
        
        scene=new JPanel();
        scene.setLayout(null);
        add(scene);
        
        addKeyListener(this);
        setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public PlayerInt getPlayerInt(){
        return playerInt;
    }
    
    public void setPlayerInt(PlayerInt playerInt){
        this.playerInt=playerInt;
    }
    
    public void refreshScene(){
        revalidate();
        repaint();
    }
    
    public void setScenebackground(){
        scene.setBackground(Color.white);
    }
    
    public void showScene(){
        setVisible(true);
    }
    
    public void drawToScene(List<GameObject> gameobjects){
        if(!gameOver){
            scene.removeAll();
            for(GameObject obj:gameobjects){
                JLabel label= new JLabel(obj.getIcon());
                label.setBounds(obj.getPosX(), obj.getPosY(), obj.getWidth(), obj.getHeight());
                scene.add(label);
            }
        }
    }
    
    public void drawToSceneM(List<MovableGameObject> gameobjects){
        if(!gameOver){
            scene.removeAll();
            for(GameObject obj:gameobjects){
                JLabel label= new JLabel(obj.getIcon());
                label.setBounds(obj.getPosX(), obj.getPosY(), obj.getWidth(), obj.getHeight());
                scene.add(label);
            }
        }
    }
    
    
    public void drawToScene(GameObject obj){
        JLabel lbl= new JLabel(obj.getIcon());
        lbl.setBounds(obj.getPosX(), obj.getPosY(), obj.getWidth(), obj.getHeight());
        scene.add(lbl);
    }
    
    
    
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_LEFT &&!gameOver){
            try{
                getPlayerInt().selectMove(0);
            }
            catch(RemoteException e1){
                e1.printStackTrace();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT&&!gameOver){
            try{
                getPlayerInt().selectMove(1);
            }
            catch(RemoteException e1){
                e1.printStackTrace();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN&&!gameOver){
            try{
                getPlayerInt().selectMove(2);
            }
            catch(RemoteException e1){
                e1.printStackTrace();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_UP&&!gameOver){
            try{
                getPlayerInt().selectMove(3);
            }
            catch(RemoteException e1){
                e1.printStackTrace();
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        
    }
    
    @Override
    public void keyTyped(KeyEvent e){
        
    }
    
    public void showGameOver(){
        gameOver=true;
        scene.removeAll();
        scene.setBackground(Color.white);
        ImageIcon icon= new ImageIcon(this.getClass().getResource(ResourcesUtils.GAMEOVER_IMG));
        JLabel lbl= new JLabel(icon); int w=200; int h=200;
        lbl.setBounds((ResourcesUtils.GAME_WIDTH/2)-(w/2), (ResourcesUtils.GAME_HEIGHT/2)-(h/2), w, h);
        scene.add(lbl);
        refreshScene();
    }
    
}

