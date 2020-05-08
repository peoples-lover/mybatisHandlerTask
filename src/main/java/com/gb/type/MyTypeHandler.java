package com.gb.type;

import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MyTypeHandler extends BaseTypeHandler<List<Integer>> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List<Integer> integers, JdbcType jdbcType) throws SQLException {

        String str = "";
        for(int j = 0; j < integers.size(); j++){
            if(j == integers.size()-1){
                str = str + integers.get(j).toString();
            }else{
                str = str + integers.get(j).toString()+",";
            }
        }
        System.out.println("MyTypeHandler 拼接后的结果：" + str);
        preparedStatement.setString(i, str);
    }

    public List<Integer> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        List<Integer> integers = new ArrayList<>();
        if(StringUtils.isNullOrEmpty(rs.getString(columnName))){
            return integers;
        }
        String[] strings = rs.getString(columnName).split(",");
        for(int i = 0; i < strings.length; i++){
            integers.add(Integer.parseInt(strings[i]));
        }
        return integers;
    }

    public List<Integer> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {

        List<Integer> integers = new ArrayList<>();
        if(StringUtils.isNullOrEmpty(rs.getString(columnIndex))){
            return integers;
        }
        String[] strings = rs.getString(columnIndex).split(",");
        for(int i = 0; i < strings.length; i++){
            integers.add(Integer.parseInt(strings[i]));
        }
        return integers;
    }

    public List<Integer> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {

        List<Integer> integers = new ArrayList<>();
        if(StringUtils.isNullOrEmpty(cs.getString(columnIndex))){
            return integers;
        }
        String[] strings = cs.getString(columnIndex).split(",");
        for(int i = 0; i < strings.length; i++){
            integers.add(Integer.parseInt(strings[i]));
        }
        return integers;
    }
}