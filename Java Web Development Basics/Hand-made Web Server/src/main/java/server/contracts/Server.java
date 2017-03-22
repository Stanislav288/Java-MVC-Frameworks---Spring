package server.contracts;

import java.net.SocketException;

/**
 * Created by Galin on 15.2.2017 г..
 */
public interface Server {
    void runServer() throws SocketException;
}
