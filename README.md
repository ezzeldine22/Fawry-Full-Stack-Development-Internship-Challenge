# E-Commerce System in Java

## Description
This project simulates a basic e-commerce shopping cart and checkout system in Java. It supports multiple product types, including expirable and shippable items, and handles customer balance, cart operations, and checkout processes.

## Features
- Add products to cart with quantity validation
- Support for expirable products
- Support for products that require shipping
- Checkout process with:
  - Expiry check
  - Balance verification
  - Shipping weight calculation
  - Final receipt with subtotal, shipping, and total amount

## Technologies Used
- Java 17+
- Java Collections (ArrayList, HashMap)
- Java Time API (LocalDate)

## Project Structure
```
FawryTask/
├── Cart.java
├── CheckoutService.java
├── Customer.java
├── ExpirableProduct.java
├── ExpirableShippable.java
├── Main.java
├── Product.java
├── Repository.java
├── ShippableProduct.java
└── Shipping.java
```

## Test Cases

### CASE 1: Successful Purchase

#### **Input (Main.java):**
```java
Customer customer = new Customer("Ali", 5000);
Cart cart = new Cart();

cart.add("cheese", 2);
cart.add("tv", 3);
cart.add("scratchCard", 1);

CheckoutService.checkout(customer, cart);
```

#### **Expected Output:**
```
** Shipment notice **
3x tv        1500.0
2x cheese    1000.0
Total package weight 2.5kg

** Checkout receipt **
2x cheese    200.0
3x tv        600.0
1x scratchCard 30.0
---------------------
Subtotal     830.0
Shipping     120.0
Amount       950.0
```

---

### CASE 2: Product Not Found

#### **Input (Main.java):**
```java
Customer customer = new Customer("Ali", 5000);
Cart cart = new Cart();

cart.add("laptop", 1);  // Not in the repository

CheckoutService.checkout(customer, cart);
```

#### **Expected Output:**
```
Product (laptop) not found 
the Cart is empty
```

---

### CASE 3: Insufficient Balance

#### **Input (Main.java):**
```java
Customer customer = new Customer("Ali", 100);  // Low balance
Cart cart = new Cart();

cart.add("tv", 2);  // total price + shipping = 400 + 40 = 440

CheckoutService.checkout(customer, cart);
```

#### **Expected Output:**
```
** Shipment notice **
2x tv        1000.0
Total package weight 1.0kg

** Checkout receipt **
2x tv        400.0
---------------------
Subtotal     400.0
Shipping     40.0
Amount       440.0

Insufficient balance for the payment
```

---

### CASE 4: Expired Product

> **Assumption:** We changed the cheese expire date to a past date (2023).

#### **Input (Main.java):**
```java
Customer customer = new Customer("Ali", 5000);
Cart cart = new Cart();

cart.add("cheese", 1);  // cheese is expired

CheckoutService.checkout(customer, cart);
```

#### **Expected Output:**
```
cheese is Expired !!!!!
** Checkout receipt **
---------------------
Subtotal     0.0
Shipping     0.0
Amount       0.0
```

## Assumptions
- The expiration logic uses `LocalDate.now()` to compare expiration.
- Shipping fee is fixed: 20 per item that requires shipping.
- All items have a unique name.
- Quantities and balance are validated properly.

## How to Run
1. Clone the repo
2. Open in any Java IDE or compile with `javac`
3. Run `Main.java`

---

Feel free to fork and customize this template for your own use cases!
