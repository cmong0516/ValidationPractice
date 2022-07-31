package spring.study;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String itemName;

    @NotNull
    @Range(min = 10000,max = 10000000)
    private Integer price;

    @NotNull
    @Range(min = 1,max = 100)
    private Integer quantity;


    public Item(String test, int price, int quantity) {

    }


    // findByItemName 으로 DB 에서 itemName 으로 객체를 찾으려 했더니
    // 기본 생성자가 없으면 호출되지 않았다.
    public Item() {
    }
}
