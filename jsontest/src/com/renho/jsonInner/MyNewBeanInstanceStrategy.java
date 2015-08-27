package com.renho.jsonInner;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.renho.jsonInner.pojo.DataTableParam;

import net.sf.json.JSONObject;
import net.sf.json.util.NewBeanInstanceStrategy;

/**
 * Ð´µÄÊ²Ã´ÆÆÍæÒâ
 * @author renho
 *
 */
public class MyNewBeanInstanceStrategy extends NewBeanInstanceStrategy {

	private final List<Class<?>> innerList = new ArrayList<Class<?>>();
	
	public MyNewBeanInstanceStrategy() {
		innerList.add(DataTableParam.Columns.class);
		innerList.add(DataTableParam.Order.class);
		innerList.add(DataTableParam.Search.class);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object newInstance(Class target, JSONObject source)
			throws InstantiationException, IllegalAccessException,
			SecurityException, NoSuchMethodException, InvocationTargetException {
		final Object[] EMPTY_ARGS = new Object[0];
		final Class[] EMPTY_PARAM_TYPES = new Class[0];
		if (target != null) {
			if(innerList.contains(target)) {
				Constructor<?>[] constructors = target.getConstructors();
				return constructors[0].newInstance(new DataTableParam());
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
