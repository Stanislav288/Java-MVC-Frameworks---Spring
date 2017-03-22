package softuni.models.bindingModels;

/**
 * Created by Galin on 4.3.2017 г..
 */
public class IssueBindingModel {

    private String name;

    private String priority;

    private String status;

    private LoggedUserModel author;

    public IssueBindingModel(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LoggedUserModel getAuthor() {
        return author;
    }

    public void setAuthor(LoggedUserModel author) {
        this.author = author;
    }
}
