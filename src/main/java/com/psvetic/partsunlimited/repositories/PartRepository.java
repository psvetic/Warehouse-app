package com.psvetic.partsunlimited.repositories;

import com.psvetic.partsunlimited.models.MakeAndModel;
import com.psvetic.partsunlimited.models.MakeAndModelCount;
import com.psvetic.partsunlimited.models.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PartRepository extends JpaRepository<Part, Long> {
    List<Part> findByManufactureDate(LocalDate manufactureDate);
    List<Part> findByModels_name (String name);
    long countByModels_name(String name);

    @Query(value = "SELECT CONCAT(ma.name, ' ', m.name) AS brandAndAuto, p.part_name AS partName, p.manufacture_date AS manufactureDate FROM partsunlimited.parts p\n" +
            "JOIN partsunlimited.model_parts mp\n" +
            "ON p.serial_number = mp.serial_number\n" +
            "JOIN partsunlimited.models m\n" +
            "ON m.idmodel = mp.idmodel\n" +
            "JOIN partsunlimited.makes ma\n" +
            "ON ma.idmake = m.idmake\n" +
            "WHERE UPPER(CONCAT(ma.name, ' ', m.name)) LIKE UPPER(CONCAT('%',:name, '%'))" +
            "GROUP BY CONCAT(ma.name, ' ', m.name), p.part_name, p.manufacture_date", nativeQuery = true)
    List<MakeAndModel> searchMakeAndModel(@Param("name") String name);

    @Query(value = "SELECT CONCAT(ma.name, ' ', m.name) AS brandAndAuto, COUNT(*) FROM partsunlimited.parts p\n" +
            "JOIN partsunlimited.model_parts mp\n" +
            "ON p.serial_number = mp.serial_number\n" +
            "JOIN partsunlimited.models m\n" +
            "ON m.idmodel = mp.idmodel\n" +
            "JOIN partsunlimited.makes ma\n" +
            "ON ma.idmake = m.idmake\n" +
            "WHERE UPPER(CONCAT(ma.name, ' ', m.name)) LIKE UPPER(CONCAT('%',:name, '%'))\n" +
            "GROUP BY CONCAT(ma.name, ' ', m.name)", nativeQuery = true)
    List<MakeAndModelCount> makeAndModelCount(@Param("name") String name);
}
