package spring.study;

import lombok.Data;
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

    public Item() {
    }
}
