public enum Browsers {
    CHROME("webdriver.chrome.driver", "C:\\chromedriver.exe"),
    EDGE("webdriver.edge.driver", "C://msedgedriver.exe");


    private final String driver;
    private final String address;
    Browsers(String driver, String address) {
        this.address = address;
        this.driver = driver;
    }

    public String getDriver() {
        return driver;
    }
    public String getAddress() {
        return address;
    }
}
