import java.time.LocalDate;

public class TradeData {
    private String direction;
    private String year;
    private LocalDate date;
    private String weekday;
    private String country;
    private String commodity;
    private String transport;
    private String measure;
    private double value;
    private double cumulative;


        // constructor, getters and setters
        public String getYear () {
        return year;
    }

        public String getCountry () {
        return country;
    }

        public String getDirection () {
        return direction;
    }

        public LocalDate getDate () {
        return date;
    }

        public void setMeasure (String measure){
        this.measure = measure;
    }

}
