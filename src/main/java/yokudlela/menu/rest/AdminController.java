package yokudlela.menu.rest;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping(path = "/admin")
public class AdminController {

    @Autowired
    private MenuRepository service;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Menu.class)) }),
            @ApiResponse(responseCode = "500", description = "Already exsists",
                    content = { @Content(mediaType = "application/json") })
    })
    @Operation(
            security = {
                    @SecurityRequirement(name = "apikey",scopes = {"menu"}),
                    @SecurityRequirement(name = "openid",scopes = {"menu"}),
                    @SecurityRequirement(name = "oauth2",scopes = {"menu"}),
            },
            summary = "Add new menu")
    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Menu add(@Parameter(description = "The new menu", required = true) @RequestBody(required = true) Menu pData) throws Exception {
        service.add(pData);
        return pData;
    }
}
