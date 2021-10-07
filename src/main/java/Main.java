public class Main {

    public static void main(String[] args) {
        String[][] myArray = new String[4][4];
        checkArr(myArray);
        myArray[0][0] = "6";
        myArray[0][1] = "7";
        myArray[0][2] = "2";
        myArray[0][3] = "17";
        myArray[1][0] = "4";
        myArray[1][1] = "7";
        myArray[1][2] = "3";
        myArray[1][3] = "17";
        myArray[2][0] = "5";
        myArray[2][1] = "6";
        myArray[2][2] = "3";
        myArray[2][3] = "17";
        myArray[3][0] = "5";
        myArray[3][1] = "7";
        myArray[3][2] = "6";
        myArray[3][3] = "17";

        readArr(myArray);
        convertArr(myArray);


    }

    //Метод проверки размера массива

    public static void checkArr(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != 4) {
                throw new IllegalArgumentException(" Массив должен быть 4х4");
            }
            for (int j = 0; j < arr.length; j++) {
                if (arr.length != 4) {
                    throw new IllegalArgumentException(" Массив должен быть 4х4");
                }
            }
        }
    }

// Метод для чтения массива

    public static void readArr(String[][] arr) {
        System.out.println("===Исходный массив====");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

// Создаем новый int- массив и заполняем его конвертированными значениями первичного  String- массива,
// затем суммируем все элементы массива.

    public static void convertArr(String[][] arr) throws NumberFormatException {
        int[][] intArr = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                try {
                    intArr[i][j] = Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("это не число!!! " + "[" + i + ":" + j + "]");
                }
            }
        }
        System.out.println("===Конвертированный массив====");
        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr.length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        int sum = 0;
        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr.length; j++) {
                sum += intArr[i][j];
            }
        }
        System.out.println("Сумма всех элементов этого массива равна: " + sum);
    }


}

