package jdbc;

import static utilities.DBUtils.*;

public class Query06 {

    public static void main(String[] args) {

        createConnection(); // database'e baglan

        String query = "SELECT * FROM ogrenciler";

        System.out.println("Sutun isimleri : " + getColumnNames(query));

        System.out.println("Okul NO : " + getColumnData(query, "okul_no"));
        System.out.println("Ogrenci isim : " + getColumnData(query, "ogrenci_ismi"));
        System.out.println("Sinif : " + getColumnData(query, "sinif"));
        System.out.println("Cinsiyet : " + getColumnData(query, "cinsiyet"));

    }
}
