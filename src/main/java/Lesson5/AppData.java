package Lesson5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AppData {
    private String[] header;
    private Integer[][] data;

    public AppData() {


    }


    public void readFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            header = bufferedReader.readLine().split(";");
            String line;
            ArrayList<Integer[]> dataArr = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                dataArr.add(createIntArray(line));
            }
            data = dataArr.toArray(new Integer[][]{});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Integer[] createIntArray(String str) {
        String[] stringArray = str.split(";");
        Integer[] intArray = new Integer[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }

        return intArray;
    }


    public String[] getHeader() {
        return header;
    }

    public Integer[][] getData() {
        return data;
    }



    @Override
    public String toString() {
        return "AppData{" +
                "header=" + Arrays.toString(header) +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
