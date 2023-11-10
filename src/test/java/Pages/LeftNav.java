package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent{

    public LeftNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath="(//span[text()='Setup'])[1]")
    public WebElement setup;
    @FindBy(xpath = "//span[text()='Parameters']")
    public WebElement parameters;
    @FindBy(xpath = "(//span[text()='Countries'])[1]")
    public WebElement countries;
    @FindBy(xpath = "//span[text()='Citizenships']")
    public WebElement citizenShips;
    @FindBy(xpath = "//span[text()='Nationalities']")
    private WebElement nationalities;
    @FindBy(xpath = "//span[text()='Fees']")
    private WebElement Fees;
    @FindBy(xpath = "(//span[text()='Entrance Exams'])[1]")
    private WebElement ExtanceExams;
    @FindBy(xpath = "(//span[text()='Setup'])[2]")
    private WebElement ExtanceExamsSetup;
    @FindBy(xpath = "(//span[text()='Entrance Exams'])[2]")
    private WebElement SetupExtanceExams;
    @FindBy(xpath="(//span[text()='States'])[1]")
    private WebElement states;



    public WebElement getWebElement(String strElement){
        switch (strElement){
            case "setup": return this.setup;
            case "parameters": return this.parameters;
            case "countries": return this.countries;
            case "citizenShips": return this.citizenShips;
            case "nationalities": return this.nationalities;
            case "Fees": return this.Fees;
            case "ExtanceExams": return this.ExtanceExams;
            case "ExtanceExamsSetup": return this.ExtanceExamsSetup;
            case "SetupExtanceExams": return this.SetupExtanceExams;
            case "states" : return this.states;
        }

        return null;
    }
}
