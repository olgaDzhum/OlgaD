package Lesson3;

public class Orange extends Fruit {

    public static int countOrange = 0;


    public Orange(float weight) {
        super(weight);
        ++countOrange;
    }


}
