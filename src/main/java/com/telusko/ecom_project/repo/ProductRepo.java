package com.telusko.ecom_project.repo;

import com.telusko.ecom_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query("SELECT p from Product p WHERE " +
            "LOWER(p.name) LIKE LOWER(CONTACT('%', :Keyword, '%')) OR " +
            "LOWER(p.desc) LIKE LOWER(CONTACT('%', :Keyword, '%')) OR " +
            "LOWER(p.brand) LIKE LOWER(CONTACT('%', :Keyword, '%')) OR " +
            "LOWER(p.category) LIKE LOWER(CONTACT('%', :Keyword, '%'))")
            List<Product> searchProducts(String keyword);


}
