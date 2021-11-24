package pl.jsystems.qa.qagui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommentsPage extends BasePage {

    public CommentsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".button.form-button.is-primary")
    public WebElement aveSettingsButton;

    @FindBy(xpath = "//*[@id=\"primary\"]/main/div[2]/div/div[1]/div[2]/div[2]/ul/li[1]/input")
    public WebElement commentsCheckBox;
}