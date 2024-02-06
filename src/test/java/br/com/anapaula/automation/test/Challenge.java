package br.com.anapaula.automation.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.anapaula.automation.test.datamass.DataMassAddressForm;
import br.com.anapaula.automation.test.datamass.DataMassUserForm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Challenge {

    private WebDriver driver;

    private WebElement box;
    private WebElement searchResults;

    DataMassUserForm dataMassUserForm = DataMassUserForm.generateDataMass();

    DataMassAddressForm dataMassAddressForm = DataMassAddressForm.generateDataMass();

    @BeforeEach
    public void openBrowser() {
        WebDriverManager.chromedriver().forceDownload().setup();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void regressiveTest() {
        driver.get("http://www.automationpractice.pl/index.php");

        signinButton();

        createAccountButton(dataMassUserForm);

        createAccountSubmitButton(dataMassUserForm);

        createAddressSubmitButton();

        OrderFlow();

    }

    private void OrderFlow() {
        box = driver.findElement(By.xpath("//a[contains(text(),'Dresses')]"));
        String dresses = box.getAttribute("href");
        driver.get(dresses);


        box = driver.findElement(By.xpath("//img[contains(@title,'Printed Chiffon Dress')]"));
        box.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@title,'Green')]")));
        box = driver.findElement(By.xpath("//a[contains(@title,'Green')]"));
        box.click();

        box = driver.findElement(By.id("add_to_cart"));
        box.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@title,'Proceed to checkout')]")));

        box = driver.findElement(By.xpath("//a[contains(@title,'Proceed to checkout')]"));
        box.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("standard-checkout")));
        box = driver.findElement(By.className("standard-checkout"));
        box.click();
        //        String checkout = searchBox.getAttribute("href");
//        driver.get(checkout);

        box = driver.findElement(By.name("processAddress"));
        box.click();

        box = driver.findElement(By.id("cgv"));
        box.click();

        box = driver.findElement(By.name("processCarrier"));
        box.click();

        box = driver.findElement(By.className("bankwire"));
        box.click();

        box = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
        box.click();

        assertThat(driver.getTitle()).startsWith("Search - My Shop");
    }

    private void createAddressSubmitButton() {
        box = driver.findElement(By.xpath("//a[contains(@title,'Add my first address')]"));
        box.click();

        box = driver.findElement(By.id("firstname"));
        box.sendKeys(dataMassAddressForm.getFirstName());

        box = driver.findElement(By.id("lastname"));
        box.sendKeys(dataMassAddressForm.getLastName());

        box = driver.findElement(By.id("company"));
        box.sendKeys(dataMassAddressForm.getCompany());

        box = driver.findElement(By.id("address1"));
        box.sendKeys(dataMassAddressForm.getAddress());

        box = driver.findElement(By.id("address2"));
        box.sendKeys(dataMassAddressForm.getAddressLine2());

        box = driver.findElement(By.id("city"));
        box.sendKeys(dataMassAddressForm.getCity());

        box = driver.findElement(By.id("id_state"));
        box.sendKeys(dataMassAddressForm.getState().toString());

        box = driver.findElement(By.id("postcode"));
        box.sendKeys(dataMassAddressForm.getPostalCode());

        box = driver.findElement(By.id("id_country"));
        box.sendKeys(dataMassAddressForm.getCountry());

        box = driver.findElement(By.id("phone"));
        box.sendKeys(dataMassAddressForm.getHomePhone());

        box = driver.findElement(By.id("phone_mobile"));
        box.sendKeys(dataMassAddressForm.getMobilePhone());

        box = driver.findElement(By.id("other"));
        box.sendKeys(dataMassAddressForm.getAdditionalInfo());

        box = driver.findElement(By.id("alias"));
        box.sendKeys(dataMassAddressForm.getAlias());

        box = driver.findElement(By.id("submitAddress"));
        box.click();

        assertThat(driver.getTitle()).startsWith("Addresses - My Shop");
    }

    private void createAccountSubmitButton(DataMassUserForm dataMassUserForm) {
        if(dataMassUserForm.getTitle()) {
            box = driver.findElement(By.id("id_gender1"));
            box.click();
        } else {
            box = driver.findElement(By.id("id_gender2"));
            box.click();
        }

        box = driver.findElement(By.id("customer_firstname"));
        box.sendKeys(dataMassUserForm.getFirstName());

        box = driver.findElement(By.id("customer_lastname"));
        box.sendKeys(dataMassUserForm.getLastName());

        box = driver.findElement(By.id("passwd"));
        box.sendKeys(dataMassUserForm.getPassword());

        box = driver.findElement(By.id("days"));
        box.sendKeys(dataMassUserForm.getDay().toString());

        box = driver.findElement(By.id("months"));
        box.sendKeys(dataMassUserForm.getMonth().toString());

        box = driver.findElement(By.id("years"));
        box.sendKeys(dataMassUserForm.getYear().toString());

        box = driver.findElement(By.id("newsletter"));

        if(dataMassUserForm.getNewsletter()) {
            box.click();
        }

        box = driver.findElement(By.id("submitAccount"));
        box.click();
        System.out.print(dataMassUserForm.getEmail() + " ; " + dataMassUserForm.getPassword());
        assertThat(driver.getTitle()).startsWith("My account - My Shop");
    }

    private void createAccountButton(DataMassUserForm dataMassUserForm) {
        box = driver.findElement(By.id("email_create"));
        box.sendKeys(dataMassUserForm.getEmail());
        box = driver.findElement(By.id("SubmitCreate"));
        box.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
        assertThat(driver.findElement(By.id("id_gender1"))).isNotNull();
    }

    private void signinButton() {
        box = driver.findElement(By.className("login"));
        box.click();
        assertThat(driver.getTitle()).startsWith("Login - My Shop");
    }


}
