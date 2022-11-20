package jdbc;

import static utilities.DBUtils.*;

public class Test {


    @org.junit.Test
    public void test01() {

        createConnection();

        String query = "SELECT * FROM patient";

        System.out.println(getColumnNames(query));

        System.out.println(getColumnData(query, "first_name"));
    }
}
