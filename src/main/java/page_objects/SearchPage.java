package page_objects;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class SearchPage {

    private By brandSelect = By.xpath("(//*[text()='Марка']//..//..//..//select)[1]");

    private By modelSelect = By.xpath("(//*[text()='Марка']//..//..//..//select)[2]");

    private By fourWheelsOption = By.xpath("//span[text()='4x4']");

    private By searchButton = By.xpath("//input[@type='button']");


    public void selectBrand(String brand){
        Select brandSelect = new Select(Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(this.brandSelect)));

        brandSelect.selectByVisibleText(brand);
    }

    public void selectModel(String model){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(modelSelect)).sendKeys(model);
    }

    public void clickSearchButton(){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton)).click();
    }

    public void clickFourWheelOption(){
        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(fourWheelsOption)).click();
    }

}
