package com.xfood.catalog.Domain.Exceptions;

public class MealNotFoundException extends Exception {
    public MealNotFoundException(String id) {
        super("Não há um nenhum Prato com o id: "+id);
    }
}
