package yokudlela.menu.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yokudlela.menu.datamodel.Food;
import yokudlela.menu.datamodel.Menu;
import yokudlela.menu.store.FoodRepository;
import yokudlela.menu.store.MenuRepository;

import javax.validation.Valid;

@RestController()
@RequestMapping(path = "/admin")
@Validated
public class AdminController {
    @Autowired(required = true)
    private MenuRepository MenuService;

    @Autowired(required = true)
    private FoodRepository FoodService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Menu.class)) }),
            @ApiResponse(responseCode = "500", description = "Already exists",
                    content = { @Content(mediaType = "application/json") })
    })
    @Operation(
            security = {
                    @SecurityRequirement(name = "apikey",scopes = {"menu"}),
                    @SecurityRequirement(name = "openid",scopes = {"menu"}),
                    @SecurityRequirement(name = "oauth2",scopes = {"menu"}),
            },
            summary = "Add new menu")
    @PostMapping(path = "/addMenu", produces = MediaType.APPLICATION_JSON_VALUE)
    public Menu addMenu(
            @Valid
            @Parameter(description = "The new menu", required = true)
            @RequestBody(required = true) Menu pData) throws Exception {
        MenuService.save(pData);
        return pData;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Food.class)) }),
            @ApiResponse(responseCode = "500", description = "Already exists",
                    content = { @Content(mediaType = "application/json") })
    })
    @Operation(
            security = {
                    @SecurityRequirement(name = "apikey",scopes = {"menu"}),
                    @SecurityRequirement(name = "openid",scopes = {"menu"}),
                    @SecurityRequirement(name = "oauth2",scopes = {"menu"}),
            },
            summary = "Add new food")
    @PostMapping(path = "/addFood", produces = MediaType.APPLICATION_JSON_VALUE)
    public Food addFood(
            @Valid
            @Parameter(description = "The new food", required = true)
            @RequestBody(required = true) Food pData) throws Exception {
        FoodService.save(pData);
        return pData;
    }
}
