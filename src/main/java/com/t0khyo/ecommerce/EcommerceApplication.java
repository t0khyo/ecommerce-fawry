package com.t0khyo.ecommerce;

import com.t0khyo.ecommerce.model.Cart;
import com.t0khyo.ecommerce.model.Customer;
import com.t0khyo.ecommerce.model.Order;
import com.t0khyo.ecommerce.model.Product;
import com.t0khyo.ecommerce.policy.expiration.Expirable;
import com.t0khyo.ecommerce.policy.expiration.NoExpiration;
import com.t0khyo.ecommerce.policy.shipping.NoShipping;
import com.t0khyo.ecommerce.policy.shipping.Shippable;
import com.t0khyo.ecommerce.service.OrderService;
import com.t0khyo.ecommerce.service.ShippingService;
import com.t0khyo.ecommerce.service.impl.OrderServiceImpl;
import com.t0khyo.ecommerce.service.impl.ShippingServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EcommerceApplication {

    public static void main(String[] args) {
        List<Product> products = createProducts();
        Customer customer = createCustomer();
        Cart cart = new Cart();

        fillCart(cart, products);

        checkoutDemo(customer, cart);
    }

    private static List<Product> createProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Cheese", 100, 5,
                new Expirable(LocalDate.of(2025, 9, 1)),
                new Shippable(200)));

        products.add(new Product("Biscuits", 150, 3,
                new Expirable(LocalDate.of(2025, 8, 1)),
                new Shippable(700)));

        products.add(new Product("Scratch Card", 50, 10,
                new NoExpiration(),
                new NoShipping()));

        products.add(new Product("TV", 300, 2,
                new NoExpiration(),
                new Shippable(700)));

        return products;
    }

    private static Customer createCustomer() {
        return new Customer("Abdelrahman", BigDecimal.valueOf(1000));
    }

    private static void fillCart(Cart cart, List<Product> products) {
        Product cheese = getProductByName(products, "Cheese");
        Product biscuits = getProductByName(products, "Biscuits");
        Product scratchCard = getProductByName(products, "Scratch Card");

        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);
    }

    private static Product getProductByName(List<Product> products, String name) {
        return products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + name));
    }

    private static void checkoutDemo(Customer customer, Cart cart) {
        ShippingService shippingService = new ShippingServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        try {
            Order order = orderService.checkout(customer, cart);
            System.out.println("\nRemaining Balance: " + customer.getBalance());
        } catch (RuntimeException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
