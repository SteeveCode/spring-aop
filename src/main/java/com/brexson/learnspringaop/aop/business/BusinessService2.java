package com.brexson.learnspringaop.aop.business;


import com.brexson.learnspringaop.aop.data.DataService2;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService2 {

    private DataService2 dataService2;

    public BusinessService2(DataService2 dataService1) {
        this.dataService2 = dataService1;
    }

    public int calculateMin() {
        int[] data = dataService2.retrieveData();
//        throw new RuntimeException("Something went wrong");
        return Arrays.stream(data).min().orElse(0);
    }
}