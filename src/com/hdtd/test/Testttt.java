package com.hdtd.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class Testttt<T> {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String name = "User";
		name = "com.hdtd.test."+name;
		Class forName = Class.forName(name);
		Type type;
		Object object = forName.newInstance();
		
		System.out.println(object);
		System.out.println(forName.getSimpleName());
		List list;
//		Object[] array = list.toArray(args);
		Integer aa = new Testttt<Integer>().aa();
		System.out.println(aa);
		String bb = new Testttt<Integer>().bb("aaaaa");
		System.out.println(bb);
		new Testttt<String>().dd();
//		System.out.println(dd);
	
		
//		List<> cc;
	}
	
	public T aa (){
		T t;
		Integer q = 12;
		t = (T)q;
		return t;
	}
	
	public  <E> E bb (E e){
		return e;
		
	}
	
	public void dd(){
//		ParameterizedType type = null;
//		Type type = this.getClass().getGenericSuperclass();
//		type.getActualTypeArguments();
//		return types[0];
		
//		ParameterizedType pt = (ParameterizedType)getClass().getGenericSuperclass();
//        Class clazz = (Class<T>)pt.getActualTypeArguments()[0];
//		System.out.println(clazz);
		class B extends Testttt<T> {}  ;
		B bsd = new B();
//		bsd.getClass().g
		
		Type type = bsd.getClass().getGenericSuperclass();
		System.out.println(type);
		Type trueType = ((ParameterizedType)type).getActualTypeArguments()[0];  
        System.out.println("trueType1 = " + trueType);  
        Class clazz;
//        List<TableName.BaseVoltage> list = null;
//		this.getClass()
	}
}
