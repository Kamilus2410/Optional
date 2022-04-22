import java.util.Optional;

public class OptionalHard {
    public static void main(String[] args) {
// Tworzymy Optional z naszego nowego samochodu
        Optional<Car> car = Optional.of(new Car());
// Mapujemy ten Optional, żeby teraz w środku była kierownica zamiast Samochodu.
// W tym celu do metody map przekazujemy lambdę,
// która jako parametr wejściowy przyjmuje samochód,
// Rezultatem lambdy jest kierownica, która została zwrócona z gettera z samochodu
        Optional<SteeringWheel> optional1 = car.map(c -> c.getSteeringWheel());
// Kierownica ma getter zwracający jej średnicę,
// Mogę zatem przemapować Optional, żeby teraz w środku była średnica tej kierownicy
        Optional<Double> optional2 = optional1.map(sw -> sw.getDiameter());
// Na końcu chcę odpakować Optional, mogę to zrobić albo wykonując metodę get(),
// Albo określając, daj mi to co masz w Optionalu, albo wartość domyślną 0.0
        Double diameterOrDefault = optional2.orElse(0.0);
// Tutaj mogę to wydrukować
        System.out.println("Diameter: " + diameterOrDefault);

        main2();
    }

    public static void main2() {
        Optional<Car> car = Optional.of(new Car());
        Double diameterOrDefault = car
                .map(c -> c.getSteeringWheel())
                .map(sw -> sw.getDiameter())
                .orElse(0.0);
        System.out.println("Diameter: " + diameterOrDefault);
    }
}

