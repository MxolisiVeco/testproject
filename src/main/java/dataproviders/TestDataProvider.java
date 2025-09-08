/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataproviders;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;

/**
 *
 * @author Veco Mxolisi
 */
public class TestDataProvider {

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider() throws IOException {
        String fileName = "data/loginData.csv";
        return readCsvData(fileName);
    }

    private Object[][] readCsvData(String fileName) throws IOException {
        try (FileReader in = new FileReader(fileName); CSVParser parser = CSVFormat.DEFAULT
                .builder()
                .setHeader() // use first record as header
                .setSkipHeaderRecord(true) // don’t return header as data
                .get()
                .parse(in)) {

            List<CSVRecord> records = parser.getRecords();

            Object[][] data = new Object[records.size()][1];
            for (int i = 0; i < records.size(); i++) {
                data[i][0] = records.get(i);
            }
            return data;
        }
    }

}
