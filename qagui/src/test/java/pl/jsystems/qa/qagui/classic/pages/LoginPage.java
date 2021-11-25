package pl.jsystems.qa.qagui.classic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private static final String PROFILE_USER = "usernameOrEmail";
    private static final String PROFILE_LOGIN = "login__form-action";
    private static final String PROFILE_PASSWORD = "password";
    private static final String PROFILE_LOGIN_NAME = "login__form-action";

    @FindBy(id = PROFILE_USER)
    public WebElement userLogInput;
    //public WebElement userLogInput = driver.findElement(By.id("usernameOrEmail"));

    @FindBy(className = PROFILE_LOGIN)
    public WebElement userContinueButton;
    //public WebElement userContinueButton =  driver.findElement(By.className("login__form-action"));

    @FindBy(id = PROFILE_PASSWORD)
    public WebElement passLogInput;
    //public WebElement passLogInput = driver.findElement(By.id("password"));

    @FindBy(className = PROFILE_LOGIN_NAME)
    public WebElement passConfirmButton;
    //public WebElement passConfirmButton = driver.findElement(By.className("login__form-action"));

    public void enterUser(String userName) {
        visibilityOfElementLocated(By.id("usernameOrEmail"),3);
        this.userLogInput.click();
        this.userLogInput.clear();
        this.userLogInput.sendKeys(userName);
    }

    public void enterPass(String pass){
        visibilityOfElementLocated(By.id("password"),3);
        this.passLogInput.click();
        this.passLogInput.clear();
        this.passLogInput.sendKeys(pass);
    }

}
