package page_objects;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage {

    private By searchSection = By.xpath("//a[@href='//www.mobile.bg/search/avtomobili-dzhipove']");

    private By acceptCookieButton = By.id("cookiescript_accept");

    public void clickSearchSection(){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(searchSection)).click();
    }

    public void acceptCookiesPolicy() {
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookieButton)).click();

        Browser.getDriver().switchTo().defaultContent();
    }
}
