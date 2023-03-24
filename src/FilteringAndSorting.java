/*TODO: Using the same csv file, write a program that prints out a sorted list of the import values of the year 2018.
    The country, commodity and transport_mode need to have the value 'all' when you filter.
    The output needs to be sorted from smallest to biggest (ascending).
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilteringAndSorting {
    public static void main(String[] args) {
        List<String[]> dataList = CsvReader.csvReader();
        List<Double> importValues = new ArrayList<>();

        for(String[] data : dataList){
            String direction = data[0];
            String year = data[1];
            String country = data[4];
            String commodity = data[5];
            String transport = data[6];
            String value = data[8];

            if (direction.equals("Imports") && year.equals("2018") &&
                    country.equals("All") && commodity.equals("All") && transport.equals("All")) {
                importValues.add(Double.parseDouble(value));
            }
        }
        Collections.sort(importValues);

        System.out.println("Sorted list of import values for 2018 :");
        for (double value : importValues) {
            System.out.println(value);
        }
    }
}
