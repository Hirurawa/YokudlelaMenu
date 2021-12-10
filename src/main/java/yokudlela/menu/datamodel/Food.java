package yokudlela.menu.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode()
@NoArgsConstructor
@Schema(description = "Food class")
@Entity
@javax.persistence.Table(name = "food")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @NotBlank(message = "error.food.name.notset")
    @NotNull(message = "error.food.name.notset")
    @Schema(description = "Name of the food")
    private String name;

    @Min(value = 1, message = "error.food.quantity.min")
    @Schema(description = "Quantity of the food")
    private int quantity;

    @Builder
    public Food(String name, int quantity)
    {
        this.name = name;
        this.quantity = quantity;
    }
}
