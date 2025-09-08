package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class BookingPages { 
    private final WebDriver driver;
    private final WebDriverWait wait;

    public BookingPages(WebDriver driver) {
        this.driver = driver;
        this.wait  = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openHome() {
        driver.get("https://www.booking.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ss")));
    }

    public void searchDestination(String city) {
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.name("ss")));
        search.clear();
        search.sendKeys(city);
    }

    public void openDates() {
        WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@data-testid='searchbox-dates-container']")));
        dateField.click();
    }

    public void selectDate(String aria) {
        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[@aria-label='" + aria + "']")));
        date.click();
    }

    public void submitSearch() {
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        submit.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@data-component='arp-search-results'] | //div[@data-testid='property-card']")));
    }

    public void applyAnyAvailableFilterAndSortLowToHigh() {
        // Apply a filter if available
        try {
            WebElement filter = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[@for=':rq:']//span[contains(@class,'fc70cba028')]//*[name()='svg']")));
            filter.click();
        } catch (Exception ignored) { /* filter may not exist */ }

        WebElement sortBy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='a9918d47bf']")));
        sortBy.click();

        WebElement lowToHigh = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[@aria-label='Property rating (low to high)']//div[contains(@class,'aa225776f2')]")));
        lowToHigh.click();

        try { Thread.sleep(1200); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }

    public void openKnownHotelDetailsUrl() {
    	driver.get("https://www.booking.com/hotel/in/eminent-suites-and-apartments.en-gb.html?aid=304142&label=gen173nr-10CAEoggI46AdIM1gEaGyIAQGYATO4AQfIAQzYAQPoAQH4AQGIAgGoAgG4Aq6x-cUGwAIB0gIkYWQ4YTJkOTQtNDE3Mi00NTMzLThhNzAtN2FmM2Y1MWZhMjNj2AIB4AIB&sid=ba1b1ed317efee66597ce517c1f041e1&all_sr_blocks=1105091102_383310798_1_1_0&checkin=2025-09-22&checkout=2025-09-23&dest_id=-2097701&dest_type=city&dist=0&group_adults=1&group_children=0&hapos=1&highlighted_blocks=1105091102_383310798_1_1_0&hpos=1&matching_block_id=1105091102_383310798_1_1_0&nflt=hotelfacility%3D107&no_rooms=1&req_adults=1&req_children=0&room1=A&sb_price_type=total&sr_order=class_asc&sr_pri_blocks=1105091102_383310798_1_1_0__400000&srepoch=1757324021&srpvid=d2b94310d10002ee&type=total&ucfs=1&");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hp_book_now_button")));
    }

    public void clickReserve() {
        WebElement reserve = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[@id='hp_book_now_button']//span[normalize-space()='Reserve']")));
        reserve.click();
    }

    public void selectOneRoomDropdown() {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//select[contains(@id,'hprt_nos_select_')]")));
        new Select(dropdown).selectByIndex(0); // select first available option
    }

    public void openKnownBookingUrl() {
    	driver.get("https://secure.booking.com/book.html?nflt=hotelfacility%3D107&hotel_id=11050911&occupancy_setup_issue_flags=&aid=304142&label=gen173nr-10CAEoggI46AdIM1gEaGyIAQGYATO4AQfIAQzYAQPoAQH4AQGIAgGoAgG4Aq6x-cUGwAIB0gIkYWQ4YTJkOTQtNDE3Mi00NTMzLThhNzAtN2FmM2Y1MWZhMjNj2AIB4AIB&sid=ba1b1ed317efee66597ce517c1f041e1&room1=A&error_url=%2Fhotel%2Fin%2Feminent-suites-and-apartments.en-gb.html%3Faid%3D304142%26label%3Dgen173nr-10CAEoggI46AdIM1gEaGyIAQGYATO4AQfIAQzYAQPoAQH4AQGIAgGoAgG4Aq6x-cUGwAIB0gIkYWQ4YTJkOTQtNDE3Mi00NTMzLThhNzAtN2FmM2Y1MWZhMjNj2AIB4AIB%26sid%3Dba1b1ed317efee66597ce517c1f041e1%26srpvid%3Dd2b94310d10002ee%26%26&hostname=www.booking.com&stage=1&checkin=2025-09-22&interval=1&children_extrabeds=&srpvid=d2b94310d10002ee&hp_visits_num=1&rt_pos_selected=1&rt_pos_selected_within_room=1&rt_selected_block_position=1&rt_num_blocks=4&rt_num_rooms=2&rt_num_blocks_per_room=%7B%221105091104%22%3A2%2C%221105091102%22%3A2%7D&rt_selected_blocks_info=%7B%221105091102_383310798_1_1_0%22%3A%7B%22rt_selected_block_position_in_rt%22%3A1%2C%22rt_selected_block_position_in_room_group%22%3A0%2C%22count%22%3A1%2C%22rt_room_symmetry_category%22%3A%22one_dimension%22%7D%7D&rt_relevance_metric_id=f98aeb61-3c65-484b-9c9c-23c430303978&rt_pageview_id=921f43b1c3ef03a6&rt_pos_final=1.1&rt_selected_total_price=4000&rt_cheapest_search_price=4000&rt_with_no_dimensions=&from_source=hotel&nr_rooms_1105091102_383310798_1_1_0=1&basket_id=68ec3f08-638e-4878-88ba-bf752468ca1b");


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
    }

    public void fillGuestDetails(String first, String last, String mail, String phoneCssId) {
        driver.findElement(By.name("firstname")).sendKeys(first);
        driver.findElement(By.name("lastname")).sendKeys(last);
        driver.findElement(By.name("email")).sendKeys(mail);
        driver.findElement(By.cssSelector("input[id='" + phoneCssId + "']")).sendKeys("9556959930");
    }

    public void continueAndSubmit() {
        // Continue button
        try {
            driver.findElement(By.xpath("//span[@class='bui-button_text js-button_text']")).click();
        } catch (Exception ignored) {}

        // Submit booking
        try {
            WebElement book = driver.findElement(By.xpath("//button[@name='book']"));
            book.click();
        } catch (Exception ignored) {}
    }
}
