package com.naveenautomation.TestBases;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;

import com.naveenautomation.Listeners.WebDriverEvents;
import com.naveenautomation.env.Environment;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

    private static Environment DEFAULT_ENV = Environment.PROD;
    public static Logger logger;
    private WebDriverEvents events;
    private EventFiringWebDriver eDriver;
    public static WebDriver driver;

    @BeforeClass
    public void setUpLogger() {
        logger = Logger.getLogger(TestBase.class);
        PropertyConfigurator.configure("log4j.properties");
        BasicConfigurator.configure();
        logger.setLevel(Level.ALL);
    }

    public void initialization() {
        setBrowserForTesting();
        driverManagement();
        logger.info("Loading Page in Browser");
        driver.get(DEFAULT_ENV.getEnvUrl());
    }

    private void driverManagement() {
        driver.manage().window().maximize();
    }

    private void setBrowserForTesting() {
        String browserName = System.getProperty("browser"); // Check if browser is set as a system property

        if (browserName == null) {
            browserName = System.getenv("BROWSER"); // If browser is not set as a system property, check environment variable
        }

        if (browserName == null) {
            // If browser is not specified, use default browser (EDGE)
            browserName = "EDGE";
        }

        switch (browserName.toUpperCase()) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                logger.info("Launching Chrome Browser");
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                logger.info("Launching Firefox Browser");
                driver = new FirefoxDriver();
                break;
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                logger.info("Launching Edge Browser");
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        // Initialize EventFiringWebDriver
        eDriver = new EventFiringWebDriver(driver);

        // Initialize WebDriverEvents
        events = new WebDriverEvents();

        // Register the event
        eDriver.register(events);
        driver = eDriver;
    }

    public void tearDown() {
        driver.close();
    }
}
