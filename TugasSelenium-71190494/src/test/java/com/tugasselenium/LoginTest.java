package com.tugasselenium;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class LoginTest {
    String email;
    String password;
    ChromeDriver chromeDriver;
    @Given("browser opened")
    public void browser_opened() {
        System.out.println("Step 1 - Browser dibuka");
        System.setProperty(
                "webdriver.chrome.driver",
                Objects.requireNonNull(getClass().getClassLoader().getResource("webdriver/chromedriver.exe")).getFile()
        );
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40)); // menunggu browser terbuka
        chromeDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }
    @Given("user in login page")
    public void user_in_register_page() {
        System.out.println("Step 2 - User ada di halaman login");
        chromeDriver.navigate().to("https://demo.guru99.com/insurance/v1/index.php");
    }
    @When("^user insert ([^\"]*) and ([^\"]*)$")
    public void user_insert_username_and_password(String argEmail, String argPassword) {
        System.out.println("Step 3 - User input email dan password untuk login");
        email = argEmail;
        password = argPassword;
        chromeDriver.findElement(By.name("email")).sendKeys(argEmail);
        chromeDriver.findElement(By.name("password")).sendKeys(argPassword);
    }
    @When("login button clicked")
    public void login_button_clicked() {
        System.out.println("Step 4 - Tombol login diklik");
        chromeDriver.findElement(By.name("submit")).click();
    }
    @Then("user redirect to main screen")
    public void user_redirect_to_main_screen() {
        System.out.println("Step 5 - User diarahkan ke halaman utama/beranda");
        Assertions.assertTrue(password.matches("[A-Za-z0-9]+") && password.length()!=0 && password.length() >= 8 && password.length() <= 13 && !email.equalsIgnoreCase(""),"Login gagal");
        List<WebElement> list = chromeDriver.findElements(By.xpath("/html/body/div[3]/form/input"));
        Assertions.assertTrue(list.size()>0,"Tombol logout tidak ditemukan");
        chromeDriver.close();
        chromeDriver.quit();
    }
}
