import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import java.util.*;

import static java.lang.Thread.sleep;



public class test {

    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", test.class.getResource("chromedriver.exe").getPath());
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.poehalisnami.ua/goryashie-turi");
        driver.manage().window().maximize();
        sleep(100);

        int i=0;
        Set<String> Links = new HashSet<>();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        while (i<10) {
            List<WebElement> elements = driver.findElements(By.className("b-tour-cards__item"));
            System.out.println("Elements:" + elements.size());
            for (WebElement elem : elements) {
                Links.add(elem.getAttribute("href"));
            }
            js.executeScript("window.scrollBy(0,1000);");
            sleep(1000);
            i++;
        }

        sleep(3000);
        System.out.println("total:");
        System.out.println(Links);

        driver.quit();




    }}