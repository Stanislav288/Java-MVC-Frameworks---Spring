package app.By_The_Cake_Add_menu;

public class Main {
    public static void main(String[] args) {
        String content=getContent();
        String html=getHtml();

        System.out.println(content);
        System.out.println(html);
    }

    private static String getContent() {
        String content = "Content-Type: text/html\n\n";

        return content;
    }

    private static String getHtml(){
        String html=  "<html>" +
                "<body>" +

                "<h1>By The Cake</h1>\n" +
                "<h2>Enjoy our awesome cakes</h2>\n" +
                "<hr>\n" +
                "<ul>\n" +
                "    <li>Home\n" +
                "        <ol>\n" +
                "            <li>Our cakes</li>\n" +
                "            <li>Our stores</li>\n" +
                "        </ol>\n" +
                "    </li>\n" +
                "    <li>Add cake</li>\n" +
                "    <li>Browse cakes</li>\n" +
                "    <li>About us</li>\n" +
                "</ul>" +

                "</body>" +
                "</html>";

        return html;
    }
}
