import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ProfilePage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    /**
     * определение локатора меню пользователя
     */
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div/div/ul/li[1]")
    private WebElement userText;
    /**
     * определение локатора кнопки выхода из аккаунта
     */
    
    @FindBy(xpath = "//*[contains(text(), 'Выйти')]")
    private WebElement logoutBtn;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/header/div[4]/div/a[1]/div/div[1]")
    private WebElement popUpMenu;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/nav/ul/li[2]/a")
    private WebElement dataMenu;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div/div[5]/div[2]/div/div[1]")
    private WebElement data;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/button")
    private WebElement x;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/nav/ul/li[3]/a")
    private WebElement yandexPay;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div[1]/div/div[2]/div[1]/button[2]")
    private WebElement go;

    @FindBy(xpath = "//*[contains(@data-testid, 'payments-short-history-link')]")
    private WebElement history;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div[1]/div/div[2]/div[2]/h3[1]")
    private WebElement lastPayment;

    @FindBy(className = "ID-Popover")
    private WebElement searchResult;

    @FindBy(css = "input[type=\"search\"]")
    private WebElement searchInput;

    public boolean isResultPresents(){
        searchInput.sendKeys("sdsddg");
        try{
            new WebDriverWait(driver, Duration.ofSeconds(4))
                    .until(ExpectedConditions.visibilityOf(searchResult));
        } catch (NoSuchElementException e){
            return false;
        }
        return true;
    }


    /**
     * метод для получения имени пользователя из меню пользователя
     */
    public String getUserName() {
        dataMenu.click();
        data.click();
        return userText.getText().substring(0,userText.getText().indexOf("@"));
    }

    public String getLastGoPay(){
        yandexPay.click();
        history.click();
        go.click();
        return lastPayment.getText();
    }

    public void closeMenu(){
        x.click();
    }

    /**
     * метод для нажатия кнопки выхода из аккаунта
     */
    public void userLogout() {
        WebElement home = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/nav/ul/li[1]/a"));
        home.click();
        popUpMenu.click();
        driver.switchTo().frame(0);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div"))).click();

        //logoutBtn.click();
    }
}