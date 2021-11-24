package pl.jsystems.qa.qagui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WordpressMainPage extends BasePage {

    public WordpressMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Log In")
    public WebElement logIn;
    //public WebElement logIn = driver.findElement(By.linkText("Log In"));

    public void clickLogIn() {
        click(logIn, 5);
    }
}
