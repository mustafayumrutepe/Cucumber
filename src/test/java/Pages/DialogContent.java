package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DialogContent extends Parent {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "input[formcontrolname='username']")
    public WebElement username;
    @FindBy(css = "input[formcontrolname='password']")
    public WebElement password;
    @FindBy(css = "button[aria-label='LOGIN']")
    public WebElement loginButton;
    @FindBy(css = "span[class='mat-mdc-tooltip-trigger logo-text']")
    public WebElement txtTechnoStudy;

//    @FindBy(css = "(//button[@class='navbar-toggle-button mdc-icon-button mat-mdc-icon-button mat-unthemed mat-mdc-button-base ng-star-inserted']/span)[2]")
//    public WebElement ozel;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'ADD')]//button")
    public WebElement addButton;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    public WebElement nameInput;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='code' ]//input")
    public WebElement codeInput;
    @FindBy(xpath = "//ms-save-button/button")
    public WebElement saveButton;
    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    public WebElement successMessage;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    public WebElement ShortName;
    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    public WebElement alreadyExist;
    @FindBy(xpath = "//mat-form-field//input[@data-placeholder='Name']")
    public WebElement searchInput;
    @FindBy(xpath = "//mat-form-field//input[@data-placeholder='Name']")
    public WebElement searchButton;
    @FindBy(xpath = "(//ms-delete-button//button)[1]")
    public WebElement deleteImageBtn;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement deleteDialogBtn;
    @FindBy(xpath = "//input[@id='ms-text-field-5']")
    private WebElement integrationCode;
    @FindBy(xpath = "//input[@id='ms-integer-field-0']")
    private WebElement priorityCode;
    @FindBy(xpath="//mat-slide-toggle[@formcontrolname='active']")
    private WebElement toggleBar;
    @FindBy(xpath="//mat-select//span[text()='Academic Period']")
    private WebElement academicPeriod;
    @FindBy(xpath="(//span[text()='Grade Level'])[1]")
    private WebElement gradeLevel;
    @FindBy(xpath="//span[text()=' Staj 2023 ']")
    private WebElement selectStaj;
    @FindBy(xpath="(//mat-option//span)[3]")
    private WebElement selectOnbir;
    @FindBy(xpath = "//tbody[@role='rowgroup']//tr//td[2]")
    public List<WebElement> nameList;


    public WebElement getWebElement(String strElement){
        switch (strElement){
            case "addButton": return this.addButton;
            case "saveButton": return this.saveButton;
            case "nameInput": return this.nameInput;
            case "codeInput": return this.codeInput;
            case "integrationCode": return this.integrationCode;
            case "priorityCode": return this.priorityCode;
            case "toggleBar": return this.toggleBar;
            case "academicPeriod": return this.academicPeriod;
            case "gradeLevel": return this.gradeLevel;
            case "selectStaj": return this.selectStaj;
            case "selectOnbir": return this.selectOnbir;

        }

        return null;
    }


    public void deleteItem(String searchText){
        mySendKeys(searchInput, searchText);
        myClick(searchButton);

        //1. yontem   beklet
        //1. StaleElement hatası verdi : erken buldum tez kaybettim
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));

        //2. yontem sayfanın kendi waitini , loading ini yakalayalım. (en sağlam yontem)
        //fuse-progress-bar/*   -> fuse-progress-bar ın çocukları
        //bu çocukları 0 olana kadar bekle
        //wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"),0));  //bunda bir
                                                                     // sıkıntı var çalışmıyor

        myClick(deleteImageBtn);
        myClick(deleteDialogBtn);
    }



// stale element açıklaması  cucumber gun05 lesson 1 başında hoca anlatmış
}
