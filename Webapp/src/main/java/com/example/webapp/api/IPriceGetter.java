package com.example.webapp.api;

import com.example.webapp.model.Database;

import java.util.Map;
//using inteface segretion principle for keeping interface minimal and focused with only one method (fetchStockData)
//using dependency inversion principle by defining the contract for the service and not the implementation

public interface IPriceGetter {
    Map<String, Database> fetchDatabaseData(String symbol);
}