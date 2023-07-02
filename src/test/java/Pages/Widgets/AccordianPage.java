package Pages.Widgets;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccordianPage extends BaseTest {

    public AccordianPage(){
        PageFactory.initElements (driver, this);
    }

    @FindBy(className = "card")
    List<WebElement> cards;

    @FindBy(id =  "section1Heading")
    public WebElement card1Header;

    @FindBy(id = "section1Content")
    public WebElement card1Text;

    @FindBy(id = "section2Heading")
    public WebElement card2Header;


    @FindBy(id = "section2Content")
    public WebElement card2Text;

    @FindBy(id = "section3Heading")
    public WebElement card3Header;

    @FindBy(id = "section3Content")
    public WebElement card3Text;

    //---------------------------------------------

}
