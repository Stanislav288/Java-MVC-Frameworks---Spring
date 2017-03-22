package mvcFramework.controllerAction;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Galin on 22.2.2017 г..
 */
public class ControllerActionPair {

    private Class controller;

    private Method actionMethod;

    private Map<String, String> pathVariables;

    public ControllerActionPair(Class controller, Method actionMethod) {
        this.controller = controller;
        this.actionMethod = actionMethod;
        this.pathVariables = new HashMap<>();
    }

    public Class getController() {
        return controller;
    }

    public Method getActionMethod() {
        return actionMethod;
    }

    public void addPathVariable(String key, String value) {
        this.pathVariables.put(key, value);
    }

    public String getPathVariable(String key) {
        return this.pathVariables.get(key);
    }
}
