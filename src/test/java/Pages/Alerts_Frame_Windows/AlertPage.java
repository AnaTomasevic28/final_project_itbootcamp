package Pages.Alerts_Frame_Windows;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage extends BaseTest {

    public AlertPage(){
        PageFactory.initElements (driver, this);
    }

    @FindBy(id = "alertButton")
    public WebElement alertButton;

    @FindBy(id = "timerAlertButton")
    public WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    public WebElement confirmButton;

    @FindBy(id = "promtButton")
    public WebElement promtButton;

    @FindBy(id = "confirmResult")
    public WebElement confirmMessage;

    @FindBy(id = "promptResult")
    public WebElement promptMessage;

    //--------------------------------
}
