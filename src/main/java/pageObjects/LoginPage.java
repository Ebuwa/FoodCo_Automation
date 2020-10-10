package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LoginPage {
    //create webdriver object
    private WebDriver driver;
    public LoginPage (WebDriver driver){
        this.driver = driver;
    }


    //using By as a locator for elements
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[4]/button");
    private By popUp = By.id("wh-popups-change-d55105ba6a4aa22400dc3e42c4233r87");


    public void enterUsername (String uName){
        //find username elements and enter username elements
        WebElement passwordField = driver.findElement(By.id("txtUsername"));
        passwordField.sendKeys(uName);
    }

    public void enterPassword (String pwd){
        //find password elements and enter password elements
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.sendKeys(pwd);
    }

    public DashboardPage clickLoginButton (){
        //click on login button
        driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[4]/button")).click();
        return new DashboardPage (driver);
    }

    public String confirmPopUp(){
        return driver.findElement(popUp).getText();
    }


}
