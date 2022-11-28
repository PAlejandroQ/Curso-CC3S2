package Contract;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class Basket {
    private BigDecimal totalValue = BigDecimal.ZERO;
    private Map<Product, Integer> basket = new HashMap< >();

    /**
     * Agrega un producto al carrito y actualiza el valor total del mismo
     * Preconditions: product != null, qtyToAdd > 0
     * Postconditions: this.totalValue >= prev_totalValue
     * @param product el producto a añadir
     * @param qtyToAdd la cantidad de producto
     */
    public void add(Product product, int qtyToAdd) {

        basket.put(product,qtyToAdd);
        this.totalValue = totalValue.add(product.getPrice().multiply(new BigDecimal(qtyToAdd)));

    }

    /**
     * Retira un producto del carrito y actualiza el valor total del mismo
     * Precondición: product != null, product in basket
     * Postcondición: this.totalValue == prev_totalValue - product.getPrice()*quantityOf(product), product not in basket
     * @param product producto a eliminar.
     */
    public void remove(Product product) {
        this.totalValue = totalValue.subtract(product.getPrice().multiply(new BigDecimal(this.quantityOf(product))));
        basket.remove(product);

    }
    private boolean invariant() {
        return totalValue.compareTo(BigDecimal.ZERO) >= 0;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public int quantityOf(Product product) {
        assert basket.containsKey(product);
        return basket.get(product);
    }

    public Set<Product> products() {
        return Collections.unmodifiableSet(basket.keySet());
    }
    @Override
    public String toString() {
        return "BasketCase{" +
                "totalValue=" + totalValue +
                ", basket=" + basket +
                '}';
    }
}
