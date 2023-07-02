package Tests;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.Interactions.SelectablePage;
import Pages.SidebarPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSelectable extends BaseTest {

    public HomepagePage homepagePage;
    public SidebarPage sidebarPage;
    public SelectablePage selectablePage;
    public String activeColor = "rgba(0, 123, 255, 1)";
    public String notActiveColor = "rgba(248, 249, 250, 1)";



    @BeforeMethod
    public void pageSetUp() throws InterruptedException {
        homepagePage = new HomepagePage ();
        sidebarPage = new SidebarPage ();
        selectablePage = new SelectablePage ();
        driver.get (homeURL);
    }

    @Test
    public void userCanOpenSelectablePage(){
        homepagePage.clickOnCard ("Interactions");
        for (int i = 0; i < sidebarPage.sidebarSubButtons.size (); i++) {
            if (sidebarPage.sidebarSubButtons.get (i).getText ().equalsIgnoreCase ("Selectable")){
                scrollIntoView (sidebarPage.sidebarSubButtons.get (i));
            }
        }
        sidebarPage.clickOnSidebarSubButtons ("Selectable");

    }

    @Test
    public void userCanSelectAllFieldsInList(){
        userCanOpenSelectablePage ();
        for (int i = 1; i <= excelReader.getLastRow ("ListFields"); i++) {
            selectablePage.clickOnListField (excelReader.getStringData ("ListFields", i, 1));
            WebElement selectedField = selectablePage.getOneListField (excelReader.getStringData ("ListFields", i, 1));
            Assert.assertEquals (selectedField.getCssValue ("background-color"), activeColor);
            Assert.assertTrue (selectedField.getAttribute ("class").contains ("active"));
        }
    }

    @Test
    public void userCanUnselectAllFieldsInList(){
        userCanOpenSelectablePage ();
        userCanSelectAllFieldsInList ();
        for (int i = 1; i <= excelReader.getLastRow ("ListFields"); i++) {
            selectablePage.clickOnListField (excelReader.getStringData ("ListFields", i, 1));
            WebElement selectedField = selectablePage.getOneListField (excelReader.getStringData ("ListFields", i, 1));
            Assert.assertEquals (selectedField.getCssValue ("background-color"), notActiveColor);
            Assert.assertFalse (selectedField.getAttribute ("class").contains ("active"));
        }
    }

    @Test
    public void userCanSelectAllFieldsInGrid(){
        userCanOpenSelectablePage ();
        selectablePage.gridTab.click ();
        for (int i = 1; i <= excelReader.getLastRow ("GridFields"); i++) {
            selectablePage.clickOnGridField (excelReader.getStringData ("GridFields", i, 1));
            WebElement selectedField = selectablePage.getOneGridField (excelReader.getStringData ("GridFields", i, 1));
            Assert.assertEquals (selectedField.getCssValue ("background-color"), activeColor);
            Assert.assertTrue (selectedField.getAttribute ("class").contains ("active"));
        }
    }

    @Test
    public void userCanUnselectAllThegridFields(){
       userCanSelectAllFieldsInGrid ();
        for (int i = 1; i <= excelReader.getLastRow ("GridFields"); i++) {
            selectablePage.clickOnGridField (excelReader.getStringData ("GridFields", i, 1));
            WebElement selectedField = selectablePage.getOneGridField (excelReader.getStringData ("GridFields", i, 1));
            Assert.assertEquals (selectedField.getCssValue ("background-color"), notActiveColor);
            Assert.assertFalse (selectedField.getAttribute ("class").contains ("active"));
        }
    }
    
    @AfterMethod
    public void pageTearDown(){
//        driver.manage ().deleteAllCookies ();
//        driver.close ();
    }
}
