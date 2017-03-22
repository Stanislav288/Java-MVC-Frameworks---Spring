package server.contracts;

import server.enums.HttpRequestType;

import java.util.Map;

/**
 * Created by Galin on 15.2.2017 г..
 */
public interface HttpRequest {
    String getUrl();

    String getPath();

    HttpRequestType getRequestType();

    String getHeader(String name);

    Map<String,String> getURLParameters();

    Map<String,String> getFromData();

    void addParameter(String name,String value);

    HttpCookie getCookie();

    HttpSession getSession();

    void setSession(HttpSession session);
}
