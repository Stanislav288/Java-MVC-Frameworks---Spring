package server.contracts;

import server.RequestHandlerImpl;

/**
 * Created by Galin on 15.2.2017 г..
 */
public interface RoutingContext {
    RequestHandlerImpl getHandler();

    Iterable<String> getParamNames();
}
