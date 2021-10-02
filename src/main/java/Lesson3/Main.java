package Lesson3;

public class Main {
    public static void main(String[] args) {
        Apple apple1 = new Apple(1.4f);
        Apple apple2 = new Apple(1.0f);
        Apple apple3 = new Apple(1.0f);
        Apple apple4 = new Apple(1.0f);
        Apple apple5 = new Apple(1.0f);
        Apple apple6 = new Apple(1.0f);
        Orange orange1 = new Orange(1.5f);
        Orange orange2 = new Orange(1.5f);


        System.out.println("Нужно сложить яблок в коробку:  " + Apple.countApple);
        System.out.println("Нужно сложить апельсинов в коробку: " + Orange.countOrange);
        System.out.println("--------------------");
        Box box2 = new Box(apple2, apple3, apple4, apple1, apple6);
        Box box1 = new Box(orange1, orange2);


    }


}
