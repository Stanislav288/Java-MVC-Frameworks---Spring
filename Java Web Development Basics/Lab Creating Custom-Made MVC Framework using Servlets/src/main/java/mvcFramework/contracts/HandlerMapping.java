package mvcFramework.contracts;

import mvcFramework.controllerAction.ControllerActionPair;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

/**
 * Created by Galin on 22.2.2017 г..
 */
public interface HandlerMapping {

    ControllerActionPair findController(HttpServletRequest request) throws MalformedURLException, UnsupportedEncodingException, ClassNotFoundException;
}
