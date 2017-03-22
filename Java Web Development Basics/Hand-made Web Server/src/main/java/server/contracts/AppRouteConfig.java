package server.contracts;

import server.RequestHandlerImpl;
import server.enums.HttpRequestType;

import java.util.Map;

/**
 * Created by Galin on 15.2.2017 г..
 */
public interface AppRouteConfig {
    AppRouteConfig addRoute(String path, RequestHandlerImpl handler);

    Iterable<Map.Entry<HttpRequestType,Map<String,RequestHandlerImpl>>> getRoutes();
}
