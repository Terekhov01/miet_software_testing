import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;
public class YaTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    /**
     * осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver(chromeOptions);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage")); }
    /**
     * тестовый метод для осуществления аутентификации
     */
    @Test
    public void loginTest() {

        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("ya_login"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("ya_password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //получаем отображаемый логин
        String user = profilePage.getUserName();
        profilePage.closeMenu();
        //и сравниваем его с логином из файла настроек
        Assert.assertEquals(ConfProperties.getProperty("ya_login"), user);
    }

    @Test
    public void paymentsTest(){
        Assert.assertEquals("10 мая 2021 г.", profilePage.getLastGoPay());
    }

    @Test
    public void searchTest(){
        Assert.assertTrue(profilePage.isResultPresents());
    }
    /**
     * осуществление выхода из аккаунта с последующим закрытием окна браузера
     */
    @AfterClass
    public static void tearDown() {
        profilePage.userLogout();
        driver.quit(); } }