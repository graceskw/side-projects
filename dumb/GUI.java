import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.lang.Math;

public class GUI{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Are you dumb?");
    JButton yes = new JButton("Yes");
    JButton no = new JButton("No");

    public GUI(){
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        panel.add(label, c);
        yes.setSize(10,5);
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        panel.add(yes, c);
        no.setSize(10,5);
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1;
        panel.add(no, c);
        yes.addActionListener(new YesButton());
        no.addActionListener(new NoButton());
       
    }

    public class NoButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            no.setLocation((int) (Math.random()*frame.getWidth()), (int) (Math.random()*frame.getHeight()));
        }
    }

    public class YesButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            yes.setVisible(false);
            no.setVisible(false);
            label.setText("Good to know :)))))))");
            panel.add(label);
        }
    }

    public static void main(String[] args){
        GUI gui = new GUI();
    }
}