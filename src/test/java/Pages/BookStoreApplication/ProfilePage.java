package Pages.BookStoreApplication;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfilePage extends BaseTest {
    public ProfilePage(){
        PageFactory.initElements (driver, this);
    }

    @FindBy(css = ".btn.btn-primary")
    public List<WebElement> submitButtons;

    @FindBy(id = "userName-value")
    public WebElement userNameValue;
}
