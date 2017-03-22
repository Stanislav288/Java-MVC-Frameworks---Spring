package web.Problem_7_Greetings;

public class Main {

    private static String firstName;

    private static String lastName;

    private static String age;

    public static void main(String[] args) {

    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        Main.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        Main.lastName = lastName;
    }

    public static String getAge() {
        return age;
    }

    public static void setAge(String age) {
        Main.age = age;
    }

    public void printRequirement(){
        System.out.println("<h1>"+"Please fulfill the required items"+"</h1>");
    }

    public static void printContent() {
        String content = "Content-Type: text/html\n\n";

        System.out.println(content);
    }

    public static void printHeader() {
        System.out.println("<html><body>");
    }

    public static void printFooter() {
        System.out.println("</body></html>");
    }
}
