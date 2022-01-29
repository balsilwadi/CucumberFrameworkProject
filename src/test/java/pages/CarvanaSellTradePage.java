package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarvanaSellTradePage {
    public CarvanaSellTradePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(text(), 'Get a real offer')]")
    public WebElement text;

    @FindBy(xpath = "//div[contains(@class, 'Subtitle__Text')]")
    public WebElement subText;

    @FindBy(xpath = "//button[@data-cv-test='VINToggle']")
    public WebElement vinButton;

    @FindBy(xpath = "//div[@data-cv-test='heroVinEntryInput']")
    public WebElement vin;

    @FindBy(xpath = "//button[@data-cv-test='heroGetMyOfferButton']")
    public WebElement getMyOffer;

}
