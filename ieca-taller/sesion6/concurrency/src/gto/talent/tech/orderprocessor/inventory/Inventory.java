package gto.talent.tech.orderprocessor.inventory;

public interface Inventory {
    public void addProduct(String product, int quantity);
    public boolean removeProduct(String product, int quantity);
    public int getStock(String product);
}
