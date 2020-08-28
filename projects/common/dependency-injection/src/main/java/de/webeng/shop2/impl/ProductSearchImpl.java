package de.webeng.shop2.impl;

import de.webeng.shop2.ProductDB;
import de.webeng.shop2.ProductSearch;

public class ProductSearchImpl implements ProductSearch {

    private final ProductDB productDB;

    public ProductSearchImpl(ProductDB productDB) {
        this.productDB = productDB;
    }

    @Override
    public void search() {

    }
}
