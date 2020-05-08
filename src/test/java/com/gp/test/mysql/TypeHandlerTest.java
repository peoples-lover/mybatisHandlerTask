package com.gp.test.mysql;

import com.gb.MybatisApplication;
import com.gb.domain.TypeHandlerDemo;
import com.gb.service.TypeHandlerDemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MybatisApplication.class)
public class TypeHandlerTest {

    @Autowired
    private TypeHandlerDemoService typeHandlerDemoService;

    @Test
    public void testSelect(){
       TypeHandlerDemo typeHandlerDemo = typeHandlerDemoService.selectTypeHandlerDemoById(2L);
       System.out.println(typeHandlerDemo.toString());
    }

    @Test
    public void testSave(){
        TypeHandlerDemo typeHandlerDemo = new TypeHandlerDemo();
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        typeHandlerDemo.setTypeHandler(integers);
        typeHandlerDemoService.insertTypeHandlerDemo(typeHandlerDemo);
        System.out.println(typeHandlerDemo.toString());
    }
}
