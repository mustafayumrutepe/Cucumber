package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Locale;

public class GWD {

    private static ThreadLocal<WebDriver> threadDriver=new ThreadLocal<>();
    public static ThreadLocal<String> threadBrowserName =new ThreadLocal<>();

    public static WebDriver getDriver() {

        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        if (threadBrowserName.get()==null) // xml den çalıştırlmayan diğer bölümler
            threadBrowserName.set("chrome"); // için default chrome olsun

        if (threadDriver.get() == null) {

            switch (threadBrowserName.get()){
                case "firefox": threadDriver.set(new FirefoxDriver()); break; // ilgili threade bir driver set ettim
                case "safari":  threadDriver.set(new SafariDriver());  break; // ilgili threade bir driver set ettim
                case "edge":    threadDriver.set(new EdgeDriver());    break; // ilgili threade bir driver set ettim
                default :  threadDriver.set(new ChromeDriver()); // ilgili threade bir driver set ettim
            }

//            threadDriver.set(new ChromeDriver());

        }
        threadDriver.get().manage().window().maximize();
        threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        return threadDriver.get();
    }





    public static void quitDriver() {
        //test sonucu ekrani bir miktar beklesin diye
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        //driver kapat
        if (threadDriver.get() != null) {//driver var ise
            threadDriver.get().quit();

            WebDriver driver= threadDriver.get();
            driver = null;

            threadDriver.set(driver);
        }
    }


}


//driverı paralel çalışacak hale getirdik
//paralel çalışmamızı sağlayan XML i kullandık.
//
//her driverı çağıran yeni drivır mı alıyordu,
//
//paralel çalışmada her bir paralel süreç ayrı bir hat
//şeklind eçalışır. yani ayrı boru hatları gibi, aynı anda
//çalışan.
//
//ayrı çalışan her bir boru hattına : pipeline : thread
//
//Thread.Sleep(5000) -> bulunduğum boru hattını beklet
//
//böylece her boru hattına ayrı bir driver oldu, extend şekli ile
//
//Cucumberda süreçler içerisinde driver static olmak zorunda
//hem static olacak hemde her boru hattına özel olacak
//static boru hatlarının kendine özel static olacak
//
//thread static : boru hattına özel static : thread local static
//thread in kendine özel static.: threadin bi tanesi
//
//static  ThreadLocal<WebDriver> : thread in local static Driverı
//               List<WebDriver>