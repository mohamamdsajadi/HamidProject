package Weather;

public class WindyWeather implements WeatherState{
    @Override
    public void  getWeatherStatus() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("the Weather  Condition state is WINDY  now ");
        System.out.println("the winds are blowing ... ");
        System.out.println("~~~~ " +  "~~~~ " + "~~~~ ");
        System.out.println("~~~~ " +  "~~~~ " + "~~~~ ");
        System.out.println("~~~~ " +  "~~~~ " + "~~~~ ");
        System.out.println("~~~~ " +  "~~~~ " + "~~~~ ");


    }
        }





