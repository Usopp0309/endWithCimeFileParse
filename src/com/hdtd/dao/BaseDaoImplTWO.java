package com.hdtd.dao;

import org.springframework.context.ApplicationContext;

import com.hdtd.domain.BasePojo;
import com.hdtd.domain2.BasePojoTwo;

import tk.mybatis.mapper.common.Mapper;

	public class BaseDaoImplTWO<T extends BasePojoTwo> implements BaseDao{
		
		/**
		 * 插入或更新
		 */
		public void saveOrUpdate(ApplicationContext context, Object obj) throws ClassNotFoundException {
			//获取拼接mapper
			String packageName = "com.hdtd.mapper.";
			String className = obj.getClass().getSimpleName();
			String mapperName = packageName + className + "Mapper";
			
			//获取mapper
			Class clazz = Class.forName(mapperName);
			Mapper mapper = context.getBean(clazz);
			T t = (T) obj;
//			System.err.println(t);
			
			Object fromKey = mapper.selectByPrimaryKey(t.getmRID());
//			System.out.println(fromKey);
			System.out.println("获取主键");
			
			//插入或更新
			if (fromKey == null) {
				mapper.insert((T) obj);
				System.out.println("为空插入");
			} else {
				mapper.updateByPrimaryKey((T) obj);
				System.out.println("跟新插入");
			}
		}

	}



