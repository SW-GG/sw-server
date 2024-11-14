package SWGG.spring_implement.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor 포함
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴을 사용해 객체 생성
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;
    private String customerPhoneNumber;
    private int basicWaffleCount;
    private int chocoWaffleCount;
    private String memo;
    private int totalPrice;
}

