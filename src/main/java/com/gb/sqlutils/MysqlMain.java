package com.gb.sqlutils;


import cn.hutool.core.util.StrUtil;
import com.gb.sqlutils.dto.FieldBean;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class MysqlMain {

    public static String package_name = "com.gb";

    public static String save_path = "D:\\temp\\code";

    public static String mysql_url = "jdbc:mysql://127.0.0.1:3306";
    public static String pre = "";

    public static String mysql_dbname = "mysql_task";
    public static String mysql_username = "root";
    public static String mysql_password = "123456";

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        String path = ResourceUtils.getURL("classpath:").getPath();
        System.out.println(path);
        String dir = null;
        if (StrUtil.isNotBlank(path)) {
            dir = path.split("target")[0];
        }
        // 指定位置可以注释这行
        save_path = dir + "src/test/java/tmp";
        File file = new File(save_path);
        if(!file.exists()){
            file.mkdirs();
        }
        List<TablesBean> list = new ArrayList<TablesBean>();

        list.add(new TablesBean("type_handler_demo"));





        List<TablesBean> list2 = new ArrayList<TablesBean>();
        Map<String, String> map = MysqlUtil2ShowCreateTable.getComments();

        for (int i = 0; i < list.size(); i++) {
            TablesBean obj = list.get(i);
            String tableName = list.get(i).getTableName();
            List<FieldBean> itemList = MysqlUtil2ShowCreateTable.readTableDetail(tableName);
            obj.setFieldList(itemList);
            obj.setComment(map.get(tableName));
            list2.add(obj);
        }

        for (int i = 0; i < list2.size(); i++) {
            MysqlUtilTable2Bean.printEntity(list2.get(i));
        }


        for (int i = 0; i < list2.size(); i++) {
            MysqlUtilTable2Contoller.printController(list2.get(i));
        }


        for (int i = 0; i < list2.size(); i++) {
            MysqlUtilTable2Mapper.printDao(list2.get(i));
        }

        for (int i = 0; i < list2.size(); i++) {
            MysqlUtilTable2Service.printService(list2.get(i));
            MysqlUtilTable2Service.printServiceImpl(list2.get(i));
        }


        for (int i = 0; i < list2.size(); i++) {
            MysqlUtilTable2XML.printXMLForMap(list2.get(i));
        }


    }

}




