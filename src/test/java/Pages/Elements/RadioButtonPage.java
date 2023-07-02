package Pages.Elements;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage extends BaseTest {

    public RadioButtonPage(){
        PageFactory.initElements (driver,this);
    }

    @FindBy(id = "yesRadio")
    public WebElement yesRadioButton;

    @FindBy(id = "impressiveRadio")
    public WebElement impressiveRadioButton;

    @FindBy(id = "noRadio")
    public WebElement noRadioButton;

    @FindBy(className = "mb-3")
    public WebElement messageQuestion;

    @FindBy(className = ("mt-3"))
    public WebElement messageAnswer;

    //--------------------------------------------

    public void clickOnRadioButton(WebElement button){
        button.click ();
    }


}
