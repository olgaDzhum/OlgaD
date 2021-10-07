package Lesson5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Lesson5 {
    public static void main(String[] args) {

        // Задание 1 Реализуем сохранение данных в файл

        try (PrintWriter printWriter = new PrintWriter("lesson5.csv")) {
            printWriter.write("Value 1;Value 2;Value 3\n" +
                    "100;200;123\n" +
                    "300;400;500");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Задание 2 Реализовываем загрузку данных из csv файла

AppData appData = new AppData();
       appData.readFile("lesson5.csv");
        System.out.println(Arrays.toString(appData.getHeader()));
        System.out.println(Arrays.deepToString(appData.getData()));

    }
}
