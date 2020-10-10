package login;




import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import setup.SetupTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends SetupTests {


    public LoginTests(WebDriver driver) {
        super(driver);
    }

    //TestNG annotation
    @Test

    public void testLogin() throws InterruptedException {
        loginPage.enterUsername("ronnieosas@yahoo.com");
        loginPage.enterPassword("Ebuwatests4_0_1");



        //handler for dashboard page
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        Thread.sleep(10000);
        loginPage.confirmPopUp();
        Thread.sleep(5000);

        dashboardPage.clickHousehold();
        dashboardPage.clickSubCategory();

        Assert.assertEquals(dashboardPage.verifyGetItem1(), "Daewoo Oven Toaster 18l Dot-1656b";)
        Assert.assertEquals(dashboardPage.verifyGetItem2(), "Kenwood Blender";)
        Assert.assertEquals(dashboardPage.verifyGetItem3(), "Scanfrost Table Top Gas Cooker Sfttc2003";)

        loginPage = dashboardPage.clickLogout();

        System.out.println("Account logged out");

    }

}

