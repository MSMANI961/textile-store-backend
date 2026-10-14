
package com.textilemart.store.service;

import com.textilemart.store.entity.Product;
import com.textilemart.store.repository.ProductRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get one product by ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Add a new product
    public Product createProduct(Product product) {
        product.setId(null);
        return productRepository.save(product);
    }

    // Update an existing product
    public Optional<Product> updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(updatedProduct.getName());
                    existingProduct.setCategory(updatedProduct.getCategory());
                    existingProduct.setPrice(updatedProduct.getPrice());
                    existingProduct.setImage(updatedProduct.getImage());
                    existingProduct.setDescription(updatedProduct.getDescription());
                    existingProduct.setRating(updatedProduct.getRating());
                    existingProduct.setStock(updatedProduct.getStock());

                    return productRepository.save(existingProduct);
                });
    }

    // Delete a product
    public boolean deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            return false;
        }

        productRepository.deleteById(id);
        return true;
    }
}

