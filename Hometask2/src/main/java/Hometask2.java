import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByChained;

import java.util.List;

public class Hometask2 {
    public static void main(String[] args) throws InterruptedException {

        String property = System.getProperty("user.dir") + "/driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", property);

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.bing.com/");

        WebElement search = driver.findElement(By.id("sb_form_q"));
        search.sendKeys("automation");
        search.submit();

        String page_title = driver.getTitle();
        System.out.println("The page title is: " + page_title);

        List<WebElement> search_results = driver.findElements(new ByChained(By.className("b_algo"), By.tagName("h2")));
        for (WebElement element: search_results) {
            String search_title = element.getText();
            System.out.println("\nTitle of search result " + search_results.indexOf(element) + " is: " + search_title);
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
