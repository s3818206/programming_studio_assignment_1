package app;

public class Temperature {
    private int year;
    private double averageTemp;
    private double minTemp;
    private double maxTemp;

    public int getYear() { return this.year; }
    public void setYear(int year) { this.year = year; }

    public double getAverageTemp() { return this.averageTemp; }
    public void setAverageTemp(double averageTemp) { this.averageTemp = averageTemp; }

    public double getMinTemp() { return this.minTemp; }
    public void setMinTemp(double minTemp) { this.minTemp = minTemp; } 

    public double getMaxTemp() { return this.maxTemp; }
    public void setMaxTemp(double maxTemp) { this.maxTemp = maxTemp;}
}
