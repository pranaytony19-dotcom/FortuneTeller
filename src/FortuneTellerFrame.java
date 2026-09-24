import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {


    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;


    private JLabel titleLabel;
    private JTextArea fortuneArea;
    private JScrollPane scrollPane;
    private JButton fortuneButton;
    private JButton quitButton;


    private final Font titleFont =
            new Font("Serif", Font.BOLD, 48);

    private final Font fortuneFont =
            new Font("Serif", Font.PLAIN, 20);

    private final Font buttonFont =
            new Font("SansSerif", Font.BOLD, 18);


    private final String[] fortunes = {
            "A surprise snack which will make your day better.",
            "Your next bug which will disappear after one mysterious restart.",
            "Someone will make you laugh which you least expect it.",
            "Good news which is headed your way.",
            "Your next cup of coffee which may contain the answer.",
            "A forgotten assignment which will suddenly come back to mind.",
            "You will find something which you thought was lost.",
            "Today is a good day which is to try something new.",
            "Your computer which will cooperate with you... eventually.",
            "An unexpected compliment which is coming your way.",
            "You will solve a problem which is faster than you expected.",
            "Your next meal which will be better than you predicted.",
            "A small decision which will lead to a funny story.",
            "You will have unusually good luck which is to find a parking spot."
    };


    private final Random random = new Random();


    private int previousFortuneIndex = -1;


    public FortuneTellerFrame() {

        super("Fortune Teller");


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setLayout(new BorderLayout(10, 10));


        createTopPanel();
        createMiddlePanel();
        createBottomPanel();


        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);


        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();


        int frameWidth = (int) (screenSize.width * 0.75);


        int frameHeight = (int) (screenSize.height * 0.75);

        setSize(frameWidth, frameHeight);


        setLocationRelativeTo(null);
    }


    private void createTopPanel() {

        topPanel = new JPanel();


        ImageIcon originalIcon =
                new ImageIcon("src/fortune.png");


        Image resizedImage =
                originalIcon.getImage().getScaledInstance(
                        300,
                        300,
                        Image.SCALE_SMOOTH
                );


        ImageIcon fortuneImage =
                new ImageIcon(resizedImage);


        titleLabel = new JLabel(
                "Fortune Teller",
                fortuneImage,
                JLabel.CENTER
        );


        titleLabel.setFont(titleFont);


        titleLabel.setHorizontalTextPosition(
                JLabel.CENTER
        );

        titleLabel.setVerticalTextPosition(
                JLabel.BOTTOM
        );


        topPanel.add(titleLabel);
    }


    private void createMiddlePanel() {

        middlePanel =
                new JPanel(new BorderLayout());


        fortuneArea = new JTextArea();


        fortuneArea.setFont(fortuneFont);


        fortuneArea.setEditable(false);


        fortuneArea.setLineWrap(true);
        fortuneArea.setWrapStyleWord(true);


        scrollPane =
                new JScrollPane(fortuneArea);


        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );


        middlePanel.add(
                scrollPane,
                BorderLayout.CENTER
        );
    }


    private void createBottomPanel() {

        bottomPanel = new JPanel();


        fortuneButton =
                new JButton("Read My Fortune!");

        quitButton =
                new JButton("Quit");


        fortuneButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);


        fortuneButton.addActionListener(
                e -> displayFortune()
        );


        quitButton.addActionListener(
                e -> System.exit(0)
        );


        bottomPanel.add(fortuneButton);
        bottomPanel.add(quitButton);
    }


    private void displayFortune() {

        int newFortuneIndex;


        do {

            newFortuneIndex =
                    random.nextInt(fortunes.length);

        } while (newFortuneIndex ==
                previousFortuneIndex);


        fortuneArea.append(
                fortunes[newFortuneIndex] + "\n"
        );


        previousFortuneIndex =
                newFortuneIndex;


        fortuneArea.setCaretPosition(
                fortuneArea.getDocument().getLength()
        );
    }
}

