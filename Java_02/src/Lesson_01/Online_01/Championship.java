package Lesson_01.Online_01;

/**
 * Project java_core_android
 *
 * @Author Alexander Grigorev
 * Created 28.01.2021
 * v1.0
 */
public class Championship {
    //Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать
    // и прыгать (методы просто выводят информацию о действии в консоль).
    //Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять
    // соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
    //Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
    //У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
    // Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.

    public static void main(String[] args) {
        Runner[] runners = {
                new Cat("Barsik", 1500, 300),
                new Cat("Murzik", 1700, 220),
                new Robot("R2D2", 99999, 0),
                new Robot("C3PO", 5000, 50),
                new Human("Petya", 2500, 150),
                new Human("Vasya", 3500, 120)
        };

        Obtacle[] obtacles = {
          new Track(1200),
          new Wall(30),
          new Track(2000),
          new Wall(140),
          new Track(3000),
          new Wall( 250)
        };

        for (Runner r : runners) {
            for (Obtacle o : obtacles) {
//                if (o instanceof Track) {
//                    r.run(o.getLength());
//                } else {
//                    r.jump(o.getHeight());
//                }
                if (!r.overcome(o)) break;
            }
        }
    }

}
