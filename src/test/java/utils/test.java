package utils;

import java.util.List;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        List<Map<String, String>> tableData = DbReader.fetch("select * from person");
        System.out.println(tableData);

        System.out.println(tableData.get(0));
    }
}
