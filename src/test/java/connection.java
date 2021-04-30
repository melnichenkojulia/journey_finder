import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import static java.lang.Thread.sleep;

public class connection{
    long previousPageHeight=0;
    long pageHeight=0;
    Set<String> Links = new HashSet<>();

    WebDriver connect() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", test.class.getResource("chromedriver.exe").getPath());
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.poehalisnami.ua/goryashie-turi");
        driver.manage().window().maximize();
        sleep(100);
        return driver;

    }

    void scroll(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try{
            while (true) {
                previousPageHeight = pageHeight;
//                List<WebElement> elements = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.className("b-tour-cards__item")));

                js.executeScript("window.scrollBy(0,1500);");
                sleep(1000);
                long pagePosition = ((Number) js.executeScript("return window.pageYOffset;")).longValue();
                pageHeight = ((Number) js.executeScript("return document.body.scrollHeight")).longValue();
                sleep(1000);
                System.out.println("Val:" + pagePosition + " height: " + pageHeight + " previous: " + previousPageHeight);
                if (previousPageHeight == pageHeight){
                    System.out.println("page ended");
                    break;
                }
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    List<WebElement> findLinks(WebDriver driver){
    WebElement element = new WebDriverWait((WebDriver) driver, 10).until(ExpectedConditions.elementToBeClickable(By.className("b-tour-cards__item")));
    List<WebElement> elements = driver.findElements(By.className("b-tour-cards__item"));
    return elements;
    }

    Set<String> GoByLinks(List<WebElement> elements){
        for (WebElement elem : elements) {
           Links.add(elem.getAttribute("href"));
        }
        return Links;
    }

    void parse_by_links(Set<String> Links){
        Iterator<String> i=Links.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }

    }

}