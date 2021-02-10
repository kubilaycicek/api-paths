package com.kubilaycicek.product.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {

    @PostMapping("/addProduct")
    public String addProduct() {
        return "Operation Successfully";
    }

    @PutMapping("/updateProduct/{id}")
    public String updateProduct(Long id) {
        return "Operation Successfully";
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable("id") Long id) {
        return "Product " + id;
    }

    @GetMapping("/list")
    public String getList() {
        return "Product List";
    }

    @DeleteMapping("product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        return "Delete " + id;
    }


}
