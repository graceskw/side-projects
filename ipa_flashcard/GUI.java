import java.awt.*;
import javax.swing.*;
// import javax.swing.JFrame;
// import javax.swing.JPanel;
// import javax.swing.JLabel;
// import javax.swing.JOptionPane;

public class GUI {
    int mode;
    int symbolSet;

    JFrame frame;
    JPanel flashcard;
    JPanel options;

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem restart;
    JMenuItem quit;
    
    public GUI(){
        // to choose the mode
        String[] modeOptions = new String[]{"IPA to description", "Description to IPA"};
        this.mode = JOptionPane.showOptionDialog(null, "Please choose desired mode:", "Mode",
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, modeOptions, modeOptions[0]);        // this.mode.showOptionDialog(null, "Please choose desired mode:",

        // to choose the symbol set
        String[] symbolSetOptions = new String[]{"Vowels", "Pulmonic consonants", "Vowels and Consonants"};
        this.symbolSet = JOptionPane.showOptionDialog(null, "Please choose desired IPA symbol set:", "IPA symbol set",
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, symbolSetOptions, symbolSetOptions[0]);        // this.mode.showOptionDialog(null, "Please choose desired mode:",

        this.frame = new JFrame("IPA Flashcard");
        // this.flashcard = new JPanel();
        // this.options = new JPanel();
        this.menuBar = new JMenuBar();
        this.menu = new JMenu("Menu");
        this.restart = new JMenuItem("Restart progress");
        this.quit = new JMenuItem("Quit");
        this.menu.add(restart);
        this.menu.add(quit);
        this.menuBar.add(menu);
        this.frame.setJMenuBar(menuBar);
    }
    
    
    
    public class FlashcardPanel extends JPanel{
        public FlashcardPanel(){
            JLabel label = new JLabel("IPA Flashcard");
            this.add(label);
            if(mode == 0){
                // show IPA symbol
                if(symbolSet == 0){
                    // show vowel symbol
                }
                else if(symbolSet == 1){
                    // show consonant symbol
                }
                else if(symbolSet == 2){
                    // show vowel and consonant symbol
                }
            }
            else if(mode == 1){
                // show description
                if(symbolSet == 0){
                    // show vowel description
                }
                else if(symbolSet == 1){
                    // show consonant description
                }
                else if(symbolSet == 2){
                    // show vowel and consonant description
                }
            }
        }

        // paint component method
    }
    
    public class OptionsPanel extends JPanel{
        public OptionsPanel(){
            if(mode == 0){
                // show description
                if(symbolSet == 0){
                    // show vowel description
                }
                else if(symbolSet == 1){
                    // show consonant description
                }
                else if(symbolSet == 2){
                    // show vowel and consonant description
                }
            }
            else if(mode == 1){
                // show IPA symbol
                if(symbolSet == 0){
                    // show vowel symbol
                }
                else if(symbolSet == 1){
                    // show consonant symbol
                }
                else if(symbolSet == 2){
                    // show vowel and consonant symbol
                }
            }

            // flow layout for the options user can choose
            // how many buttons depends on the symbol set chosen
            // button labels are in text file
        }

        // paint component method
    }

// for debugging
    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
