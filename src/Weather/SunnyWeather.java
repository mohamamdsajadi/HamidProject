package Weather;

public class SunnyWeather implements WeatherState {


    @Override
    public void getWeatherStatus() throws InterruptedException {
        int screenWidth = 90;
        int screenHeight = 20;

        for (int i = 0; i < 10; i++) {

        } {

            // Print the sun
            for (int y = 0; y < screenHeight; y++) {
                for (int x = 0; x < screenWidth; x++) {
                    if (isSunPosition(x, y, screenWidth, screenHeight)) {
                        System.out.print('*');
                    } else {
                        System.out.print(' ');
                    }
                }
                System.out.println();
            }

            // Pause for a short duration
            Thread.sleep(100);
        }
    }

    private static boolean isSunPosition(int x, int y, int screenWidth, int screenHeight) {
        int centerX = screenWidth / 2;
        int centerY = screenHeight / 2;
        int radius = Math.min(screenWidth, screenHeight) / 4;

        double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
        return distance <= radius;
    }

}




