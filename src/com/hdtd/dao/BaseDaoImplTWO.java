package com.hdtd.dao;

import org.springframework.context.ApplicationContext;

import com.hdtd.domain.BasePojo;
import com.hdtd.domain2.BasePojoTwo;

import tk.mybatis.mapper.common.Mapper;

	public class BaseDaoImplTWO<T extends BasePojoTwo> implements BaseDao{
		
		/**
		 * ��������
		 */
		public void saveOrUpdate(ApplicationContext context, Object obj) throws ClassNotFoundException {
			//��ȡƴ��mapper
			String packageName = "com.hdtd.mapper.";
			String className = obj.getClass().getSimpleName();
			String mapperName = packageName + className + "Mapper";
			
			//��ȡmapper
			Class clazz = Class.forName(mapperName);
			Mapper mapper = context.getBean(clazz);
			T t = (T) obj;
//			System.err.println(t);
			
			Object fromKey = mapper.selectByPrimaryKey(t.getmRID());
//			System.out.println(fromKey);
			System.out.println("��ȡ����");
			
			//��������
			if (fromKey == null) {
				mapper.insert((T) obj);
				System.out.println("Ϊ�ղ���");
			} else {
				mapper.updateByPrimaryKey((T) obj);
				System.out.println("���²���");
			}
		}

	}



