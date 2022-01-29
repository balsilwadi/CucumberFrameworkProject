package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.CarvanaSteps;

public class CarvanaHomePage {
    public CarvanaHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //Scenario 1
    @FindBy(xpath = "//a[@data-cv-test='headerCarFinderLink']")
    public WebElement carFinder;

    //Scenario 2
    @FindBy(xpath = "//a[@data-cv-test='headerTradesLink']")
    public WebElement sellTrade;

    //Scenario 3
    @FindBy(xpath = "//a[@class='MenuButton__MenuButtonWrapper-dq0g44-0 imLDTG']")
    public WebElement financing;

    @FindBy(xpath = "//a[@data-cv-test='headerFinanceLoanCalc']")
    public WebElement autoLoanCalc;


}
