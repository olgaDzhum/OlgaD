package Lesson3;

import java.util.ArrayList;
import java.util.Arrays;

public class Box {
    private float weight;
    private float appleWeight;
    private float orangeWeight;

// Создаю перегруженные конструкторы для яблок и апельсинов


    public Box(Apple... apples) {
        System.out.println("===Коробка с Яблоками====");
        for (int i = 0; i < apples.length; i++) {
            System.out.println("Яблоко: " + apples[i].weight);
        }
        getWeight(apples);
        appleWeight = weight;
        System.out.println("======Новая коробка======");
        changeBox(apples);
        System.out.println("++++Коробка от яблок пуста++++");
        for (int i = 0; i < apples.length; i++) {
            System.out.println(apples[i]);
            System.out.println();

        }
    }


    public Box(Orange... oranges) {
        System.out.println("===Коробка с Апельсинами====");
        for (int i = 0; i < oranges.length; i++) {
            System.out.println("Апельсин: " + oranges[i].weight);
        }
        getWeight(oranges);
        orangeWeight = weight;
        System.out.println("Коробка с яблоками и коробка с апельсинами имеют одинаковый вес?");
        System.out.println(compare(appleWeight));
        changeElementsOfArray(oranges);
    }

    // Метод, который перекладывает фрукты в пустую коробку

    public void changeBox(Fruit[] arr) {
        ArrayList<Fruit> anotherBox = new ArrayList<>(Arrays.asList(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] instanceof Apple) {
                System.out.println("Яблоко: " + arr[i].weight);
            }
            if (arr[i] instanceof Orange) {
                System.out.println("Апельсин: " + arr[i].weight);
            }
        }
        Arrays.fill(arr, null);
        System.out.println();
    }

// Метод для сравнения веса коробок

    public boolean compare(float appleWeight) {
        return appleWeight == orangeWeight;
    }


// Метод для вычисления веса коробки

    public float getWeight(Fruit[] arr) {
        float sum = 0.0F;
        for (int i = 0; i < arr.length; i++) {
            weight = sum += arr[i].weight;
        }
        System.out.println();
        System.out.println("Вес коробки: " + weight);
        System.out.println("--------------------");
        return weight;
    }

// Поменять эл-ты массива местами

    public void changeElementsOfArray(Fruit[] arr) {
        System.out.println("+++++++Меняем эл-ты массива местами+++++++");
        Fruit tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
