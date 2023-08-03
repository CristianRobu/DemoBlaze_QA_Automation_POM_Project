package constants;

import com.github.javafaker.Faker;

public class Constants {
    public static final String URL = "https://demoblaze.com/index.html";
    public static final String USERNAME = "cris12312125122";
    public static final String PASSWORD = "pass123";
    public static final String WELCOME_MESSAGE = "Welcome";
    public static final String SIGNUP_SUCCESSFUL_MESSAGE = "Sign up successful.";
    public static final String NO_USERNAME_LOGIN_ATTEMPT = "Please fill out Username and Password.";
    public static final String SIGN_UP = "Sign up";
    public static final String PRODUCT_ADDED_TEXT = "Product added.";

    public static final String USERNAME_EXISTS_ALREADY = "This user already exist.";

    //Css Values
    public static final String BACKGROUND_COLOR = "background color";
    public static String generateUsername() {
        Faker faker = new Faker();
        return faker.name().firstName()+ "@gmail.com";
    }

    // RGB COLOURS
    public static final String BLUE_COLOR = "rgba(2, 117, 216, 1)";
}
