package Tests;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.SidebarPage;
import Pages.Widgets.AccordianPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAccordian extends BaseTest {

    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;
    public AccordianPage accordianPage;
    public String widgetsButton;
    public String accordianURL;


    @BeforeMethod
    public void pageSetUp(){
        homepagePage = new HomepagePage ();
        sidebarPage = new SidebarPage ();
        accordianPage = new AccordianPage ();
        widgetsButton = excelReader.getStringData ("CardNames", 3,0);
        accordianURL = excelReader.getStringData ("URL", 6, 0);
        driver.get (homeURL);
    }

    @Test
    public void userCanGoOnAccordianPage(){
        homepagePage.clickOnCard (widgetsButton);
        for (int i = 0; i < sidebarPage.sidebarSubButtons.size (); i++) {
            if (sidebarPage.sidebarSubButtons.get (i).getText ().equalsIgnoreCase ("Accordian")){
                scrollIntoView (sidebarPage.sidebarSubButtons.get (i));
                sidebarPage.sidebarSubButtons.get (i).click ();
            }
        }
        Assert.assertEquals (driver.getCurrentUrl (), accordianURL);
        Assert.assertTrue (accordianPage.card1Header.isDisplayed ());
        Assert.assertTrue (accordianPage.card1Text.isDisplayed ());
    }

    @Test
    public void userCanCloseFirstCardText() throws InterruptedException {
        userCanGoOnAccordianPage ();
        accordianPage.card1Header.click ();
        Thread.sleep (1000);
        Assert.assertFalse (elementIsPresent (accordianPage.card1Text));
    }

    @Test
    public void userCanOpenaAndCloseSecondCardText() throws InterruptedException {
        userCanGoOnAccordianPage ();
        accordianPage.card2Header.click ();
        Thread.sleep (1000);
        Assert.assertFalse (elementIsPresent (accordianPage.card1Text));
        Assert.assertTrue (elementIsPresent (accordianPage.card2Text));
        accordianPage.card2Header.click ();
        Thread.sleep (1000);
        Assert.assertFalse (elementIsPresent (accordianPage.card2Text));
    }

    @Test
    public void userCanOpenaAndCloseThirdCardText() throws InterruptedException {
        userCanGoOnAccordianPage ();
        accordianPage.card3Header.click ();
        Thread.sleep (1000);
        Assert.assertFalse (elementIsPresent (accordianPage.card1Text));
        Assert.assertTrue (elementIsPresent (accordianPage.card3Text));
        accordianPage.card3Header.click ();
        Thread.sleep (1000);
        Assert.assertFalse (elementIsPresent (accordianPage.card3Text));
    }

    @AfterMethod
    public void pageTearDown(){
        driver.manage ().deleteAllCookies ();
//        driver.close ();
    }
}
