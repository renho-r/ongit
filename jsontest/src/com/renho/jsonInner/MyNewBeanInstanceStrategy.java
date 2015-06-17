package com.renho.jsonInner;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import net.sf.json.JSONObject;
import net.sf.json.util.NewBeanInstanceStrategy;

public class MyNewBeanInstanceStrategy extends NewBeanInstanceStrategy {

	@Override
	public Object newInstance(Class target, JSONObject source)
			throws InstantiationException, IllegalAccessException,
			SecurityException, NoSuchMethodException, InvocationTargetException {
		final Object[] EMPTY_ARGS = new Object[0];
		final Class[] EMPTY_PARAM_TYPES = new Class[0];
		if (target != null) {
			System.out.println(target);
			if(true) {
				
			}else {
				Constructor c = target.getDeclaredConstructor(EMPTY_PARAM_TYPES);
				c.setAccessible(true);
				try {
					return c.newInstance(EMPTY_ARGS);
				} catch (InstantiationException e) {
					// getCause() was added on jdk 1.4
					String cause = "";
					try {
						cause = e.getCause() != null ? "\n"
								+ e.getCause().getMessage() : "";
					} catch (Throwable t) { /* ignore */
					}
					throw new InstantiationException(
							"Instantiation of \""
									+ target
									+ "\" failed. "
									+ "It's probably because class is an interface, "
									+ "abstract class, array class, primitive type or void."
									+ cause);
				}
			}
		}
		return null;
	}
}
