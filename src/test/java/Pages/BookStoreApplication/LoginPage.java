package Pages.BookStoreApplication;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    public LoginPage(){
        PageFactory.initElements (driver, this);
    }

    @FindBy(id = "userName")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login")
    public WebElement loginButton;

    @FindBy(id = "newUser")
    public WebElement newUserButton;

    @FindBy(className = "mb-1")
    public WebElement invalidLoginMessage;

    //-------------------------------------

    public void enterUsername(String username){
        usernameField.clear ();
        usernameField.sendKeys (username);
    }
    public void enterPassword(String password){
        passwordField.clear ();
        passwordField.sendKeys (password);
    }

}
