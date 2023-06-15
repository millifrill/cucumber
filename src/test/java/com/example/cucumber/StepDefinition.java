package com.example.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class StepDefinition {

    static WebDriver driver;
    private WebElement linkElement;

    @Given("SVT Play is available")
    public void svt_play_is_available() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("incognito");
        driver = new ChromeDriver(options);
        driver.get("https://svtplay.se");
    }

    @When("User visits SVT Play")
    public void user_visits_svt_play() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div/div[2]/button[3]")).click();
        // Här kan man även navigera till en specifik sida som ska testas eller liknande
    }

    @Then("The title should be {string}")
    public void the_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle, "The title is not correct");
    }

    @Then("The logotyp should be visible")
    public void the_logotyp_should_be_visible() {
        WebElement logoElement = driver.findElement(By.className("sc-31022b15-0"));
        assertTrue(logoElement.isDisplayed(), "The logo is not displayed/visible");
    }

    @Then("The menu links text should be {string}, {string} and {string}")
    public void the_menu_links_text_should_be_and(String expectedMenuLinkText1, String expectedMenuLinkText2, String expectedMenuLinkText3) {
        List<WebElement> actualMenuLinks = driver.findElements(By.className("sc-354ed288-1"));
        assertEquals(3, actualMenuLinks.size());

        String actualText1 = actualMenuLinks.get(0).getText().trim();
        String actualText2 = actualMenuLinks.get(1).getText().trim();
        String actualText3 = actualMenuLinks.get(2).getText().trim();

        assertEquals(expectedMenuLinkText1, actualText1, "First menu link text is not correct");
        assertEquals(expectedMenuLinkText2, actualText2, "Second menu link text is not correct");
        assertEquals(expectedMenuLinkText3, actualText3, "Third menu link text is not correct");
    }

    @Then("The link {string} should be visible")
    public void the_link_should_be_visible(String linkText) {
        WebElement linkElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[2]/p[1]/a/span[2]"));
        assertTrue(linkElement.isDisplayed());
    }

    @Then("The link text should be {string}")
    public void The_link_text_should_be(String expectedLinkText) {
        String linkElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[2]/p[1]/a/span[2]")).getText().trim();
        assertEquals(expectedLinkText, linkElement, "The link text is not correct");
    }

    @When("User visits SVT Play and navigates to Availability page")
    public void user_visits_svt_play_and_navigates_to_availability_page() {
        driver.get("https://www.svt.se/kontakt/sa-arbetar-svt-med-tillganglighet");
    }

    @Then("The heading on the page Availability in SVT Play should be {string}")
    public void the_heading_on_the_page_availability_in_svt_play_should_be(String expectedHeading) {
        String actualHeadning = driver.findElement(By.tagName("h1")).getText();
        assertEquals(expectedHeading, actualHeadning, "The main heading is not correct");
    }

    @When("User visits the page Program in SVT Play")
    public void user_visits_the_page_program_in_svt_play() {
        driver.get("https://www.svtplay.se/program");
    }

    @Then("Check quantity of categories on program page")
    public void check_quantity_of_categories_on_program_page() {
        List<WebElement> categoryItems = driver.findElements(By.className("sc-a9073dc0-1"));
        assertEquals(16, categoryItems.size(), "Number of categories is not correct");
    }

    @Then("The heading on the page Program in SVT Play should be {string}")
    public void the_heading_on_the_page_program_in_svt_play_should_be(String expectedHeading) {
        String actualHeadning = driver.findElement(By.xpath("//*[@id=\"program-a-o\"]")).getText();
        assertEquals(expectedHeading, actualHeadning, "The main heading is not correct");
    }

    @When("User visits the page Chanels in SVT Play")
    public void user_visits_the_page_chanels_in_svt_play() {
        driver.get("https://www.svtplay.se/kanaler");
        //driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/header/div[2]/div/div/nav/ul[1]/li[3]/a")).click();
    }

    @Then("The heading on the page Chanels in SVT Play should be {string}")
    public void the_heading_on_the_page_chanels_in_svt_play_should_be(String expectedHeading) {
        String actualHeadning = driver.findElement(By.tagName("h1")).getText();
        assertEquals(expectedHeading, actualHeadning, "The main heading is not correct");
    }

    @When("User visits the page Sign language in SVT Play")
    public void user_visits_the_page_sign_language_in_svt_play() {
        driver.get("https://www.svtplay.se/syntolkat");
    }

    @Then("The heading on the page Sign language in SVT Play should be {string}")
    public void the_heading_on_the_page_sign_language_in_svt_play_should_be(String expectedHeading) {
        String actualHeadning = driver.findElement(By.tagName("h1")).getText();
        assertEquals(expectedHeading, actualHeadning, "The main heading is not correct");
    }

    @When("User visits the page Audio description in SVT Play")
    public void user_visits_the_page_audio_description_in_svt_play() {
        driver.get("https://www.svtplay.se/teckensprak");
    }

    @Then("The heading on the page Audio description in SVT Play should be {string}")
    public void the_heading_on_the_page_audio_description_in_svt_play_should_be(String expectedHeading) {
        String actualHeadning = driver.findElement(By.tagName("h1")).getText();
        assertEquals(expectedHeading, actualHeadning, "The main heading is not correct");
    }

    @Then("Exit should be the first match when Searching for Exit")
    public void exit_should_be_the_first_match_when_searching_for_exit() {
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("exit");
        searchInput.sendKeys(Keys.ENTER);
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"play_main-content\"]/section/div/ul/li[1]/article/a/div[2]/h2/span/em")));
        WebElement searchResultHeading1 = driver.findElement(By.xpath("//*[@id=\"play_main-content\"]/section/div/ul/li[1]/article/a/div[2]/h2/span/em"));
        String searchResultHeading1Text = searchResultHeading1.getText();
        assertEquals("Exit", searchResultHeading1Text, "Första sökresultatet borde vara Exit");
    }

    @Then("The search form should be hidden")
    public void the_search_form_should_be_hidden() {
        WebElement searchInput = driver.findElement(By.name("q"));
        Assertions.assertTrue(searchInput.isDisplayed());

        Dimension newDimension = new Dimension(600, 600);
        driver.manage().window().setSize(newDimension);

        searchInput = driver.findElement(By.name("q"));
        Assertions.assertFalse(searchInput.isDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
