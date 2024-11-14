package SWGG.spring_implement.controller;

import SWGG.spring_implement.model.Order;
import SWGG.spring_implement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    // 주문 데이터 조회
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrders() {
        try {
            List<Order> orders = orderService.getAllOrders();
            return ResponseEntity.ok(orders);  // 직접 List를 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // 주문 데이터 생성
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Map<String, Object> payload) {
        Order order = new Order();

        // 주문 정보 설정
        order.setOrderNumber((String) payload.getOrDefault("orderNumber", ""));
        order.setCustomerPhoneNumber((String) payload.getOrDefault("customerPhoneNumber", ""));
        order.setBasicWaffleCount((Integer) payload.getOrDefault("basicWaffleCount", 0));
        order.setChocoWaffleCount((Integer) payload.getOrDefault("chocoWaffleCount", 0));
        order.setMemo((String) payload.getOrDefault("memo", ""));
        order.setTotalPrice((Integer) payload.getOrDefault("totalPrice", 0));

        try {
            // 주문 저장
            Order savedOrder = orderService.createOrder(order);

            // 저장된 주문 반환 (201 Created 응답과 함께 반환)
            return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
        } catch (Exception e) {
            // 에러 처리: 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
