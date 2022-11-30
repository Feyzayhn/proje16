package stepDefinitions.jdbcStepDefinitions;

import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

import static utilities.DataBaseUtility.*;
import static utilities.DataBaseUtility.getColumnData;

public class JdbcStepDefinition {

    @Given("hasta,doktor ve personel id gorunur oldugunu dogrular")
    public void hastaDoktorVePersonelIdGorunurOldugunuDogrular() {

        createConnection();

        String queryPatient = "SELECT * FROM patient where id=322342";
        String queryPhysician = "SELECT * FROM physician where id=309705";
        String queryPhysician2 = "SELECT * FROM physician where id=322880";
        String queryStaff = "SELECT * FROM staff where id=320120";
        String query = "select first_name,last_name from public.physician";

        String query2 = "select first_name,last_name from public.physician where id=322880 or id=309705";

        //System.out.println("getQueryResultMap(query) = " + getQueryResultMap(query));
        List<Map<String, Object>> doctorList = getQueryResultMap(query2);
        for (Map<String, Object> w : doctorList) {

            System.out.println(w);
        }

        /*String query1 = "select * from jhi_user";
        //List<Object> allData = getColumnData(query, "ssn");
        //System.out.println(allData);
        List<String> columnNames = getColumnNames(query1);
        System.out.println(columnNames);
        for (int i = 0; i < columnNames.size(); i++) {
            List<Object>  allData = getColumnData(query1, columnNames.get(i)); // sutunlari sirayla aliyor
            System.out.println(allData);
        }*/

        // System.out.println(getQueryResultMap(queryPatient));
        System.out.println(getQueryResultList(queryPhysician));
        System.out.println("getColumnData(queryPhysician2,\"first_name\") = " + getColumnData(queryPhysician2, "first_name"));
        System.out.println(getQueryResultList(queryStaff));

        //System.out.println(getQueryResultList(queryPatient));

        //System.out.println(getSecondCellValue(queryStaff));
        //System.out.println(getMaxCountryId(queryStaff, "id"));


        //System.out.println(getColumnNames(queryPatient));
        //System.out.println(getColumnNames(queryPhysician));
        //System.out.println(getColumnNames(queryStaff));

        //System.out.println(getColumnData(queryPatient, "email"));
        //System.out.println(getColumnData(queryPhysician, "first_name"));
        //System.out.println(getColumnData(queryStaff, "last_name"));

        closeConnection();
    }
}
