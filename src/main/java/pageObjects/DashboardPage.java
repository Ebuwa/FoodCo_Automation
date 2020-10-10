package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    //create a constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    //locate the dashboardPage elements using By

    private By household = By.xpath("//*[@id=\"nav-menu-item-3339\"]/a");
    private By subCategory = By.xpath("//*[@id=\"content\"]/div[3]/ul/li[4]/a/span/span[1]");
    private By getItem1 = By.xpath("//*[@id=\"content\"]/div[3]/ul/li[6]/div/div[1]/a/div");
    private By getItem2 = By.xpath("//*[@id=\"content\"]/div[3]/ul/li[8]/div/div[1]/a/div");
    private By getItem3 = By.xpath("//*[@id=\"content\"]/div[3]/ul/li[17]/div/div[1]/a/div");
    private By logOut = By.xpath("//*[@id=\"nav-menu-item-6558\"]/a");


    //confirm the URL of the dashboardPage
    public String getDashboardPageUrl() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        //wait for URL to be visible
        wait.until(ExpectedConditions.urlToBe("https://foodco.ng/user-account/"));
        return driver.getCurrentUrl();
    }



    public void clickHousehold() throws InterruptedException {
        //click on Household from categories on dashboard page
        Thread.sleep(5000);
        driver.findElement(household).click();
    }

    public void clickSubCategory() throws InterruptedException {
        Thread.sleep(10000);
        //select sub-category: Kitchen & Dinning
        driver.findElement(subCategory).click();
    }

    //assert first item on page list
    public void verifyGetItem1(){
        driver.findElement(getItem1).isDisplayed();
    }

    //assert second item second item on page list
    public void verifyGetItem2(){
        driver.findElement(getItem2).isDisplayed();
    }

    //assert third item on page list
    public void verifyGetItem3(){
        driver.findElement(getItem3).isDisplayed();
    }

    public LoginPage clickLogout() throws InterruptedException {
        //wait
        Thread.sleep(5000);
        driver.findElement(logOut).click();
        return new LoginPage(driver);
    }




}
