public class App {
    public static void main(String[] args) {
        MyDriver driver = new MyDriver();
        LoginProperty loginProperty = new LoginProperty();

        driver.logIn(loginProperty.username, loginProperty.password);

        driver.submit("//*[@id=\"login\"]/div[4]/form/div/input[12]");

        driver.createNewDirectory();

        driver.setNameOfDirectory("TestRepository");

        driver.setCheckbox("repository_auto_init");
        driver.setCheckbox("repository_gitignore_template_toggle");

        driver.setDropDownMenu("//*[@id=\"new_repository\"]/div[6]/div[4]/div[2]/span[2]/details/summary",
                "//*[@id=\"new_repository\"]/div[6]/div[4]/div[2]/span[2]/details/details-menu/div[3]/div[1]/label[52]/span");

        driver.submit("//*[@id=\"new_repository\"]/div[6]/button");

        driver.delete();

        driver.submitDelete();

        driver.close();
    }
}
