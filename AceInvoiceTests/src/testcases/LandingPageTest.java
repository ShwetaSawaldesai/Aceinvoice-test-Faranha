
package testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class LandingPageTest {

    WebDriver driver = new ChromeDriver();
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    String month = calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.ENGLISH);
    int year = Calendar.getInstance().get(Calendar.YEAR);
    String Year = Integer.toString(year);

    @BeforeTest
    public void before() {
      driver.get("http://staging.aceinvoice.com/sign_in");
      driver.findElement(By.name("email")).sendKeys("farhana@bigbinary.com");
      driver.findElement(By.name("password")).sendKeys("welcome");
      driver.findElement(By.name("login")).click();
      driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
      }

    @Test
    public void verifyLandingPage() {

        //hamburgerMenu
        Boolean hamburgerMenu = driver.findElement(By.className("hamburger-menu-link")).isDisplayed();
        assertTrue(hamburgerMenu);
        driver.findElement(By.className("hamburger-menu-link")).click();

        //Organization
        String selectOrganization = driver.findElement(By.xpath("//div[@class=\"sidebar-header\"]//h4")).getText();
        assertEquals(selectOrganization, "Select Organization");

        //New Organization
        String newOrganization = driver.findElement(By.xpath("//div[@class=\"sidebar-content-wrap\"]//li[1]//a")).getText();
        assertEquals(newOrganization, "new Organization");

        //Organization Name
        String organizationName = driver.findElement(By.xpath("//div[@class=\"sidebar-content-wrap\"]//li[2]//a")).getText();
        assertEquals(organizationName, "BigBinary");

        //Add Organization
        Boolean Add = driver.findElement(By.partialLinkText("Add")).isDisplayed();
        assertTrue(Add);

        driver.findElement(By.partialLinkText("Add")).click();
        driver.navigate().back();

         //Project
        Boolean Project = driver.findElement(By.linkText("Projects")).isDisplayed();
        assertTrue(Project);

        //Time Tracking
        Boolean timeTracking = driver.findElement(By.linkText("Time Tracking")).isDisplayed();
        assertTrue(timeTracking);

        //Reports
        Boolean Reports = driver.findElement(By.linkText("Reports")).isDisplayed();
        assertTrue(Reports);

        //Expenses
        Boolean Expenses = driver.findElement(By.linkText("Expenses")).isDisplayed();
        assertTrue(Expenses);

        //Import Timesheet
        Boolean ImportTimesheet = driver.findElement(By.linkText("Import Timesheet")).isDisplayed();
        assertTrue(ImportTimesheet);

        //Notification
        Boolean Notification = driver.findElement(By.xpath("//div[@class='header-right col-auto']//li[@class=\"notification-link\"]")).isDisplayed();
        assertTrue(Notification);

        //Profile dropDown
        Boolean dropDown = driver.findElement(By.xpath("//div[@class=\"dropdown\"]/a[@class=\"dropdown-toggle\"]")).isDisplayed();
        assertTrue(dropDown);

        driver.findElement(By.xpath("//div[@class=\"dropdown\"]/a[@class=\"dropdown-toggle\"]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //My Account
        Boolean myAccount = driver.findElement(By.linkText("My Account")).isDisplayed();
        assertTrue(myAccount);

        //Change Email
        Boolean changeEmail = driver.findElement(By.linkText("Change Email")).isDisplayed();
        assertTrue(changeEmail);

        //Change Password
        Boolean changePassword = driver.findElement(By.linkText("Change Password")).isDisplayed();
        assertTrue(changePassword);

        //Log Out
        Boolean Logout = driver.findElement(By.linkText("Logout")).isDisplayed();
        assertTrue(Logout);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Calendar
        Boolean previousArrow = driver.findElement(By.xpath("//div[@class=\"week-navigation\"]//a")).isDisplayed();
        assertTrue(previousArrow);

        Boolean nextArrow = driver.findElement(By.xpath("//div[@class=\"week-navigation\"]//a[2]")).isDisplayed();
        assertTrue(nextArrow);

        Boolean monthYear = driver.findElement(By.className("month-text")).isDisplayed();
        assertTrue(monthYear);

        String monthYearText = driver.findElement(By.className("month-text")).getText();
        assertEquals(monthYearText, month + " " + Year);

        String week = ("//div[@class=\"calendar-table floating-box p-0\"]//div[@class=\"calendar-header\"]//div[@class=\"calendar-row\"]");

        String firstColumn = driver.findElement(By.xpath(week + "//div[1]")).getText();
        assertEquals(firstColumn, "Mon");

        String secondColumn = driver.findElement(By.xpath(week + "//div[2]")).getText();
        assertEquals(secondColumn, "Tue");

        String thirdColumn = driver.findElement(By.xpath(week + "//div[3]")).getText();
        assertEquals(thirdColumn, "Wed");

        String fourthColumn = driver.findElement(By.xpath(week + "//div[4]")).getText();
        assertEquals(fourthColumn, "Thu");

        String fifthColumn = driver.findElement(By.xpath(week + "//div[5]")).getText();
        assertEquals(fifthColumn, "Fri");

        String sixthColumn = driver.findElement(By.xpath(week + "//div[6]")).getText();
        assertEquals(sixthColumn, "Sat");

        String seventhColumn = driver.findElement(By.xpath(week + "//div[7]")).getText();
        assertEquals(seventhColumn, "Sun");

        //LogTime
        String logTime = driver.findElement(By.xpath("//div[@class=\"time-entry-form\"]//h4")).getText();
        assertEquals(logTime, "Log Time");

        String date = driver.findElement(By.xpath("//div[@class=\"time-entry-form\"]//h4[2]")).getText();
        int currentdate = calendar.get(Calendar.DATE);
        assertEquals(date, month + " " + currentdate + "," + " " + Year);

        //Select Project
        Boolean selectProject = driver.findElement(By.xpath("//div[@class=\"bg-white floating-box form-content form-page p-4 border-top-0\"]//div[1]//div[@class=\"field-value\"]//select//option[1]")).isDisplayed();
        assertTrue(selectProject);

        //Select Task
        Boolean selectTask = driver.findElement(By.xpath("//div[@class=\"bg-white floating-box form-content form-page p-4 border-top-0\"]//div[2]//div[@class=\"field-value\"]//select//option")).isDisplayed();
        assertTrue(selectTask);

        //Enter Hours
        Boolean enterHours = driver.findElement(By.xpath("//input[@placeholder=\"Enter Hours\"]")).isDisplayed();
        assertTrue(enterHours);

        //Notes
        Boolean Notes = driver.findElement(By.xpath("//textarea[@placeholder=\"Notes\"]")).isDisplayed();
        assertTrue(Notes);

        //Save Entry
        Boolean saveEntryButton = driver.findElement(By.xpath("//button[@type=\"button\"]")).isDisplayed();
        assertTrue(saveEntryButton);

        String saveEntryText = driver.findElement(By.xpath("//button[@type=\"button\"]")).getText();
        assertEquals(saveEntryText, "Save Entry");
    }
    @AfterTest
      public void after() {
      driver.close();
    }
}

