package app;

public class GlobalTemp extends Temperature {
    private double landOceanAverageTemp;
    private double landOceanMinTemp;
    private double landOceanMaxTemp;
    
    public double getLandOceanAverageTemp() { return this.landOceanAverageTemp; }
    public void setLandOceanAverageTemp(double landOceanAverageTemp) { this.landOceanAverageTemp = landOceanAverageTemp; }

    public double getLandOceanMinTemp() { return this.landOceanMinTemp; }
    public void setLandOceanMinTemp(double landOceanMinTemp) { this.landOceanMinTemp = landOceanMinTemp;}

    public double getLandOceanMaxTemp() { return this.landOceanMaxTemp; }
    public void setLandOceanMaxTemp(double landOceanMaxTemp ) {this.landOceanMaxTemp = landOceanMaxTemp;}
}
