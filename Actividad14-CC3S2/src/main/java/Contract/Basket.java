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
        assert product != null : "No puedes ingresar un producto vacío";
        assert qtyToAdd > 0 : "La cantidad a agregar tiene que ser mayor a 0";

        BigDecimal prev_totalValue = this.totalValue;

        basket.put(product,qtyToAdd); //add the product
        this.totalValue = totalValue.add(product.getPrice().multiply(new BigDecimal(qtyToAdd))); //update totalValue

        assert basket.containsKey(product) : "El producto no se encuentra en la cesta";
        assert (prev_totalValue.compareTo(this.totalValue) == -1) : "El valor total actual debe ser mayor al anterior valor" ;

    }

    /**
     * Retira un producto del carrito y actualiza el valor total del mismo
     * Precondición: product != null, product in basket
     * Postcondición: this.totalValue == prev_totalValue - product.getPrice()*quantityOf(product), product not in basket
     * @param product producto a eliminar.
     */
    public void remove(Product product) {
        assert product != null : "El producto no puede ser nulo";
        assert basket.containsKey(product) : "El producto tiene que estar registrado en la cesta";

        //update totalValue
        this.totalValue = totalValue.subtract(product.getPrice().multiply(new BigDecimal(this.quantityOf(product))));
        //remove product from the basket
        basket.remove(product);

        assert !basket.containsKey(product) : "El producto no ha sido eliminado";

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
