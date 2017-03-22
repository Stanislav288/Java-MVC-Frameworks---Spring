package app;

public class Problem_1_Welcome_to_HTML {
    public static void main(String[] args) {

        String content = getContent();
        String html = getHtml();

        System.out.println(content);
        System.out.println(html);
    }

    private static String getContent() {
        String content = "Content-Type: text/html\n\n";

        return content;
    }

    private static String getHtml() {
        String html = "<html>" +
                ""
                ""
                "<body>" +
                "<p>I am learning HTML and CSS!</p>\n" +
                "</body>" +
                "</html>";

        return html;
    }
}
