package jdbc;

import org.junit.Test;

import static utilities.DBUtils.*;

public class Query01 {

    @Test
    public void test01() {

        createConnection();

        String queryPatient = "SELECT * FROM patient";
        String queryPhysician = "SELECT * FROM physician";
        String queryStaff = "SELECT * FROM staff";

        System.out.println(getColumnNames(queryPatient));
        System.out.println(getColumnNames(queryPhysician));
        System.out.println(getColumnNames(queryStaff));

        System.out.println(getColumnData(queryPatient, "first_name"));
        System.out.println(getColumnData(queryPhysician, "id"));
        System.out.println(getColumnData(queryStaff, "id"));
    }
}
