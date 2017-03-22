package mvcFramework.handlers;

import mvcFramework.annotations.controller.Controller;
import mvcFramework.annotations.request.GetMapping;
import mvcFramework.annotations.request.PostMapping;
import mvcFramework.controllerAction.ControllerActionPair;
import mvcFramework.contracts.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Galin on 22.2.2017 г..
 */
public class HandlerMappingImpl implements HandlerMapping {

    @Override
    public ControllerActionPair findController(HttpServletRequest request) throws MalformedURLException, UnsupportedEncodingException, ClassNotFoundException {
        String urlPath = request.getRequestURI();
        String projectPath =
                URLDecoder.decode(request.getServletContext().getResource("/WEB-INF/classes").getPath(),
                        "UTF-8");
        //TODO FindAllControllers;
        List<Class> controllers = this.findAllControllers(projectPath);
        ControllerActionPair controllerActionPair = null;
        for (Class controller : controllers) {
            Method[] methods = controller.getDeclaredMethods();
            for (Method method : methods) {
                //TODO Find method path
                String methodPath = this.findMethodPath(request, method);
                if (methodPath == null) {
                    continue;
                }
                //TODO If paths are matching return a new ActionPairController with the appropriate class, method and path variables
                if (this.isPathMatching(urlPath, methodPath)) {
                    controllerActionPair = new ControllerActionPair(controller, method);
                    this.addPathVariables(controllerActionPair, urlPath, methodPath);
                }
            }
        }

        return controllerActionPair;
    }


    private void addPathVariables(ControllerActionPair controllerActionPair, String urlPath, String methodPath) {
        String[] uriTokens = urlPath.split("/");
        String[] methodTokens = methodPath.split("/");
        //TODO If paths are matching return a new ActionPairController with the appropriate class, method and path variables
        for (int i = 0; i < methodTokens.length; i++) {
            if (methodTokens[i].startsWith("{") && methodTokens[i].endsWith("}")) {
                String key = methodTokens[i].replace("{","").replace("}","");
                String value = uriTokens[i];
                controllerActionPair.addPathVariable(key, value);
            }
        }
    }

    private boolean isPathMatching(String urlPath, String methodPath) {
        boolean isPathMatching = true;
        String[] uriTokens = urlPath.split("/");
        String[] methodsTokens = methodPath.split("/");
        //TODO If the lengths are different return false
        if (uriTokens.length != methodsTokens.length) {
            isPathMatching = false;
            return isPathMatching;
        }

        for (int i = 0; i < uriTokens.length; i++) {
            if (methodsTokens[i].startsWith("{") && methodsTokens[i].endsWith("}")) {
                continue;
            }

            if (!uriTokens[i].equals(methodsTokens[i])) {
                isPathMatching = false;
                break;
            }
        }
        //TODO If there is a path variable {some id} ignore and continue to check if the path is the same
        return isPathMatching;
    }

    private String findMethodPath(HttpServletRequest request, Method method) {
        String value = null;
        switch (request.getMethod()) {
            case "POST":
                PostMapping postMapping = method.getAnnotation(PostMapping.class);
                if (postMapping != null) {
                    value = postMapping.value();
                }
                break;
            case "GET":
                GetMapping getMapping = method.getAnnotation(GetMapping.class);
                if (getMapping != null) {
                    value = getMapping.value();
                }
                break;
        }

        return value;
    }

    private List<Class> findAllControllers(String projectDirectory) throws ClassNotFoundException {
        List<Class> controllerClasses = new ArrayList<>();
        File directory = new File(projectDirectory);
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                Class controller = this.getClass(file);
                if (controller != null) {
                    if (controller.isAnnotationPresent(Controller.class)) {
                        controllerClasses.add(controller);
                    }
                }
            } else if (file.isDirectory()) {
                //TODO Recursively check all directories for classes
                String subDirectory = file.getAbsolutePath();
                controllerClasses.addAll(this.findAllControllers(subDirectory));
            }

        }

        return controllerClasses;
    }

    private Class getClass(File file) throws ClassNotFoundException {
        String absolutePath = file.getAbsolutePath();
        String classPattern = "^(.+classes\\\\)(.+)(.class)$";
        Pattern pattern = Pattern.compile(classPattern);
        Matcher matcher = pattern.matcher(absolutePath);
        Class currentClass = null;
        if (matcher.find()) {
            String className = matcher.group(2).replace("\\", ".");
            if (!className.endsWith("DispatcherServlet")) {
                currentClass = Class.forName(className);
            }
        }

        return currentClass;
    }
}
