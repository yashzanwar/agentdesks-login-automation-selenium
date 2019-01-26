import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.util.ArrayList;

public class TestSuite extends DataBaseActivity{


    public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException {
        WebDriver driver = null;
        try {
            HomePage homepage = new HomePage(driver);
            driver = homepage.navigateToWebsite();
            homepage.signUpNewAccount();
            homepage.welComeOnBoard();
            homepage.shareMLS();




        }catch (Exception e) {
            Reporter.log(e.toString());
        }finally {
            driver.quit();
        }
    }
}
