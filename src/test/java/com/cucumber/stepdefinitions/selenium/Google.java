package com.cucumber.stepdefinitions.selenium;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by vimalraj on 21/03/16.
 */
public class Google {
    WebDriver driver;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
//    	System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_win/chromedriver.exe");
//    	driver = new ChromeDriver();
    }

    @Given("^I am on Google home page$")
    public void iAmOnGoogleHomePage() throws Throwable {
        driver.get("http://www.google.com");
    }

    @Then("^I verify the title is \"([^\"]*)\"$")
    public void iVerifyTheTitleIs(String arg0) throws Throwable {
        Assert.assertEquals("Title not matches", arg0, driver.getTitle());
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshotBytes, "image/png");
        }

        if (driver != null) {
            driver.quit();
        }

    }
}
