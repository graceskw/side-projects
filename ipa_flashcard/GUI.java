import java.awt.*;
import javax.swing.*;
// import javax.swing.JFrame;
// import javax.swing.JPanel;
// import javax.swing.JLabel;
// import javax.swing.JOptionPane;

public class GUI {
    int mode;
    int symbolSet;
    boolean lightMode = true;

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
    
    Image[] vowelImages = new Image[28];
    Image[] consonantImages = new Image[186];

    public GUI(){
        // to choose the mode
        String[] modeOptions = new String[]{"IPA to description", "Description to IPA"};
        this.mode = JOptionPane.showOptionDialog(null, "Please choose desired mode:", "Mode",
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, modeOptions, modeOptions[0]);        // this.mode.showOptionDialog(null, "Please choose desired mode:",

        // to choose the symbol set
        String[] symbolSetOptions = new String[]{"Vowels", "Pulmonic consonants", "Vowels and Consonants"};
        this.symbolSet = JOptionPane.showOptionDialog(null, "Please choose desired IPA symbol set:", "IPA symbol set",
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, symbolSetOptions, symbolSetOptions[0]);        // this.mode.showOptionDialog(null, "Please choose desired mode:",
        
        getImage();
        createGUI();
        
        this.frame.setVisible(true);
        frame.repaint();
        flashcardPanel.repaint();
    }
    
    // create GUI
    private void createGUI(){
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

        this.frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        // create flashcardPanel and add to frame
        this.flashcardPanel = new FlashcardPanel();
            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 1;
            c.gridheight = 5;
            // c.insets = new Insets(10, 10, 10, 10);
        this.frame.add(flashcardPanel, c);

        // create optionPanel and add to frame
        this.optionPanel = new OptionPanel();
            c.gridx = 0;
            c.gridy = 5;
            c.gridwidth = 1;
            c.gridheight = 3;
        this.frame.add(optionPanel, c);
        
        // create buttonPanel and create+add confirm, cancel, and skip buttons
        this.buttonPanel = new JPanel();
        this.buttonPanel.setLayout(new GridLayout(1, 2));
        confirmButton = new JButton("Confirm");
        // cancelButton = new JButton("Cancel");
        skipButton = new JButton("Skip");
        this.buttonPanel.add(confirmButton);
        // this.buttonPanel.add(cancelButton);
        this.buttonPanel.add(skipButton);
            c.gridx = 0;
            c.gridy = 8;
            c.gridwidth = 1;
            c.gridheight = 2;
            c.fill = GridBagConstraints.HORIZONTAL;
        this.frame.add(buttonPanel, c);

    }

    // get images of flashcards
    private void getImage(){
        // light mode
        if(lightMode){
            for(int i=1; i<=28; i++){
                vowelImages[i-1] = new ImageIcon("ipa_symbols/vowel light2/vowel light_page-000"+i+".jpg").getImage();
            }
            // load consonant
        }

    }
    
    public class FlashcardPanel extends JPanel{
        private int cardWidth = 297;
        private int cardHeight = 210;

// doesnt work, not even line is drawn
        public void paintComponent(Graphics g) {   
            if(mode == 0){
                // show IPA symbol
                if(symbolSet == 0){
                    // show vowel symbol
                    super.paintComponent(g);
                    Graphics2D g2D = (Graphics2D) g;
                    g2D.setColor(Color.black);
                    // int h = this.getHeight();
                    // int w = this.getWidth();
        
                    g2D.drawImage(vowelImages[0], 0, 0, cardWidth, cardHeight, this);
                    g2D.drawLine(0, 0, this.getWidth(), this.getHeight());
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

    }
    
    public class OptionPanel extends JPanel{
        public OptionPanel(){
            if(mode == 0){
                // show description
                if(symbolSet == 0){
                    // show vowel description
                    setLayout(new GridLayout(1, 4));
                    String[] s1 = {"high", "mid", "low"};
                    JComboBox<String> tongueHeight = new JComboBox<>(s1);
                    String[] s2 = {"front", "cental", "back"};
                    JComboBox<String> backness = new JComboBox<>(s2);
                    String[] s3 = {"tense", "lax"};
                    JComboBox<String> tense = new JComboBox<>(s3);
                    String[] s4 = {"unrounded", "rounded"};
                    JComboBox<String> round = new JComboBox<>(s4);
                    add(tongueHeight);
                    add(backness);
                    add(tense);
                    add(round);
                }
                else if(symbolSet == 1){
                    // show consonant description
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
