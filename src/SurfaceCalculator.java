/*TODO: Write a small program that will take in length and width measurements and then calculates the surface.
    The thing is that the measurements can come in metres, centimetres (0.01 metre) or millimeters (0.001 m).
    The program takes in the measurements as strings and then translates them to metres before calculating the surface.
    There are different ways of doing this, but since we are working with fixed concepts, this is a great opportunity to use enumerations.
    Enumerations can have methods, so use a method to check if the incoming measurement
    (which could be x1 m, x1 cm or x1 mm) is in a correct unit of measurement and then to decide which calculation to do in order to turn it into a metre.
 */
import java.util.Scanner;

public class SurfaceCalculator {
    public enum Unit {
        METER("m", 1),
        CENTIMETER("cm", 0.01),
        MILLIMETER("mm", 0.001);

        private final String abbreviation;
        private final double conversionFactor;

        Unit(String abbreviation, double conversionFactor) {
            this.abbreviation = abbreviation;
            this.conversionFactor = conversionFactor;
        }

        public boolean matches(String abbreviation) {
            return this.abbreviation.equals(abbreviation);
        }

        public double toMeters(double value) {
            return value * conversionFactor;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length: ");
        String lengthString = scanner.nextLine();

        Unit lengthUnit = getValidUnit(lengthString);
        double lengthInMeters = lengthUnit.toMeters(parseValue(lengthString));

        System.out.print("Enter width: ");
        String widthString = scanner.nextLine();

        Unit widthUnit = getValidUnit(widthString);
        double widthInMeters = widthUnit.toMeters(parseValue(widthString));

        double surfaceArea = lengthInMeters * widthInMeters;
        System.out.println("Surface area: " + surfaceArea + " m^2");
    }

    private static Unit getValidUnit(String measurementString) {
        for (Unit unit : Unit.values()) {
            if (measurementString.endsWith(unit.abbreviation)) {
                return unit;
            }
        }
        throw new IllegalArgumentException("Invalid measurement string: " + measurementString);
    }

    private static double parseValue(String measurementString) {
        String valueString = measurementString.substring(0, measurementString.length() - 2);//removing the last two characters of the string (which should be the unit abbreviation)
        double value = Double.parseDouble(valueString); //parsing the remaining string as a double using Double.parseDouble()
        return value;
    }

}

