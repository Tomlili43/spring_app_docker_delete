package com.aift.lukie.Model.Primary;
import com.aift.lukie.Model.Primary.MonthAll;
import java.util.*;
import java.io.Serializable;
public class MonthAllId implements Serializable {
    private Integer month;
    private String productId;
    private Integer year;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonthAll monthAll = (MonthAll) o;
        return Objects.equals(month,monthAll.getMonth()) &&
            Objects.equals(productId,monthAll.getProductId()) &&
            Objects.equals(year,monthAll.getYear());
    }
    @Override
    public int hashCode(){
        return Objects.hash(month,productId,year);
    }
}
