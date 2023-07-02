package Tests;

import Base.BaseTest;
import Pages.Elements.ButtonsPage;
import Pages.HomepagePage;
import Pages.SidebarPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestButtons extends BaseTest {

    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;
    public ButtonsPage buttonsPage;
    public JavascriptExecutor js;
    public Actions actions;
    public String elementsCard;
    public String buttonsSubButtonName;
    public String buttonsURL;
    public String doubleClickMessage;
    public String rightClickMessage;
    public String clickMessage;

    @BeforeMethod
    public void pageSetUp(){
        homepagePage = new HomepagePage ();
        sidebarPage = new SidebarPage ();
        buttonsPage = new ButtonsPage ();
        js = (JavascriptExecutor) driver;
        actions = new Actions (driver);
        elementsCard = excelReader.getStringData ("CardNames", 0,0);
        buttonsSubButtonName = excelReader.getStringData ("ElementsSubButtons",4,0);
        buttonsURL = excelReader.getStringData ("URL", 1,3);
        doubleClickMessage = "You have done a double click";
        rightClickMessage = "You have done a right click";
        clickMessage = "You have done a dynamic click";
        driver.get (homeURL);
    }

    @Test
    public void userCanOpenButtonsPage(){
        homepagePage.clickOnCard (elementsCard);
        for (int i = 0; i < sidebarPage.sidebarSubButtons.size (); i++) {
            if (sidebarPage.sidebarSubButtons.get (i).getText ().equalsIgnoreCase (buttonsSubButtonName)){
                scrollIntoView (sidebarPage.sidebarSubButtons.get (i));
                break;
            }
        }
        sidebarPage.clickOnSidebarSubButtons (buttonsSubButtonName);
        Assert.assertEquals (driver.getCurrentUrl (), buttonsURL);
        Assert.assertTrue (buttonsPage.buttons.get (0).isDisplayed ());
        Assert.assertTrue (buttonsPage.buttons.get (1).isDisplayed ());
        Assert.assertTrue (buttonsPage.buttons.get (2).isDisplayed ());
    }

    @Test
    public void doubleClickOnButton() {
        driver.get (buttonsURL);
        waitForVisibility (buttonsPage.buttons.get (0));
        actions.doubleClick (buttonsPage.buttons.get (0)).perform ();
        Assert.assertTrue (buttonsPage.doubleClickMessage.isDisplayed ());
        Assert.assertEquals (buttonsPage.doubleClickMessage.getText (), doubleClickMessage);
    }

    @Test
    public void rightClickOnButton(){
        driver.get (buttonsURL);
        waitForClickability (buttonsPage.buttons.get (1));
        actions.contextClick (buttonsPage.buttons.get (1)).perform();
        Assert.assertTrue (buttonsPage.rightClickMessage.isDisplayed ());
        Assert.assertEquals (buttonsPage.rightClickMessage.getText (), rightClickMessage);
    }

    @Test
    public void clickOnButton(){
        driver.get (buttonsURL);
        buttonsPage.buttons.get (2).click ();
        Assert.assertTrue (buttonsPage.clickMeMessage.isDisplayed ());
        Assert.assertEquals (buttonsPage.clickMeMessage.getText (), clickMessage);
    }

    @AfterMethod
    public void pageTearDown(){
//        driver.manage ().deleteAllCookies ();
//        driver.close ();
    }
}
