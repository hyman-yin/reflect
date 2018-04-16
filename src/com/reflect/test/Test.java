package com.reflect.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Test {
	public static void main(String[] args) {
		try {
			Class c = Class.forName("com.reflect.util.Person");
			Field[] fields = c.getDeclaredFields();

			StringBuffer sb = new StringBuffer();
			sb.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName() + " {\n");
			for (Field field : fields) {
				sb.append("\t");
				sb.append(Modifier.toString(field.getModifiers()) + " ");
				sb.append(field.getType().getSimpleName() + " ");
				sb.append(field.getName() + ";\n");
			}

			Constructor[] fields2=c.getConstructors();
			for(Constructor constructor: fields2){
				sb.append("\tpublic "+c.getSimpleName()+" (");
				Type[] typeList=constructor.getGenericParameterTypes();
				for (Type paramType : typeList) {
					sb.append(paramType.getTypeName());
					sb.append(",");
				}
				sb.append(");\n");
			}
			
			
			
			Method[] methods = c.getMethods();
			sb.append("\n");
			for (Method method : methods) {
				sb.append("\t");
				sb.append(Modifier.toString(method.getModifiers()) + " ");
				sb.append(method.getReturnType().getSimpleName() + " ");
				sb.append(method.getName() + "(");

				Type[] paramTypeList = method.getGenericParameterTypes();// 方法的参数列表
				for (Type paramType : paramTypeList) {
					sb.append(paramType.getTypeName());
					sb.append(",");
				}
				sb.append(") {}");
				sb.append("\n");
			}

			sb.append("}");
			System.out.println(sb);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
