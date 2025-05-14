import model.Product;
import model.Order;
import model.Customer;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Esercizio2 {
    public static void main(String[] args) {
        Product p1 = new Product(1L, "Teddy Bear", "Baby", 20.0);
        Product p2 = new Product(2L, "Pikachu Plush", "Toys", 35.0);
        Product p3 = new Product(3L, "Baby Powder", "Baby", 10.0);
        Product p4 = new Product(4L, "Batman Toy", "Toys", 40.0);

        Customer customer = new Customer(1L, "Marge", 2);

        Order o1 = new Order(1L, "Delivered", LocalDate.of(2021, 1, 10), LocalDate.of(2021, 1, 15),
                List.of(p1, p3), customer);

        Order o2 = new Order(2L, "Pending", LocalDate.of(2021, 2, 5), LocalDate.of(2021, 2, 10),
                List.of(p2, p4), customer);

        List<Order> orders = List.of(o1, o2);

        List<Order> babyOrders = orders.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> "Baby".equalsIgnoreCase(product.getCategory())))
                .collect(Collectors.toList());

        babyOrders.forEach(System.out::println);
    }
}
