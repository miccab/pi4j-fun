package miccab.pi4jfun;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;

public class Pi4jManager implements AutoCloseable {
    private final Context pi4j;

    public Pi4jManager() {
        pi4j = Pi4J.newAutoContext();
    }

    public void printInfo() {
        pi4j.platforms().describe().print(System.out);
        pi4j.providers().describe().print(System.out);
    }

    public Context pi4j() {
        return pi4j;
    }

    @Override
    public void close() {
        pi4j.shutdown();
    }
}
