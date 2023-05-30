import java.lang.Thread;

public class App {
    

    
    public static void main(String[] args){

        Visuals v = new Visuals();
        KeyBinder k = new KeyBinder(v);
        v.frame.addKeyListener(k);

        PlayerMovement p = new PlayerMovement(v, k);
        BallMovement b = new BallMovement(v);
        ScoreManager s = new ScoreManager(v, b);


        Thread playerMovement = new Thread(p);
        Thread ballMovement = new Thread(b);
        Thread scoreManager = new Thread(s);

        playerMovement.start();
        ballMovement.start();
        scoreManager.start();   

    }
}
