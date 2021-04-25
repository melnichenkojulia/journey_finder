import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class test {

    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver",test.class.getResource("chromedriver.exe").getPath());
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.poehalisnami.ua/goryashie-turi");
        sleep(100);
        Document doc = Jsoup.parse(driver.getPageSource());
        Elements elements = doc.getElementsByClass("b-tour-cards__link");
        for (Element elem: elements) {
            System.out.println(elem.text());
        }
        sleep(2000);

        driver.quit();





//        driver.quit();
    }}