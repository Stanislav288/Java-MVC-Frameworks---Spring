package web.Problem_7_Greetings;

import web.Utils;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Galin on 29.1.2017 г..
 */
public class AgeForm {

    public static void main(String[] args) throws IOException {
        Main.printContent();
        Main.printHeader();

        String body = "<form action=\"message_form.cgi\" method=\"GET\" >" +
                "<h1>Please fulfill the required items</h1>" +
                " <label>Age:</label><input type=\"text\" name=\"age\" >\n" +
                "<input type=\"submit\" value=\"Greet Me>\">" +
                "</form>";

        Map<String, String> params = Utils.getParameters(System.in);
        String lastName = params.get("lastName");
        Main.setLastName(lastName);

        System.out.println("<p>"+Main.getFirstName()+"</p>");
        System.out.println("<p>"+lastName+"</p>");

        System.out.println(body);
        Main.printFooter();
    }
}
