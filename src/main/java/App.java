import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

//        Stream edge = new Stream(Browsers.EDGE, "TestRepositoryEdge");
//        edge.start();

        Stream chrome1 = new Stream(Browsers.CHROME, "TestRepositoryChrome1");

        chrome1.start();



        Logging log = new Logging("log.txt");
        log.writeLog(true, "test");


    }
}
