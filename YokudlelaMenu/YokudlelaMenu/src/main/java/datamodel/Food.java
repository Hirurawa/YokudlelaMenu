package datamodel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class Food {

    private String name;
    private int quantity;

}
