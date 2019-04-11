package android;

import java.io.IOException;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;

import static java.lang.Thread.*;

public class AppiumServer{

    public void startServer() {
        CommandLine cmd = new CommandLine("/usr/local/Cellar/node/10.2.1/bin/node");
        cmd.addArgument("/usr/local/lib/node_modules/appium/build/lib/main.js");
        cmd.addArgument("--address");
        cmd.addArgument("0.0.0.0");
        cmd.addArgument("--port");
        cmd.addArgument("4723");

        DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);
        try {
            executor.execute(cmd, handler);
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecuteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopServer() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("killall node Simulator");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}