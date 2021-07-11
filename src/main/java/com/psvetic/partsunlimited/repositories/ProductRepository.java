package com.psvetic.partsunlimited.repositories;

import com.psvetic.partsunlimited.models.Product;
import com.psvetic.partsunlimited.models.ProductWithDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p.serial_number AS serialNumber, p.product_name AS productName, p.manufacture_date AS manufactureDate,\n" +
            "CASE WHEN pd.iddiscount IS NULL\n" +
            "THEN p.base_price ELSE p.base_price - p.base_price * d.percent / 100 END price\n" +
            "FROM (partsunlimited.products p LEFT JOIN partsunlimited.product_discounts pd ON p.serial_number = pd.serial_number )\n" +
            "LEFT JOIN partsunlimited.discounts d ON pd.iddiscount = d.iddiscount", nativeQuery = true)
    List<ProductWithDiscount> displayProductInfo();
}
