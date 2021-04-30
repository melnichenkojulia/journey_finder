import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.Set;



public class test {
    public static void main(String[] args) throws InterruptedException, IOException {
        connection connect1=new connection();
        WebDriver driver=connect1.connect();
        connect1.scroll(driver);
        List<WebElement> elements=connect1.findLinks(driver);
        Set <String> Links=connect1.GoByLinks(elements);
        connect1.parse_by_links(Links);
        driver.quit();


}
}






