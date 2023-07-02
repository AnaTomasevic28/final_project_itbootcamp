package Tests;

import Base.BaseTest;
import Pages.Elements.TextBoxPage;
import Pages.HomepagePage;
import Pages.SidebarPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTextBox extends BaseTest {

    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;
    public TextBoxPage textBoxPage;
    public String elementsCard;
    public String textBoxSubButton;
    public String textBoxUrl;
    public String fullName;
    public String email;
    public String currentAddress;
    public String permanentAddress;

    @BeforeMethod
    public void pageSetUp(){
        homepagePage = new HomepagePage ();
        sidebarPage = new SidebarPage ();
        textBoxPage = new TextBoxPage ();
        elementsCard = excelReader.getStringData ("CardNames", 0,0);
        textBoxSubButton = excelReader.getStringData ("ElementsSubButtons",0,0);
        textBoxUrl  = excelReader.getStringData ("URL", 1, 1);
        fullName = excelReader.getStringData ("TextBox",1 ,0);
        email = excelReader.getStringData ("TextBox", 1,1);
        currentAddress = excelReader.getStringData ("TextBox", 1,2);
        permanentAddress = excelReader.getStringData ("TextBox", 1,3);
        driver.get (homeURL);
    }


    @Test(priority = 1)
    public void userCanOpenTextBoxPage(){
        homepagePage.clickOnCard (elementsCard);
        sidebarPage.clickOnSidebarSubButtons (textBoxSubButton);
        Assert.assertEquals (driver.getCurrentUrl (), textBoxUrl);
        Assert.assertTrue (textBoxPage.submitButton.isDisplayed ());
        Assert.assertTrue (textBoxPage.fullNameField.isDisplayed ());
    }

    @Test(priority = 10)
    public void userCanSubmitValidData(){
        driver.get (textBoxUrl);
        textBoxPage.enterFullname (fullName);
        textBoxPage.enterEmail (email);
        textBoxPage.enterCurrentAddress (currentAddress);
        textBoxPage.enterPermanentAddress (permanentAddress);
        scrollIntoView (textBoxPage.submitButton);
        textBoxPage.submitButton.click ();
        Assert.assertTrue (textBoxPage.currentAddressField.get (1).isDisplayed ());
        Assert.assertTrue (textBoxPage.permanentAddressField.get (1).isDisplayed ());
        Assert.assertTrue (textBoxPage.nameSubmited.isDisplayed ());
        Assert.assertTrue (textBoxPage.emailSubmited.isDisplayed ());
    }


    @AfterMethod
    public void pageTearDown(){
//        driver.manage ().deleteAllCookies ();
//        driver.close ();
    }

}
