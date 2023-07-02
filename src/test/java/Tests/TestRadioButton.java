package Tests;

import Base.BaseTest;
import Pages.Elements.RadioButtonPage;
import Pages.HomepagePage;
import Pages.SidebarPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestRadioButton extends BaseTest {

    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;
    public RadioButtonPage radioButtonPage;
    public String elementsCard;
    public String radioButtonSubButton;
    public String radioButtonURL;
    public JavascriptExecutor js;

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage ();
        sidebarPage = new SidebarPage ();
        radioButtonPage = new RadioButtonPage ();
        js = (JavascriptExecutor) driver;
        elementsCard = excelReader.getStringData ("CardNames", 0,0);
        radioButtonSubButton = excelReader.getStringData ("ElementsSubButtons",2,0);
        radioButtonURL = excelReader.getStringData ("URL", 1, 2);
        driver.get (homeURL);

    }

    @Test
    public void userCanOpenRadioButtonPage() throws InterruptedException {
        homepagePage.clickOnCard (elementsCard);
        sidebarPage.clickOnSidebarSubButtons (radioButtonSubButton);
        Assert.assertEquals (driver.getCurrentUrl (), radioButtonURL);
        Assert.assertTrue (radioButtonPage.messageQuestion.isDisplayed ());
        Assert.assertEquals (radioButtonPage.messageQuestion.getText (), "Do you like the site?");
    }

    @Test
    public void clickOnYesRadioButton(){
        driver.get (radioButtonURL);
        js.executeScript ("arguments[0].click()", radioButtonPage.yesRadioButton);
        Assert.assertTrue (radioButtonPage.yesRadioButton.isSelected ());
        Assert.assertTrue (radioButtonPage.messageAnswer.isDisplayed ());
        Assert.assertEquals (radioButtonPage.messageAnswer.getText (), "You have selected Yes");
    }
    @Test
    public void clickOnImpressiveButton(){
        driver.get (radioButtonURL);
        js.executeScript ("arguments[0].click()", radioButtonPage.impressiveRadioButton);
        Assert.assertTrue (radioButtonPage.impressiveRadioButton.isSelected ());
        Assert.assertTrue (radioButtonPage.messageAnswer.isDisplayed ());
        Assert.assertEquals (radioButtonPage.messageAnswer.getText (), "You have selected Impressive");
    }

    @Test
    public void clickOnNoRadioButton(){
        driver.get (radioButtonURL);
        js.executeScript ("arguments[0].click()", radioButtonPage.noRadioButton);
        Assert.assertTrue (radioButtonPage.noRadioButton.isSelected ());
        boolean b = false;
        try{
            b = radioButtonPage.messageAnswer.isDisplayed ();
        }
        catch (Exception e){
        }
        Assert.assertTrue (b);
    }

    @AfterMethod
    public void pageTearDown(){
//        driver.manage ().deleteAllCookies ();
//        driver.close ();
    }
}
