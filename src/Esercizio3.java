import model.Product;
import java.util.List;
import java.util.stream.Collectors;

public class Esercizio3 {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product(1L, "Anti-age Cream", "Boys", 43.0),
                new Product(2L, "Iron-man Toy", "Girls", 45.0),
                new Product(3L, "Beard Conditioner", "Boys", 30.0),
                new Product(4L, "Lego", "Girls", 150.0)
        );

        List<Product> discountedBoys = products.stream()
                .filter(p -> "Boys".equalsIgnoreCase(p.getCategory()))
                .map(p -> {
                    p.setPrice(p.getPrice() * 0.9);
                    return p;
                })
                .collect(Collectors.toList());

        discountedBoys.forEach(System.out::println);
    }
}
