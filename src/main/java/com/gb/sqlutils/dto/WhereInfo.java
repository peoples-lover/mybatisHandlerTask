package com.gb.sqlutils.dto;


import lombok.Data;

@Data
public class WhereInfo {

    private String left;

    private String operator;

    private String right;



    public static WhereInfo build(String left,String operator,String right){
        WhereInfo whereInfo = new WhereInfo();
        whereInfo.setLeft(left);
        whereInfo.setOperator(operator);
        whereInfo.setRight(right);
        return whereInfo;
    }


}
