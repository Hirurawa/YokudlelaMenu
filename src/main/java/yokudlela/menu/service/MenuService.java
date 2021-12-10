package yokudlela.menu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yokudlela.menu.datamodel.Menu;
import yokudlela.menu.store.FoodRepository;
import yokudlela.menu.store.MenuRepository;
import yokudlela.menu.utils.logging.AspectLogger;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    FoodRepository foodRep;
    @Autowired
    MenuRepository menuRep;


    public List<Menu> getAll(){
        List<Menu> allAvailable = menuRep.findAll();
        return allAvailable;
    }
}
