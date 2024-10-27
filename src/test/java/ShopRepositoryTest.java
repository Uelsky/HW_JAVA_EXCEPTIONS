import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


public class ShopRepositoryTest {
    ShopRepository shopRepository = new ShopRepository();

     @Test
    public void testRemoveExistingProduct() {
        // Добавляем товар в репозиторий
        Product product = new Product(1, "Книга", 10);
        shopRepository.add(product);

        // Проверяем, что товар существует
        Product foundProduct = shopRepository.findById(1);
        assertNotNull(foundProduct);

        // Удаляем товар
        shopRepository.removeById(1);

        // Проверяем, что товар больше не существует
        foundProduct = shopRepository.findById(1);
        assertNull(foundProduct);
    }

    @Test
    public void testRemoveNonExistingProduct() {
        try {
            shopRepository.removeById(100);
        } catch (NotFoundException e) {
            Assertions.assertEquals("Товар с ID 100 не найден.", e.getMessage());
        }
    }
}
