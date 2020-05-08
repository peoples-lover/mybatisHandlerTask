package com.gb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gb.domain.TypeHandlerDemo;

/**
* <p>
* typeHandler测试 服务类
* </p>
*
* @author quyixiao
* @since 2020-05-07
*/
public interface TypeHandlerDemoService extends IService<TypeHandlerDemo> {



	TypeHandlerDemo selectTypeHandlerDemoById(Long id);


	Long insertTypeHandlerDemo(TypeHandlerDemo typeHandlerDemo);


	int updateTypeHandlerDemoById(TypeHandlerDemo typeHandlerDemo);


	int updateCoverTypeHandlerDemoById(TypeHandlerDemo typeHandlerDemo);


	int deleteTypeHandlerDemoById(Long id);


}