package Lesson03;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class HomeWork03 {

    public static char[][] map;
    public static int mapX;
    public static int mapY;
    public static final char EMPTY = '_';
    public static final char HUMAN = 'X';
    public static final char AI = 'O';
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        createMap();
        printMap();

        while (true) {
            turnHuman();
            printMap();
            if (checkWin(HUMAN)) {
                System.out.println("Вы победили");
                break;
            }
            if (chechFullMap()) {
                System.out.println("Ничья!");
                break;
            }
            turnAI();
            printMap();
            if (checkWin(AI)) {
                System.out.println("Вы проиграли");
                break;
            }
            if (chechFullMap()) {
                System.out.println("Ничья!");
                break;
            }
        }

    }

    public static void createMap() {
        mapX = 3;
        mapY = 3;
        map = new char[mapY][mapX];
        for (int y = 0; y < mapY; y++) {
            for (int x = 0; x < mapX; x++) {
                map[y][x] = EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int y = 0; y < mapY; y++) {
            for (int x = 0; x < mapX; x++) {
                if (x < mapX - 1)
                    System.out.print(map[y][x] + " | ");
                else
                    System.out.println(map[y][x]);
            }
        }
        System.out.println();
    }

    public static void turnHuman() {
        int x;
        int y;
        do {
            System.out.println("Ваш ход! Введите координаты:");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValid(y, x) || !isEmpty(y, x));
        map[y][x] = HUMAN;
    }

    public static boolean isValid(int y, int x) {
        return x >= 0 && x < mapX && y >= 0 && y < mapY;
    }

    public static boolean isEmpty(int y, int x) {
        return map[y][x] == EMPTY;
    }

    public static void turnAI() {
        int x;
        int y;
        System.out.println("Ходит ИИ");
        do {
            x = RANDOM.nextInt(mapX);
            y = RANDOM.nextInt(mapY);
        } while (!isEmpty(y, x));
        map[y][x] = AI;
    }

    public static boolean checkWin (char player) {
        if (map[0][0] == player && map[0][1] == player && map[0][2] == player) return true;
        if (map[1][0] == player && map[1][1] == player && map[1][2] == player) return true;
        if (map[2][0] == player && map[2][1] == player && map[2][2] == player) return true;
        if (map[0][0] == player && map[1][0] == player && map[2][0] == player) return true;
        if (map[0][1] == player && map[1][1] == player && map[2][1] == player) return true;
        if (map[0][2] == player && map[1][2] == player && map[2][2] == player) return true;
        if (map[0][0] == player && map[1][1] == player && map[2][2] == player) return true;
        if (map[0][2] == player && map[1][1] == player && map[2][0] == player) return true;
        return false;
    }

    public static boolean chechFullMap () {
        for (int y = 0; y < mapY; y++) {
            for (int x = 0; x < mapX; x++) {
                if (map[y][x] == EMPTY)
                        return false;
            }
        }
        return true;
    }

}
