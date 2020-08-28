package de.webeng.shop2;

public class WebShop {

    private ProductSearch productSearch;
    private ShoppingCart shoppingCart;

    public WebShop(ProductSearch productSearch, ShoppingCart shoppingCart) {
        this.productSearch = productSearch;
        this.shoppingCart = shoppingCart;
    }

    public void searchProducts() {
        this.productSearch.search();
    }

    public void addToCart() {
        this.shoppingCart.add();
    }
}
