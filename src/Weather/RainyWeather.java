package Weather;

public class RainyWeather implements WeatherState {

    @Override
    public void getWeatherStatus() throws InterruptedException {
        int screenWidth = 80;
        int screenHeight = 20;
        int numDrops = 100;

        System.out.println("WEATHER IS RAINY ...");
        System.out.println("== === ==== ====== ==== === ==== ====== ========= ==== ==== === === ==  = = = = =");
        for (int m = 0; m < 15; m++) {
            char[][] screen = new char[screenHeight][screenWidth];
            for (int i = 0; i < numDrops; i++) {
                int x = (int) (Math.random() * screenWidth);
                int y = (int) (Math.random() * screenHeight);
                screen[y][x] = '|';
            }

            // Print the screen
            for (int y = 0; y < screenHeight; y++) {
                for (int x = 0; x < screenWidth; x++) {
                    if (screen[y][x] == '|') {
                        System.out.print('|');
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
}

