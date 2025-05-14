import model.Product;
import java.util.List;
import java.util.stream.Collectors;


public class Esercizio1 {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product(1L, "Ulysses", "Books", 150.0),
                new Product(2L, "Teddy Bear", "Toys", 40.0),
                new Product(3L, "Notebook", "Books", 10.0),
                new Product(4L, "The Lord of the Rings", "Books", 102.0)
        );

        List<Product> expensiveBooks = products.stream()
                .filter(p -> "Books".equalsIgnoreCase(p.getCategory()) && p.getPrice() > 100)
                .collect(Collectors.toList());

        expensiveBooks.forEach(System.out::println);
    }
}
