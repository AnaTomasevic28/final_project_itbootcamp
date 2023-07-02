package Tests;

import Base.BaseTest;
import Pages.Elements.LinksPage;
import Pages.HomepagePage;
import Pages.SidebarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestLinks extends BaseTest {

    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;
    public LinksPage linksPage;
    public String elementsCard;
    public String linksSubButton;
    public String messageCreated;
    public String messageNoContent;
    public String messageMoved;
    public String messageBadRequest;
    public String messageUnauthorized;
    public String messageForbiden;
    public String messageNotFound;
    public String linksURL;
    public JavascriptExecutor js;



    @BeforeMethod
    public void pageSetUp(){
        homepagePage = new HomepagePage ();
        sidebarPage = new SidebarPage ();
        linksPage = new LinksPage ();
        js = (JavascriptExecutor) driver;
        elementsCard = excelReader.getStringData ("CardNames", 0,0);
        linksSubButton = excelReader.getStringData ("ElementsSubButtons", 5,0);
        messageCreated = excelReader.getStringData ("LinkMessages", 1,0);
        messageNoContent = excelReader.getStringData ("LinkMessages", 2, 0);
        messageMoved = excelReader.getStringData ("LinkMessages", 3,0);
        messageBadRequest = excelReader.getStringData ("LinkMessages", 4,0);
        messageUnauthorized = excelReader.getStringData ("LinkMessages", 5, 0);
        messageForbiden = excelReader.getStringData ("LinkMessages", 6, 0);
        messageNotFound = excelReader.getStringData ("LinkMessages", 7, 0);
        linksURL = excelReader.getStringData ("URL", 1, 4);
        driver.get (homeURL);

    }

    @Test(priority = 1)
    public void userCanOpenLinkPage(){
        homepagePage.clickOnCard (elementsCard);
        for (int i = 0; i < sidebarPage.sidebarSubButtons.size (); i++) {
            if (sidebarPage.sidebarSubButtons.get (i).getText ().equalsIgnoreCase (linksSubButton)){
                scrollIntoView (sidebarPage.sidebarSubButtons.get (i));
            }
        }
        sidebarPage.clickOnSidebarSubButtons (linksSubButton);
        Assert.assertEquals (driver.getCurrentUrl (), linksURL);
        Assert.assertTrue (linksPage.firstLink.isDisplayed ());
    }

    @Test
    public void clickOpensNewTab() throws InterruptedException {
        driver.get (linksURL);
        linksPage.clickOnLink (linksPage.firstLink);
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles ());
        driver.switchTo ().window (tabs.get (1));
        Assert.assertEquals (driver.getCurrentUrl (), homeURL);
        Assert.assertTrue (homepagePage.cards.get (0).isDisplayed ());
        Assert.assertTrue (homepagePage.cards.get (1).isDisplayed ());

        driver.switchTo ().window (tabs.get (0));
        linksPage.clickOnLink (linksPage.secondLink);
        ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles ());
        driver.switchTo ().window (tabs2.get (2));
        Assert.assertEquals (driver.getCurrentUrl (), homeURL);
        Assert.assertTrue (homepagePage.cards.get (0).isDisplayed ());
        Assert.assertTrue (homepagePage.cards.get (1).isDisplayed ());
    }

    @Test
    public void clickOnCreated(){
        driver.get (linksURL);
        linksPage.clickOnLink (linksPage.createdApiLink);
        waitForVisibility (linksPage.messages);
        Assert.assertTrue (linksPage.messages.isDisplayed ());
        Assert.assertEquals (linksPage.messages.getText (), messageCreated);
    }
    @Test
    public void clickOnNoContent(){
        driver.get (linksURL);
        linksPage.clickOnLink (linksPage.noContentApiLink);
        waitForVisibility (linksPage.messages);
        Assert.assertTrue (linksPage.messages.isDisplayed ());
        Assert.assertEquals (linksPage.messages.getText (), messageNoContent);
    }


    @Test
    public void clickOnMoved(){
        driver.get (linksURL);
        linksPage.clickOnLink (linksPage.movedApiLink);
        waitForVisibility (linksPage.messages);
        Assert.assertTrue (linksPage.messages.isDisplayed ());
        Assert.assertEquals (linksPage.messages.getText (), messageMoved);
    }

    @Test
    public void clickOnBadRequest(){
        driver.get (linksURL);
        linksPage.clickOnLink (linksPage.badRequestApiLink);
        waitForVisibility (linksPage.messages);
        Assert.assertTrue (linksPage.messages.isDisplayed ());
        Assert.assertEquals (linksPage.messages.getText (), messageBadRequest);
    }

    @Test
    public void clickOnUnauthorized(){
        driver.get (linksURL);
        linksPage.clickOnLink (linksPage.unauthorizedApiLink);
        waitForVisibility (linksPage.messages);
        Assert.assertTrue (linksPage.messages.isDisplayed ());
        Assert.assertEquals (linksPage.messages.getText (), messageUnauthorized);
    }

    @Test
    public void clickOnForbiden(){
        driver.get (linksURL);
        linksPage.clickOnLink (linksPage.forbidenApiLink);
        waitForVisibility (linksPage.messages);
        Assert.assertTrue (linksPage.messages.isDisplayed ());
        Assert.assertEquals (linksPage.messages.getText (), messageForbiden);
    }

    @Test
    public void clickNotFound(){
        driver.get (linksURL);
        scrollIntoView (linksPage.notFoundApiLink);
        linksPage.clickOnLink (linksPage.notFoundApiLink);
        Assert.assertTrue (linksPage.messages.isDisplayed ());
        Assert.assertEquals (linksPage.messages.getText (), messageNotFound);
    }

    @AfterMethod
    public void pageTearDown(){
//        driver.manage ().deleteAllCookies ();
//        driver.close ();
    }
}
