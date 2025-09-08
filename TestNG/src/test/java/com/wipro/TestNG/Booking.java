package com.wipro.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Booking {

    WebDriver driver;  

    // ================== TEST CASE ==================
    @Test(priority = 0)
    public void Bookingflow() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.booking.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // Enter destination
        WebElement search = driver.findElement(By.name("ss"));
        search.sendKeys("Puri,India");
        Thread.sleep(1000);

        // Click date field
        WebElement dateField = driver.findElement(By.xpath("//button[@data-testid='searchbox-dates-container']"));
        dateField.click();
        Thread.sleep(1000);

        // Pick check-in date (18 September 2025)
        WebElement checkIn = driver.findElement(By.xpath("//span[@aria-label='Fr 19 September 2025']"));
        checkIn.click();

        // Pick check-out date (19 September 2025)
        WebElement checkOut = driver.findElement(By.xpath("//span[@aria-label='Sa 20 September 2025']"));
        checkOut.click();
        Thread.sleep(1000);

        // Submit search
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();

        WebElement checkbox = driver.findElement(By.xpath("//label[@for=':rq:']//span[@class='fc70cba028 f823b234fe ca6ff50764']//*[name()='svg']"));
        checkbox.click();
        Thread.sleep(2000);

        WebElement sortBy = driver.findElement(By.xpath("//span[@class='a9918d47bf']"));
        sortBy.click();
        Thread.sleep(1000);

        WebElement sortByLowToHigh = driver.findElement(By.xpath("//button[@aria-label='Property rating (low to high)']//div[@class='aa225776f2 ca9d921c46 d1bc97eb82']"));
        sortByLowToHigh.click();
        Thread.sleep(2000);

        WebElement checkbox1 = driver.findElement(By.xpath("//label[@for=':rq:']//span[@class='fc70cba028 f823b234fe ca6ff50764']//*[name()='svg']"));
        checkbox1.click();
        Thread.sleep(2000);

        // ✅ Close browser at the end of the test
        driver.quit();
    }

    @Test(priority = 1)
    public void BookingFunctionality() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.booking.com/hotel/in/collection-o-puri.html?label=gen173nr-10CAEoggI46AdIM1gEaGyIAQGYATO4ARfIAQ_YAQPoAQH4AQGIAgGoAgG4Ao6w8MUGwAIB0gIkNDdiNzdjZDQtZjNlYi00NTYxLWIwZjktY2U0NTNiMzRkOTFl2AIB4AIB&aid=304142&ucfs=1&arphpl=1&checkin=2025-09-18&checkout=2025-09-19&dest_id=-2108407&dest_type=city&group_adults=2&req_adults=2&no_rooms=1&group_children=0&req_children=0&hpos=1&hapos=1&sr_order=popularity&srpvid=c8264f4ee74b003e&srepoch=1757159155&all_sr_blocks=1439152502_415400806_2_0_0&highlighted_blocks=1439152502_415400806_2_0_0&matching_block_id=1439152502_415400806_2_0_0&sr_pri_blocks=1439152502_415400806_2_0_0__127135&from=searchresults"); // truncated for brevity
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement reserve = driver.findElement(By.xpath("//button[@id='hp_book_now_button']//span[normalize-space()='Reserve']"));
        reserve.click();
        Thread.sleep(2000);

        WebElement dropdown = driver.findElement(By.xpath("//select[@id='hprt_nos_select_1439152502_415400806_2_0_0']"));

        // Create a Select object
        Select select = new Select(dropdown);

        // Select the 1st option (index starts from 0)
        select.selectByIndex(0);


        // ✅ Close browser at the end of the test
        driver.quit();
    }

    @Test(priority = 2)
    public void BookingDetails() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);

        driver.get("https://secure.booking.com/book.html?hotel_id=14391525&occupancy_setup_issue_flags=&aid=304142&label=gen173nr-10CAEoggI46AdIM1gEaGyIAQGYATO4ARfIAQ_YAQPoAQH4AQGIAgGoAgG4Ao6w8MUGwAIB0gIkNDdiNzdjZDQtZjNlYi00NTYxLWIwZjktY2U0NTNiMzRkOTFl2AIB4AIB&sid=ae0be11573562185e710cebd58f47b93&room1=A%2CA&error_url=%2Fhotel%2Fin%2Fcollection-o-puri.html%3Faid%3D304142%26label%3Dgen173nr-10CAEoggI46AdIM1gEaGyIAQGYATO4ARfIAQ_YAQPoAQH4AQGIAgGoAgG4Ao6w8MUGwAIB0gIkNDdiNzdjZDQtZjNlYi00NTYxLWIwZjktY2U0NTNiMzRkOTFl2AIB4AIB%26sid%3Dae0be11573562185e710cebd58f47b93%26srpvid%3Dc8264f4ee74b003e%26%26&hostname=www.booking.com&stage=1&checkin=2025-09-18&interval=1&children_extrabeds=&srpvid=c8264f4ee74b003e&hp_visits_num=1&rt_pos_selected=1&rt_pos_selected_within_room=1&rt_selected_block_position=1&rt_num_blocks=6&rt_num_rooms=1&rt_num_blocks_per_room=%7B%221439152502%22%3A6%7D&rt_selected_blocks_info=%7B%221439152502_415400806_2_0_0%22%3A%7B%22rt_selected_block_position_in_rt%22%3A1%2C%22rt_selected_block_position_in_room_group%22%3A0%2C%22count%22%3A2%2C%22rt_room_symmetry_category%22%3A%22symmetric%22%7D%7D&rt_relevance_metric_id=71427e2b-d6c6-4038-8d3f-24fedca3d3de&rt_pageview_id=5d1552bd2455009b&rt_pos_final=1.1&rt_selected_total_price=2542&rt_cheapest_search_price=1271&rt_with_no_dimensions=&from_source=hotel&nr_rooms_1439152502_415400806_2_0_0=2&basket_id=5e1c8223-160b-43b5-bd85-0a7b19d491ed"); // truncated for brevity
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("saikiran");
        Thread.sleep(2000);

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("PMV");
        Thread.sleep(1000);

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("saikiran@gmail.com");
        Thread.sleep(1000);


        WebElement phone = driver.findElement(By.xpath("//*[@id=\":rt:\"]"));
        phone.sendKeys("8327727235");
        Thread.sleep(2000);

        
        WebElement finalr=driver.findElement(By.xpath("//span[@class='bui-button_text js-button_text']"));
        finalr.click();
        
        Thread.sleep(2000);
        
        
        WebElement bookin=driver.findElement(By.xpath("//button[@name='book']"));
        bookin.click();
        Thread.sleep(1000);
      
        /*  
        WebElement cont=driver.findElement(By.xpath("//button[@class='bui-button bui-button--secondary']"));
        cont.click();
        Thread.sleep(1000);
        

        WebElement checkbox = driver.findElement(By.xpath("label[for=':r12:']"));
        checkbox.click();
        Thread.sleep(2000);
        
        
        WebElement radioButton = driver.findElement(By.id("I'm booking for someone else"));  // Replace with actual ID
        radioButton.click();  // Selects the radio button
        
        */

        // ✅ Close browser at the end of the test
        driver.quit();
    }

                      
    }