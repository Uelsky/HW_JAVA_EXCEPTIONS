import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ShopRepositoryTest {
    ShopRepository shopRepository = new ShopRepository();

    @Test
    public void testRemoveExistingProduct() {
        Product product = new Product(1, "Книга", 10);
        shopRepository.add(product);
        Assertions.assertArrayEquals(new Product [] {product}, shopRepository.getProducts());

        shopRepository.removeById(1);
        Assertions.assertArrayEquals(new Product [] {}, shopRepository.getProducts());
    }

    @Test
    public void testRaiseException() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.removeById(1);
        });
    }
}
