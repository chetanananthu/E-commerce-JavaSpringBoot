package com.example.product_service.service;

import com.example.product_service.entity.Product;
import com.example.product_service.model.ProductDto;
import com.example.product_service.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<ProductDto> getAllProducts(){
        List<Product>products=productRepository.findAll();
        List<ProductDto>productDtos=new ArrayList<>();
        products.stream().forEach(product -> {
            ProductDto productDto=new ProductDto();
            productDto.setId(product.getId());
            productDto.setName(product.getName());
            productDto.setPrice(product.getPrice());
            productDto.setQuantity(productDto.getQuantity());
            productDto.setOrderId(productDto.getOrderId());

            productDtos.add(productDto);
        });
        return productDtos;
    }

    public ProductDto getAProduct(long id){
        Optional<Product> product=productRepository.findById(id);
        ProductDto productDto=new ProductDto();
        BeanUtils.copyProperties(product.get(),productDto);
        return productDto;
    }

    public List<ProductDto>getProductByOrderId(int id){
        List<Product>products=productRepository.findByOrderId(id);
        List<ProductDto>productDtos=new ArrayList<>();
        products.stream().forEach(product -> {
            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setName(product.getName());
            productDto.setPrice(product.getPrice());
            productDto.setQuantity(productDto.getQuantity());
            productDto.setOrderId(productDto.getOrderId());
            productDtos.add(productDto);
        });
        return productDtos;
    }

    public ProductDto addProduct(ProductDto productDto){
        Product product=new Product();
        BeanUtils.copyProperties(productDto,product);
        productRepository.saveAndFlush(product);
        return productDto;
    }

    public ProductDto updateProduct(ProductDto productDto){
        Product product=new Product();
        BeanUtils.copyProperties(productDto,product);
        productRepository.saveAndFlush(product);
        return productDto;
    }

    public void deleteProduct(long id){
        Optional<Product>product=productRepository.findById(id);
        productRepository.delete(product.get());
    }


}
