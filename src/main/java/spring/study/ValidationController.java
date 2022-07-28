package spring.study;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


@Slf4j
@RestController
@AllArgsConstructor
public class ValidationController {

    private final ItemService itemService;

    @GetMapping("/validation")
    public Item validation(HttpServletRequest request) {
        log.info(request.getParameter("itemName"));

        Item item = new Item();
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
}
