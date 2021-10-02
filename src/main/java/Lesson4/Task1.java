package Lesson4;

import java.util.HashMap;

public class Task1 {

  //  1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
    //  Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
    //  Посчитать, сколько раз встречается каждое слово.


    public static void main(String[] args) {
        String[] array = {"Кошка", "Собака", "Лошадь", "Лось", "Собака", "Мышь", "Мышь", "Хомяк", "Собака", "Корова"};
        HashMap<String, Integer> unique = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (unique.containsKey(array[i])) {
                unique.put(array[i], unique.get(array[i]) + 1);
            } else {
                unique.put(array[i], 1);

            }

        }
        System.out.println(unique);
    }

}



