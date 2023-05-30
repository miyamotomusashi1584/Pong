import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class KeyBinder implements KeyListener{

    public KeyBinder(Visuals view){
        
    }

    boolean wKey=false, sKey=false, upKey=false, downKey=false;


    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W){
            System.out.println("W is pressed");
            wKey=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_S){
            System.out.println("S is pressed");
            sKey=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_UP){
            System.out.println("UP is pressed");
            upKey=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            System.out.println("DOWN is pressed");
            downKey=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W){
            System.out.println("W is released");
            wKey=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_S){
            System.out.println("S is released");
            sKey=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_UP){
            System.out.println("UP is released");
            upKey=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            System.out.println("DOWN is released");
            downKey=false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    
    public HashMap<String, Boolean> checkKeys(){
        
        HashMap<String, Boolean> keys = new HashMap<String, Boolean>();
        keys.put("w", wKey);
        keys.put("s", sKey);
        keys.put("up", upKey);
        keys.put("down", downKey);

        return keys;
    }



}
