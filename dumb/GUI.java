import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;

public class GUI{
    JFrame frame = new JFrame("Are you dumb?");
    JPanel panel = new JPanel();
    JButton yes = new JButton("Yes");
    JButton no = new JButton("No");

    public GUI(){
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        panel.add(yes);
        panel.add(no);
        no.setLocation((int) Math.random()*frame.getWidth(), );
    }

    public class NoButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            no.setLocation((int) Math.random()*frame.getWidth(), (int) Math.random()*frame.getHeight());
        }
    }

    public class YesButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            yes.setVisible(false);
            no.setVisible(false);
            JLabel label = new JLabel("Good to know :)))))))");
            panel.add(label);
            // JDialog dialog = new JDialog(frame, "Good to know :)))))))");
        }
    }

    public static void main(String[] args){
        GUI gui = new GUI();
        gui.panel.add(gui.yes);
        gui.panel.add(gui.no);
        gui.yes.addActionListener(gui.new YesButton());
        gui.no.addActionListener(gui.new NoButton());
    }
}