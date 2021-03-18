package Lesson07.study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private final int WIN_WIDTH = 500;
    private final int WIN_HEIGHT = 550;
//    private final int WIN_POS_X = 650;
//    private final int WIN_POS_Y = 200;

    private SettingsWindow settingsWindow;
    private GameMap gameMap;

    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); // получаем информацию о разрешении экрана
    private final int WIN_POS_X = ((int) dimension.getWidth() - WIN_WIDTH) / 2;
    private final int WIN_POS_Y = ((int) dimension.getHeight() - WIN_HEIGHT) / 2;

    GameWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIN_WIDTH, WIN_HEIGHT);
//        setLocation(WIN_POS_X, WIN_POS_Y); // установка местоположения окна  вручную

        // установка местоположения окна по середине относительно разрешения экрана
//        setLocation(((int) dimension.getWidth() - WIN_WIDTH) / 2, ((int) dimension.getHeight() - WIN_HEIGHT) / 2);
        setLocation(WIN_POS_X, WIN_POS_Y);
        setTitle("The Game");
        setResizable(false);

        settingsWindow = new SettingsWindow(this); // передаем данные GameWindow в конструктор SettingsWindow для установки окна посередине
        gameMap = new GameMap();

        JButton btnStartGame = new JButton("Start New Game");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });

        JButton btnExitGame = new JButton("Exit");
        btnExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel buttonPanel = new JPanel(); // создаем панель
        buttonPanel.setLayout(new GridLayout(1, 2)); // выбираем компоновщик GridLayout и делим поле на 2 столбца
        buttonPanel.add(btnStartGame); // добавляем кнопку старт на левый столбец поля
        buttonPanel.add(btnExitGame); // добавляем конпку выход на правый столбец поля

        add(buttonPanel, BorderLayout.SOUTH); // добавляем поле в окно внизу - на юге, по компоновщику BirderLayout

//        add(btnStartGame, BorderLayout.NORTH); // компоновщик BorderLayout по-умолчанию
//        add(btnExitGame, BorderLayout.SOUTH);

//        setLayout(new GridLayout(1,2)); // замена компоновщика по-умолчанию BorderLayout на GridLayout
//        add(btnStartGame);
//        add(btnExitGame);

//        setLayout(new FlowLayout()); // замена компоновщика по-умолчанию BorderLayout на FlowLayout
//        add(btnStartGame);
//        add(btnExitGame);

        add(gameMap);

        setVisible(true);
    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        gameMap.start(gameMode, fieldSizeX, fieldSizeY, winLength);
    }

}
