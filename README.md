# E-commerce System

A simple Java-based e-commerce system built for the **Awry Rise Journey Challenge**.  
This system handles product management, cart operations, checkout flow, shipping calculations, and expiry validations.

---

## Features

- Define products with name, price, quantity.
- Support both **expirable** (e.g., Cheese, Biscuits) and **non-expirable** (e.g., TV, Mobile) products.
- Support **shippable** and **non-shippable** products.
- Products requiring shipping must provide weight.
- Customers can add products to cart with quantity constraints.
- On checkout:
  - Handles validations (stock, expiry, balance, empty cart)
  - Calculates subtotal, shipping fees, and total
  - Prints checkout and shipping details to console
- Sends shippable products to a `ShippingService`.

---

## Class Diagram

```mermaid
---
config:
  look: classic
  layout: dagre
  theme: neutral
---
classDiagram
    ExpirationPolicy <|-- Expirable
    ExpirationPolicy <|-- NoExpiration
    ShippingPolicy <|-- Shippable
    ShippingPolicy <|-- NoShipping
    Product *-- ExpirationPolicy
    Product *-- ShippingPolicy
    Customer "1" --> "1" Cart : has
    Cart "1" --> "1..*" CartItem : contains
    Order "1" --> "1..*" OrderItem : contains 
    class Product {
      - name: String
      - price: double
      - quantity: int
      - expirationPolicy: ExpirationPolicy
      - shippingPolicy: ShippingPolicy
      + decreaseQuantity(amount: int)
      + isExpired(): boolean
      + isShippable(): boolean
    }
    class Customer {
      - name: String
      - cart: Cart
      - balance: BigDecimal
      + pay(amount: BigDecimal)
    }
    class Cart {
      - items: List<CartItem>
      + add(product: Product, quantity: int): void
      + empty(): void
      + isEmpty()
    }
    class CartItem {
      - product: Product
      - quantity: int
    }
    class Order {
      - items: List<OrderItem>
      - packageWeight: double
      - subtotal: BigDecimal
      - shippingFees: BigDecimal
      - total: BigDecimal
      + createFromCart(cart: Cart): Order
    }
    class OrderItem {
      - product: Product
      - quantity: int
    }
    class ExpirationPolicy {
      <<interface>>
      + isExpirable(): boolean
      + isExpired(): boolean
      + getExpirationDate(): LocalDate
    }
    class Expirable {
      - expirationDate: LocalDate
      + isExpirable(): boolean
      + isExpired(): boolean
      + getExpirationDate(): LocalDate
    }
    class NoExpiration {
      + isExpirable(): boolean
      + isExpired(): boolean
      + getExpirationDate(): LocalDate
    }
    class ShippingPolicy {
      <<interface>>
      + isShippable(): boolean
    }
    class Shippable {
      - weight: double
      + isShippable(): boolean
      + getWeight(): double 
    }
    class NoShipping {
      + isShippable(): boolean
    }

```
