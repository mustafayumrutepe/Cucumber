package StepDefinitions;

import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before   //cucumber in annotation i
    public void before(){

    }

    @After   //cucumber in annotation i
    public void after(Scenario senaryo){

        ExcelUtility.writeToExcel("src/test/java/ApachePOI/resource/SenaryoSonuclari3.xlsx",senaryo);
        // extent reportun plugini aktif iken açık kalsın //yani mesela _07_TestRunnerExtentReport taki gibi  plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} varsa çalışsın, bu yoksa burayı kapatalım. yoksa hata veriri, plugin demek rapor demek
        if (senaryo.isFailed()){
            TakesScreenshot ts=((TakesScreenshot) GWD.getDriver());
            byte[] hafizadakiHali=ts.getScreenshotAs(OutputType.BYTES);
            senaryo.attach(hafizadakiHali, "image/png", "screenshot name");
        }

        GWD.quitDriver();
    }
}
