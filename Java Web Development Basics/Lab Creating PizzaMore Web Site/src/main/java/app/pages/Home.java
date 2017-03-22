package app.pages;

import app.models.cookie.Cookie;
import app.models.header.Header;
import app.models.session.Session;
import app.models.session.SessionData;
import app.repository.SessionRepository;
import app.utils.WebUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Home {

    private static Map<String, String> parameters;

    private static Map<String, Cookie> cookies;

    private static Header header;

    private static SessionRepository sessionRepository;

    static {
        parameters = new HashMap<>();
        cookies = new HashMap<>();
        header = new Header();
        sessionRepository = new SessionRepository();
    }


    public static void main(String[] args) {
        readParameters();
        header.printHeader();
        readCookies(args);
        readHtml();
    }

    public static void readParameters() {
        parameters = WebUtils.getParameters();
        for (String param : parameters.keySet()) {
            switch (param) {
                case "language":
                    String value = parameters.get("language");
                    setCookie("lang", value);
                    break;

                case "signin":
                    goToSignIn();
                    break;

                case "signup":
                    goToSignUp();
                    break;
            }
        }
    }

    private static void goToSignUp() {
        header.addLocation("http://localhost:80/cgi-bin/signup.cgi");
    }

    private static void goToSignIn() {
        header.addLocation("http://localhost:80/cgi-bin/signin.cgi");
    }

    private static void setCookie(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        header.addCookie(cookie);
    }

    private static void readCookies(String[] args) {
        if (args.length == 0) {
            return;
        }

        for (String incomingCookie : args) {
            String[] tokens = incomingCookie.split("=");
            String key = tokens[0];
            String value = tokens[1];
            value = value.replace(";", "");
            Cookie cookie = new Cookie(key, value);
            cookies.put(key, cookie);
        }
    }

    private static void signOut(long id) {
        sessionRepository.delete(id);
    }

    private static void readHtml() {
        Cookie sessionCookie = cookies.get("sid");
        String username = null;
        if (sessionCookie != null) {
            long sid = Long.parseLong(sessionCookie.getValue());
            Session session=sessionRepository.findById(sid);
            //Sign Out
            if(parameters.containsKey("signout")){
                signOut(sid);
                session=null;
            }

            if(session!=null){
                Set<SessionData>  sessionData=session.getSessionData();
                for (SessionData data:sessionData) {
                    if(data.getKey().equals("username")){
                        username=data.getValue();
                    }
                }
            }
        }


        Cookie languageCookie;
        if (!WebUtils.isPost()) {
            if (cookies.containsKey("lang")) {
                languageCookie = cookies.get("lang");
                if (languageCookie.getValue().equals("DE")) {
                    readHtmlDe(username);
                } else {
                    readHtmlEn(username);
                }
            }
        } else {
            if (parameters.containsKey("language")) {
                String language = parameters.get("language");
                if (language.equals("DE")) {
                    readHtmlDe(username);
                } else {
                    readHtmlEn(username);
                }
            }
        }
    }

    private static void readHtmlEn(String username) {
        String name="signIn";
        String value="Sign In";
        if(username!=null){
            name="signout";
            value="Sign Out ("+username+")";
        }
    }

    private static void readHtmlDe(String username) {
    }
}
