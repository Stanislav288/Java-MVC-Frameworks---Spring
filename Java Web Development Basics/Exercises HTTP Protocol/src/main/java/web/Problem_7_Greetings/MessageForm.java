package web.Problem_7_Greetings;

import web.Utils;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Galin on 29.1.2017 г..
 */
public class MessageForm {
    public static void main(String[] args) throws IOException {
        Main.printContent();
        Main.printHeader();

        Map<String, String> params = Utils.getParameters(System.in);
        String age = params.get("age");
        Main.setAge(age);

        String output = String.format("Hello %s %s at age %s!", Main.getFirstName(), Main.getLastName(), Main.getAge());
        System.out.println("<h1>" + output + "</h1>");
        Main.printFooter();
    }


}
