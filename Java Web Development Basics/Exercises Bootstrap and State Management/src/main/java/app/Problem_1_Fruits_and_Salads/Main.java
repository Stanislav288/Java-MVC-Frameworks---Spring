package app.Problem_1_Fruits_and_Salads;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        printContent();
        printBody();
    }

    private static void printContent() {
        String content = "Content-Type: text/html\n\n";

        System.out.println(content);
    }

    private static void printBody() {
        String html =
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>Fruits</title>\n" +
                        "    <link rel=\"stylesheet\" href=\"../bootstrap/css/bootstrap.min.css\"/>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<div class=\"container\">\n" +
                        "    <div class=\"row\">\n" +
                        "        <div class=\"col-lg-3\">\n" +
                        "            <h3>Favorites</h3>\n" +
                        "            <ol>\n" +
                        "                <li><a href=\"#\">Banana</a></li>\n" +
                        "                <li><a href=\"#\">Watermelon</a></li>\n" +
                        "                <li><a href=\"#\">Apple</a></li>\n" +
                        "            </ol>\n" +
                        "        </div>\n" +
                        "        <div class=\"col-lg-9\">\n" +
                        "            <h1>Fresh Fruits & Salads</h1>\n" +
                        "            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the\n" +
                        "                industry's\n" +
                        "                standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it\n" +
                        "                to\n" +
                        "                make\n" +
                        "                a\n" +
                        "                type specimen book. It has survived not only five centuries, but also the leap into electronic\n" +
                        "                typesetting,\n" +
                        "                remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets\n" +
                        "                containing\n" +
                        "                Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including\n" +
                        "                versions\n" +
                        "                of Lorem Ipsum.</p>\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "</div>\n" +
                        "</body>\n" +
                        "</div>\n" +
                        "<script src=\"../bootstrap/jquery/jquery-3.1.1.min.js\"></script>\n" +
                        "<script src=\"../bootstrap/js/bootstrap.min.js\"></script>\n" +
                        "</body>\n" +
                        "</html>";
        System.out.println(html);
    }
}
