package com.gb.sqlutils.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class StatementInfo implements Serializable {

    private static final long serialVersionUID = 5785272795014999759L;

    //表名
    private String tableName;
    //列名
    private List<String> tableNames;
    //是不是多表
    private boolean isMultipleTable;

    // set 的键值对
    private Map<String, String> setMaps;

    // where 的键值对
    private Map<String, WhereInfo> whereMaps;

    // where 后面的语句
    private String whereStr;

    // value 的键值对
    private Map<String, String> valueMaps;
    // select 中的要查找的值
    private List<String> selects;
    // joins
    private List<String> joins;

    //
    private List<String> orderbys;
    // 分组
    private List<String> groupbys;


    public StatementInfo(String tableName) {
        this.tableName = tableName;
    }


    public StatementInfo() {
    }
}
