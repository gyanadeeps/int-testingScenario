package Tests;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.implementation.bytecode.Throw;
import net.masterthought.cucumber.util.Util;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.util.concurrent.TimeUnit;


public class LoginStepDefination {

    WebDriver driver = new ChromeDriver(); //creating driver class so that we can use ever method


    @Given("^User (?:opens|Navigates to|Redirects to) \"([^\"]*)\" in browser$")  //?: is ignore as argument and act as regular exp
    public void user_open_url(String url) throws Throwable {
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        driver.get(url);

    }

    // throw new PendingException(); (if any step def is not define then it will show the error message.

    // (.*) - capture group
    // | - pipe use for alternation so that user can chose multiple values

    //@Then("^User can see \"([^\"]*)\"$")
    //public void user_can_see_field(String arg1) throws Throwable {
        //driver.findElement(By.name("UserLogin")); //user name field validate

        //driver.findElement(By.name("UserPasswd")); //password field validate


    //}

    @Then("^User should see (?:Button|Text|Link|Field) \"([^\"]*)\"$")
    public void user_can_see(String fieldName) throws Throwable {
        //driver.findElement(By.name(fieldName));  //validate text/field/link/button is getting displayed
        //driver.findElement(By.className(fieldName)); //validate text with class name
        //driver.findElement(By.linkText(fieldName)); //test field verify
        //driver.findElement(By.name(fieldName));
        //driver.findElement(By.("UserPasswd"));
        driver.findElement(By.linkText(fieldName));
    }

    @Then("^[iI] [Ss]hould see element with xpath \"([^\"]*)\"$")
    public void element_with_xpath(String xPath){
         driver.findElement(By.xpath(xPath));

        }

    @When("^I click on \"([^\"]*)\"$")
    public void i_click_on(String xPath) throws Throwable {

        try {
            WebElement newXpath = driver.findElement(By.xpath(xPath));
            newXpath.click();
            driver.getCurrentUrl();
            System.out.println("This is a link");
        } catch (Exception exp) {
            System.out.println("This is not a link");
            throw exp;
        }

    }

    //Mouse over on one object
    @When("^[Ii] [dD]o [Mm]ouseover on [Xx]path \"([^\"]*)\"$")
        public void mouseover_on_xpath(String xPath){
            Actions action = new Actions(driver);
            WebElement target = driver.findElement(By.xpath(xPath));
            action.moveToElement(target).perform();
        }

//    @Then("^I take a screenshot$")
//    public void i_take_a_screenshot(){
//
//        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrFile, new File("/Users/gsahoo/IdeaProjects/CucumberLearning/out/screenshots/test.png"));
//
//    }


    @When("^User type valid username (.*)$")
    public void user_login(String username) throws Throwable {
        WebElement loginField = driver.findElement(By.name("UserLogin")); //find login user name field
        loginField.sendKeys(username); //type username //find password name field
    }

    @When("^User type valid password (.*)$")
    public void user_password(String passwd) throws Throwable {
        WebElement loginPassword = driver.findElement(By.name("UserPasswd"));
        loginPassword.sendKeys(passwd); //type password
    }

    @When("^User click button \"([^\"]*)\"$")
    public void user_click_button(String arg) throws Throwable {
        WebElement clickButtonLogin = driver.findElement(By.name("login_button")); //find login button
        clickButtonLogin.click();  //click login button
        driver.findElement(By.name("UserLogin")); //user name should display on landing page

    }

    @Then("^User should not see \"([^\"]*)\"$")
    public void user_should_not_see(String arg1) throws Throwable {

        WebElement textShouldNotPresent = null;
        try {

            textShouldNotPresent = driver.findElement(By.name("login_button"));
        }
                catch(Exception exp)
            {
                System.out.println("Element should not present on this Page");
                throw exp;
            }

    }

    @Then("^User double click button \"([^\"]*)\"$")
    public void button_logout(String arg1) throws Throwable {
        WebElement clickButtonLogout = driver.findElement(By.id("ext-gen36"));
        clickButtonLogout.click();

        WebElement verifySuccessLogout = null;

        try
        {
            verifySuccessLogout = driver.findElement(By.linkText("Forgot Passwords?")); //forgot password link should display after logout

        }
                catch(Exception exp)

                {
                    System.out.println("Not able to find the element");
                    //throw exp;
                }

            Assert.assertEquals("The two value does not match",30, 20);
            Assert.assertNotNull("The object is not null", verifySuccessLogout);


    }

    @Then("^[Cc]lose the browser$")
    public void closeBrowser(){

       driver.quit();

    }


}