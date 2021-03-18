package Lesson_03.Homework_03;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Homework_03 {
    public static void main(String[] args) {
//      задание 1
//      Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
//      Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//      Посчитать, сколько раз встречается каждое слово
        String[] strArr = {"sun", "paper", "blade", "sun", "note", "tree",
                "respect", "hydrant", "cover", "push", "tree", "blade", "leather",
                "death", "sun", "cover", "blade", "impulse", "sun", "talk"};
        Set<String> mySet = new LinkedHashSet<>(Arrays.asList(strArr));
        System.out.println(mySet); // вывод списка уникальных слов в порядке их добавления
        Iterator<String> i = mySet.iterator();
        while (i.hasNext()) {
            int sum = 0;
            String currentWord = i.next();
            for (String s : strArr) {
                if (s.equals(currentWord))
                    sum++;
            }
            System.out.println(currentWord + " " + sum);
        }

        System.out.println("");

        PhoneBook record = new PhoneBook();
        record.add(1111111, "Ivanov");
        record.add(2222222, "Petrov");
        record.add(3333333, "Sidorov");
        record.add(4444444, "Ivanov");
        record.add(5555555, "Vetrov");
        record.add(6666666, "Alekseev");

        record.print(); // выводим Телефонную книгу

        System.out.println();

        record.get("Ivanov");
        record.get("Petrov");
        record.get("Suslik");

    }
}
