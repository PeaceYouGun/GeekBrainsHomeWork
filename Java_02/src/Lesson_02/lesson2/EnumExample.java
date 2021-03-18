package lesson2;

/**
 * Project java_core_l2
 *
 * @Author Alexander Grigorev
 * Created 19.02.2021
 * v1.0
 */
public class EnumExample {

    public static void main(String[] args) {
        Operator op = Operator.SUM;
        System.out.println(op.operation(10, 12));
        op = Operator.MUL;
        System.out.println(op.operation(5, 25));

        WeekDay day = WeekDay.SUNDAY;
        System.out.println(day);
        System.out.println(day.russianName);
        System.out.println(day.dayNumber);
    }

    enum Operator {

        SUM {
            public int operation(int x, int y) {return x + y;}
        },
        MUL {
            public int operation(int x, int y) {return x * y;}
        };

        public abstract int operation(int x, int y);
    }


    enum WeekDay {
        MONDAY(1, "Понедельник"),
        TUESDAY(2, "Вторник"),
        WEDNESDAY(3, "Среда"),
        THURSDAY(4, "Четверг"),
        FRIDAY(5, "Пятница"),
        SATURDAY(6, "Суббота"),
        SUNDAY(7, "Воскресенье");

        private int dayNumber;
        private String russianName;

        WeekDay(int dayNumber, String russianName) {
            this.dayNumber = dayNumber;
            this.russianName = russianName;
        }

        public int getDayNumber() {
            return dayNumber;
        }

        public String getRussianName() {
            return russianName;
        }
    }
}
