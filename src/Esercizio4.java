import model.Product;
import model.Order;
import model.Customer;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Esercizio4 {
    public static void main(String[] args) {
        Product p1 = new Product(1L, "T'Challa Toy", "Toys", 50.0);
        Product p2 = new Product(2L, "It", "Books", 23.0);
        Product p3 = new Product(3L, "Beard Conditioner", "Boys", 16.0);
        Product p4 = new Product(3L, "Alice's Adventures in Wonderland", "Books", 20.0);

        Customer c1 = new Customer(1L, "Jake", 2);
        Customer c2 = new Customer(2L, "Raymond", 1);

        Order o1 = new Order(1L, "Shipped",
                LocalDate.of(2021, 2, 15), LocalDate.of(2021, 2, 20),
                List.of(p1, p2, p4), c1);

        Order o2 = new Order(2L, "Delivered",
                LocalDate.of(2021, 3, 10), LocalDate.of(2021, 3, 15),
                List.of(p3), c1);

        Order o3 = new Order(3L, "Processing",
                LocalDate.of(2021, 1, 25), LocalDate.of(2021, 1, 30),
                List.of(p1, p4), c1);

        Order o4 = new Order(4L, "Shipped",
                LocalDate.of(2021, 2, 20), LocalDate.of(2021, 2, 25),
                List.of(p2), c2);

        List<Order> orders = List.of(o1, o2, o3, o4);

        List<Product> result = orders.stream()
                .filter(o -> o.getCustomer().getTier() == 2)
                .filter(o -> !o.getOrderDate().isBefore(LocalDate.of(2021, 2, 1)) &&
                        !o.getOrderDate().isAfter(LocalDate.of(2021, 4, 1)))
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }
}
