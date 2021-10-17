package Lesson6;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {


            System.out.println("Введите название города: ");
            String scannerCity = scanner.nextLine();

            System.out.println("введите 1 - чтобы получить погоду на 1 день, введите 5- чтобы получить погоду на 5 дней");
            String scannerDays = scanner.nextLine();

            try {
                controller.getWeather(scannerDays, scannerCity);
                System.out.println(" To EXIT press 0");
            } catch (IOException e) {
                e.printStackTrace();
            }
            String line = scanner.nextLine();
            if (line.equals("0"))
                break;
        }
    }
}
