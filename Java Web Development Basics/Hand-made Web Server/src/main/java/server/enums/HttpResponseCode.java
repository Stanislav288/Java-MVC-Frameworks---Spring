package server.enums;

/**
 * Created by Galin on 15.2.2017 г..
 */
public enum HttpResponseCode {
    OK(200,"OK"),
    MovedPermanently(301,"Moved Permanently"),
    Created(201,"Created"),
    Found(302,"Found"),
    Unauthorized(401,"Unauthorized");

    private int value;

    private String text;

    HttpResponseCode(int value,String text){
        this.value=value;
        this.text=text;
    }
}
