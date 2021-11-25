package yokudlela.menu.datamodel;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.ArrayList;

@Data
@EqualsAndHashCode()
@NoArgsConstructor
@Schema(description = "Food class")
public class Food {
    @Schema(description = "Food ID")
    private long id;

    @Schema(description = "Name of the food")
    private String name;

    @Schema(description = "Quantity of the food")
    private int quantity;

    private List<Menu> menus = new ArrayList<>();

    @Builder
    public Food(String name, int quantity)
    {
        this.name = name;
        this.quantity = quantity;
    }
}
