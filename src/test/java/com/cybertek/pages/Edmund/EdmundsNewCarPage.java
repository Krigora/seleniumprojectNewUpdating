package com.cybertek.pages.Edmund;
import static org.testng.Assert.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EdmundsNewCarPage extends BasePage {

    ////<select data-tracking-id="new_cars_index_mmy_make_select" data-no-refresh="false" id="sel-3731105644245450" name="select-make" aria-label="Select Make" class="vehicle-type-select search-by-select w-100 btn btn-sm btn-secondary text-left"

    @FindBy(name = "select-make")
    public WebElement make;

    //<select data-tracking-id="new_cars_index_mmy_model_select" data-no-refresh="false" id="sel-827923538744288" name="select-model" aria-label="Select Model" class="vehicle-type-select search-by-select w-100 btn btn-sm btn-secondary text-left" disabled=""><option selected="" class="" value="">Any Model</option></select>

    @FindBy(name = "select-model")
    public WebElement model;

    ////<input type="text" id="zip-input-1041984622096337" name="make_model_tab" inputmode="numeric" pattern="[0-9]*" value="60656" placeholder="" data-test="zip-input" data-tracking-id="new_cars_index_mmy_make_model_tab_zip_code_entry" aria-label="Zip Code" class="search-by-zip-input pl-2 form-control-sm form-control">

    @FindBy(xpath = "//input[@data-tracking-id='new_cars_index_mmy_make_model_tab_zip_code_entry']")
    public WebElement zipCode;

    @FindBy(xpath = "//button[@data-tracking-id='new_cars_index_mmy_make_model_tab_submit']")
    public WebElement goBtn;

    public void selectMake(String carMake) {
        Select makeDropDown = new Select(make); //creating Select class object because it is drop down
        makeDropDown.selectByVisibleText(carMake);

    }

    public void selectModel(String carModel) {
        Select modelDropDown = new Select(model);
        modelDropDown.selectByVisibleText(carModel);

    }

    @Override
    public void isCurrentPage() {
        assertEquals(driver.getTitle(), "New Cars for Sale - Pricing and Deals | Edmunds");

        //<select data-tracking-id="new_cars_index_mmy_make_select" data-no-refresh="false" id="sel-3731105644245450" name="select-make" aria-label="Select Make" class="vehicle-type-select search-by-select w-100 btn btn-sm btn-secondary text-left"
    }
}
