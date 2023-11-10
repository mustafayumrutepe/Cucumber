package _JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Giris {

    @Test
    public void test1() throws SQLException {
//        bir sorgunun çalışması için yapılanlar
        String HostUrl="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila";
        String username="root";    //(jdbc:mysql://) bu javaya mysql e baglan diyor
        String password="'\"-LhCB'.%k[4S]z";

//        1- bağlantı bilgilerini girdik : connection bilgileri set edildi.
        Connection baglanti = DriverManager.getConnection(HostUrl, username, password);

//        2- db seçtik.  // HostUrl ye bu bilgi eklendi (/sakila) bu kısımdır

//        3- Sorgu ekranını açtık
        Statement sorguEkrani = baglanti.createStatement();

//        4- Sorgu Ekranına, sorguyu yazdım, çalıştırdım ve sonuçları aldım
        ResultSet sonucTablosu=sorguEkrani.executeQuery("select*from customer");

//        5- altta sonuçlar gözüktü  - javanın içinde ise sonuçları satır satır okuyoruz
        sonucTablosu.next();  //şuanda ilk satıra geldim
        // sonuçların hepsi çok olur bilgisayarı yormasın diye
        // bilgisayar bize hangi satırı istiyorsun yaz onu vereyim diyor.
        // her next bir sonraki satırı veriyor

        String ad=sonucTablosu.getString("first_name"); //istediğim bilgiyi aldım
        String soyad=sonucTablosu.getString("last_name");  //bu satırdaki istediğim bilgiyi aldım
        System.out.println("ad = " + ad);
        System.out.println("soyad = " + soyad);

        sonucTablosu.next(); // 2. satıra gittim

        ad=sonucTablosu.getString("first_name"); //istediğim bilgiyi aldım
        soyad=sonucTablosu.getString("last_name");  //bu satırdaki istediğim bilgiyi aldım
        System.out.println("ad = " + ad);
        System.out.println("soyad = " + soyad);

        baglanti.close();
    }
}
