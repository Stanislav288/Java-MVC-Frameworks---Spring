package server.contracts;

/**
 * Created by Galin on 15.2.2017 г..
 */
public interface HttpSession {
    String getId();

    void clear();

    void add(String key,String value);

    String get(String key);

    boolean isAuthenticated();
}
