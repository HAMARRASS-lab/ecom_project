package com.codeWithProject.ecom.services.customer;

import com.codeWithProject.ecom.dto.ProductDetailsDto;
import com.codeWithProject.ecom.dto.ProductDto;
import com.codeWithProject.ecom.entity.FAQ;
import com.codeWithProject.ecom.entity.Product;
import com.codeWithProject.ecom.entity.Review;
import com.codeWithProject.ecom.repository.FAQRepository;
import com.codeWithProject.ecom.repository.ProductRepository;
import com.codeWithProject.ecom.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerProductServiceImpl implements CustomerProductService {

    private final ProductRepository productRepository;

    private final FAQRepository faqRepository;

    private final ReviewRepository reviewRepository;


    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }

    public List<ProductDto> searchProductByTitle(String name) {
        List<Product> products = productRepository.findAllByNameContaining(name);
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }

    public ProductDetailsDto getProductDetailsById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);

//        if (optionalProduct.isPresent()) {
//            List<FAQ> faqList = faqRepository.findAlProductId(productId);
//            List<Review> reviewList = reviewRepository.findAllProductId(productId);
//            ProductDetailsDto productDetailsDto = new ProductDetailsDto();
//
//            productDetailsDto.setProductDto(optionalProduct.get().getDto());
//            productDetailsDto.setFaqDtoList(faqList.stream().map(FAQ::getFAQDto).collect(Collectors.toList()));
//            productDetailsDto.setReviewDtoList(reviewList.stream().map(Review::getDto).collect(Collectors.toList()));
//
//            return productDetailsDto;
//        }
        return null;
    }
}
