package com.online.Smart_Online_Shopping_Platform.service;

import com.online.Smart_Online_Shopping_Platform.Enum.ProductCategory;
import com.online.Smart_Online_Shopping_Platform.dto.request.ProductRequestDto;
import com.online.Smart_Online_Shopping_Platform.dto.response.ProductResponseDto;
import com.online.Smart_Online_Shopping_Platform.exception.SellerNotFoundException;
import com.online.Smart_Online_Shopping_Platform.model.Product;
import com.online.Smart_Online_Shopping_Platform.model.Seller;
import com.online.Smart_Online_Shopping_Platform.repository.CustomerRepository;
import com.online.Smart_Online_Shopping_Platform.repository.ProductRepository;
import com.online.Smart_Online_Shopping_Platform.repository.SellerRepository;
import com.example.smartdeals.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {

        Seller seller = sellerRepository.findByEmail(productRequestDto.getSellerEmail());
        if (seller == null) {
            throw new SellerNotFoundException("Seller doesn't exist");
        }

        // dto -> entity
        Product product = ProductTransformer.ProductRequestDtoToProduct(productRequestDto);
        product.setSeller(seller);
        seller.getProducts().add(product);

        Seller savedSeller = sellerRepository.save(seller); // save both product and seller
        List<Product> productList = savedSeller.getProducts();
        Product latestProduct = productList.get(productList.size() - 1);

        // prepare response dto
        return ProductTransformer.ProductToProductResponseDto(latestProduct);
    }

    public List<ProductResponseDto> getProdByCategoryAndPriceGreaterThan(int price,
                                                                         ProductCategory category) {

        List<Product> products = productRepository.getProdByCategoryAndPriceGreaterThan(price, category);

        // prepare list of response dtos
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for (Product product : products) {
            productResponseDtos.add(ProductTransformer.ProductToProductResponseDto(product));
        }

        return productResponseDtos;
    }
}
