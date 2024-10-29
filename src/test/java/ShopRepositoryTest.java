import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ShopRepositoryTest {
    ShopRepository shopRepository = new ShopRepository();

    @Test
    public void testRemoveExistingProduct() {
        Product product = new Product(1, "Книга", 10);
        shopRepository.add(product);
        Assertions.assertEquals(1, shopRepository.getProducts().length);

        shopRepository.removeById(1);
        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.removeById(1);
        });
    }

    @Test
    public void testRemoveNonExistingProduct() {
        try {
            shopRepository.removeById(1);
        } catch (NotFoundException e) {
            Assertions.assertEquals("Товар с ID 1 не найден.", e.getMessage());
        }
    }
}
