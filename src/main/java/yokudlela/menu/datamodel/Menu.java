package yokudlela.menu.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Schema(description = "Menu")
@Entity
@javax.persistence.Table(name = "rmenu")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Schema(description = "Name of the menu")
    @NotBlank(message = "error.menu.name.notset")
    @NotNull(message = "error.menu.name.notset")
    private String name;

    @Schema(description = "Food items in the menu")
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Food> foods = new ArrayList<>();

    @Schema(description = "How many items we have in the menu")
    @NotBlank(message = "error.menu.quantity.notset")
    @NotNull(message = "error.menu.quantity.notset")
    private int quantity;

    @Schema(description = "Price of one menu")
    @NotBlank(message = "error.menu.price.notset")
    @NotNull(message = "error.menu.price.notset")
    @Min(value=1, message = "error.menu.price.few")
    private int price;

    public Menu(String name){
        this.name = name;
    }

}
