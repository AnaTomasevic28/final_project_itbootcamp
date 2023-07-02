package Pages.Elements;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LinksPage extends BaseTest {

    public LinksPage(){
        PageFactory.initElements (driver, this);
    }

    @FindBy(id = "simpleLink")
    public WebElement firstLink;

    @FindBy(id = "dynamicLink")
    public WebElement secondLink;

    @FindBy(id = "created")
    public WebElement createdApiLink;

    @FindBy(id = "no-content")
    public WebElement noContentApiLink;

    @FindBy(id = "moved")
    public WebElement movedApiLink;

    @FindBy(id = "bad-request")
    public WebElement badRequestApiLink;

    @FindBy(id = "unauthorized")
    public WebElement unauthorizedApiLink;

    @FindBy(id = "forbidden")
    public  WebElement forbidenApiLink;

    @FindBy(id = "invalid-url")
    public WebElement notFoundApiLink;

    @FindBy(id = "linkResponse")
    public WebElement messages;

    //----------------------------------------

    public void clickOnLink(WebElement link){
        link.click ();
    }




}
