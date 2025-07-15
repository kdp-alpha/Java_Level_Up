package com.jpatutorial.demo.repositories;

import com.jpatutorial.demo.entities.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    List<ProductEntity> findAllByOrderByPrice();

    List<ProductEntity> findBy(Sort sort);

}
