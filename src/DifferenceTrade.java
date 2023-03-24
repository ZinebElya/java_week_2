/*TODO: This is a hard challenge. Using the same csv file,
    write a program that will make a comparison of the export values of the months of the year 2019 with the year of 2020.
    The country is the 'European Union'. Make use of HashMaps and the Collectors.groupingByfunction in the Collectors api of the streams api.
    They 'key' function needs to be the month, and the 'value' function needs to be the sum of the export values for that month.
 */

import java.util.List;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;


public class DifferenceTrade {
    public static void main(String[] args){
        List<String[]> dataList = CsvReader.csvReader();

        // Filter data for year 2019 and country 'European Union'
        List<String[]> data2019 = dataList.stream()
                .filter(row -> row[0].equals("Exports"))
                .filter(row -> row[1].equals("2019"))
                .filter(row -> row[4].equals("European Union (27)"))
                .collect(Collectors.toList());
        /*
        System.out.println("Data for 2019:");
        data2019.forEach(row -> System.out.println(Arrays.toString(row)));
         */

        // Group data 2019 by month and sum the export values with for loop
        Map<String, Integer> export2019ByMonth = new HashMap<>();
        for (String[] row : data2019) {
            String month = row[2].substring(3, 5);
            String year = row[2].substring(6);
            String monthYear = month + "-" + year;
            int exportValue = Integer.parseInt(row[8]);
            if (export2019ByMonth.containsKey(monthYear)) {
                export2019ByMonth.put(monthYear, export2019ByMonth.get(monthYear) + exportValue);
            } else {
                export2019ByMonth.put(monthYear, exportValue);
            }
        }

        System.out.println(export2019ByMonth);

        // Group data 2019 by month and sum the export values with Collectors.groupingBy
        Map<String, Integer> export2019 = data2019.stream()
                .collect(Collectors.groupingBy(
                        row -> row[2].substring(3, 10),
                        Collectors.summingInt(row -> Integer.parseInt(row[8]))
                ));

        System.out.println("Exports in 2019:");
        System.out.println(export2019);


        // Filter data for year 2020 and country 'European Union'
        List<String[]> data2020 = dataList.stream()
                .filter(row -> row[0].equals("Exports"))
                .filter(row -> row[1].equals("2020"))
                .filter(row -> row[4].equals("European Union (27)"))
                .collect(Collectors.toList());
        /*
        System.out.println("Data for 2020:");
        data2020.forEach(row -> System.out.println(Arrays.toString(row)));
         */

        // Group data 2020 by month and sum the export values with Collectors.groupingBy
        Map<String, Integer> export2020 = data2020.stream()
                .collect(Collectors.groupingBy(
                        row -> row[2].substring(3, 10),
                        Collectors.summingInt(row -> Integer.parseInt(row[8]))
                ));

        System.out.println("Exports in 2020:");
        System.out.println(export2020);


        // Compare the values for each month of 2019 and 2020
        System.out.println("Difference in exports by month:");
        for (String month : export2019.keySet()) {
            int value2019 = export2019.getOrDefault(month, 0);

            int value2020 = export2020.getOrDefault(month, 0);
            System.out.println(month + ": " + value2019 + " (2019) - " + value2020 + " (2020) = " + (value2019 - value2020));
        }



    }
}
