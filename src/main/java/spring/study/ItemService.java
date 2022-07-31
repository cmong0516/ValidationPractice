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
        List<Item> itemNameList = em.createQuery("select i from Item i where i.itemName=:itemName", Item.class)
                .setParameter("itemName", itemName)
                .getResultList();

        return itemNameList.stream().findAny();
    }

    public Optional<Item> updateItem(Long id) {
        Optional<Item> findById = itemRepository.findById(id);
        return findById(id);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public void delete(Long id) {
        Optional<Item> byId = itemRepository.findById(id);
        Item item = byId.get();
        itemRepository.delete(item);
    }
}
