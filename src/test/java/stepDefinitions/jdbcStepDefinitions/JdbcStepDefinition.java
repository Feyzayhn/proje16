package stepDefinitions.jdbcStepDefinitions;

import io.cucumber.java.en.Given;

import static utilities.DBUtils.*;
import static utilities.DBUtils.getColumnData;

public class JdbcStepDefinition {

    @Given("hasta,doktor ve personel id gorunur oldugunu dogrular")
    public void hastaDoktorVePersonelIdGorunurOldugunuDogrular() {


        createConnection();

        String queryPatient = "SELECT * FROM patient";
        String queryPhysician = "SELECT * FROM physician";
        String queryStaff = "SELECT * FROM staff";

        System.out.println(getColumnNames(queryPatient));
        System.out.println(getColumnNames(queryPhysician));
        System.out.println(getColumnNames(queryStaff));

        System.out.println(getColumnData(queryPatient, "id"));
        System.out.println(getColumnData(queryPhysician, "id"));
        System.out.println(getColumnData(queryStaff, "id"));

        closeConnection();
    }
}
