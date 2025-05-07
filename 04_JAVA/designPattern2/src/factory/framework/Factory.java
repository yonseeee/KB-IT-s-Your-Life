package factory.framework;

public abstract class Factory {
    public final Product create(String owner){//template
        Product p=createProduct(owner);
        registerProduct(p);
        return p;
    }

    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product p);
}
