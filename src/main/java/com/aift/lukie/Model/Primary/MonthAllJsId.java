package com.aift.lukie.Model.Primary;
import com.aift.lukie.Model.Primary.MonthAllJs;
import java.util.*;
import java.io.Serializable;
public class MonthAllJsId implements Serializable {
    private Integer month;
    private String productId;
    private Integer year;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonthAllJs monthAllJs = (MonthAllJs) o;
        return Objects.equals(month,monthAllJs.getMonth()) &&
            Objects.equals(productId,monthAllJs.getProductId()) &&
            Objects.equals(year,monthAllJs.getYear());
    }
    @Override
    public int hashCode(){
        return Objects.hash(month,productId,year);
    }
}
