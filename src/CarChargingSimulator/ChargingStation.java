package CarChargingSimulator;

import CarChargingSimulator.Car.Car;
import Weather.WeatherState;

import java.time.LocalDateTime;
import java.util.*;

public class ChargingStation {
    private String name;
    private List<Location> locations;
    private Queue<Car> cars;

    private WeatherState weatherState;

    private Thread workingThread;

    public ChargingStation(String name, WeatherState weatherState) {
        this.name = name;
        this.locations = new ArrayList<Location>();
        this.cars = new PriorityQueue();
        this.weatherState = weatherState;
    }

    public void addCar(Car car) throws InterruptedException {
        car.setArriveTime(LocalDateTime.now());
        System.out.println();
        if (isAllLocationOccupied()) throw new RuntimeException(); // full exception
        if (cars.size() * 8 < 15) {//each car takes 2 minutes to be charged and the fixed amount time is 15 minutes
            this.cars.add(car);
            System.out.println("- - - - - - - - - - - - - - - - --  ");
            System.out.println("car " + car + " arrived  in Station's queue " + this.name + " in : " + car.getArriveTime());
            System.out.println("the waiting time is  : " + cars.size() * 2 + " minutes");
            System.out.println("- - - - - - - - - - - - - - - - --  ");
        } else {
            throw new RuntimeException();

        }//car wants to  go
//        workingThread = new Thread(() -> {
//                try {
//                    this.startWorking();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//        if (!workingThread.isAlive() && !isAllLocationOccupied()){
//            workingThread.start();
//        }
    }

    public void addLocation(Location location) {
        this.locations.add(location);
    }

    public void getWeatherState() throws InterruptedException {
        weatherState.getWeatherStatus();
    }

    public void setWeatherState(WeatherState weatherState) {
        this.weatherState = weatherState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Queue getCars() {
        return cars;
    }

    public void setCars(Queue cars) {
        this.cars = cars;
    }

    public void refillSource(Location location) throws InterruptedException {
        String energySourceType = location.getSlot().getEnergySource().getClass().getSimpleName();
        String weatherStatus = weatherState.getClass().getSimpleName();
        //should be complete
        if (energySourceType.equalsIgnoreCase("Water")) {
            if (weatherStatus.equals("RainyWeather")) {
                System.out.println("energy generating with rain ... ");
                showProcessBar();
                location.getSlot().getEnergySource().energyGenerating(2000);
            } else {
                System.out.println("we are in another weather condition ... can't fill this resource");
                throw new RuntimeException();
            }
        }

    }

    public void showProcessBar() throws InterruptedException {
        int totalProgress = 50;
        int currentProgress = 0;

        System.out.print("Progress: [");

        while (currentProgress < totalProgress) {
            currentProgress++;

            int percentage = (currentProgress * 100) / totalProgress;
            int completedBlocks = (currentProgress * 20) / totalProgress;
            int remainingBlocks = 20 - completedBlocks;

            System.out.print("=".repeat(completedBlocks));
            System.out.print(" ".repeat(remainingBlocks));
            System.out.print("] " + percentage + "%");

            System.out.print("\r");

            Thread.sleep(100);
        }

        System.out.println("\nProgress complete!");
        Thread.sleep(2000);
    }

    private List<Thread> threads = new ArrayList<>();

    public synchronized void startWorking() throws InterruptedException {
        Random random = new Random();

        while (!cars.isEmpty()) {
            Car car = this.cars.poll();
            Thread thread = new Thread(() -> {
                int locationIndex = random.nextInt(0, locations.size());
                Location location = locations.get(locationIndex);
                if (!location.isOccupied()) {
                    System.out.println();
                    location.setCar(car);
                    System.out.println(" + + + + + + + + + + + + + + ++ ");
                    System.out.println("car " + car + " went  to location :  " + location.getName());
                    System.out.println(" + + + + + + + + + + + + + + ++ ");
                    try {
                        location.charge();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            threads.add(thread);
        }
        threads.forEach(x -> x.start());
        threads.forEach(x-> {
            try {
                x.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


    }


    public boolean isAllLocationOccupied() {
        for (Location e : locations
        ) {
            if (!e.isOccupied()) return false;

        }
        return true;
    }
}
