import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class GoogleTest {
    FirefoxDriver wd;
    
    @Before
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void GoogleTest() {
        wd.get("https://www.google.co.in/?gfe_rd=cr&ei=HFzSV9ODFufA8geX-4ToCA");
        wd.findElement(By.xpath("//div[@id='lga']/div")).click();
        wd.findElement(By.id("sb_ifc0")).click();
        wd.findElement(By.id("lst-ib")).click();
        wd.findElement(By.id("lst-ib")).clear();
        wd.findElement(By.id("lst-ib")).sendKeys("Saucelabs Test");
        wd.findElement(By.id("lst-ib")).click();
        wd.findElement(By.id("lst-ib")).sendKeys("\n");
        wd.findElement(By.linkText("Sauce Labs: Cross Browser Testing, Selenium Testing, and Mobile ...")).click();
        wd.findElement(By.linkText("SIGN IN")).click();
        wd.findElement(By.name("username")).click();
        wd.findElement(By.name("username")).clear();
        wd.findElement(By.name("username")).sendKeys("raryshire");
        wd.findElement(By.name("password")).click();
        wd.findElement(By.name("password")).clear();
        wd.findElement(By.name("password")).sendKeys("maggieBless271\\");
        wd.findElement(By.id("submit")).click();
        wd.findElement(By.linkText("Automated Builds")).click();
        wd.findElement(By.linkText("TestGit1 Run 3")).click();
        wd.findElement(By.linkText("Dashboard")).click();
        if (!wd.findElement(By.tagName("html")).getText().contains("Automated Builds")) {
            System.out.println("verifyTextPresent failed");
        }
    }
    
    @After
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
