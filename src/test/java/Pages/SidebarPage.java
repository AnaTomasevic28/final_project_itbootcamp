package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;

public class SidebarPage extends BaseTest {

    public SidebarPage(){
        PageFactory.initElements (driver, this);
    }

    @FindBy(className = "group-header")
    public List<WebElement> sidebarButtons;

    @FindBy(css = ".btn.btn-light ")
    public List<WebElement> sidebarSubButtons;

    //----------------------------------------

    public void clickOnSidebarButton(String nameOfSidebarButton){
        for (int i = 0; i < sidebarButtons.size (); i++) {
           if (sidebarButtons.get (i).getText ().equalsIgnoreCase (nameOfSidebarButton)){
               sidebarButtons.get (i).click ();
               break;
           }
        }
    }

    public void clickOnSidebarSubButtons(String nameOfSidebarSubButton){
        for (int i = 0; i < sidebarSubButtons.size (); i++) {
            if (sidebarSubButtons.get (i).getText ().equalsIgnoreCase (nameOfSidebarSubButton)){
                sidebarSubButtons.get (i).click ();
                break;
            }
        }
    }
}
