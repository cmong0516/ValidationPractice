package spring.study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ItemService {

    ItemRepository itemRepository;

    public void save(Item item) {
        log.info(item.toString());
        itemRepository.save(item);
    }
}
