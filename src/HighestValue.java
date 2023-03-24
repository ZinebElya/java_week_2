/*TODO: Using the same csv file, write a program that will output the highest export value of the year 2019,
    the country is China, the commodity is 'all' and the transport mode is also 'all'.
    There are multiple solutions to do this: by using a method of the streaming api or by sorting and finding the highest value.
    Try them both.
    Extra: The output of the program needs to be the sum instead of the highest value.

 */
import java.util.List;
import java.util.stream.Collectors;
public class HighestValue {
    public static void main(String[] args) {

        // Call the csvReader method from CsvReader class to get the data
        List<String[]> dataList = CsvReader.csvReader();

        // 1. Using the Stream API

        // Filter the data to keep only the entries matching the criteria
        List<String[]> filteredData = dataList.stream()
                .filter(row -> row[1].equals("2019")) // Year = 2019
                .filter(row -> row[4].equals("China")) // Country = China
                .filter(row -> row[5].equals("All")) // Commodity = All
                .filter(row -> row[6].equals("All")) // Transport mode = All
                .collect(Collectors.toList());

        // 1.1 Using sort() : Sort the filtered data by export value
        filteredData.sort((row1, row2) -> Integer.parseInt(row2[8]) - Integer.parseInt(row1[8]));

        // Get the highest export value
        int highestValue = Integer.parseInt(filteredData.get(0)[8]);

        System.out.println("The highest export value of 2019 for China, is: " + highestValue);

        //1.2 Using max() : Find the highest export value using the max method
        int highestValue2 = filteredData.stream()
                .mapToInt(row -> Integer.parseInt(row[8])) // extract the export value as an int
                .max() // find the max value
                .getAsInt(); // get the max value as an int

        System.out.println("The highest export value of 2019 for China, is: " + highestValue);

        //  1.Using sorting and searching
        int highestValue3 = 0;
        for (String[] row : dataList) {
            if (row[0].equals("Exports") && row[1].equals("2019") && row[4].equals("China")
                    && row[5].equals("All") && row[6].equals("All")) {
                int value = Integer.parseInt(row[8]);
                if (value > highestValue3) {
                    highestValue3 = value;
                }
            }
        }

        System.out.println("The highest export value of 2019 for China, is: " + highestValue);


    }
}
