package app.models.header;

import app.models.cookie.Cookie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Galin on 1.2.2017 г..
 */
public class Header {
    private String type;

    private String location;

    private List<Cookie> cookies;

    public Header() {
        this.type = "Content-type:text/html";
        this.cookies=new ArrayList<>();
    }

    public void addLocation(String location){
        this.location=location;
    }

    public void addCookie(Cookie cookie){
        this.cookies.add(cookie);
    }

    public void printHeader(){
        System.out.println(this.type);

        if(!this.cookies.isEmpty()){
            StringBuilder cookies=new StringBuilder();
            for (Cookie cookie:this.cookies){
                cookies.append(cookie);
            }

            System.out.println("Set-cookie: "+cookies);

            if(this.location!=null){
                System.out.println("Location: "+this.location);
            }

            //End of header
            System.out.println();
        }
    }
}
