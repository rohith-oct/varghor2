package pack2;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FollowLinkTest extends TestBase {

	/**
     * Runs a simple test verifying link can be followed.
     *
     * @throws InvalidElementStateException
     */
    @Test(dataProvider = "hardCodedBrowsers")
    public void verifyLinkTest(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();

        this.annotate("Visiting GuineaPig page...");
        GuineaPigPage page = GuineaPigPage.visitPage(driver);

        this.annotate("Clicking on link...");
        page.followLink();

        this.annotate("Asserting that we are on a new page...");
        Assert.assertFalse(page.isOnPage());
    }

}


