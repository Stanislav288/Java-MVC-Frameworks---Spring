package web.Problem_1_By_the_Cake_add_cake;

import web.FileReader;
import web.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    private static final List<Cake> cakes = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        printContent();
        // printHeader();
        printBody();
        addCake();
        //printFooter();

    }

    private static void printContent() {
        String content = "Content-Type: text/html\n\n";

        System.out.println(content);
    }

    private static void printBody() {
        String path="C:\\Users\\Galin\\Desktop\\broken laptop\\softuni\\Java Web Development\\Java Web Development Basics\\Exercises HTTP Protocol\\src\\main\\resources\\add_cake.html";
        String html = FileReader.readHtml(path);
        System.out.println(html);
    }

    private static void addCake() throws IOException {
        Map<String, String> params = Utils.getParameters(System.in);
        String name = params.get("name");
        int price = Integer.parseInt(params.get("price"));
        Cake cake = new Cake(name, price);
        cakes.add(cake);
        System.out.println("<p>" + cake + "</p>");
    }

    private static void printHeader() {
        System.out.println("<html><body>");
    }

    private static void printFooter() {
        System.out.println("</body></html>");
    }
}
