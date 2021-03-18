package Lesson_04.Online_04;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JDialog{
    private static final int WIN_WIDTH = 200;
    private static final int WIN_HEIGHT = 150;

    private SwingClient swingClient;

    private final JPanel panelTop = new JPanel(new GridLayout(4, 2));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField tfLogin = new JTextField("Vasya");
    private final JPasswordField tfPassword = new JPasswordField("123456");

    private final JButton btnLogin = new JButton("Login");

    SettingsWindow(SwingClient swingClient) {
        this.swingClient = swingClient;

        setSize(WIN_WIDTH, WIN_HEIGHT);

        Rectangle chatWindow = swingClient.getBounds();
        int posX = (int) chatWindow.getCenterX() - WIN_WIDTH / 2;
        int posY = (int) chatWindow.getCenterY() - WIN_HEIGHT / 2;
        setLocation(posX, posY);

        setTitle("Settings");
        setResizable(false);
        setAlwaysOnTop(true);

        panelTop.add(new JLabel("  IP address:"));
        panelTop.add(tfIPAddress);
        panelTop.add(new JLabel("  Port:"));
        panelTop.add(tfPort);
        panelTop.add(new JLabel("  Login:"));
        panelTop.add(tfLogin);
        panelTop.add(new JLabel("  Password:"));
        panelTop.add(tfPassword);
        add(panelTop, BorderLayout.NORTH);

        add(btnLogin, BorderLayout.SOUTH);
    }
}
