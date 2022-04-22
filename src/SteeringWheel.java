import java.util.Optional;

public class SteeringWheel {
    private final double diameter;
    public SteeringWheel(final double diameter) {
        this.diameter = diameter;
    }
    public double getDiameter() {
        System.out.println("Getting diameter");
        return diameter;
    }
    public Optional<Double> getDiameterOpt() {
        System.out.println("Getting diameter optional");
        return Optional.of(diameter);
    }
    @Override
    public String toString() {
        return "SteeringWheel{" +
                "diameter=" + diameter +
                '}';
    }
}