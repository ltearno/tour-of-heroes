package fr.lteconsulting.angular2gwt.demos.tourofheroes.server;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest( /* properties = "server.port=9000", */ webEnvironment = WebEnvironment.RANDOM_PORT )
public class ApplicationTest
{
	@LocalServerPort
	Integer port;

	private WebDriver driver;

	private WebDriverWait wait;

	@Before
	public void setup() throws Exception
	{
		String chromeDriverPath = getSeleniumDriverPath();

		System.out.println( "Using ChromeDriver path : " + chromeDriverPath );
		System.out.println( "Application available on url http://localhost:" + port );

		System.setProperty( "webdriver.chrome.driver", chromeDriverPath );

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait( 30, TimeUnit.SECONDS );
		wait = new WebDriverWait( driver, 10 );

		driver.get( "http://localhost:" + port );
	}

	@Test
	public void testChangeHeroName() throws InterruptedException
	{
		String xpath = "/html/body/my-app/my-dashboard/div/div[1]/div/h4";
		By firstHeroButton = By.xpath( xpath );

		wait.until( elementToBeClickable( firstHeroButton ) );

		driver.findElement( firstHeroButton ).click();
		driver.findElement( By.xpath( "//input" ) ).clear();
		driver.findElement( By.xpath( "//input" ) ).sendKeys( "Toto" );
		driver.findElement( By.xpath( "//button[2]" ) ).click();

		assertEquals( "Toto", driver.findElement( firstHeroButton ).getText() );

		// for demonstration, we allow the user to see what happened !
		Thread.sleep( 5000 );
	}

	@After
	public void tearDown()
	{
		driver.quit();
	}

	private String getSeleniumDriverPath()
	{
		return System.getProperty( "user.dir" ) + "\\chromedriver.exe";
	}
}
