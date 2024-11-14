package SWGG.spring_implement.repository;

import SWGG.spring_implement.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // JpaRepository를 상속하면 기본적인 CRUD 메서드를 사용할 수 있습니다.
}

