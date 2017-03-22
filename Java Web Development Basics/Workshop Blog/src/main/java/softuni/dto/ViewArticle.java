package softuni.dto;


public class ViewArticle {

    private long id;

    private String articleTitle;

    private String articleContent;

    private String authorFullName;

    public ViewArticle() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {

        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent =
                articleContent.length() >= 500
                        ? articleContent.substring(0, 500)
                        : articleContent.substring(0, articleContent.length());
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }
}
