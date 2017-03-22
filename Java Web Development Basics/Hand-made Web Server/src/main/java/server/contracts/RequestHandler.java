package server.contracts;

import java.io.IOException;
import java.io.Writer;

/**
 * Created by Galin on 15.2.2017 г..
 */
public interface RequestHandler {
    void handle(HttpContext httpContext) throws IOException;

    void setWriter(Writer writer);
}
