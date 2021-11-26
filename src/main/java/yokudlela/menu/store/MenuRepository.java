package yokudlela.menu.store;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yokudlela.menu.datamodel.Menu;
import java.util.List;

@Repository
public interface MenuRepository extends CrudRepository<Menu, String> {
    public Menu findByName(String name);
    public List<Menu> findAll();
    public Menu save(Menu menu);
    public void delete(Menu menu);
}
