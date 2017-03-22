package server.contracts;

/**
 * Created by Galin on 15.2.2017 г..
 */
public interface HttpResponse {
    String getResponse();
    void addResponseHeader(String header,String value);
}