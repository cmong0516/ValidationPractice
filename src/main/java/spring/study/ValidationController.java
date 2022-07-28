package spring.study;


import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validation;

@Slf4j
@RestController
public class ValidationController {

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
            return String.valueOf(bindingResult.getFieldError().getDefaultMessage());
        }

        log.info(item.toString());
        return "ok";
    }
}
