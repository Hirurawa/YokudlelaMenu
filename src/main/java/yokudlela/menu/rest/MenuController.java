package yokudlela.menu.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yokudlela.menu.datamodel.Food;
import yokudlela.menu.datamodel.Menu;
import yokudlela.menu.store.FoodRepository;
import yokudlela.menu.store.MenuRepository;
import yokudlela.menu.utils.logging.AspectLogger;

import java.util.List;

@RestController()
@RequestMapping(path = "/menu")
public class MenuController {
    @Autowired
    private MenuRepository MenuService;

    @Autowired
    private FoodRepository FoodService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Menu.class)) }),
            @ApiResponse(responseCode = "500", description = "Unsuccessful",
                    content = { @Content(mediaType = "application/json") })
    })
    @Operation(summary = "Get all menu")
    @GetMapping(path = "/getAllMenu", produces = MediaType.APPLICATION_JSON_VALUE)
    @AspectLogger
    public List<Menu> getAllMenu()
    {
        return MenuService.findAll();
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Food.class)) }),
            @ApiResponse(responseCode = "500", description = "Unsuccessful",
                    content = { @Content(mediaType = "application/json") })
    })
    @Operation(summary = "Get all food")
    @GetMapping(path = "/getAllFood", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Food> getAllFood()
    {
        return FoodService.findAll();
    }
}
