package com.jhdit.java.learning.streams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Explore different application of Java Streams e.g. to sum the total non-space characters of all product names in a list of products
 */

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

    private int inParallelSumNonWhiteSpaceCharsUsingLambdaPipelineWithMethodReferences(List<Product> products) {
        Function<Product, String> nameMapper = Product::getName;
        return products.parallelStream().map(nameMapper.andThen(String::trim)).mapToInt(String::length).sum();
    }


    @Test
    void exploreStreamPipelineElements()   {
        // Given: a list of populated Product objects
        List<Product> products = new ArrayList<>();
        products.add(new Product("Alpha"));
        products.add(new Product("Beta"));
        products.add(new Product("Gamma"));

        // Then: check variants of the same functionality using different implementations of Java streams
        assertEquals(14, sumNonWhiteSpaceCharsUsingLambdaPipeline(products));
        assertEquals(14, sumNonWhiteSpaceCharsUsingLambdaPipelineWithMethodReferences(products));
        assertEquals(14, inParallelSumNonWhiteSpaceCharsUsingLambdaPipelineWithMethodReferences(products));
    }
}
