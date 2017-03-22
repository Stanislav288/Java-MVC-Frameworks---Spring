package mvcFramework.contracts;

import mvcFramework.controllerAction.ControllerActionPair;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Galin on 21.2.2017 г..
 */
public interface Dispatcher {

    ControllerActionPair dispatchRequest(HttpServletRequest request);

    String dispatchAction(HttpServletRequest request, HttpServletResponse response, ControllerActionPair controllerActionPair);
}
