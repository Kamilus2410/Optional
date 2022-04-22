import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();
        System.out.println(empty);
        Optional<String> ofFull = Optional.of("Something");
        System.out.println(ofFull);
        Optional<String> ofNullable = Optional.ofNullable(null);
        System.out.println(ofNullable);

        System.out.println(empty.isEmpty());
        System.out.println(empty.isPresent());

        if (ofFull.isPresent()) {
            String variable = ofFull.get();
            System.out.println(variable);
        }
        System.out.println();

        String test1 = empty.orElse(default1());  //zawsze wykona metode
        String test2 = empty.orElseGet(() -> default2()); //jak pusty wykona metode jako "Supplier"
        String test3 = ofFull.orElse(default1());
        String test4 = ofFull.orElseGet(() -> default2());
        System.out.println(test4);

        empty.ifPresentOrElse(cos -> System.out.println(cos), () -> System.out.println("default"));
        ofFull.ifPresentOrElse(cos -> System.out.println(cos), () -> System.out.println("default"));

//        someMethod();

    }

    private static String default1() {
        System.out.println("default1");
        return "default1";
    }
    private static String default2() {
        System.out.println("default2");
        return "default2";
    }

    private static Optional<String> someMethod() {
        return Optional.empty();
    }
}
