package yokudlela.menu.store;

import yokudlela.menu.datamodel.Food;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {
    public Food findByName(String pName);
    public List<Food> findAll();
    public Food save(Food pTable);
    public void delete(Food pFood);
}