package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginPage_RB {

    public LoginPage_RB(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#inputEmail")
    public WebElement emailInput;

    @FindBy(css = "#inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInBtn;

    @FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
    public WebElement accountHolderName;




  /*  public void login(String user) {
        String userEmail = ConfigurationReader.getProperty(user + "_username");
        String userPassword = ConfigurationReader.getProperty(user + "_password");
        emailBox.sendKeys(userEmail);
        passwordBox.sendKeys(userPassword);
        signInBtn.click();
    }

    */



    // overload login method to have two parameters
    /*
    public void login(String userName, String password){
        emailInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        signInBtn.click();
    }

     */















}


