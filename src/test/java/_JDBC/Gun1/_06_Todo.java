package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _06_Todo extends JDBCParent {


    @Test
    public void todo1() throws SQLException {// TODO : city tablosundaki tüm satırlardaki şehir isimlerini absolute ile yazdırınız
        ResultSet rs = sorguEkrani.executeQuery("select city from city");

        rs.last();
        int amount=rs.getRow();

        for (int i = 1; i <= amount; i++) {
            rs.first();
            rs.absolute(i);
            System.out.println(i+". şehir = " + rs.getString(1));
        }
    }



    @Test
    public void todo2() throws SQLException { // TODO : city tablosundaki tüm satırlardaki şehir isimlerini relative ile yazdırınız
        ResultSet rs = sorguEkrani.executeQuery("select city from city");

        rs.last();
        int amount=rs.getRow();
        rs.first();

        for (int i = 1; i <= amount; i++) {

            rs.absolute(i);
            System.out.println(i+". şehir = " + rs.getString(1));
        }
    }


}
