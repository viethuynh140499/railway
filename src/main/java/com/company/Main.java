package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String baseUrl ="http://demo.guru99.com/";
        System.getProperty("webdriver.chrome.driver", "src/main/Executables/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(baseUrl);

        driver.findElement(By.xpath("//a[@href='http://demo.guru99.com/insurance/v1/index.php']")).click();

        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();

        // select
        Select title = new Select(driver.findElement(By.name("title")));
        title.selectByVisibleText("Doctor");

        WebElement firstName = driver.findElement(By.id("user_firstname"));
        firstName.sendKeys("Huynh");

        WebElement lastName = driver.findElement(By.id("user_surname"));
        lastName.sendKeys("Viet");

        WebElement phone = driver.findElement(By.id("user_phone"));
        phone.sendKeys("0981405300");

        Select year = new Select(driver.findElement(By.name("year")));
        year.selectByVisibleText("1995");
        Select month = new Select(driver.findElement(By.name("month")));
        month.selectByVisibleText("September");
        Select day = new Select(driver.findElement(By.name("date")));
        day.selectByVisibleText("2");

        WebElement radioFull = driver.findElement(By.name("licencetype"));
        WebElement radioProvisional = driver.findElement(By.xpath("//input[@value='Provisional']"));
        radioFull.click();

        Select licencePeriod = new Select(driver.findElement(By.name("licenceperiod")));
        licencePeriod.selectByVisibleText("5");

        Select occupation = new Select(driver.findElement(By.name("occupation")));
        occupation.selectByVisibleText("Actor");

        driver.findElement(By.id("user_address_attributes_street")).sendKeys("Dung si thanh khe");
        driver.findElement(By.id("user_address_attributes_city")).sendKeys("Da nang");
        driver.findElement(By.id("user_address_attributes_county")).sendKeys("Viet Nam");
        driver.findElement((By.id("user_address_attributes_postcode"))).sendKeys("550000");
        driver.findElement(By.id("user_user_detail_attributes_email")).sendKeys("vietpro.huynhh@gmail.com");
        driver.findElement(By.id("user_user_detail_attributes_password")).sendKeys("viet123456");
        driver.findElement(By.id("user_user_detail_attributes_password_confirmation")).sendKeys("viet123456");
        driver.findElement(By.xpath("//input[@value='Create']")).click();
    }
}
