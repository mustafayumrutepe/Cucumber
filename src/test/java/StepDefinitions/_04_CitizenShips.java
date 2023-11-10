package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _04_CitizenShips {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Navigate CitizenShips")
    public void navigateCitizenShips() {
        ln.myClick(ln.setup);
        ln.myClick(ln.parameters);
        ln.myClick(ln.citizenShips);
    }

    @When("Create a CitizenShips")
    public void createACitizenShips() {
        String citizenShipsName= RandomStringUtils.randomAlphanumeric(8);//8 harf
        String citizenShipsShCo= RandomStringUtils.randomNumeric(4); // 4 rakam

        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput,citizenShipsName);
        dc.mySendKeys(dc.ShortName,citizenShipsShCo);
        dc.myClick(dc.saveButton);
    }

    @When("Create a CitizenShips name as {string} short name as {string}")
    public void createACitizenShipsNameAsShortNameAs(String name, String shortName) {
        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput,name);
        dc.mySendKeys(dc.ShortName,shortName);
        dc.myClick(dc.saveButton);
    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dc.verifyContainsText(dc.alreadyExist,"already");
    }

    @When("User delete the {string}")
    public void userDeleteThe(String name) {
        dc.deleteItem(name);
    }
}
