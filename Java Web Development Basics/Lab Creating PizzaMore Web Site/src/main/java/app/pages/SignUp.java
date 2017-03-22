package app.pages;

import app.models.header.Header;
import app.models.user.User;
import app.utils.WebUtils;
import app.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

public class SignUp {

    private static Map<String, String> parameters;

    private static Header header;

    private static UserRepository userRepository;

    static {
        parameters = new HashMap<>();
        header = new Header();
        userRepository = new UserRepository();
    }

    public static void main(String[] args) {
        readParameters();
        header.printHeader();
        readHtml();
    }

    private static void readParameters() {
        parameters = WebUtils.getParameters();
        String username = null;
        String password = null;
        for (String param : parameters.keySet()) {
            switch (param) {
                case "usename":
                    username = parameters.get("username");
                    break;
                case "password":
                    password = parameters.get("password");
                case "signup":
                    if (username.isEmpty() || password.isEmpty()) {
                        return;
                    }

                    User user = new User(username, password);
                    createUser(user);
                    header.addLocation("http://localhost:80/cgi-bin/signin.cgi");
                    break;
                case "main":
                    header.addLocation("http://localhost:80/cgi-bin/home.cgi");
                    break;
            }
        }
    }

    public static void createUser(User user){
        userRepository.createUser(user);
    }
}
