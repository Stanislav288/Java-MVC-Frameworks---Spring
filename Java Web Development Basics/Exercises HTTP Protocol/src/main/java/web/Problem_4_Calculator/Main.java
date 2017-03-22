package web.Problem_4_Calculator;

import web.FileReader;
import web.Problem_1_By_the_Cake_add_cake.Cake;
import web.Utils;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Galin on 29.1.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        printContent();
        printBody();
        Main.calculate();
    }

    private static void printContent() {
        String content = "Content-Type: text/html\n\n";

        System.out.println(content);
    }

    private static void printBody() {
        String path = "C:\\Users\\Galin\\Desktop\\broken laptop\\softuni\\Java Web Development\\Java Web Development Basics\\Exercises HTTP Protocol\\src\\main\\resources\\calculator.html";
        String html = FileReader.readHtml(path);
        System.out.println(html);
    }

    private static void calculate() throws IOException {
        Map<String, String> params = Utils.getParameters(System.in);
        double firstNumber = Double.parseDouble(params.get("firstNumber"));
        String operation = params.get("operation");
        double secondNumber = Double.parseDouble(params.get("secondNumber"));

        double result = 0;
        switch (operation) {
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            default:
                System.out.println("<p>"+"Invalid sign!"+"</p>");
                return;
        }

        System.out.println("<p>"+"Result: " + result+"</p>");
    }
}
