package tests;

import browser.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import page_objects.LandingPage;
import page_objects.ResultPage;
import page_objects.SearchPage;

public class MobileTest {

    private static final Logger log = LogManager.getLogger(MobileTest.class);

    @Before
    public void beforeScenario() {
        Browser.initChrome();
    }


    @Test
    public void Task(){

        //This could be passed to the mvn test task as a param if we need to handle different environments
        Browser.getDriver().get("https://www.mobile.bg/");

        LandingPage landingPage = new LandingPage();
        SearchPage search = new SearchPage();
        ResultPage resultsPage = new ResultPage();

        landingPage.acceptCookiesPolicy();
        landingPage.clickSearchSection();

        search.selectBrand("VW");
        search.selectModel("Golf");

        search.clickFourWheelOption();

        search.clickSearchButton();

        log.info("Number of VW Golfs with 4x4: " + resultsPage.getNumberOfAds());

        log.info("Number of VIP adds: " + resultsPage.getCountOfAllVipAdds());
    }

    @After
    public void afterScenario() {
        Browser.tearDown();
    }
}
