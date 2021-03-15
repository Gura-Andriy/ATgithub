public class App {
    public static void main(String[] args) {
        MyDriver driver = new MyDriver();
        LoginProperty loginProperty = new LoginProperty();

        //Login on Github
        driver.logIn(loginProperty.username, loginProperty.password);
        driver.submit("//*[@id=\"login\"]/div[4]/form/div/input[12]", driver.checkTextareaNotEmptyById("password"));

        //Click to create new repository
        driver.createNewDirectory();

        //Create repository page
        driver.setNameOfDirectory("TestRepository");

        driver.setCheckbox("repository_auto_init");
        driver.setCheckbox("repository_gitignore_template_toggle");

        driver.setDropDownMenu("//*[@id=\"new_repository\"]/div[6]/div[4]/div[2]/span[2]/details/summary",
                "//*[@id=\"new_repository\"]/div[6]/div[4]/div[2]/span[2]/details/details-menu/div[3]/div[1]/label[52]/span");

        driver.submit("//*[@id=\"new_repository\"]/div[6]/button",  driver.checkTextareaNotEmptyById("repository_name"));

        //Write readme file
        driver.submit("//*[@id=\"readme\"]/div[1]/div");

        driver.writeText("//*[@id=\"new_blob\"]/div/file-attachment/div/div[2]/div/div/div[5]/div[1]/div/div/div/div[5]/div/pre/span/span",
                "test text in readme file");

        driver.submitById("submit-file");

        //Delete repository
        driver.delete();

        driver.submitDelete();

        driver.close();
    }
}
