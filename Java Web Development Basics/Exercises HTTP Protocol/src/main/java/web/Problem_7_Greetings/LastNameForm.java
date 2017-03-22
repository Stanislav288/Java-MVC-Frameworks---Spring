package web.Problem_7_Greetings;

import web.Utils;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Galin on 29.1.2017 г..
 */
public class LastNameForm {

    public static void main(String[] args) throws IOException {
        Main.printContent();
        Main.printHeader();

        String body = "<form action=\"age_form.cgi\" method=\"GET\" >" +
                "<h1>Please fulfill the required items</h1>" +
                " <label>Last Name:</label><input type=\"text\" name=\"lastName\" >\n" +
                "<input type=\"submit\" value=\"Next>\">" +
                "</form>";

        Map<String, String> params = Utils.getParameters(System.in);
        String firstName = params.get("firstName");
        Main.setFirstName(firstName);

        System.out.println("<p>"+firstName+"</p>");

        System.out.println(body);
        Main.printFooter();
    }
}
