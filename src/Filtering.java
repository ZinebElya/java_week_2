/*TODO: Using the same csv file about effects of covid 19 on trade,
    write a small program that will print the values for both import and the export every day for the year 2016,
    where the country value is 'all'.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Filtering {

    public static void main(String[] args) {

        List<String[]> dataList = CsvReader.csvReader();

        //SimpleDateFormat to convert date from string to Date object
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            for (String[] data : dataList) {
                    //Check if the row matches the required criteria
                if (data[0].equals("Exports") || data[0].equals("Imports")) {
                    Date date = dateFormat.parse(data[2]);
                    String country = data[4];
                    String year = data[1];

                    if (country.equals("All") && year.equals("2016")) {

                        // Print import and export values for the day
                        System.out.println("Date: " + data[2] + ", Export: " + data[8] + ", Import: " + data[9]);
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
