package com.Intigral.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class FrontendTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the edgedriver executable
        System.setProperty("webdriver.edge.driver", "C:/Users/aiman/Downloads/edgedriver_win64/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void validateSubscriptionPackages() {
        // Validate packages for Saudi Arabia
        validateCountryPackages("sa-en",
                new String[]{"LITE", "CLASSIC", "PREMIUM"},
                new String[]{"15", "25", "60"},
                new String[]{"SAR/month", "SAR/month", "SAR/month"});

        // Validate packages for Kuwait
        validateCountryPackages("kw-en",
                new String[]{"LITE", "CLASSIC", "PREMIUM"},
                new String[]{"1.2", "2.5", "4.8"},
                new String[]{"KWD/month", "KWD/month", "KWD/month"});

        // Validate packages for Bahrain
        validateCountryPackages("bh-en",
                new String[]{"LITE", "CLASSIC", "PREMIUM"},
                new String[]{"2", "3", "6"},
                new String[]{"BHD/month", "BHD/month", "BHD/month"});
    }

    private void validateCountryPackages(String countryPath, String[] expectedPackageNames, String[] expectedPackagePrices, String[] expectedCurrencies) {
        driver.get("https://subscribe.stctv.com/" + countryPath);

        List<WebElement> packages = driver.findElements(By.cssSelector(".plan-title"));
        List<WebElement> prices = driver.findElements(By.cssSelector(".price"));

        // Filter out the "FREE" price element
        prices = prices.stream().filter(price -> price.findElements(By.className("free")).isEmpty()).collect(Collectors.toList());

        // Ensure the correct number of packages are found
        System.out.println("Number of package elements found: " + packages.size());
        System.out.println("Number of price elements found: " + prices.size());

        Assert.assertEquals(packages.size(), expectedPackageNames.length, "Number of packages mismatch for " + countryPath);
        Assert.assertEquals(prices.size(), expectedPackagePrices.length, "Number of prices mismatch for " + countryPath);

        for (int i = 0; i < packages.size(); i++) {
            String packageName = packages.get(i).getText().toUpperCase();
            String packagePrice = prices.get(i).findElement(By.tagName("b")).getText();
            String currency = prices.get(i).findElement(By.tagName("i")).getText().replace("\n", " ").trim();

            // Print the actual values for debugging
            System.out.println("Actual package name: " + packageName);
            System.out.println("Actual package price: " + packagePrice);
            System.out.println("Actual currency: " + currency);

            // Validate package details
            Assert.assertEquals(packageName, expectedPackageNames[i], "Package name mismatch for " + countryPath);
            Assert.assertEquals(packagePrice, expectedPackagePrices[i], "Package price mismatch for " + countryPath);
            Assert.assertEquals(currency, expectedCurrencies[i], "Currency mismatch for " + countryPath);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
