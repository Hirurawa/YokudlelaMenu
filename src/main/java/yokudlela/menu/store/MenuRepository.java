package yokudlela.menu.store;

import org.springframework.stereotype.Service;
import yokudlela.menu.datamodel.Menu;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MenuRepository {
    private static final List<Menu> menus = new ArrayList<>();

    @PostConstruct
    public void  init(){
        menus.add(Menu.builder()
                    .name("A1")
                    .build()
                );
    }

    public boolean delete(String pName){
        Optional<Menu> tmp = getByName(pName);
        if(tmp.isEmpty()) return false;
        return MenuRepository.menus.remove(tmp.get());
    }

    public void add(Menu pMenu) throws Exception{
        if(getByName(pMenu.getName()).isEmpty()){
            MenuRepository.menus.add(pMenu);
        }
        else throw new Exception();
    }

    public void modify(Menu pMenu) throws IllegalAccessException, InvocationTargetException {
        Optional<Menu> tmp = getByName(pMenu.getName());
    }

    public Optional<Menu> getByName(String pName){
        Optional<Menu> res = menus.stream().filter(element -> element.getName().equals(pName)).findFirst();
        return res;
    }

    public List<Menu> getAvailable(boolean pAvailable){
        return menus.stream().filter(element -> element.getQuantity() > 1).collect(Collectors.toList());
    }

    public List<Menu> getAll(){
        return menus;
    }

}
