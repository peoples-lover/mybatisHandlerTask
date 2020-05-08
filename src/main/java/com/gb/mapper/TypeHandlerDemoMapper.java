package com.gb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gb.domain.TypeHandlerDemo;
import org.apache.ibatis.annotations.Param;

/**
* <p>
* typeHandler测试 服务类
* </p>
*
* @author admin
* @since 2020-05-07
*/
public interface TypeHandlerDemoMapper extends BaseMapper<TypeHandlerDemo> {


	TypeHandlerDemo selectTypeHandlerDemoById(@Param("id")Long id);


	Long insertTypeHandlerDemo(TypeHandlerDemo typeHandlerDemo);


	int updateTypeHandlerDemoById(TypeHandlerDemo typeHandlerDemo);


	int updateCoverTypeHandlerDemoById(TypeHandlerDemo typeHandlerDemo);


	int deleteTypeHandlerDemoById(@Param("id")Long id);


}