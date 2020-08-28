package de.webeng;

import de.webeng.shop2.ProductDB;
import de.webeng.shop2.ProductSearch;
import de.webeng.shop2.ShoppingCart;
import de.webeng.shop2.WebShop;
import de.webeng.shop2.impl.ProductDBImpl;
import de.webeng.shop2.impl.ProductSearchImpl;
import de.webeng.shop2.impl.ShoppingCartImpl;

public class App {
    public static void main(String[] args) {
        ProductDB db = new ProductDBImpl();
        ProductSearch search = new ProductSearchImpl(db);
        ShoppingCart cart = new ShoppingCartImpl();

        WebShop webshop = new WebShop(search, cart);
    }
}
