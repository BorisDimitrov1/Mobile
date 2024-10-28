package page_objects;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class ResultPage {

    private By numberOfAds = By.xpath("//h1//parent::div");

    private By vipAddIndicator = By.xpath("//*[@class='promoLine']");

    private By lastPageFromPagination = By.xpath("//div[@class='a saveSlink gray']");
    private By nextPageButton = By.xpath("//*[@class='saveSlink next']");

    public int getNumberOfAds(){
        String numberOfAds = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(this.numberOfAds)).getText();
        String allNumbers = extractAllNumbers(numberOfAds);
        return extractLastNumber(allNumbers);
    }

    private String extractAllNumbers(String str)
    {
        // Replacing every non-digit number with a space(" ")
        str = str.replaceAll("[^0-9]", " "); // regular expression

        // Replace all the consecutive white spaces with a single space
        str = str.replaceAll(" +", " ");

        if (str.equals(""))
            return "-1";

        return str;
    }

    private int extractLastNumber(String str){
        String[] allNumbers = str.split(" ");

        return Integer.parseInt(allNumbers[allNumbers.length - 1]);
    }

    public int getCountOfAllVipAdds(){

        int result = 0;
        int currentPageVipAds;

        for(int currentPage = 1; currentPage < getNumberOfPages(); currentPage++){

            currentPageVipAds = getNumberOfVipAddsForCurrentPage();
            result += currentPageVipAds;

            if(currentPageVipAds < 20){
                return result;
            }else{
                Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(nextPageButton)).click();
            }
        }

        return result;
    }

    private int getNumberOfVipAddsForCurrentPage() {
        List<WebElement> vipAdds = Browser.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(vipAddIndicator));

        return vipAdds.size();
    }

    public int getNumberOfPages(){
        return Integer.parseInt(Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(lastPageFromPagination)).getText());
    }
}
