package com.xfood.ordering.Domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Document("order")
public class Order {

    public Order() {
        creationDate = new Date();
    }

    @Id
    private String id;
    private String mealId;
    private String title;
    private Date creationDate;
    private BigDecimal price;
    private Integer amount;

}
