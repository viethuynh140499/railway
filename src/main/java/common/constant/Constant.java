package common.constant;

import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://www.railway.somee.com/";
    public static final String USERNAME = "asas4@gmail.com";
    public static final String PASSWORD = "viet123456";
    public static final String ERRORMESSAGE = "Invalid username or password. Please try again.";
    public static final String USERNAMEINVALD = "You must specify a username.";
    public static final String PASSWORDINVALD = "You must specify a password.";
    public static final String ERRORINFORMATION = "There was a problem with your login and/or errors exist in your form.";

    public static final String DEPART_DATE = "4/24/2021";
    public static final String DEPART_FROM = "Phan Thiết";
    public static final String ARRIVE_AT = "Sài Gòn";
    public static final String SEAT_TYPE = "Hard bed";
    public static final int TICKET_AMOUNT= 1;
    public static final LocalDate CURRENT_DATE = LocalDate.now();
}
