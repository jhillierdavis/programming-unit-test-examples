package com.jhdit.java.learning.streams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Product {
    String name;

    Product(String name)    {
        this.name = name;
    }

    String getName()    {
        return this.name;
    }
}

public class StreamExamples {

    private int sumNonWhiteSpaceCharsUsingLambdaPipeline(List<Product> products) {
        Function<Product, String> nameMapper = p -> p.getName();
        UnaryOperator<String> trimMapper = s -> s.trim();
        ToIntFunction<String> lengthMapper = s -> s.length();
        return products.stream().map(nameMapper.andThen(trimMapper)).mapToInt(lengthMapper).sum();
    }

    private int sumNonWhiteSpaceCharsUsingLambdaPipelineWithMethodReferences(List<Product> products) {
        Function<Product, String> nameMapper = Product::getName;
        UnaryOperator<String> trimMapper = String::trim;
        ToIntFunction<String> lengthMapper = String::length;
        return products.stream().map(nameMapper.andThen(trimMapper)).mapToInt(lengthMapper).sum();
    }


    @Test
    void exploreStreamPipelineElements()   {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Alpha"));
        products.add(new Product("Beta"));
        products.add(new Product("Gamma"));

        // Then:
        assertEquals(14, sumNonWhiteSpaceCharsUsingLambdaPipeline(products));
        assertEquals(14, sumNonWhiteSpaceCharsUsingLambdaPipelineWithMethodReferences(products));
    }
}
