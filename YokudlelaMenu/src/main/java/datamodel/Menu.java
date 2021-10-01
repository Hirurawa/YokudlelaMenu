package datamodel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class Menu {

    private String name;
    private List<String> items = new ArrayList<>();
    private int quantity;
    private LocalDate expiration;

    public Menu(String name){
        this.name = name;
    }

}
