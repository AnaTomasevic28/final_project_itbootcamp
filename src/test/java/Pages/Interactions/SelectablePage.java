package Pages.Interactions;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectablePage extends BaseTest {

    public SelectablePage(){
        PageFactory.initElements (driver, this);
    }

    @FindBy(id = "demo-tab-list")
    public WebElement listTab;

    @FindBy(id = "demo-tab-grid")
    public WebElement gridTab;

    @FindBy(css = ".mt-2.list-group-item.list-group-item-action")
    public List<WebElement> listFields;

    @FindBy(css = ".list-group-item.list-group-item-action")
    public List<WebElement> gridFields;

//    @FindBy(linkText = "One")
//    public WebElement oneGrid;
//
//    @FindBy(linkText = "Two")
//    public WebElement twoGrid;
//
//    @FindBy(linkText = "Three")
//    public WebElement threeGrid;
//
//    @FindBy(linkText = "Four")
//    public WebElement fourGrid;
//
//    @FindBy(linkText = "Five")
//    public WebElement fiveGrid;
//
//    @FindBy(linkText = "Six")
//    public WebElement sixGrid;
//
//    @FindBy(linkText = "Seven")
//    public WebElement sevenGrid;
//
//    @FindBy(linkText = "Eight")
//    public WebElement eightGrid;
//
//    @FindBy(linkText = "Nine")
//    public WebElement nineGrid;

    //----------------------------------------

    public void clickOnListField(String nameOfTheField){
        for (int i = 0; i < listFields.size (); i++) {
            if (listFields.get (i).getText ().equalsIgnoreCase (nameOfTheField)){
                listFields.get (i).click ();
            }
        }
    }

    public void clickOnGridField(String nameOfTheField){
        for (int i = 0; i < gridFields.size (); i++) {
            if (gridFields.get (i).getText ().equalsIgnoreCase (nameOfTheField)){
                gridFields.get (i).click ();
            }
        }
    }

    public WebElement getOneListField(String nameOfTheField){
        for (int i = 0; i < listFields.size (); i++) {
            if (listFields.get (i).getText ().equalsIgnoreCase (nameOfTheField)){
                return listFields.get (i);
            }
        }
        return null;
    }

    public WebElement getOneGridField(String nameOfTheField){
        for (int i = 0; i < gridFields.size (); i++) {
            if (gridFields.get (i).getText ().equalsIgnoreCase (nameOfTheField)){
                return gridFields.get (i);
            }
        }
        return null;
    }





}
