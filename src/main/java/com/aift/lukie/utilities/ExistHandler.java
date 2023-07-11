package com.aift.lukie.utilities;

public enum ExistHandler {
    Exist("Exist",true), NotExist("Not Exist",false);

    private String status;
    private boolean boolStatus;

    private ExistHandler(String status ,boolean boolStatus){
        this.status = status;
        this.boolStatus = boolStatus;
    };

    @Override
    public String toString(){
        return String.format(
            "{" + " status: %s" +
            " boolStatus: %s" +
            "}",
            status, boolStatus
        );
    }
}
