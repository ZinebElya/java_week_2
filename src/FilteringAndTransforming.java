/*TODO: Using the same csv file, write a program that will print the values for export and import every single day
    but instead of in dollars, we want to see the values in euros, and this for the year of 2016.
    Currently, 1 dollar is about 0.85 euro. Be careful though! Not every line has a value expressed in dollar!
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FilteringAndTransforming {
    public static void main(String[] args) {
        List<String[]> dataList = CsvReader.csvReader();

        double exchangeRate = 0.85; // conversion rate from dollar to euro

        // iterate over the rows and print the values for export and import every single day for the year of 2016
        for (String[] data : dataList) {
            String direction = data[0];
            String year = data[1];
            String dateStr = data[2];
            String measure = data[7];
            String valueStr = data[8];

            try {

            // check if the row corresponds to the year of 2016
            if (!year.equals("2016")) {
                continue;
            }

            if(data[0].equals("Exports") || data[0].equals("Imports")) {

                // convert the value to euro if it is expressed in dollar
                double value;
                if (measure.equals("$")) {
                    value = Double.parseDouble(valueStr) * exchangeRate;
                    measure = "euro"; // change the measure to "euro"

                } else {
                    value = Double.parseDouble(valueStr);
                }

                // print the values for export and import every single day
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                Date date = dateFormat.parse(dateStr);

                System.out.println(direction + "," + dateStr + ", " + measure + ", " + value);
            }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}

