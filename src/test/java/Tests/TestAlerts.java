package Tests;

import Base.BaseTest;
import Pages.Alerts_Frame_Windows.AlertPage;
import Pages.HomepagePage;
import Pages.SidebarPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestAlerts extends BaseTest {

    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;
    public AlertPage alertPage;
    public JavascriptExecutor js;
    public WebDriverWait wait;
    public String alertsFrameWindowsCard;
    public String alertsSubButton;
    public String alertsURL;
    public String firtsAlertMessage;
    public String secondAlertMessage;
    public String thirdAlertMessage;


    @BeforeMethod
    public void pageSetUp() throws InterruptedException {
        homepagePage = new HomepagePage ();
        sidebarPage = new SidebarPage ();
        alertPage = new AlertPage ();
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait (driver, Duration.ofSeconds (10));
        alertsFrameWindowsCard = excelReader.getStringData ("CardNames", 2, 0);
        alertsSubButton = excelReader.getStringData ("AlertsFrameWindowsSubbutons", 2,0);
        alertsURL = excelReader.getStringData ("URL", 1, 5);
        firtsAlertMessage = "You clicked a button";
        secondAlertMessage = "This alert appeared after 5 seconds";
        thirdAlertMessage = "Do you confirm action?";
    }

    @Test(priority = 10)
    public void userCanGoOnAlertPage(){
        driver.get (homeURL);
        homepagePage.clickOnCard (alertsFrameWindowsCard);
        for (int i = 0; i < sidebarPage.sidebarSubButtons.size (); i++) {
            if (sidebarPage.sidebarSubButtons.get (i).getText ().equalsIgnoreCase (alertsSubButton)){
                scrollIntoView (sidebarPage.sidebarSubButtons.get (i));
            }
        }
        sidebarPage.clickOnSidebarSubButtons (alertsSubButton);
        Assert.assertEquals (driver.getCurrentUrl (), alertsURL);
        Assert.assertTrue (alertPage.alertButton.isDisplayed ());
        Assert.assertTrue (alertPage.confirmButton.isDisplayed ());
        Assert.assertTrue (alertPage.promtButton.isDisplayed ());
        Assert.assertTrue (alertPage.timerAlertButton.isDisplayed ());
    }

    @Test(priority = 20)
    public void alertAppearsWhenUserClicksOnFirstButton(){
        driver.get (alertsURL);
        alertPage.alertButton.click ();
        Assert.assertTrue (alertIsPresent ());
        Assert.assertEquals (driver.switchTo ().alert ().getText (), firtsAlertMessage);
        driver.switchTo ().alert ().accept ();
        Assert.assertFalse (alertIsPresent ());

    }

    @Test(priority = 30)
    public void alertAppearsAfterFiveSecWhenUserClicksOnSecondButton(){
        driver.get (alertsURL);
        alertPage.timerAlertButton.click ();
        Assert.assertFalse (alertIsPresent ());
        wait.until(ExpectedConditions.alertIsPresent ());
        Assert.assertTrue (alertIsPresent ());
        Assert.assertEquals (driver.switchTo ().alert ().getText (), secondAlertMessage);
        driver.switchTo ().alert ().accept ();
        Assert.assertFalse (alertIsPresent ());
    }

    @Test(priority = 40)
    public void confirmBoxAppearsWhenUserClicksOnThirdButton() throws InterruptedException {
        driver.get ("https://demoqa.com/alerts");
        alertPage.confirmButton.click ();
        Thread.sleep (2000);
        Assert.assertTrue (alertIsPresent ());
        Assert.assertEquals (driver.switchTo ().alert ().getText (), thirdAlertMessage);
        driver.switchTo ().alert ().accept ();
        Assert.assertTrue (alertPage.confirmMessage.isDisplayed ());
        Assert.assertEquals (alertPage.confirmMessage.getText (), "You selected Ok");

    }

    @Test(priority = 50)
    public void userCanDismisConfirmBox(){
        driver.get (alertsURL);
        alertPage.confirmButton.click ();
        Assert.assertTrue (alertIsPresent ());
        Assert.assertEquals (driver.switchTo ().alert ().getText (), thirdAlertMessage);
        driver.switchTo ().alert ().dismiss ();
        Assert.assertTrue (alertPage.confirmMessage.isDisplayed ());
        Assert.assertEquals (alertPage.confirmMessage.getText (), "You selected Cancel");
    }

    @Test(priority = 60)
    public void promptBoxAppearsWhenUserClicksOnFourthButton(){
        driver.get (alertsURL);
        alertPage.promtButton.click ();
        Assert.assertTrue (alertIsPresent ());
        Assert.assertEquals (driver.switchTo ().alert ().getText (), "Please enter your name");
    }

    @Test(priority = 70)
    public void userCanEnterTextInPromtpBox(){
        driver.get (alertsURL);
        alertPage.promtButton.click ();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys ("Ana");
        alert.accept ();
        Assert.assertTrue (alertPage.promptMessage.isDisplayed ());
        Assert.assertEquals (alertPage.promptMessage.getText (), "You entered Ana");

    }

    @Test(priority = 80)
    public void userCanDismisPromptBox(){
        driver.get (alertsURL);
        alertPage.promtButton.click ();
        Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
        alert2.sendKeys ("Ana");
        alert2.dismiss ();
        Assert.assertFalse (alertIsPresent ());
    }

    @AfterMethod
    public void pageTearDown(){
//        driver.manage ().deleteAllCookies ();
//        driver.close ();
    }
}
