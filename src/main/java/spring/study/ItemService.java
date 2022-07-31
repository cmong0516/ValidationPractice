package spring.study;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemService {

    private final EntityManager em;

    // final 을 넣어주지 않으면 에러발생.
    private final ItemRepository itemRepository;

    public void save(Item item) {
        log.info(item.toString());
        itemRepository.save(item);
    }

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    public Optional<Item> findByItemName(String itemName) {

        log.info("itemServiceItemName = {}",itemName);
        List<Item> itemNameList = em.createQuery("select m from Item m where m.itemName=:itemName", Item.class)
                .setParameter("itemName", itemName)
                .getResultList();

        return itemNameList.stream().findAny();
    }
}
