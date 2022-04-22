import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Brasil");
        list.add("Denmark");
        list.add("China");
        list.add("Poland");

        Optional<String> poland = find(list, "Poland");
        Optional<String> cuda = find(list, "Cuda");
        System.out.println(poland);
        System.out.println(cuda);

    }
    private static Optional<String> find (List<String> countries, String element) {
        for (String country : countries) {
            if (element.equals(country)) {
                return Optional.of(country);
            }
        }
        return Optional.empty();
    }
}
