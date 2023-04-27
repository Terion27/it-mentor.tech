package calculator;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String inputString = inputString();
            String result = calc(inputString);
            print(result);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String calc(String input) {
        String[] str = input.split(" ");
        int result = switch (str[1]) {
            case "+" -> Integer.parseInt(str[0]) + Integer.parseInt(str[2]);
            case "-" -> Integer.parseInt(str[0]) - Integer.parseInt(str[2]);
            case "/" -> Integer.parseInt(str[0]) / Integer.parseInt(str[2]);
            case "*" -> Integer.parseInt(str[0]) * Integer.parseInt(str[2]);
            default -> throw new IllegalArgumentException("Не верный оператор");
        };
        return String.valueOf(result);
    }

    private static String inputString() throws IOException {
        Scanner scan = new Scanner(System.in);
        return valid(scan.nextLine());
    }

    private static String valid(String inputString) throws IOException {
        String exception = "throws Exception";
        String[] str = inputString.split(" ");
        if (str.length == 3 && !(str[1].equals("/") && str[2].equals("0"))) {
            try {
                int numOne = Integer.parseInt(str[0]);
                int numTwo = Integer.parseInt(str[2]);
                if (!numberRange(numOne, numTwo)) throw new IOException(exception);
            } catch (NumberFormatException e) {
                throw new IOException(exception);
            }
        } else {
            throw new IOException(exception);
        }
        return inputString;
    }

    private static boolean numberRange(int numOne, int numTwo) {
        return ((numOne >= 1 && numOne <= 10) && (numTwo >= 1 && numTwo <= 10));
    }

    private static void print(String result) {
        System.out.println(result);
    }
}