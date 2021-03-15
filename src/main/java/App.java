public class App {
    public static void main(String[] args) {

        Stream chrome = new Stream("TestRepository1");
        Stream chrome2 = new Stream("TestRepository2");

        chrome.start();
        chrome2.start();

    }
}
