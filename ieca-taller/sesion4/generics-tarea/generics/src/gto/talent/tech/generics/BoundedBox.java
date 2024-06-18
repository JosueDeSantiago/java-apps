package gto.talent.tech.generics;

public class BoundedBox<T extends CharSequence> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
