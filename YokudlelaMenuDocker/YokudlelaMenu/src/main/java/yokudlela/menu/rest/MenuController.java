package yokudlela.menu.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import yokudlela.menu.store.MenuRepository;
import yokudlela.menu.datamodel.Menu;

import java.util.List;

@RestController()
@RequestMapping(path = "/menu")
public class MenuController {

    @Autowired
    private MenuRepository service;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Query successful",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Menu.class))) }),
    })
    @Operation(summary = "Get All menus")
    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Menu> getAll()
    {
        return service.getAll();
    }

}
