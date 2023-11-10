package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_NextPrevAbsRel extends JDBCParent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select*from language");

        rs.next();  // bir adım ileri
        System.out.println("1. satır = " + rs.getString(2));  // 2. column index değil -ing  // rs.getString("name") şeklinde başlıktan da gidilebilir

        rs.next();  //bir adım ileri
        System.out.println("2. satır = " + rs.getString(2));  // 2. column index değil  -ital

        rs.previous();  // bir adım geri
        System.out.println("1. satır = " + rs.getString(2));  // 2. column index değil  -ing

    }


    @Test
    public void test2() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select*from film");

        rs.absolute(10);  // 10 satır/a direk git
        System.out.println("10. satır title = " + rs.getString("title"));

        rs.absolute(5);  // 5 satıra direk git
        System.out.println("5. satır title = " + rs.getString("title"));

        rs.relative(3);  // en son neredeysen , ordan itibaren 5 git
        System.out.println("10. satır title = " + rs.getString("title"));

        rs.absolute(-7);
        System.out.println("rs.getString(\"title\") = " + rs.getString("title"));
    }

    // rs.next() : sonraki satır
    // rs.previous : önceki satır
    // rs.absolute(10) : baştan itibaren 10.satıra ileri gider.
    // rs.relative(10) : bulunduğu yerden 10.satıra ileri gider.
    // rs.absolute(-10) : - (eksi) sondan demektir, sondan 10.satır
    // rs.relative(-5) :  - (eksi) bulunduğu yerden 5 satır geri


    //absolute baştan itibaren sayıp 5 tane gidiyor
    //relative bulundugu yerden sayıp gidiyor
}
