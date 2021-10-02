package Lesson4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        HashMap<String, List<String>> telephoneBook = new HashMap<>();
        telephoneBook.put("Ivanov", new ArrayList<>(Arrays.asList("8916549788", "8567830178", "89264324356")));
        telephoneBook.put("Petrov", new ArrayList<>(Arrays.asList("89267894376")));
        telephoneBook.put("Sidorov", new ArrayList<>(Arrays.asList("89267898771")));
        telephoneBook.put("Pukin", new ArrayList<>(Arrays.asList("89264754376", "85467894362")));
        System.out.println(telephoneBook);
        System.out.println("===================");


        //  Поиск по фамилии осуществляется через метод get
        System.out.println(telephoneBook.get("Ivanov"));
    }
}