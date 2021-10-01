package store;

import datamodel.Menu;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MenuRepository {
    private static final List<Menu> menus = new ArrayList<>();

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
        if(!tmp.isEmpty()){
            BeanUtils.copyProperties(tmp.get(), pMenu);
        }
    }

    public Optional<Menu> getByName(String pName){
        Optional<Menu> res = menus.stream().filter(element -> element.getName().equals(pName)).findFirst();
        return res;
    }

    public List<Menu> getAvailable(boolean pAvailable){
        return menus.stream().filter(element -> element.getQuantity() > 1).collect(Collectors.toList());
    }
}