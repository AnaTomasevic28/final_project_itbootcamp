package Pages.Elements;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TextBoxPage extends BaseTest {

    public TextBoxPage(){
        PageFactory.initElements (driver, this);
    }

    @FindBy(id = "userName")
    public WebElement fullNameField;

    @FindBy(id = "userEmail")
    public WebElement userEmailField;

    @FindBy(id = "currentAddress")
    public List<WebElement> currentAddressField;

    @FindBy(id = "permanentAddress")
    public List<WebElement> permanentAddressField;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "email")
    public WebElement emailSubmited;

    @FindBy(id = "name")
    public WebElement nameSubmited;

    //--------------------------------

    public void enterFullname(String username){
        fullNameField.clear ();
        fullNameField.sendKeys (username);
    }

    public void enterEmail(String email){
        userEmailField.clear ();
        userEmailField.sendKeys (email);
    }
    public void enterCurrentAddress( String currentAddress){
        currentAddressField.get (0).clear ();
        currentAddressField.get (0).sendKeys (currentAddress);
    }

    public void enterPermanentAddress(String permanentAddress){
        permanentAddressField.get (0).clear ();
        permanentAddressField.get (0).sendKeys (permanentAddress);
    }


}
