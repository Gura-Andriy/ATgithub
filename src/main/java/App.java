public class App {
    public static void main(String[] args) {

        Stream chrome = new Stream(Browsers.CHROME, "TestRepository1");
//        Stream edge = new Stream(Browsers.EDGE, "TestRepository2");

        chrome.start();
//        edge.start();

    }
}
