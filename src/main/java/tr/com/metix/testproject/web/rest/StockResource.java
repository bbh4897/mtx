package tr.com.metix.testproject.web.rest;
import org.springframework.web.bind.annotation.*;
import tr.com.metix.testproject.service.StockService;
import tr.com.metix.testproject.service.dto.RestaurantCategoryDTO;
import tr.com.metix.testproject.service.dto.StockDTO;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StockResource {

    private final StockService stockService;

    public StockResource(StockService stockService) {
        this.stockService = stockService;
    }


    @GetMapping("/stocks")
    public List<StockDTO> selectStock() {
        return stockService.getStock();
    }

    @PostMapping("/createStock")
    public StockDTO createStock(@RequestBody StockDTO stockDTO) throws URISyntaxException {

        StockDTO stockDTO1 = stockService.createStock(stockDTO);
        return stockDTO1;
    }

    @DeleteMapping("/deleteStock/{id}")
    public void deleteStock(@PathVariable Long id) {

        stockService.deleteStock(id);

    }

    @PutMapping("/updateStock")
    public StockDTO updateStock (@RequestBody StockDTO stockDTO) throws URISyntaxException {

        StockDTO stockDTO1 = stockService.updateStock(stockDTO);
        return stockDTO1;
    }
}
