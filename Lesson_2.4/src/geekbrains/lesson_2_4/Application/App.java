package geekbrains.lesson_2_4.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App extends JFrame {
    JPanel jpN = new JPanel(new GridLayout());
    JPanel jpS = new JPanel(new GridLayout());

    JButton jb = new JButton("Send it!");
    JTextArea jta = new JTextArea();
    JScrollPane jsp = new JScrollPane(jta);
    JTextField jtf = new JTextField();

    JMenuBar mainMenu = new JMenuBar();
    JMenu mFile = new JMenu("File");
    JMenu mHelp = new JMenu("Help");
    JMenuItem mFileExit = new JMenuItem("Exit");
    JMenuItem mHelpAbout = new JMenuItem("Info");

    public App() {
        super("Self-message chat");
        setSize(300, 400);
        setMinimumSize(new Dimension(300, 400));
        jta.setLineWrap(true);
        jta.setEditable(false);

        //Actions feedback
        jb.addActionListener(e -> {
            sendMessage();
        });
        jtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) sendMessage();
            }
        });
        jpN.add(jsp);
        jpS.add(jtf);
        jpS.add(jb);
        add(jpN);
        add("South", jpS);

        //Menu properties
        setJMenuBar(mainMenu);
        mainMenu.add(mFile);
        mainMenu.add(mHelp);
        mFile.add(mFileExit);
        mHelp.add(mHelpAbout);
        mFileExit.addActionListener(e -> System.exit(0));
        mHelpAbout.addActionListener(e -> JOptionPane.showMessageDialog(null, "Super chat version 1.0", "About", JOptionPane.INFORMATION_MESSAGE));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //Sending message/writing it to the file
    void sendMessage() {
        String out = jtf.getText();
        jta.append(getTime() + ": " + out + "\n");
        jtf.setText("");
        jtf.grabFocus();
    }

    //Time info
    public String getTime() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
}