package server.contracts;

import server.enums.HttpRequestType;

import java.util.Map;

/**
 * Created by Galin on 15.2.2017 г..
 */
public interface ServerRouteConfig {
    Map<HttpRequestType,Map<String, RoutingContext>> getRoutes();
}
