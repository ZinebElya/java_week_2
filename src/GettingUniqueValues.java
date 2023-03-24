/*TODO: Read in the csv file about effects-of-covid-19-on-trade. Each column has a set of unique values.
    List all of these unique values for each column.
    There are different ways of doing this, but you are required to use the streaming api to do so.
 */
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class GettingUniqueValues {

    public static void main(String[] args) {

        List<String[]> data = CsvReader.csvReader();

        // list unique values for each column
        Set<String> direction = data.stream().map(arr -> arr[0]).collect(Collectors.toSet());
        Set<String> year = data.stream().map(arr -> arr[1]).collect(Collectors.toSet());
        Set<String> date = data.stream().map(arr -> arr[2]).collect(Collectors.toSet());
        Set<String> weekday = data.stream().map(arr -> arr[3]).collect(Collectors.toSet());
        Set<String> country = data.stream().map(arr -> arr[4]).collect(Collectors.toSet());
        Set<String> commodity = data.stream().map(arr -> arr[5]).collect(Collectors.toSet());
        Set<String> transport = data.stream().map(arr -> arr[6]).collect(Collectors.toSet());
        Set<String> measure = data.stream().map(arr -> arr[7]).collect(Collectors.toSet());
        Set<String> value = data.stream().map(arr -> arr[8]).collect(Collectors.toSet());
        Set<String> cumulative= data.stream().map(arr -> arr[9]).collect(Collectors.toSet());

        /*Each set is created by calling the "map" method on the "data" List and passing in a lambda expression that extracts
        the value of a specific column.
        The "collect" method is then called to collect the unique values into a Set.
         */

        // print out unique values for each column
        System.out.println("Direction: " + direction);
        System.out.println("Year: " + year);
        System.out.println("Country: " + country);
        System.out.println("Transport: " + transport);
        System.out.println("Weekday: " + weekday);



    }
}
