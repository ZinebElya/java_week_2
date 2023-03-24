import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public static List<String[]> csvReader(){
/*
        String csvFile = "C:\\Users\\admin\\Downloads\\effects-of-covid19.csv";

        // read in the CSV file
        List<String[]> data = null;
        // The data is stored in a List of String arrays called "data"
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            data = br.lines()
                    .skip(1) // skip the first line
                    .map(line -> line.split(","))// Each line of the CSV file is then split by commas using the "split" method and stored in a String array
                    .collect(Collectors.toList()); // the data is collected using the "collect" method.
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        String csvFile = "C:\\Users\\admin\\Downloads\\effects-of-covid19.csv";
        String line = "";
        String cvsSplitBy = ",";
        List<String[]> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            // Skip header line
            br.readLine();

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] row = line.split(cvsSplitBy);
                dataList.add(row);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }
}

