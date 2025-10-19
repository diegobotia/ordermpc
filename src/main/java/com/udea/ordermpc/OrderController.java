package com.udea.ordermpc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    // Simulamos una "base de datos en memoria"
    private final Map<Integer, Order> orders = new HashMap<>();

    public OrderController() {
        // Inicializamos con algunos productos de ejemplo
        orders.put(1, new Order(1, "Laptop", 1200.0));
        orders.put(2, new Order(2, "Smartphone", 800.0));
        orders.put(3, new Order(3, "Tablet", 450.0));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        Order order = orders.get(id);
        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(new ArrayList<>(orders.values()));
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        int newId = orders.keySet().stream().mapToInt(v -> v).max().orElse(0) + 1;
        order.setId(newId);
        orders.put(newId, order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}
