package com.gb.sqlutils;

import com.gb.util.DateUtil;
import com.gb.util.OrderUtil;
import com.google.common.base.CaseFormat;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandlerRegistry;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class MysqlUtil {


    public static String field2JavaCode(String field) {
        String javaCode = field;

        javaCode = javaCode.toLowerCase();
        javaCode = javaCode.trim();

        if (javaCode.contains("_")) {
            String[] codes = javaCode.split("_");
            if (codes.length > 1) {
                for (int i = 1; i < codes.length; i++) {
                    codes[i] = (codes[i].substring(0, 1)).toUpperCase()
                            + codes[i].substring(1);
                }
                javaCode = "";
                for (int i = 0; i < codes.length; i++) {
                    javaCode += codes[i];
                }
            }
            return javaCode;

        }
        return field;
    }

    public static String type2JavaTypeFull(String type) {
        String tableType = type.toUpperCase();


        tableType = tableType.trim().toUpperCase();
        String javaType = "";
        if (tableType.indexOf("BIGINT") >= 0) {
            javaType = "java.lang.Long";
        } else if (tableType.indexOf("VARCHAR") >= 0) {
            javaType = "java.lang.String";
        } else if (tableType.indexOf("INT") >= 0) {
            javaType = "java.lang.Integer";
        } else if (tableType.indexOf("DATETIME") >= 0) {
            javaType = "java.util.Date";
        } else if (tableType.indexOf("TEXT") >= 0) {
            javaType = "java.lang.String";
        } else if (tableType.indexOf("DOUBLE") >= 0) {
            javaType = "java.math.BigDecimal";
        } else if (tableType.indexOf("DECIMAL") >= 0) {
            javaType = "java.math.BigDecimal";
        } else if (tableType.indexOf("VARBINARY") >= 0) {
            javaType = "java.lang.String";
        } else {
            javaType = "";
        }

        return javaType;
    }

    public static String type2JavaType(String type) {
        String tableType = type.toUpperCase();

        tableType = tableType.trim().toUpperCase();
        String javaType = "";
        if (tableType.indexOf("BIGINT") >= 0) {
            javaType = "Long";
        } else if (tableType.indexOf("VARCHAR") >= 0) {
            javaType = "String";
        } else if (tableType.indexOf("INT") >= 0) {
            javaType = "Integer";
        } else if (tableType.indexOf("DATETIME") >= 0) {
            javaType = "Date";
        } else if (tableType.indexOf("TEXT") >= 0) {
            javaType = "String";
        } else if (tableType.indexOf("DOUBLE") >= 0) {
            javaType = "BigDecimal";
        } else if (tableType.indexOf("DECIMAL") >= 0) {
            javaType = "BigDecimal";
        } else if (tableType.indexOf("VARBINARY") >= 0) {
            javaType = "String";
        } else {
            javaType = "";
        }

        return javaType;
    }

    public static String tableName2SpaceName(String tableName) {

        String javaCode = tableName.toLowerCase();
        javaCode = javaCode.trim();
        String[] codes = javaCode.split("_");

        javaCode = "";
        if(tableName.startsWith("lsd_") || tableName.startsWith("bi_")
                || tableName.startsWith("arc_") || tableName.startsWith("cl_") ){
            for (int i = 1; i < codes.length; i++) {
                codes[i] = (codes[i].substring(0, 1)).toUpperCase()
                        + codes[i].substring(1);

                javaCode += codes[i];
            }

        }else{
            for (int i = 0; i < codes.length; i++) {
                codes[i] = (codes[i].substring(0, 1)).toUpperCase()
                        + codes[i].substring(1);

                javaCode += codes[i];
            }
        }

        return javaCode;

    }


    public static String getFirstToLower(String str) {
        String a = str.substring(0,1);
        String b = str.substring(1,str.length());
        return a.toLowerCase() + b;

    }


    /**
     * 驼峰法转下划线
     *
     * @param line 源字符串
     * @return 转换后的字符串
     */
    public static String camel2Underline(String line) {
        if (line == null || "".equals(line)) {
            return "";
        }
        try {
            return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, line);
        } catch (Exception e) {
            log.error("line=" + line, e);
        }
        return "";
    }



    public static String showSql(Configuration configuration, BoundSql boundSql) {
        try {
            Map<String,String> listMap = new HashMap<>();
            Object parameterObject = boundSql.getParameterObject();
            List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
            String sql = boundSql.getSql().replaceAll("[\\s]+", " ");
            if (parameterMappings.size() > 0 && parameterObject != null) {
                TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
                if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                    String value = getParameterValue(parameterObject);
                    if (value.contains("?")) {
                        String key =  OrderUtil.getUserPoolOrder("rn");
                        listMap.put(key,value);
                        value = key;
                    }
                    sql = sql.replaceFirst("\\?", value);
                } else {
                    MetaObject metaObject = configuration.newMetaObject(parameterObject);
                    for (ParameterMapping parameterMapping : parameterMappings) {
                        String propertyName = parameterMapping.getProperty();
                        if (metaObject.hasGetter(propertyName)) {
                            Object obj = metaObject.getValue(propertyName);
                            String value = getParameterValue(obj);
                            if (value.contains("?")) {
                                String key =  OrderUtil.getUserPoolOrder("rn");
                                listMap.put(key,value);
                                value = key;
                            }
                            sql = sql.replaceFirst("\\?", value);
                        } else if (boundSql.hasAdditionalParameter(propertyName)) {
                            Object obj = boundSql.getAdditionalParameter(propertyName);

                            String value = getParameterValue(obj);
                            if (value.contains("?")) {
                                String key =  OrderUtil.getUserPoolOrder("rn");
                                listMap.put(key,value);
                                value = key;
                            }
                            sql = sql.replaceFirst("\\?", value);
                        }
                    }
                }
            }
            if(!listMap.isEmpty()){
                for (Map.Entry<String, String> m : listMap.entrySet()) {
                    sql = sql.replaceAll(m.getKey(),m.getValue());
                }
            }
            return sql;
        } catch (Exception e) {
            log.error("showSql exception ", e);
        }
        return "";
    }


    private static String getParameterValue(Object obj) {
        String value = null;
        if (obj instanceof String) {
            if(obj != null && obj.toString().contains("'")){
                value = "\"" + obj.toString() + "\"";
            }else{
                value = "'" + obj.toString() + "'";
            }
        } else if (obj instanceof Date) {

            value = "'" + DateUtil.formatDateToYYYYMMddHHmmss((Date) obj) + "'";
        } else {
            if (obj != null) {
                value = obj.toString();
            } else {
                value = "''";
            }
        }
        return value;
    }


}
