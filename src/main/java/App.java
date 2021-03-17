import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

//        String tor = new String(Browsers.TOR, "TestRepositoryTor");


        Stream edge1 = new Stream(Browsers.EDGE, "TestRepositoryEdge");

        Stream chrome1 = new Stream(Browsers.CHROME, "TestRepositoryChrome1");

        chrome1.start();
        edge1.start();



    }
}
