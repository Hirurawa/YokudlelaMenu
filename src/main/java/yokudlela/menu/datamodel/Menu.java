package yokudlela.menu.datamodel;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode()
@NoArgsConstructor
@Schema(description = "Menu class")
public class Menu {
    @Schema(description = "Menu ID")
    private long id;

    @Schema(description = "Name of the menu")
    private String name;

    @Schema(description = "Foods in the menu")
    private List<Food> foods = new ArrayList<>();

    @Schema(description = "Quantity of the menu")
    private int quantity;

    @Schema(description = "Price of the menu")
    private int price;

    @Builder
    public Menu(String name)
    {
        this.name = name;
    }
}
