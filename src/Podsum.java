import java.util.Locale;
import java.util.Optional;

public class Podsum {
    public static void main(String[] args) {

        Optional<Human> adam = retrieveHuman("Adam");
        var gosia = retrieveHuman("Gosia");
        adam.ifPresentOrElse(h -> System.out.println(h.getName()), () -> System.out.println("no human"));
        gosia.ifPresentOrElse(h -> System.out.println(h.getName()), () -> System.out.println("no human"));
        System.out.println();

        if (adam.isPresent()) {
            System.out.println(adam.get());
        } else System.out.println("else no human");
        System.out.println();

        System.out.println(adam.orElse(new Human("Leszek orzeszek")));
        System.out.println(adam.orElseGet(() -> new Human("Leszek orzeszek")));
        System.out.println(gosia.orElse(new Human("Gosia samosia"))); // nie widze roznicy
        System.out.println(gosia.orElseGet(() ->(new Human("Gosia samosia"))));
        System.out.println();

        Optional<String> name = adam.map(h -> h.getName());
        System.out.println(name);
        System.out.println(name.map(h -> h.toUpperCase(Locale.ROOT)));
        Optional<String> gosianame = gosia.map(h -> h.getName());
        System.out.println(gosianame.map(h -> h.toUpperCase(Locale.ROOT))); //operacja na tym co jest w sordku jezeli istnieje, jezeli nie to Optional.empty
        System.out.println();

        Optional<String> adamOpt = adam.map(h -> h.getName()).filter(n -> n.length() > 4);
        System.out.println(adamOpt);
        adamOpt.ifPresent(n -> System.out.println(n));
        gosia.map(h -> h.getName()).filter(n -> n.length() >4).ifPresent(n -> System.out.println(n));
        System.out.println();

        Human orHuman = adam
                .or(() -> Optional.empty())
                .or(() -> Optional.ofNullable(new Human("Edyta")))
                .get();
        System.out.println(orHuman);

        System.out.println(adam.orElseThrow(() -> new RuntimeException("Brak ludzia")));


    }

    public static Optional<Human> retrieveHuman(final String name) {
//        return name.endsWith("a") ? Optional.of(new Human(name)) : Optional.empty();
//        return name.endsWith("a") ? Optional.of(null) : Optional.empty(); //wywali blad
        return name.endsWith("a") ? Optional.ofNullable(new Human(name)) : Optional.empty();
//        return name.endsWith("a") ? Optional.ofNullable(null) : Optional.empty();

    }

}
