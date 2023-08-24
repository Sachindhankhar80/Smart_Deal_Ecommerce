package com.online.Smart_Online_Shopping_Platform.repository;

import com.online.Smart_Online_Shopping_Platform.Enum.ProductCategory;
import com.online.Smart_Online_Shopping_Platform.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.price >= :price and p.category = :category")
    public List<Product> getProdByCategoryAndPriceGreaterThan(int price, ProductCategory category);
}
