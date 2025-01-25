package com.example.graphql.service;

import com.example.graphql.entity.Product;
import com.example.graphql.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;



    public List<Product> getProducts(){
        return repository.findAll();
    }

    public List<Product> getProductsByCategory(String category){
        return repository.findByCategory(category);
    }

    //sales team : update the stock of a product in (IS)
    public Product updateStock(int id, int stock){

       Product existingProduct= repository.findById(id)
                .orElseThrow(()-> new RuntimeException("product not found with id "+id));

       existingProduct.setStock(stock);
       return repository.save(existingProduct);
    }

    //warehouse : receive new shipment
    public Product receiveNewShipment(int id, int quantity){

        Product existingProduct= repository.findById(id)
                .orElseThrow(()-> new RuntimeException("product not found with id "+id));

       existingProduct.setStock(existingProduct.getStock()+quantity);
        return repository.save(existingProduct);
    }

    public Product createStock(Product product) {
        return repository.save(product);
    }

    public String deleteStock(int id) {
        Product existingProduct = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found with id" + id));
         repository.deleteById(existingProduct.getId());
         return "Stock deleted !!";
    }
}
