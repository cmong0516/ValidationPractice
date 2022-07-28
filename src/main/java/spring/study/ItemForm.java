package spring.study;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Data
public class ItemForm {

    @NotNull
    private String itemName;
    @NotNull
    @Range(min = 10000,max = 10000000)
    private Integer price;
    @NotNull
    @Range(min = 1,max = 100)
    private Integer quantity;
}
