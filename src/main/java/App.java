public class App {
    public static void main(String[] args) {
        MyDriver driver = new MyDriver();

        driver.logIn();

        driver.createNewDirectory();

        driver.setNameOfDirectory();

        driver.setCheckboxes();

        driver.submit();

        driver.delete();

        driver.submitDelete();

    }
}
