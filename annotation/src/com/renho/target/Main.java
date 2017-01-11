package com.renho.target;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.renho.target.TestTarget;
import com.renho.target.TestTarget.PARAMETER_RENHO;
import com.renho.target.TestTarget.TYPE_RENHO;
import com.renho.target.pojo.User;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		
		User user = new User();
		
		TYPE_RENHO tr = User.class.getAnnotation(TestTarget.TYPE_RENHO.class);
		String tableName = tr.tableName();
		System.out.println("tableName:" + tableName);
		
		Map<String, String> req = new HashMap<String, String>(){{
			put("p1", "req-P1");
			put("p2", "req-P2");
		}};
		Method[] methods = user.getClass().getDeclaredMethods();
		for(Method method: methods) {
			Annotation[][] annotationss = method.getParameterAnnotations();
			List<Object> params = new ArrayList<Object>();
			if("showParam".equals(method.getName())) {
				 TypeVariable<Method>[] tvs = method.getTypeParameters();
				 for(TypeVariable<Method> tv: tvs) {
					 System.out.println(tv.getName());
				 }
				Type[] types = method.getGenericParameterTypes();
				for(Type type: types) {
					System.out.println(type.toString());
				}
				for(Annotation[] annotations: annotationss) {
					if(annotations.length > 0) {
						for(Annotation annotation: annotations) {
							if(annotation instanceof PARAMETER_RENHO) {
								PARAMETER_RENHO pr = (PARAMETER_RENHO) annotation;
								params.add(req.get(pr.value()));
							}
						}
					}
				}
				if(params.size() > 0) {
					Object back = method.invoke(user, params.toArray());
					System.out.println("a : " + back.toString());				
				}
			}
		}
	}

}
