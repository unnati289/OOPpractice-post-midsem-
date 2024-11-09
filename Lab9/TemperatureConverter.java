public class TemperatureConverter{
    public static double celsuisToFahr(double celsius){
        assert celsius>=-273.15 : "temperature in degree celsius can not be leass than -273.15";
        return (celsius *9)/5 +32;
    }
    publuc static double fahrtocels(double fahr){
        assert fahr>=-459.67 : "temperature in degree fahr can not be leass than -459.67";
        return ((fahr-32)*5)/9;
    }
}