package web.Problem_5_Log_in_form;

import web.FileReader;
import web.Utils;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Galin on 29.1.2017 г..
 */

public class Main {
    public static void main(String[] args) throws IOException {
        printContent();
        printBody();
        login();
    }

    private static void printContent() {
        String content = "Content-Type: text/html\n\n";

        System.out.println(content);
    }

    private static void printBody() {
        String path = "C:\\Users\\Galin\\Desktop\\broken laptop\\softuni\\Java Web Development\\Java Web Development Basics\\Exercises HTTP Protocol\\src\\main\\resources\\log_in_form.html";
        String html = FileReader.readHtml(path);
        System.out.println(html);
    }

    private static void login() throws IOException {
        Map<String, String> params = Utils.getParameters(System.in);
        String username = params.get("username");
        String password = params.get("password");

        String output = String.format("Hi %s, your password is %s", username, password);

        System.out.println("<p>" + output + "</p>");
    }
}
