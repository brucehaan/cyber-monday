package brucehan.product.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

import static jakarta.persistence.FetchType.*;

/**
 * 주 테이블 (외래 키 보유 - 연관관계의 주인)
 */
@Entity
@Table(name = "products")
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "brand_name", nullable = false, length = 50)
    private String brandName;

    @Column(name = "seller", nullable = false, length = 50)
    private String seller;

    @Column(name = "price")
    private int price;

    /**
     * 주 테이블에 외래 키를 둔다
     * 장점
     * - 객체지향적 : Product.getStock()을 호출할 때 로직이 자연스러움
     * - 성능최적화 : JPA 매핑이 가장 매끄럽고, 프록시 및 지연 로딩이 완벽하게 동작함
     * 단점
     * - 값이 없으면 외래 키에 null을 허용해야 함
     */
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "STOCK_ID")
    private Stock stock;
}

