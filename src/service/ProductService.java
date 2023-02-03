package service;

import model.Product;
import repository.ProductRepository;

import java.util.List;

public class ProductService implements  BaseService<Product> {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Product getById(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public Product add(Product entity) {
        return productRepository.add(entity);
    }
}
