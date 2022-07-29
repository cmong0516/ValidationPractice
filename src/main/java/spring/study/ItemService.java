package spring.study;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemService {

    // final 을 넣어주지 않으면 에러발생.
    private final ItemRepository itemRepository;

    public void save(Item item) {
        log.info(item.toString());
        itemRepository.save(item);
    }
}
