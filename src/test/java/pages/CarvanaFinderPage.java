package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarvanaFinderPage {
    public CarvanaFinderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
    public WebElement header1;

    @FindBy(tagName = "h3")
    public WebElement header3;

    @FindBy(xpath = "//a[@data-qa='router-link']")
    public WebElement tryCarFinder;



}
