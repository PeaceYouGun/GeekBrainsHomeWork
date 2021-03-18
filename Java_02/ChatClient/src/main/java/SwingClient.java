import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class SwingClient extends JFrame implements ActionListener, MessageProcessor {
    private static final int WIN_WIDTH = 400;
    private static final int WIN_HEIGHT = 300;

    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); // получаем информацию о разрешении экрана
    private final int WIN_POS_X = ((int) dimension.getWidth() - WIN_WIDTH) / 2;
    private final int WIN_POS_Y = ((int) dimension.getHeight() - WIN_HEIGHT) / 2;

    private final SettingsWindow settingsWindow;

    private final JTextArea log = new JTextArea();

//    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
//    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
//    private final JTextField tfPort = new JTextField("8189");
//    private final JCheckBox cbAlwaysOnTop = new JCheckBox("Always on top");
//    private final JTextField tfLogin = new JTextField("Vasya");
//    private final JPasswordField tfPassword = new JPasswordField("123");
//    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    //    private final JButton btnDisconnect = new JButton("<html><b>Disconnect</b></html>");
    private final JTextField tfMessage = new JTextField(8); // 8 - клавиша Enter вызывает обраюотчик события
    private final JButton btnSend = new JButton("<html><b>Send</b></html>");

    private final JList<String> userList = new JList<>();

    private MessageService messageService;

    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {  // запуск Swing'а в отдельном потоке с помощью invokeLater
//            @Override
//            public void run() {
//                new SwingClient();
//            }
//        });

        // запуск Swing'а в отдельном потоке с помощью invokeLater конвертированного в лямбда

        SwingUtilities.invokeLater(SwingClient::new);
    }

    public SwingClient() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);  // левый верхний угол окна в центре экрана
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocation(WIN_POS_X, WIN_POS_Y);

        setTitle("Balabolka");

        settingsWindow = new SettingsWindow(this);  // передаем данные SwingClient в конструктор SettingsWindow для установки окна посередине

        // Создание строки главного меню
        JMenuBar menuBar = new JMenuBar();
        // Добавление в главное меню выпадающих пунктов меню
        menuBar.add(createFileMenu());
        menuBar.add(createEditMenu());
        menuBar.add(createHelpMenu());
        // Подключаем меню к интерфейсу приложения
        setJMenuBar(menuBar);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        JScrollPane scrollUsers = new JScrollPane(userList);
        String[] users = {"user1", "user2", "user3", "user4", "user5", "user6",
                "user_with_an_exceptionally_long_nickname"};
        userList.setListData(users);
        scrollUsers.setPreferredSize(new Dimension(100, 0));

        btnSend.addActionListener(this);
        tfMessage.addActionListener(this);
        btnSend.setPreferredSize(new Dimension(100, 25));

        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);

        add(scrollLog, BorderLayout.CENTER);
        add(scrollUsers, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

//        Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler) this);
        messageService = new ChatMessageService("localhost", 65500, this);

        setVisible(true);
    }

    private JMenu createFileMenu() {
        // Создание выпадающего меню
        JMenu file = new JMenu("File");
        // Пункты меню Connect, Disconnect и Exit с иконками (которые почему-то не отображаются)
        JMenuItem connect = new JMenuItem("Connect", new ImageIcon("/Lesson_04/Online_04/images/connect.png"));
        JMenuItem disconnect = new JMenuItem("Disconnect", new ImageIcon("/Lesson_04/Online_04/images/disconnect.png"));
        JMenuItem exit = new JMenuItem("Exit", new ImageIcon("/Lesson_04/Online_04/images/exit.png"));
        // Добавим в меню пункт Connect и Disconnect
        file.add(connect);
        file.add(disconnect);
        // Добавление разделителя
        file.addSeparator();
        file.add(exit);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });

        return file;
    }

    private JMenu createEditMenu() {
        JMenu edit = new JMenu("Edit");

        JRadioButtonMenuItem cbAlwaysOnTop = new JRadioButtonMenuItem("Always on top");
        edit.add(cbAlwaysOnTop);

        cbAlwaysOnTop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAlwaysOnTop(cbAlwaysOnTop.isSelected());
            }
        });

        return edit;
    }

    private JMenu createHelpMenu() {
        JMenu help = new JMenu("Help");
        JMenuItem link = new JMenuItem("Help");
        help.add(link);
        link.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebpage("http://google.com");
            }
        });

        return help;
    }

    private static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnSend || src == tfMessage) {
            messageService.sendMessage(tfMessage.getText());
            tfMessage.setText("");
        }
    }

    @Override
    public void processMessage(String msg) {
        log.append(msg + System.lineSeparator());
    }
}
