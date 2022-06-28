package hello.itemservice.repository.jpa;

import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.ItemSearchCond;
import hello.itemservice.repository.ItemUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class JpaItemRepositoryV2 implements ItemRepository {

    //JpaItemRepositoryV2 는 ItemRepository 를 구현한다. 그리고 SpringDataJpaItemRepository 를 생성주 주입을 통해 사용한다
    //////////////////////////지금 여기서 SpringDataJpaItemRepository 사용해서 repository 이용함
    private final SpringDataJpaItemRepository repository;

    @Override
    public Item save(Item item) {
        return repository.save(item);
    }

    @Override
    public void update(Long itemId, ItemUpdateDto updateParam) {
        Item findItem = repository.findById(itemId).orElseThrow();
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    @Override
    public Optional<Item> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Item> findAll(ItemSearchCond cond) {
        String itemName = cond.getItemName();
        Integer maxPrice = cond.getMaxPrice();
        if (StringUtils.hasText(itemName) && maxPrice != null) {
            //return repository.findByItemNameLikeAndPriceLessThanEqual("%" + itemName + "%", maxPrice);

            return repository.findItems("%" + itemName + "%", maxPrice);

        } else if (StringUtils.hasText(itemName)) {

            return repository.findByItemNameLike("%" + itemName + "%");

        } else if (maxPrice != null) {

            return repository.findByPriceLessThanEqual(maxPrice);

        } else {
            return repository.findAll();
        }
    }
}