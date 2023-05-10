package gr.aueb.cf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


public class MySellenium {
    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Apostolis S/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        //driver.wait(3000);

        driver.get("http://tutorialsninja.com/demo/index.php"); // open the url

        driver.manage().window().maximize(); // maximize window

        driver.findElement(By.name("search")).click(); // clicks search tab
        Thread.sleep(1000); // wait 1 sec

        driver.findElement(By.name("search")).sendKeys("MacBook"); //types macbook in search tab
        Thread.sleep(1000); // wait 1 sec

        driver.findElement(By.className("input-group-btn")).click(); // clicks search button
        Thread.sleep(1000); // wait 1 sec

        driver.findElement(By.xpath("//img[@alt='MacBook']")).click();
        Thread.sleep(1000); // wait 1 sec

        driver.findElement(By.id("input-quantity")).clear(); // clears the original input
        Thread.sleep(1000); // wait 1 sec

        driver.findElement(By.name("quantity")).sendKeys("2"); // types 2 in quantity
        Thread.sleep(1000); // wait 1 sec

        driver.findElement(By.id("button-cart")).click(); // clicks add to cart button
        Thread.sleep(1000); // wait 1 sec

        String txt = driver.findElement(By.className("alert")).getText(); // gets responses text
        System.out.println(txt);

        Assert.assertEquals(txt, "Success: You have added MacBook to your shopping cart! \n×"); //checks if purchase succeed

        Thread.sleep(1000); // wait 1 sec
        driver.close(); // closes current tab
    }
}
