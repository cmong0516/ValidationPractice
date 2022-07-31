package spring.study;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


@Slf4j
@RestController
@AllArgsConstructor
public class ValidationController {

    private final ItemService itemService;

    @GetMapping("/validation")
    public Item validation(HttpServletRequest request) {
        log.info(request.getParameter("itemName"));

        Item item = new Item("Test", 10000, 15);
        item.setItemName(request.getParameter("itemName"));
        item.setPrice(Integer.valueOf(request.getParameter("price")));
        item.setQuantity(Integer.valueOf(request.getParameter("quantity")));

        return item;
    }

    @GetMapping("/validation2")
    public String validation2(@Validated @ModelAttribute Item item, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);
            return "errors";
        }

//        Item item = new Item();
//        item.setItemName(itemForm.getItemName());
//        item.setPrice(itemForm.getPrice());
//        item.setQuantity(item.getQuantity());

        itemService.save(item);

//        log.info(itemForm.toString());
        return "saveOk";
    }

    @GetMapping("/validation3")
    public Optional<Item> validation3(Long id) {
        return itemService.findById(id);
    }

    @GetMapping("/validation4")
    public Optional<Item> findByItemName(@ModelAttribute Item item) {
        log.info(item.getItemName());
        Optional<Item> byItemName = itemService.findByItemName(item.getItemName());

        return byItemName;
    }

    @GetMapping("/updateitem")
    public Item updateItem(Long id) {
        Optional<Item> byId = itemService.findById(id);
        Item item = byId.get();
        item.setItemName("updateItem");
        item.setPrice(20000);
        item.setQuantity(50);

        itemService.save(item);

        return item;

    }
}
