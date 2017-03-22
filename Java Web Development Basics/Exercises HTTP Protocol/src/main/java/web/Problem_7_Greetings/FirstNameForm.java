package web.Problem_7_Greetings;


public class FirstNameForm {
    public static void main(String[] args) {
        Main.printContent();
        Main.printHeader();

        String body="<form action=\"last_name_form.cgi\" method=\"GET\" >" +
                "<h1>Please fulfill the required items</h1>"+
                " <label>First Name:</label><input type=\"text\" name=\"firstName\" >\n" +
                "<input type=\"submit\" value=\"Next>\">"+
                "</form>";

        System.out.println(body);
        Main.printFooter();
    }
}
