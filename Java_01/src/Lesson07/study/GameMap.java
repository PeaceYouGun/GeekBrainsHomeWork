package Lesson07.study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GameMap extends JPanel {

    public static final int GAME_MODE_HVH = 0;
    public static final int GAME_MODE_HVA = 1;

    private int gameMode;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;                          // продолжить с 2:25:00
    private int[][] field;

    private int cellWidth;
    private int cellHeight;

    private final char HUMAN_DOT = 'X';
    private final char AI_DOT = 'O';
    private final char EMPTY_DOT = '.';

    public static final Random RANDOM = new Random();

    GameMap() {
        setBackground(Color.BLACK);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                update(e);
            }
        });
    }

    private void update(MouseEvent e){
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        System.out.println("X: " + cellX + " Y: " + cellY);
    }

    void start(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
//        System.out.println("gameMode: " + gameMode +
//                "\nfieldSizeX: " + fieldSizeX +
//                "\nfieldSizeY: " + fieldSizeY +
//                "\nwinLength: " + winLength);
        this.gameMode = gameMode;
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        field = new int[fieldSizeX][fieldSizeY];
        repaint(); // запуск отрисовки
    }

    private void render(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        cellWidth = width / fieldSizeX; //выяснаем ширину и высоту ячейки
        cellHeight = height / fieldSizeY;

        g.setColor(Color.WHITE);// устанавливаем цвет для рисования

        //отрисовка линий по горизонтали
        for (int i = 1; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y); // рисуем линии от точки x1,y1 к точке x2,y2
        }

        //отрисовка линий по веритикали
        for (int i = 1; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }
    }

    private void aiTurn() {
        if (turnAIWinCell()) { // выиграет ли игрок на следующем ходу?
            return;
        }
        if (turnHumanWinCell()) { // выиграет ли ИИ на следующем ходу?
            return;
        }
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell());
        field[y][x] = AI_DOT;
    }

    private boolean turnAIWinCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    field[i][j] = AI_DOT; // поставим нолик в каждую клетку по очереди
                    if (checkWin(AI_DOT)) {
                        return true;    // если комбинация выигрышная, вернем истину, оставив нолик тут
                    }
                    field[i][j] = EMPTY_DOT; // если нет, то оставим поле пустым
                }
            }
        }
        return false;
    }

    // проверка на выигрышный следующий ход от игрока
    private boolean turnHumanWinCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    field[i][j] = HUMAN_DOT; // поставим крестик в каждую клетку по очереди
                    if (checkWin(HUMAN_DOT)) {  // если игрок на этом ходу победит
                        field[i][j] = AI_DOT; // поставить на это место нолик
                        return true;
                    }
                    field[i][j] = EMPTY_DOT; // если нет, то оставим поле пустым
                }
            }
        }
        return false;
    }

    // проверка на победу
    private boolean checkWin(char characterSymbol) {
        for (int i = 0; i < fieldSizeX; i++) {  // проверяем все поле
            for (int j = 0; j < fieldSizeY; j++) {
                if (checkLine(i, j, 1, 0, winLength, characterSymbol)) {
                    return true; // проверка линии по Х
                }
                if (checkLine(i, j, 1, 1, winLength, characterSymbol)) {
                    return true; // проверка линии по диагонали Х У
                }
                if (checkLine(i, j, 0, 1, winLength, characterSymbol)) {
                    return true; // проверка линии по У
                }
                if (checkLine(i, j, 1, -1, winLength, characterSymbol)) {
                    return true; // проверка линии по диагонали Х -У
                }
            }
        }
    }

    // проверка линии
    private boolean checkLine(int x, int y, int vx, int vy, int len, char c) {
        final int farX = x + (len - 1) * vx;    // посчитаем конец проверяемой линии
        final int farY = y + (len - 1) * vy;
        if (!isValidCell(farX, farY)) {
            return false;   // проверяем не выйдет ли проверяемая линия за пределы поля
        }
        for (int i = 0; i < len; i++) { // ползем по проверяемой линии
            if (field[y + i * vy][x + i * vx] != c) {
                return false;   // проверяем одинаковые ли символы в ячейках
            }
        }
        return true;
    }

    private static boolean isFullMap() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field [y][x] == EMPTY_DOT;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

}
