import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson6Lottery {

    final static int NUMBER = 7;
    final static int MIN_NUMBER = 0;
    final static int MAX_NUMBER = 9;
    public static void main(String[] args) {
        int[] arrHidden = new int[NUMBER];
        Random rnd = new Random();
        System.out.println("Загадані " + NUMBER + " чисел у діапазоні від " + MIN_NUMBER + " до " + MAX_NUMBER);
        for (int i = 0; i < arrHidden.length; i++) {
            arrHidden[i] = rnd.nextInt(MAX_NUMBER+1) + MIN_NUMBER;
        }
        Arrays.sort(arrHidden);

        int[] arrGuess = new int[NUMBER];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < arrGuess.length; i++) {
            System.out.print("Введіть число N " + (i + 1) + ": ");
            try {
                arrGuess[i] = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Помилка. Це не число.");
                i--;
                scan = new Scanner(System.in);
                continue;
            }
            if (arrGuess[i] < MIN_NUMBER || arrGuess[i] > MAX_NUMBER) {
                System.out.println("\nПомилка. Число не у визначеному діапазоні.");
                i--;
                continue;
            }
        }
        Arrays.sort(arrGuess);
        int win = 0;
        for (int i = 0; i < arrGuess.length; i++) {
            if (arrGuess[i] == arrHidden[i])
                win++;
        }

        System.out.println("Загадані " + Arrays.toString(arrHidden));
        System.out.println("Вгадані " + Arrays.toString(arrGuess));
        System.out.println("Кількість збігів: " + win);
    }
}
