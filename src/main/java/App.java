import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {

//        Stream tor1 = new Stream(Browsers.TOR, "TestRepositoryTor1");
//        tor1.start();

        TorDriver tor = new TorDriver();
        tor.testSetup();
        tor.open_tor_browser();
        tor.afterClass();


//        Stream edge1 = new Stream(Browsers.EDGE, "TestRepositoryEdge1");
//
//        Stream chrome1 = new Stream(Browsers.CHROME, "TestRepositoryChrome1");
//
//        chrome1.start();
//        edge1.start();



    }
}
