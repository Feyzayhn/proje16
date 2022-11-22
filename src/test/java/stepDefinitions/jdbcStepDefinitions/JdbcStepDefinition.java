package stepDefinitions.jdbcStepDefinitions;

import io.cucumber.java.en.Given;

import static utilities.DBUtils.*;
import static utilities.DBUtils.getColumnData;

public class JdbcStepDefinition {

    @Given("hasta,doktor ve personel id gorunur oldugunu dogrular")
    public void hastaDoktorVePersonelIdGorunurOldugunuDogrular() {

        createConnection();

        String queryPatient = "SELECT * FROM patient where id=322342";
        String queryPhysician = "SELECT * FROM physician where id=309705";
        String queryStaff = "SELECT * FROM staff where id=320120";

        // System.out.println(getQueryResultMap(queryPatient));


       // System.out.println(getColumnNames(queryPatient));
       // System.out.println(getColumnNames(queryPhysician));
       // System.out.println(getColumnNames(queryStaff));

        System.out.println(getColumnData(queryPatient, "email"));
        System.out.println(getColumnData(queryPhysician, "first_name"));
        System.out.println(getColumnData(queryStaff, "last_name"));


        closeConnection();
    }
}
