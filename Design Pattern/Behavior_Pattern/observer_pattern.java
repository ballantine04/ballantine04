// import java.util.Observer;
import java.util.ArrayList;
// import java.util.Observable;

interface Subject{
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
interface Observer{
    public void update(float temp, float humidity, float pressure);
}
interface DisplayElement {
    public void display();
}

class WeatherData implements Subject {
    private ArrayList observers;
    private float temperature; 
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList();
    }
    public void registerObserver(Observer o){
        observers.add(o);
    }
    public void removeObserver(Observer o){
        int i = observers.indexOf(o);
        if(i>=0) observers.remove(i);
    }
    public void notifyObservers(){
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }
    public void measurementsChanged(){
        notifyObservers();
    }
    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}

class CurrentConditionsDisplay implements Observer, DisplayElement{
    private float temperature; 
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    public void update(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
    public void display() {
        System.out.println("Current conditions: "+temperature+"F degrees and" + humidity+"% humidity");
    }

}

public class test {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);

    }
}


[output]
Current conditions: 80.0F degrees and65.0% humidity
Current conditions: 82.0F degrees and70.0% humidity
Current conditions: 78.0F degrees and90.0% humidity
