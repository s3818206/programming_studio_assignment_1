package app;

public class AverageTempByRegion {
    private String region;
    private int year;
    private int yearRange;
    private double averageTemp;

    public String getRegion() {return this.region;}
    public void setRegion(String region) {this.region = region;}

    public int getYear() {return year;}
    public void setYear(int year) {this.year = year;}

    public int getYearRange() {return yearRange;}
    public void setYearRange(int inputYearRange) {this.yearRange = inputYearRange;}

    public double getAverageTemp() {return averageTemp;}
    public void setAverageTemp(double averageTemp) {this.averageTemp = averageTemp;}
}
