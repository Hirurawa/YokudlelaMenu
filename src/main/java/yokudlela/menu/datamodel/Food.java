package yokudlela.menu.datamodel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode()
@NoArgsConstructor
@Schema(description = "Food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @NotBlank(message = "error.food.name.notset")
    @NotNull(message = "error.food.name.notset")
    @Schema(description = "Name of the food")
    private String name;

    @Schema(description = "How much of this food we have")
    @Min(value = 1, message = "error.food.quantity.min")
    private int quantity;

    @Schema(description = "This food is in which menu")
    @ManyToMany(mappedBy = "foods")
    private List<Menu> menus = new ArrayList<>();
}
