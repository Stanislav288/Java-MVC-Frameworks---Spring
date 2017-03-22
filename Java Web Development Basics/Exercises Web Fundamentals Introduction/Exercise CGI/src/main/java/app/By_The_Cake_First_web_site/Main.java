package app.By_The_Cake_First_web_site;

/**
 * Created by Galin on 26.1.2017 г..
 */
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
                "<hr>" +
                "</body>" +
                "</html>";

        return html;
    }
}
