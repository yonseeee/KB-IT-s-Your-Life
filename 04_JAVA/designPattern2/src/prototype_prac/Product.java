package prototype_prac;

public interface Product extends Cloneable {
    void use(String s);
    Product createCopy();
}
