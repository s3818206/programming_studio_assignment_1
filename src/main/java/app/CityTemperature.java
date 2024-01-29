package app;

public class CityTemperature extends Temperature {
    private String latitude;
    private String longtitude;

    public String getLatitude() { return this.latitude; }
    public void setLatitude(String latitude) { this.latitude = latitude;}

    public String getLongitude() { return this.longtitude; }
    public void setLongitude(String longtitude) { this.longtitude = longtitude;}
}
