package com.xfood.ordering.Application.ReadModels.Results;

import java.math.BigDecimal;
import java.util.Date;

public class OrderResult {
    public String id;
    public String mealId;
    public String title;
    public Date creationDate;
    public BigDecimal price;
    public Integer amount;
}
