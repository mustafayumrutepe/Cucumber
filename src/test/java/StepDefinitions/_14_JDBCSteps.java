package StepDefinitions;

import Pages.DialogContent;
import Utilities.DBUtility;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class _14_JDBCSteps {
    DialogContent dc=new DialogContent();

    @Then("Send the query the database {string} and control match")
    public void sendTheQueryTheDatabaseAndControlMatch(String sql) {
        // DB deb oku
        List<List<String>> dbList= DBUtility.getDataList(sql);  //db den okudum
        for (int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i).get(0));  //okudugum DB bilgisini kontrol ediyorum
        }

        System.out.println("**************############################################***************");

        // UI dan oku  (Web den)
        List<WebElement> UIList = dc.nameList;
        for (int i = 0; i < UIList.size(); i++) {
            System.out.println(UIList.get(i).getText());  // okudugum UI bilgisini kontrol ediyorum
        }

        // karşılaştır
        for (int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i).get(0)+" - "+UIList.get(i).getText());
            Assert.assertNotEquals(dbList.get(i).get(0).trim(), UIList.get(i).getText().trim(), "Eşleştirme yapılamadı");
        }










    }
}
