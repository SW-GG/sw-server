package SWGG.spring_implement.service;

import SWGG.spring_implement.model.Order;
import SWGG.spring_implement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    //새로운 주문데이터 설정
    @Transactional
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // 모든 주문 데이터 조회
    public List<Order> getAllOrders() {
        try {
            return orderRepository.findAll();  // 여기서 DB에 연결하여 데이터를 가져옵니다.
        } catch (Exception e) {
            // 예외를 로깅하거나 적절한 예외 처리 추가
            throw new RuntimeException("Failed to retrieve orders", e);
        }
    }


}

