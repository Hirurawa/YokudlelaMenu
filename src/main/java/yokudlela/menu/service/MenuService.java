package yokudlela.menu.service;

import org.springframework.stereotype.Service;
import yokudlela.menu.datamodel.Menu;
import yokudlela.menu.store.MenuRepository;

import java.util.List;

@Service
public class MenuService {
    MenuRepository tRep = new MenuRepository();

    public List<Menu> getAll(){
        List<Menu> allAvailable = tRep.getAll();
        return allAvailable;
    }
}
