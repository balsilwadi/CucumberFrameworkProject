package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import utilities.Driver;
import utilities.Waiter;

public class CarvanaSteps {

    public WebDriver driver;
    public CarvanaHomePage carvanaHomePage;
    public CarvanaFinderPage carvanaFinderPage;
    public CarvanaQaPage carvanaQaPage;
    public CarvanaSellTradePage carvanaSellTradePage;
    public CarvanaGetYourOfferPage carvanaGetYourOfferPage;
    public CarvanaAutoLoanCalcPage carvanaAutoLoanCalcPage;
    Actions actions;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        carvanaHomePage = new CarvanaHomePage(driver);
        carvanaFinderPage = new CarvanaFinderPage(driver);
        carvanaQaPage = new CarvanaQaPage(driver);
        carvanaSellTradePage = new CarvanaSellTradePage(driver);
        carvanaGetYourOfferPage = new CarvanaGetYourOfferPage(driver);
        carvanaAutoLoanCalcPage = new CarvanaAutoLoanCalcPage(driver);
        actions = new Actions(driver);
    }


    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String key) {

        switch (key) {
            case "CAR FINDER" -> carvanaHomePage.carFinder.click();

            case "SELL/TRADE" -> carvanaHomePage.sellTrade.click();

            case "AUTO LOAN CALCULATOR" -> carvanaHomePage.autoLoanCalc.click();

        }

    }

    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedTo(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @And("user should see {string} text")
    public void userShouldSeeText(String key) {

        switch (key) {
            case "CAR FINDER" -> {
                Assert.assertTrue(carvanaFinderPage.header1.isDisplayed());
                Assert.assertEquals(carvanaFinderPage.header1.getText(), key);
            }
            case "Car Finder can help! Answer a few quick questions to find the right car for you." -> {
                Assert.assertTrue(carvanaFinderPage.header3.isDisplayed());
                Assert.assertEquals(carvanaFinderPage.header3.getText(), key);
            }
            case "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?" -> {
                Assert.assertTrue(carvanaQaPage.headline.isDisplayed());
                Assert.assertEquals(carvanaQaPage.headline.getText(), key);
            }
            case "Select up to 4 in order of importance" -> {
                Assert.assertTrue(carvanaQaPage.subHeadline.isDisplayed());
                Assert.assertEquals(carvanaQaPage.subHeadline.getText(), key);
            }
            case "GET A REAL OFFER IN 2 MINUTES" -> {
                Assert.assertTrue(carvanaSellTradePage.text.isDisplayed());
                Assert.assertEquals(carvanaSellTradePage.text.getText(), key);
            }
            case "We pick up your car. You get paid on the spot." -> {
                Assert.assertTrue(carvanaSellTradePage.subText.isDisplayed());
                Assert.assertEquals(carvanaSellTradePage.subText.getText(), key);
            }
            case "We couldn’t find that VIN. Please check your entry and try again." -> {
                Waiter.waitForWebElementToBeVisible(driver, 60, carvanaGetYourOfferPage.error);
                Assert.assertTrue(carvanaGetYourOfferPage.error.isDisplayed());
                Assert.assertEquals(carvanaGetYourOfferPage.error.getText(), key);
            }
        }

    }

    @And("user should see {string} link")
    public void userShouldSeeLink(String key) {
        Assert.assertTrue(carvanaFinderPage.tryCarFinder.isDisplayed());
        Assert.assertTrue(carvanaFinderPage.tryCarFinder.isEnabled());
        Assert.assertEquals(carvanaFinderPage.tryCarFinder.getText(), key);
    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String key) {
        carvanaFinderPage.tryCarFinder.click();
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String key) {

        switch (key) {
            case "VIN" -> carvanaSellTradePage.vinButton.click();

            case "GET MY OFFER" -> {
                Waiter.pause(5);
                carvanaSellTradePage.getMyOffer.click();
            }

        }
    }

    @And("user enters vin number as {string}")
    public void userEntersVinNumberAs(String key) {
        carvanaSellTradePage.vin.click();
        actions.sendKeys(key).perform();
    }

    @When("user hovers over on {string} menu item")
    public void userHoversOverOnMenuItem(String key) {
        actions.moveToElement(carvanaHomePage.financing).perform();
    }

    @When("user enters {string} as {string}")
    public void userEntersAs(String key1, String key2) {
        switch (key1) {
            case "Cost of Car I want" -> {
                carvanaAutoLoanCalcPage.price.click();
                actions.sendKeys(key2).perform();
            }

            case "What is Your Down Payment?" -> {
                carvanaAutoLoanCalcPage.downPayment.click();
                actions.sendKeys(key2).perform();
            }
        }
    }


    @And("user selects {string} as {string}")
    public void userSelectsAs(String key1, String key2) {
        switch (key1) {
            case "What’s Your credit Score?" -> {
                Select select = new Select(carvanaAutoLoanCalcPage.creditScore);
                select.selectByIndex(0);

            }

            case "Choose Your Loan Terms" -> {
                Select select = new Select(carvanaAutoLoanCalcPage.loanTerm);
                select.selectByIndex(1);
            }
        }
    }

    @Then("user should see the monthly payment as {string}")
    public void userShouldSeeTheMonthlyPaymentAs(String key) {
        Assert.assertEquals(carvanaAutoLoanCalcPage.monthlyPayment.getText(),key);
    }
}
