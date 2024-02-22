package PageObjects;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class HomePage {
	public static  WebDriver driver;
	public static  WebDriverWait wait;
	
	@FindBy(xpath="//div@class='ur class name")
	private WebElement popupContainer; 
	
	@FindBy(id="nav-hamburger-menu")
	private WebElement navHamburgerMenu;
	
	@FindBy(xpath="//a[@class=\"hmenu-item\" and @data-menu-id=\"10\"]")
	private WebElement mensfashion;
	
	@FindBy(linkText ="Clothing")
	private WebElement clothing;
	
	@FindBy(xpath="(//span[contains(text(),'4 Stars & Up')])[1]")
	private WebElement star; 
	
	@FindBy(xpath="//span[text()='₹1,000 - ₹1,500']")
	private WebElement pricerange;
	
	@FindBy(xpath="//li[contains(@id,'Allen Solly')]//following-sibling::i")
	private WebElement brand;
	
	@FindBy(xpath="//span[text()=\"Men's Underwear Uno IntelliSoft Antimicrobial Micro Modal Trunk, Pack of 5\"]")
	private WebElement secondproduct;
	
	@FindBy(xpath="//span[text()='Amazon Fashion']")
	private WebElement pageLoad;
	
	
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		PageFactory.initElements(driver,this);
		
	}
	
	
	public void naviagateToAmazonHomePage() {
		
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
	}

	
	
	public boolean isElementPresent(WebElement targetElement) {
		Boolean isPresent = false;
		try {
			return isPresent = targetElement.isDisplayed();
		} catch (Exception ex) {
			ex.printStackTrace();
			return isPresent;
		}

	}
	
	public boolean waitForVisibility(WebElement targetElement) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(targetElement));
		//	wait.until(ExpectedConditions.visibilityOf(targetElement));
			return true;
		} catch (TimeoutException e) {
			System.out.println("Element is not visible: " + targetElement);
			System.out.println();
			System.out.println(e.getMessage());
			throw new TimeoutException();

		}
	}
	public void clickFashionAndMens() throws InterruptedException {
		
		WebElement element1=wait.until(ExpectedConditions.elementToBeClickable(navHamburgerMenu));
		element1.click();
		WebElement element2=wait.until(ExpectedConditions.elementToBeClickable(mensfashion));
		element2.click();
		Thread.sleep(4000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()",clothing );
		while(!isElementPresent(pageLoad))
		{
			
		}
		
	}
	
	public void filterByCustomerReview() {
		
		WebElement element = driver.findElement(By.xpath("//div[@aria-label='4 Stars & Up']"));
		String text = element.getText();
	//	Assert.assertEquals(text,string);
		//System.out.println("Assert Verification passed");
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()",star );
		
		
		}
	
public String filterByCustomerReviewText() {
		
		WebElement element = driver.findElement(By.xpath("(//span[contains(text(),'4 Stars & Up')])[1]"));
		String text = element.getText();
		return text;
		
		}
	
		public void filterByPriceRange() {
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()",pricerange );
		
		}

		public void filterByBrand() {
	
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click()",brand );
	
		}
		
		public void countOftheProduct() throws InterruptedException {
			Thread.sleep(5000);
			List<WebElement> elements = driver.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"));
			System.out.println("Counts of the Result   "+ " : " +  elements.size());
			
			for (int i = 0; i < elements.size(); i++) {
				
				if(i == 1)
				{
					elements.get(i).click();
				}
				
			}
	
		}
		
		
		public void clickAddtocart() throws InterruptedException {
			
			
			String a = driver.getWindowHandle();
			Set<String> b = driver.getWindowHandles();
			
			for(String c : b)
			{
				if(!c.equals(a))
				{
					driver.switchTo().window(c);
				}
			}
			Thread.sleep(5000);
			WebElement addtoCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click()",addtoCart );
		}
		
		public String getValue()
		{
			WebElement element = driver.findElement(By.xpath("//span[@id='nav-cart-count']"));
			String text = element.getText();
			return text;
		}
		
		public String getElementText(WebElement element)
		{
			String text = element.getText();
			return text;
		}
		
		
		
		
		public void takeScreenShotPath() throws IOException {
			
			
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			File Des = new File("C:\\Users\\Agnes Jude\\Jude-WorkSpace\\BDD-Workspace\\AmazonDemo\\ScreenShot\\Screen01.png");
			FileUtils.copyFile(source, Des);
		}
		
		
		
		
}
