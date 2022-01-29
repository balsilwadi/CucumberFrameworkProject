package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarvanaAutoLoanCalcPage {
    public CarvanaAutoLoanCalcPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='input-group'])[1]")
    public WebElement price;

    @FindBy(xpath = "(//div[@class='input-group'])[2]")
    public WebElement downPayment;

    @FindBy(name = "creditScoreIndex")
    public WebElement creditScore;


    @FindBy(name = "loanTerm")
    public WebElement loanTerm;

    @FindBy(className = "loan-calculator-display-value")
    public WebElement monthlyPayment;





}
