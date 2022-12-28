import java.awt.*;
import javax.swing.*;
// import javax.swing.JFrame;
// import javax.swing.JPanel;
// import javax.swing.JLabel;
// import javax.swing.JOptionPane;

public class GUI {
    int mode;
    int symbolSet;

    private JFrame frame;
    private JPanel flashcardPanel;
    private JPanel optionPanel;
    private JPanel buttonPanel;

    private JButton confirmButton;
    private JButton skipButton;
    private JButton cancelButton;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem restart;
    private JMenuItem quit;
    
    public GUI(){
        // to choose the mode
        String[] modeOptions = new String[]{"IPA to description", "Description to IPA"};
        this.mode = JOptionPane.showOptionDialog(null, "Please choose desired mode:", "Mode",
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, modeOptions, modeOptions[0]);        // this.mode.showOptionDialog(null, "Please choose desired mode:",

        // to choose the symbol set
        String[] symbolSetOptions = new String[]{"Vowels", "Pulmonic consonants", "Vowels and Consonants"};
        this.symbolSet = JOptionPane.showOptionDialog(null, "Please choose desired IPA symbol set:", "IPA symbol set",
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, symbolSetOptions, symbolSetOptions[0]);        // this.mode.showOptionDialog(null, "Please choose desired mode:",
        
        this.frame = new JFrame();
        // set frame title according to mode and symbol set
        if(mode == 0){ // IPA to description
            if(symbolSet == 0) frame.setTitle("IPA Flashcard: Vowel to description");
            else if(symbolSet == 1) frame.setTitle("IPA Flashcard: Pulmonic consonant to description");
            else if(symbolSet == 2) frame.setTitle("IPA Flashcard: Vowel or consonant to description");
        }
        else if(mode == 1){ // description to IPA
            if(symbolSet == 0) frame.setTitle("IPA Flashcard: Description to vowel");            
            else if(symbolSet == 1)frame.setTitle("IPA Flashcard: Description to pulmonic consonant");
            else if(symbolSet == 2)frame.setTitle("IPA Flashcard: Description to vowel or consonant");
        }
        
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(800, 600);

        // create menu
        this.menuBar = new JMenuBar();
        this.menu = new JMenu("Menu");
        this.restart = new JMenuItem("Restart progress");
        this.quit = new JMenuItem("Quit");
        this.menu.add(restart);
        this.menu.add(quit);
        this.menuBar.add(menu);
        this.frame.setJMenuBar(menuBar);

// use gridbaglayout for the panels in the frame
        this.frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.flashcardPanel = new FlashcardPanel();
            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 1;
            c.gridheight = 5;
        this.frame.add(flashcardPanel);

        this.optionPanel = new OptionPanel();
            c.gridx = 0;
            c.gridy = 5;
            c.gridwidth = 1;
            c.gridheight = 3;
        this.frame.add(optionPanel);
        
        // create buttonPanel and create+add confirm, cancel, and skip buttons
        this.buttonPanel = new JPanel();
        this.buttonPanel.setLayout(new GridLayout(1, 3));
        confirmButton = new JButton("Confirm");
        cancelButton = new JButton("Cancel");
        skipButton = new JButton("Skip");
        this.buttonPanel.add(confirmButton);
        this.buttonPanel.add(cancelButton);
        this.buttonPanel.add(skipButton);
            c.gridx = 0;
            c.gridy = 8;
            c.gridwidth = 1;
            c.gridheight = 2;
        this.frame.add(buttonPanel);
        
        

        this.frame.setVisible(true);
    }
    
    
    
    public class FlashcardPanel extends JPanel{
        public FlashcardPanel(){
            flashcardPanel = new JPanel();
            flashcardPanel.setLayout(new BorderLayout());
            if(mode == 0){
                // show IPA symbol
                if(symbolSet == 0){
                    // show vowel symbol
                }
                else if(symbolSet == 1){
                    // show consonant symbol
                    // to be implemented
                }
                else if(symbolSet == 2){
                    // show vowel and consonant symbol
                    // to be implemented
                }
            }
            else if(mode == 1){
                // show description
                if(symbolSet == 0){
                    // show vowel description
                    // to be implemented
                }
                else if(symbolSet == 1){
                    // show consonant description
                    // to be implemented
                }
                else if(symbolSet == 2){
                    // show vowel and consonant description
                    // to be implemented
                }
            }
        }

        // paint component method
    }
    
    public class OptionPanel extends JPanel{
        public OptionPanel(){
            if(mode == 0){
                // show description
                if(symbolSet == 0){
                    // show vowel description
                    setLayout(new GridLayout(1, 5));
                    String[] s1 = {"pulmonic", "non-pulmonic"};
                    JComboBox<String> airflow = new JComboBox<>(s1);
                    String[] s2 = {"bilabial", "labiodental", "dental", "alveolar", "post-alveolar", "retroflex", "palatal", "velar", "uvular", "pharyngeal", "glottal"};
                    JComboBox<String> place = new JComboBox<>(s2);
                    String[] s3 = {"central", "lateral"};
                    JComboBox<String> centrality = new JComboBox<>(s3);
                    String[] s4 = {"oral", "nasal"};
                    JComboBox<String> oral = new JComboBox<>(s4);
                    String[] s5 = {"stop", "trill", "tap/flap", "fricative", "affricate", "approximant"};
                    JComboBox<String> manner = new JComboBox<>(s5);
                    add(airflow);
                    add(place);
                    add(centrality);
                    add(oral);
                    add(manner);
                }
                else if(symbolSet == 1){
                    // show consonant description
                    // to be implemented
                }
                else if(symbolSet == 2){
                    // show vowel and consonant description
                    // to be implemented
                }
            }
            else if(mode == 1){
                // show IPA symbol
                if(symbolSet == 0){
                    // show vowel symbol
                    // to be implemented
                }
                else if(symbolSet == 1){
                    // show consonant symbol
                    // to be implemented
                }
                else if(symbolSet == 2){
                    // show vowel and consonant symbol
                    // to be implemented
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
