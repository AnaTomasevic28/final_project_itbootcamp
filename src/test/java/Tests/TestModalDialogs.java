package Tests;

import Base.BaseTest;
import Pages.Alerts_Frame_Windows.ModalDialogsPage;
import Pages.HomepagePage;
import Pages.SidebarPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestModalDialogs extends BaseTest {

    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;
    public ModalDialogsPage modalDialogsPage;
    public String alertsFrameWindowsCard;
    public String modalDialogsSubButton;
    public String modalDialogsUrl;

    @BeforeMethod
    public void pageSetUp(){
        homepagePage = new HomepagePage ();
        modalDialogsPage = new ModalDialogsPage ();
        sidebarPage = new SidebarPage ();
        alertsFrameWindowsCard = excelReader.getStringData ("CardNames", 2, 0);
        modalDialogsSubButton = excelReader.getStringData ("AlertsFrameWindowsSubbutons", 5, 0);
        modalDialogsUrl = excelReader.getStringData ("URL", 1, 6);
        driver.get (homeURL);

    }

    @Test(priority = 1)
    public void userCanGoOnModalDialogsPage(){
        homepagePage.clickOnCard (alertsFrameWindowsCard);
        for (int i = 0; i < sidebarPage.sidebarSubButtons.size (); i++) {
            if(sidebarPage.sidebarSubButtons.get (i).getText ().equalsIgnoreCase (modalDialogsSubButton)){
                scrollIntoView (sidebarPage.sidebarSubButtons.get (i));
                sidebarPage.sidebarSubButtons.get (i).click ();
            }
        }
        Assert.assertEquals (driver.getCurrentUrl (), modalDialogsUrl);
        Assert.assertTrue (modalDialogsPage.smallModalButton.isDisplayed ());
        Assert.assertTrue (modalDialogsPage.largeModalButton.isDisplayed ());
    }

    @Test
    public void userCanOpenSmallModalDialog(){
        userCanGoOnModalDialogsPage ();
        modalDialogsPage.smallModalButton.click ();
        Assert.assertTrue (modalDialogsPage.smallModalDialog.isDisplayed ());
        WebElement smallModalTitle =  driver.findElement (By.id ("example-modal-sizes-title-sm"));
        Assert.assertEquals ( smallModalTitle.getText (), "Small Modal");
    }

    @Test
    public void userCanCloseSmallModalDialog() throws InterruptedException {
        userCanGoOnModalDialogsPage ();
        userCanOpenSmallModalDialog ();
        modalDialogsPage.closeSmallDialog.click ();
        Thread.sleep (1000);
        Assert.assertFalse (elementIsPresent (modalDialogsPage.smallModalDialog));
    }

    @Test
    public void userCanOpenLargeModalDialog() throws InterruptedException {
        userCanGoOnModalDialogsPage ();
        modalDialogsPage.largeModalButton.click ();
        Thread.sleep (1000);
        Assert.assertTrue (modalDialogsPage.largeModalDialog.isDisplayed ());
        WebElement largeModalTitle = driver.findElement (By.id ("example-modal-sizes-title-lg"));
        Assert.assertEquals (largeModalTitle.getText (), "Large Modal");
    }

    @Test
    public void userCanCloseLargeModalDialog() throws InterruptedException {
        userCanGoOnModalDialogsPage ();
        userCanOpenLargeModalDialog ();
        modalDialogsPage.closeLargeDialog.click ();
        Thread.sleep (1000);
        Assert.assertFalse (elementIsPresent (modalDialogsPage.largeModalDialog));
    }

    @AfterMethod
    public void pageTearDown(){
        driver.manage ().deleteAllCookies ();
//        driver.close ();
    }
}
