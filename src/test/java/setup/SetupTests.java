package setup;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class SetupTests {
    //import webDriver object
    public WebDriver driver;
    //import loginPage object
    public LoginPage loginPage;
    //import dashboardPage object
    private DashboardPage dashboardPage;

    public SetupTests (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @BeforeTest
public void setUp(){
    //import ChromeDriver
    System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    //instantiate WebDriver object
    driver = new ChromeDriver();
    //maximize webpage
    driver.manage().window().maximize();
    //launch web application
    driver.get("https://foodco.ng/");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //instantiate login page after browser launch
    loginPage = new LoginPage(driver);
}

    @AfterTest
        public void quitBrowser() throws InterruptedException {
        //the "close" command would only close the browser but the "quit" command would exit the session
            driver.quit();
}


}

