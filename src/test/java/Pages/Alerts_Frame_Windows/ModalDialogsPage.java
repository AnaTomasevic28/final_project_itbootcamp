package Pages.Alerts_Frame_Windows;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalDialogsPage extends BaseTest {

    public ModalDialogsPage(){
        PageFactory.initElements (driver, this);
    }

    @FindBy(id = "showSmallModal")
    public WebElement smallModalButton;

    @FindBy(id = "showLargeModal")
    public WebElement largeModalButton;

    @FindBy(css = ".modal-dialog.modal-sm")
    public WebElement smallModalDialog;

    @FindBy(id = "closeSmallModal")
    public WebElement closeSmallDialog;

    @FindBy(css = ".modal-dialog.modal-lg")
    public WebElement largeModalDialog;

    @FindBy(id = "closeLargeModal")
    public WebElement closeLargeDialog;

    //----------------------------------------



}
