package com.example.product_service.controller;
import com.example.product_service.model.ProductDto;
import com.example.product_service.service.ProductService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> productDtos=productService.getAllProducts();
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getAProduct(@PathVariable("id") long id){
        ProductDto productDto=productService.getAProduct(id);
        return new ResponseEntity<>(productDto,HttpStatus.OK);
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<List<ProductDto>> getProductsByOrderId(@PathVariable("orderId") long orderId){
        List<ProductDto> productDtos=productService.getProductByOrderId(orderId);
        return new ResponseEntity<>(productDtos,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestBody  ProductDto productDto){
        ProductDto product=productService.addProduct(productDto);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestBody  ProductDto productDto){
        ProductDto product=productService.addProduct(productDto);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
