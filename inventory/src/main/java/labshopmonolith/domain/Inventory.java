package labshopmonolith.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import labshopmonolith.InventoryApplication;
import lombok.Data;

@Entity
@Table(name = "Inventory_table")
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long stock;

    @PostPersist
    public void onPostPersist() {}

    @PostLoad
    public void makeDelay(){
        try {
            Thread.currentThread().sleep((long) (600 + Math.random() * 220));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static InventoryRepository repository() {
        InventoryRepository inventoryRepository = InventoryApplication.applicationContext.getBean(
            InventoryRepository.class
        );
        return inventoryRepository;
    }

    public void decreaseStock(DecreaseStockCommand decreaseStockCommand) {}
}
