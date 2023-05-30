import java.util.HashMap;
import java.util.Random;

import javax.swing.JPanel;


class PlayerMovement implements Runnable{

    Visuals v;
    KeyBinder c;


    public PlayerMovement(Visuals view, KeyBinder con){
        this.v=view;
        this.c=con;
    }
    

    
    @Override
    public void run(){
 
        while(true){

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {}

            HashMap<String, Boolean> keys = c.checkKeys(); 

            if(keys.get("w")==true){
                moveUpwards(v.block1);
            }

            if(keys.get("s")==true){
                moveDownwards(v.block1);
            }

            if(keys.get("up")==true){
                moveUpwards(v.block2);
            }

            if(keys.get("down")==true){
                moveDownwards(v.block2);
            }
            
            

        }

    }

    public void moveUpwards(JPanel p){

        if(p.getY()>0)
        p.setBounds(p.getX(), p.getY()-1, 10, 100);

    }
    
    public void moveDownwards(JPanel p){

        if(p.getY()+100<560)
        p.setBounds(p.getX(), p.getY()+1, 10, 100);

    }


}

class BallMovement implements Runnable{


    Visuals v;
    int score1=0, score2=0;

    public BallMovement(Visuals view){
        this.v = view;
    }



    @Override
    public void run() {

        
        while(true){
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {}

            HashMap<String, JPanel> comp = v.checkComponents();

            moveBall(comp.get("ball"), comp.get("p1"), comp.get("p2"));
        }
        
    }
    
    Random r = new Random();

    int xdirection = -1;
    int ydirection = 0;
    int yvector = 0;
    int timeslost = 0;

    public void moveBall(JPanel b, JPanel p1, JPanel p2){



        if(b.getX()<=p1.getX()+10 && b.getX()>p1.getX() && b.getY()>p1.getY()-10 && b.getY()+10<p1.getY()+100+10){
            xdirection=1;

            if(b.getY() > p1.getY()-10 && b.getY() < p1.getY()+p1.getHeight()/2){
                ydirection=-1;
                System.out.println("up");
            }
            if(b.getY() < p1.getY()+100+10 && b.getY() > p1.getY()+p1.getHeight()/2){
                ydirection=1;
                System.out.println("down");
            }
            if(b.getY() > p1.getY()-10 && b.getY() < p1.getY()+33){
                yvector=(r.nextInt(4-2)+2);
                System.out.println("top");
            }
            if(b.getY() >= p1.getY()+33 && b.getY()+10 <= p1.getY()+66){
                yvector=(r.nextInt(2-0)+0);
                System.out.println("mid");
            }
            if(b.getY() > p1.getY()+66 && b.getY() < p1.getY()+99+10){
                yvector=(r.nextInt(4-2)+2);
                System.out.println("bot");
            }

        }

        if(b.getX()+10>=p2.getX() && b.getX()+10<p2.getX()+10 && b.getY()>p2.getY()-10 && b.getY()+10<p2.getY()+100+10){
            xdirection=-1;

            if(b.getY() > p1.getY()-10 && b.getY() < p1.getY()+p1.getHeight()/2){
                ydirection=-1;
                System.out.println("up");
            }
            if(b.getY() < p1.getY()+100+10 && b.getY() > p1.getY()+p1.getHeight()/2){
                ydirection=1;
                System.out.println("down");
            }
            if(b.getY() > p1.getY()-10 && b.getY() < p1.getY()+33){
                yvector=(r.nextInt(4-2)+2);
                System.out.println("top");
            }
            if(b.getY() >= p1.getY()+33 && b.getY()+10 <= p1.getY()+66){
                yvector=(r.nextInt(2-1)+1);
                System.out.println("mid");
            }
            if(b.getY() > p1.getY()+66 && b.getY() < p1.getY()+99+10){
                yvector=(r.nextInt(4-2)+2);
                System.out.println("bot");
            }


        }

        if(b.getY()<=0){
            System.out.println("top wall");
            ydirection*=-1;
        }
        if(b.getY()+10>=560){
            System.out.println("bottom wall");
            ydirection*=-1;
        }
        if(b.getX()<-450){
            System.out.println("left");
            b.setBounds(442, 280, 10, 10);
            xdirection = timeslost%2==0 ? 1 : -1;
            ydirection = timeslost%3==0 ? 1 : -1;
            yvector= r.nextInt(3-1)+1;
            timeslost++;
            score2++;
        }
        if(b.getX()>1350){
            System.out.println("right");
            b.setBounds(442, 280, 10, 10);
            xdirection = timeslost%2==0 ? 1 : -1;
            ydirection = timeslost%3==0 ? 1 : -1;
            yvector= r.nextInt(3-1)+1;
            timeslost++;
            score1++;
        }
        

        b.setBounds(b.getX()+3*xdirection, b.getY()+yvector*ydirection, 10, 10);

    }


    public HashMap<String, Integer> checkScore(){

        HashMap<String, Integer> scores = new HashMap<String, Integer>();
        scores.put("s1", score1);
        scores.put("s2", score2);

        return scores;

    }

}

class ScoreManager implements Runnable{

    Visuals v;
    BallMovement b;

    public ScoreManager(Visuals view, BallMovement b){
        this.v=view;
        this.b=b;

    }



    @Override
    public void run() {

        while(true){

            HashMap<String, Integer> scores = b.checkScore();

            editScores(scores.get("s1"), scores.get("s2"));

            
        }
        
    }

    public void editScores(int s1, int s2){
        v.score.setText(String.valueOf(s1) + " - " + String.valueOf(s2));
    }

    public void checkIfSomeoneWon(){

    }

}
