package suites;


import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import listeners.CustomISuiteListener;
import listeners.CustomITestListener;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.yandex.MainPage;

import java.net.MalformedURLException;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.Boolean.parseBoolean;
import static java.net.URI.create;
import static utils.ConfigureProperties.*;

@Listeners({CustomITestListener.class, CustomISuiteListener.class})
public class BaseTest {
    RemoteWebDriver driver;
    public MainPage yandex;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        if (!CustomISuiteListener.skippedTest.contains(getClass().getSimpleName())) {
            yandex = new MainPage();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(getConfigureProperty("browser"));
            capabilities.setVersion(getConfigureProperty("version"));
            capabilities.setCapability("enableVNC", parseBoolean(getConfigureProperty("vns")));
            capabilities.setCapability("enableVideo", parseBoolean(getConfigureProperty("video")));
            driver = new RemoteWebDriver(
                    create(getConfigureProperty("remote")).toURL(),
                    capabilities);
            WebDriverRunner.setWebDriver(driver);
            getWebDriver().manage().window().maximize();
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        }
    }


}
