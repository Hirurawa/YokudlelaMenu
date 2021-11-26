package yokudlela.menu.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@EqualsAndHashCode()
@NoArgsConstructor
@Entity
@javax.persistence.Table(name = "menu")
@Schema(description = "Menu class")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Menu {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @NotBlank(message = "error.menu.name.notset")
    @NotNull(message = "error.menu.name.notset")
    @Schema(description = "Name of the menu")
    private String name;

    @Schema(description = "Foods in the menu")
    @ManyToMany(fetch = FetchType.LAZY )
    @JoinColumn(name="food_id", nullable=false)
    private List<Food> foods = new ArrayList<>();

    @Schema(description = "Quantity of the menu")
    @NotBlank(message = "error.menu.quantity.notset")
    @NotNull(message = "error.menu.quantity.notset")
    private int quantity;

    @NotBlank(message = "error.menu.price.notset")
    @NotNull(message = "error.menu.price.notset")
    @Min(value=1, message = "error.menu.price.few")
    @Schema(description = "Price of the menu")
    private int price;

    @Builder
    public Menu(String name)
    {
        this.name = name;
    }
}
