package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.MenuRepository;

@RestController()
@RequestMapping(path = "/menu")
public class MenuController {

    @Autowired
    private MenuRepository service;

}
