import org.example.exercise1.Product;
import org.example.exercise1.ProductNotFoundException;
import org.example.exercise1.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    ShoppingCart shoppingCart;

    @BeforeEach
    public void setup() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void given_emptyShoppingCart_when_productAdded_then_productAdded() {
        // Given
        Product soda = new Product("Soda", 2);
        assertEquals(0, shoppingCart.getItemCount());

        // When
        shoppingCart.addItem(soda);

        // Then
        assertEquals(1, shoppingCart.getItemCount());
    }

    @Test
    public void given_emptyShoppingCart_when_removeItem_then_errorIsThrown() {
        // Given
        Product soda = new Product("Soda", 2);
        assertEquals(0, shoppingCart.getItemCount());

        // When
        // Then
        assertThrows(ProductNotFoundException.class, () -> {
            shoppingCart.removeItem(soda);
        });
    }

    @Test
    public void given_shoppingCart_when_productsAdded_then_countIsUpdated() {
        // Given
        assertEquals(0, shoppingCart.getItemCount());

        // When
        Product product1 = new Product("Product 1", 1);
        Product product2 = new Product("Product 2", 1);
        Product product3 = new Product("Product 3", 1);
        Product product4 = new Product("Product 4", 1);

        shoppingCart.addItem(product1);
        shoppingCart.addItem(product2);
        shoppingCart.addItem(product3);
        shoppingCart.addItem(product4);

        // Then
        assertEquals(4, shoppingCart.getItemCount());
    }

    @Test
    public void given_shoppingCart_when_productsAdded_then_balanceIsUpdated() {
        // Given
        assertEquals(0, shoppingCart.getItemCount());
        assertEquals(0, shoppingCart.getBalance());

        // When
        double expectedBalance = 0;
        Product product1 = new Product("Product 1", 1.5);
        Product product2 = new Product("Product 2", 3.2);
        Product product3 = new Product("Product 3", 8.6);
        Product product4 = new Product("Product 4", 0.12);

        shoppingCart.addItem(product1);
        shoppingCart.addItem(product2);
        shoppingCart.addItem(product3);
        shoppingCart.addItem(product4);

        expectedBalance += product1.getPrice();
        expectedBalance += product2.getPrice();
        expectedBalance += product3.getPrice();
        expectedBalance += product4.getPrice();

        // Then
        assertEquals(expectedBalance, shoppingCart.getBalance());
    }


}
