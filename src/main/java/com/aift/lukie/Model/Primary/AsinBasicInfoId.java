package com.aift.lukie.Model.Primary;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;

public class AsinBasicInfoId implements Serializable {
    private String id;
    private Timestamp timestamp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsinBasicInfoId asinBasicInfoId = (AsinBasicInfoId) o;
        return Objects.equals(id, asinBasicInfoId.id) &&
                Objects.equals(timestamp, asinBasicInfoId.timestamp);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id,timestamp);
    }
}
