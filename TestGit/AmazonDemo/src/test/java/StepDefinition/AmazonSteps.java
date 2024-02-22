package StepDefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonSteps {
	
	private WebDriver driver;
	private HomePage homePage;
	
	
	@Given("User is on Amazon.in homepage")
	public void user_is_on_amazon_in_homepage() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Agnes Jude\\Jude-WorkSpace\\BDD-Workspace\\CucumberJava\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		homePage = new HomePage(driver);
		homePage.naviagateToAmazonHomePage();
	    
	}

	@When("User clicks on Fashion and selects Mens")
	public void user_clicks_on_fashion_and_selects_mens() throws InterruptedException {
		
		homePage.clickFashionAndMens();
	    
	}

	@When("User filters products by Average customer review of four stars and Up {string}")
	public void user_filters_products_by_average_customer_review_of_four_stars_and_up(String string) {
	    
		
		
		homePage.filterByCustomerReview();
		
	
	}

	@When("user filters products by price range")
	public void user_filters_products_by_price_range() {
		
		homePage.filterByPriceRange();
	    
	}

	@When("User selects Allen Solley in Brands")
	public void user_selects_allen_solley_in_brands() {
	    
		homePage.filterByBrand();
		
	}

	@When("User counts the number of results in the first page")
	public void user_counts_the_number_of_results_in_the_first_page() throws InterruptedException {
	   
		homePage.countOftheProduct();
	}

	@When("User clicks on the second product and add it to Cart")
	public void user_clicks_on_the_second_product_and_add_it_to_cart() throws InterruptedException {
	    
		homePage.clickAddtocart();
		
	}

	@Then("User validates that the number on the Cart is increased by {string}")
	public void user_validates_that_the_number_on_the_cart_is_increased_by(String int1) throws IOException {
	    
		String value = (String)homePage.getValue();
		Assert.assertEquals(value, int1);
		System.out.println("Assert Verification passed");
		homePage.takeScreenShotPath();
	}




}
