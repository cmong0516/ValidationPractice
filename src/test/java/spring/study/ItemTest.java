package spring.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {

    private final ItemService itemService;

    public ItemTest(ItemService itemService) {
        this.itemService = itemService;
    }

    @Test
    void save() {
        Item test = new Item("Test", 10000, 15);
        itemService.save(test);


    }
}
