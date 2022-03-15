package com.unit.testing.unittesting.business;

import com.unit.testing.unittesting.data.SomeDataService;

public class SomeBusinessImpl {

    SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data){
        int sum = 0;
        for(int value:data){
            sum += value;
        }
        return sum;
    }

    public int calculateSumFromSomeDataService(){
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for(int value:data){
            sum += value;
        }
        return sum;
    }
}
