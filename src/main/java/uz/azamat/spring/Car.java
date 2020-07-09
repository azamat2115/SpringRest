package uz.azamat.spring;

public class Car {
    private int id;
    private String carName;
    private String carColor;

    public Car(int id, String carName, String carColor) {
        this.id = id;
        this.carName = carName;
        this.carColor = carColor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
}
