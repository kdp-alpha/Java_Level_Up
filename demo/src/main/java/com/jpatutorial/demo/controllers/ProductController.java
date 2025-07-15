package com.jpatutorial.demo.controllers;

import com.jpatutorial.demo.entities.ProductEntity;
import com.jpatutorial.demo.repositories.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final int PAGE_SIZE = 5;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(){
        return productRepository.findAllByOrderByPrice();
    }

    @GetMapping("/getSortedData")
    public List<ProductEntity> getAllProductSort(@RequestParam(defaultValue="id") String sortBy) {
        return productRepository.findBy(Sort.by( sortBy,"price"));

    }

    @GetMapping("/productPages")
    public List<ProductEntity> getAllProductByPage(@RequestParam(defaultValue = "0") Integer pageNumber){
        Pageable pageable = PageRequest.of(pageNumber,PAGE_SIZE);

        return productRepository.findAll(pageable).getContent();
    }




}
