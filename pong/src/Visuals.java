import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Visuals {
    
    public JFrame frame = new JFrame("Pong");

    JPanel block1 = new JPanel();
    JPanel block2 = new JPanel();
    JPanel ball = new JPanel();
    JLabel score = new JLabel("0 - 0");


    public Visuals(){

        initFrame();
        initComponents();

    }

    public void initFrame(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBounds(140, 40, 900, 600);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.black);

    }

    public void initComponents(){

        frame.add(block1);
        block1.setLayout(null);
        block1.setBackground(Color.white);
        block1.setBounds(40, 250-15, 10, 100);
        block1.setVisible(true);

        frame.add(block2);
        block2.setLayout(null);
        block2.setBackground(Color.white);
        block2.setBounds(830, 250-15, 10, 100);
        block2.setVisible(true);

        frame.add(ball);
        ball.setLayout(null);
        ball.setBackground(Color.white);
        ball.setBounds(53+389, 250+30, 10, 10);
        ball.setVisible(true);

        frame.getContentPane().add(score);
        score.setForeground(Color.white);
        score.setBounds(350, 45, 190, 50);
        score.setHorizontalAlignment(SwingConstants.CENTER);
        score.setFont(new Font("Verdana", Font.BOLD, 50));
        score.setVisible(true);
        
        
    }

    public HashMap<String, JPanel> checkComponents(){
        
        HashMap<String, JPanel> components = new HashMap<String, JPanel>();
        components.put("p1", block1);
        components.put("p2", block2);
        components.put("ball", ball);

        return components;

    }






}
