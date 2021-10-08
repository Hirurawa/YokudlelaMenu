package yokudlela.menu.datamodel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class Menu {

    private String name;
    private List<Food> items = new ArrayList<>();
    private int quantity;
    private int price;

    public Menu(String name){
        this.name = name;
    }

}
