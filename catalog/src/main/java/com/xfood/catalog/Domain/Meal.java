package com.xfood.catalog.Domain;

import com.xfood.catalog.Domain.Exceptions.BusinessException;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document("meal")
public class Meal {

    @Id
    private String id;
    private String title;
    private String description;
    private BigDecimal price;
    private Integer preparationTime;
    private Integer amount;

    public void decrementAmount(Integer amount) throws BusinessException {
        if(this.amount - amount <= 0){
            throw new BusinessException("Quantidade do pedido foi maior que o disponível!");
        }
        this.amount -= amount;
    }

}
