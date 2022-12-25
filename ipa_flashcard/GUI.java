import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI {
    JFrame frame;
    JPanel flashcard;
    JPanel options;
    
    public void GUI{
        this.frame = new JFrame("IPA Flashcard");
        // this.flashcard = new JPanel();
        // this.options = new JPanel();
    }
    
    
    
    public class FlashcardPanel extends JPanel{
        public FlashcardPanel(){
            JLabel label = new JLabel("IPA Flashcard");
            this.add(label);
        }

        // paint component method
    }
    
    public class OptionsPanel extends JPanel{
        public OptionsPanel(){
            // flow layout for the options user can choose
            // how many buttons depends on the symbol set chosen
            // button labels are in text file
        }

        // paint component method
    }

}
