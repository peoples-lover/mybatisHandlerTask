package com.gb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gb.domain.TypeHandlerDemo;
import com.gb.mapper.TypeHandlerDemoMapper;
import com.gb.service.TypeHandlerDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* <p>
* typeHandler测试 服务类
* </p>
*
* @author admin
* @since 2020-05-07
*/

@Service
public class TypeHandlerDemoServiceImpl extends ServiceImpl<TypeHandlerDemoMapper, TypeHandlerDemo> implements TypeHandlerDemoService {


    @Autowired
	private TypeHandlerDemoMapper typeHandlerDemoMapper;



	@Override
	public TypeHandlerDemo selectTypeHandlerDemoById(Long id){
		return typeHandlerDemoMapper.selectTypeHandlerDemoById(id);
	}



	@Override
	public Long insertTypeHandlerDemo(TypeHandlerDemo typeHandlerDemo){
		return typeHandlerDemoMapper.insertTypeHandlerDemo(typeHandlerDemo);
	}



	@Override
	public int updateTypeHandlerDemoById(TypeHandlerDemo typeHandlerDemo){
		return typeHandlerDemoMapper.updateTypeHandlerDemoById(typeHandlerDemo);
	}



	@Override
	public int updateCoverTypeHandlerDemoById(TypeHandlerDemo typeHandlerDemo){
		return typeHandlerDemoMapper.updateCoverTypeHandlerDemoById(typeHandlerDemo);
	}



	@Override
	public int deleteTypeHandlerDemoById(Long id){
		return typeHandlerDemoMapper.deleteTypeHandlerDemoById(id);
	}



}
