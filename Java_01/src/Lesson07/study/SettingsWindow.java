package Lesson07.study;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private final int WIN_WIDTH = 400;
    private final int WIN_HEIGHT = 400;
    //    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    private final int MIN_FIELD_SIZE = 3;
    private final int MAX_FIELD_SIZE = 10;
    private final int MIN_WIN_LENGTH = 3;

    private final String FIELD_SIZE_PREFIX = "  Размер поля: ";
    private final String WIN_LENGTH_PREFIX = "  Выигрышная длина: ";

    private JRadioButton humanVsHuman;
    private JRadioButton humanVsAi;
    private JSlider sliderWinLength;
    private JSlider sliderFieldSize;
    private JButton btnStart;

    private GameWindow gameWindow;

    SettingsWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WIN_WIDTH, WIN_HEIGHT);
//        setLocation(((int) dimension.getWidth() - WIN_WIDTH) / 2, ((int) dimension.getHeight() - WIN_HEIGHT) / 2);  // по центру экрана в зависимости от разрешения

        Rectangle gameWindowBounds = gameWindow.getBounds();
//        setLocation(((int)gameWindowBounds.getWidth() - WIN_WIDTH)/2 + (int)gameWindowBounds.getX(),(int)(gameWindowBounds.getHeight() - WIN_HEIGHT)/2 + (int)gameWindowBounds.getY());
        int posX = (int) gameWindowBounds.getCenterX() - WIN_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WIN_HEIGHT / 2;
        setLocation(posX, posY);
        setTitle("Settings");
        setResizable(false);

        setLayout(new GridLayout(10, 1));

        gameModeControl();
        fieldSizeAndWinControl();
        btnStart = new JButton("Start Game!");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonClickMethod();
            }
        });

        // установка кнопки Start Game по центру
        JPanel buttonPanel = new JPanel(); // создаем панель
        JPanel emptyPanel1 = new JPanel();
        JPanel emptyPanel2 = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3)); // выбираем компоновщик GridLayout и делим поле на 2 столбца
        buttonPanel.add(emptyPanel1);
        buttonPanel.add(btnStart);
        buttonPanel.add(emptyPanel2);
        add(buttonPanel);

//        add(btnStart);

    }

    private void gameModeControl() {
        add(new JLabel("  Выберите режим игры:"));
        humanVsHuman = new JRadioButton("Человек против человека", true);
        humanVsAi = new JRadioButton("Человек против ИИ");
        ButtonGroup gameMode = new ButtonGroup(); //создаем группу для объединения радиобаттон
        gameMode.add(humanVsHuman); //добавляема в группу радиобаттон
        gameMode.add(humanVsAi); //добавляема в группу радиобаттон
        add(humanVsHuman); //добавляем радиобаттон в окно Settings
        add(humanVsAi); //добавляем радиобаттон в окно Settings
    }

    private void fieldSizeAndWinControl() {
        JLabel labelFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel labelWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);

        sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = sliderFieldSize.getValue();
                labelFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                sliderWinLength.setMaximum(currentValue);
            }
        });

        sliderWinLength = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelWinLength.setText(WIN_LENGTH_PREFIX + sliderWinLength.getValue());
            }
        });

        add(new JLabel("  Выберите размер поля"));
        add(labelFieldSize);
        add(sliderFieldSize);

        add(new JLabel("  Выберите длину выигрышной позиции"));
        add(labelWinLength);
        add(sliderWinLength);
    }

    private void buttonClickMethod() {
        int gameMode;
        if (humanVsHuman.isSelected()) {
            gameMode = GameMap.GAME_MODE_HVH;
        } else if (humanVsAi.isSelected()) {
            gameMode = GameMap.GAME_MODE_HVA;
        } else {
            throw new RuntimeException("Неизвестный тип игры"); // Выкидываем исключение
        }

        int fieldSize = sliderFieldSize.getValue();
        int winLength = sliderWinLength.getValue();

        gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLength);

        setVisible(false); // скрываем окно настроек
    }

}
