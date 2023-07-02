package Tests;

import Base.BaseTest;
import Pages.BookStoreApplication.LoginPage;
import Pages.BookStoreApplication.ProfilePage;
import Pages.HomepagePage;
import Pages.SidebarPage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.profiler.model.Profile;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {

    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;
    public LoginPage loginPage;
    public ProfilePage profilePage;
    public String bookStoreApplicatonCard;
    public String loginURL;
    public String validUsername;
    public String validPassword;
    public String profileURL;




    @BeforeMethod
    public void pageSetUp(){
        homepagePage = new HomepagePage ();
        sidebarPage = new SidebarPage ();
        loginPage = new LoginPage ();
        profilePage = new ProfilePage ();
        bookStoreApplicatonCard = excelReader.getStringData ("CardNames", 5,0);
        loginURL = excelReader.getStringData ("URL", 6,1);
        profileURL = excelReader.getStringData ("URL", 6,2);
        validUsername = excelReader.getStringData ("LoginPage", 1,0);
        validPassword = excelReader.getStringData ("LoginPage", 1,1);
        driver.get ("https://demoqa.com/");
    }

    @Test(priority = 1)
    public void userCanGoOnLoginPage(){
        homepagePage.clickOnCard (bookStoreApplicatonCard);
        for (int i = 0; i < sidebarPage.sidebarSubButtons.size (); i++) {
            if (sidebarPage.sidebarSubButtons.get (i).getText ().equalsIgnoreCase ("Login")){
                scrollIntoView (sidebarPage.sidebarSubButtons.get (i));
                sidebarPage.sidebarSubButtons.get (i).click ();
            }
        }
        Assert.assertTrue (loginPage.loginButton.isDisplayed ());
        Assert.assertEquals (driver.getCurrentUrl (), loginURL);
    }

    @Test(priority = 40)
    public void userCanLoginWithValidCredentials() throws InterruptedException {
        driver.get (loginURL);
        loginPage.enterUsername (validUsername);
        loginPage.enterPassword (validPassword);
        loginPage.loginButton.click ();
        Thread.sleep (1000);
        for (int i = 0; i < profilePage.submitButtons.size (); i++) {
            if (profilePage.submitButtons.get (i).getText ().equalsIgnoreCase ("Log Out")){
                Assert.assertTrue (profilePage.submitButtons.get (i).isDisplayed ());
            }
        }
        Thread.sleep (2000);
        Assert.assertEquals (driver.getCurrentUrl (), profileURL);
        Assert.assertEquals (profilePage.userNameValue.getText (), validUsername);
    }

    @Test(priority = 10)
    public void userCanNotLoginWithInvalidUsername() throws InterruptedException {
        driver.get (loginURL);
        for (int i = 1; i < excelReader.getLastRow ("LoginPage"); i++) {
            loginPage.enterUsername (excelReader.getStringData ("LoginPage", i, 2));
            loginPage.enterPassword (validPassword);
            loginPage.loginButton.click ();
            Assert.assertEquals (driver.getCurrentUrl (), loginURL);
            Thread.sleep (1000);
            Assert.assertTrue (loginPage.invalidLoginMessage.isDisplayed ());
            Assert.assertEquals (loginPage.invalidLoginMessage.getText (), "Invalid username or password!");
        }
    }

    @Test(priority = 20)
    public void userCanNotLoginWithInvalidPassword() throws InterruptedException {
        driver.get (loginURL);
        for (int i = 1; i < excelReader.getLastRow ("LoginPage"); i++) {
            loginPage.enterUsername (validUsername);
            loginPage.enterPassword (excelReader.getStringData ("LoginPage", i, 3));
            loginPage.loginButton.click ();
            Assert.assertEquals (driver.getCurrentUrl (), loginURL);
            Thread.sleep (1000);
            Assert.assertTrue (loginPage.invalidLoginMessage.isDisplayed ());
            Assert.assertEquals (loginPage.invalidLoginMessage.getText (), "Invalid username or password!");
        }

    }

    @Test(priority = 30)
    public void userCanNotLoginWithInvalidUsernameAndInvalidPassword() throws InterruptedException {
        driver.get (loginURL);
        for (int i = 1; i < excelReader.getLastRow ("LoginPage"); i++) {
            loginPage.enterUsername (excelReader.getStringData ("LoginPage", i, 2));
            loginPage.enterPassword (excelReader.getStringData ("LoginPage", i, 3));
            loginPage.loginButton.click ();
            Assert.assertEquals (driver.getCurrentUrl (), loginURL);
            Thread.sleep (1000);
            Assert.assertTrue (loginPage.invalidLoginMessage.isDisplayed ());
            Assert.assertEquals (loginPage.invalidLoginMessage.getText (), "Invalid username or password!");
        }
    }

    @AfterMethod
    public void pageTearDown(){
        driver.manage ().deleteAllCookies ();
    }
}
