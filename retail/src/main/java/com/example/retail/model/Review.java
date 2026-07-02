package com.example.retail.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "reviews")
public class Review {

    @Id
    private String id;

    private Long productId;

    private Long customerId;

    @NotBlank(message = "Comment is required")
    private String comment;

    @Min(1)
    @Max(5)
    private Integer rating;

    private LocalDateTime createdAt;
}