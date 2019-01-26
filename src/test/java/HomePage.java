import com.sun.tools.javac.comp.Enter;
import org.apache.wml.dom.WMLAccessElementImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class HomePage extends action {

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    Locator mainButton(){
        return new Locator(By.xpath("//a[@href='/movies-in-theaters/?ref_=nv_tp_inth_1'][text()='Movies']"),"Main Button");
    }

    Locator topRated(){
        return new Locator(By.xpath("//a[@href='/chart/top?ref_=nv_mv_250_6'][text()='Top Rated Movies']"),"Top Rated");
    }

    Locator moviesName(){
        return new Locator(By.xpath("//td[@class='titleColumn']//a"),"Movies Names");
    }

    Locator year(){
        return new Locator(By.xpath("//td[@class='titleColumn']//span"),"Year");
    }

    Locator rating(){
        return new Locator(By.xpath("//td[@class='ratingColumn imdbRating']//strong"),"Rating");
    }

    Locator signUpButton(){
        return new Locator(By.xpath("//a[contains(text(),'have an account? Sign up')]"),"Sign Up Button");
    }

    Locator signUpViaEmail(){
        return new Locator(By.xpath("//button[@class='btn btn-email']"),"Email Sign Up");
    }

    Locator email(){
        return new Locator(By.xpath("//input[@type='email']"),"Email text box");
    }

    Locator password(){
        return new Locator(By.xpath("//input[@type='password'][@placeholder='Password']"),"Password text box");
    }

    Locator mobile(){
        return new Locator(By.xpath("//input[@type='tel']"),"Telephone Text Box");
    }

    Locator joinNowButton(){
        return new Locator(By.xpath("//button[@type='submit'][@name='home_form']"),"Join Now Button");
    }

    Locator firstName(){
        return new Locator(By.xpath("//input[@name='firstname']"),"First Name Text Box");
    }

    Locator lastName(){
        return new Locator(By.xpath("//input[@id='lastname']"),"Last Name Text Box");
    }

    Locator companyName(){
        return new Locator(By.xpath("//input[@name='companyname']"),"Company Name");
    }

    Locator state(){
        return new Locator(By.xpath("//span[text()='Type your state here']"),"State");
    }

    Locator autoSuggest(){
        return new Locator(By.xpath("//div[@id='ui-select-choices-row-0-0']"),"Auto Suggestion");
    }

    Locator nameOfMLS(){
        return new Locator(By.xpath("//span[text()='Type the name of your MLS']"),"Name of MLS");
    }

    Locator autoSuggest1(){
        return new Locator(By.xpath("//*[@id='ui-select-choices-row-1-1']/span"),"Auto Suggest");
    }

    Locator MLSRegistered(){
        return new Locator(By.xpath("//input[@placeholder='MLS Registered Email']"),"MLS Registered");
    }

    Locator agentID(){
        return new Locator(By.xpath("//input[@placeholder='MLS Agent ID']"),"Agent ID");
    }

    Locator licenceID(){
        return new Locator(By.xpath("//input[@placeholder='License ID']"),"License ID");
    }

    public WebDriver navigateToWebsite() throws InterruptedException, IllegalAccessException, InstantiationException, IOException {
        File file;
        if(System.getProperty("os.name").contains("Mac")) {
            file = new File(new File("src/test/resources/chromedriver").getCanonicalPath());
        }else if(System.getProperty("os.name").contains("Windows")){
            file = new File(new File("src/test/resources/chromedriver.exe").getCanonicalPath());
        }else {
            file = new File(new File("src/test/resources/chromedriver2").getCanonicalPath());
        }
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath().replace("\\","\\\\"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://web.agentdesks.com/");
        return driver;
    }

    public String signUpNewAccount() throws InterruptedException, IllegalAccessException, InstantiationException {
        Random random = new Random(System.currentTimeMillis());
        click(signUpButton());
        wait(5000);
        click(signUpViaEmail());
        String email = "automate".concat(String.valueOf(random.nextInt()+"@agentdesks.com"));
        EnterValue(email(), email);
        EnterValue(password(),"121212");
        EnterValue(mobile(),"9".concat(String.valueOf(random.nextInt())));
        click(joinNowButton());
        return email;
    }


    public void welComeOnBoard() throws IllegalAccessException, InstantiationException {
        EnterValue(firstName(),"yash");
        EnterValue(lastName(),"zanwar");
        EnterValue(companyName(),"Agent Desks");
        click(joinNowButton());
    }

    public void shareMLS() throws IllegalAccessException, InstantiationException, InterruptedException {
        click(state());
        click(autoSuggest());
        click(nameOfMLS());
        click(autoSuggest1());
        EnterValue(MLSRegistered(),"yahszanwar007@gmail.com");
        EnterValue(agentID(),"121212");
        EnterValue(licenceID(),"1212");
        click(joinNowButton());
        wait(6000);
        click(joinNowButton());
        click(joinNowButton());






    }
}
