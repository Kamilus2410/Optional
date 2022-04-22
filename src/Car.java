import java.util.Optional;

public class Car {
    private final SteeringWheel steeringWheel;
    public Car() {
        this.steeringWheel = new SteeringWheel(0.6);
    }
    public Car(final SteeringWheel steeringWheel) {
        this.steeringWheel = steeringWheel;
    }
    public SteeringWheel getSteeringWheel() {
        System.out.println("Getting steering wheel");
        return steeringWheel;
    }
    public Optional<SteeringWheel> getSteeringWheelOpt() {
        System.out.println("Getting steering wheel optional");
        return Optional.ofNullable(steeringWheel);
    }
    @Override
    public String toString() {
        return "Car{" +
                "steeringWheel=" + steeringWheel +
                '}';
    }
}