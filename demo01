package testReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import testReflection.bean.User;

/**
 * 1:Class.forName()
 * 2:.class
 * 3:object.getClass()
 * @author phk
 *
 */
public class Demo01 {

	public static void main(String[] args) {
		String path = "testReflection.bean.User";
		try {
			Class<?> clazz = Class.forName(path);
			User user = (User) clazz.newInstance();
			System.out.println(user.getName());
			
			Constructor<User> con = (Constructor<User>)clazz.getDeclaredConstructor(int.class,int.class,String.class);
			
			User user2 = con.newInstance(1,18,"dfd");
			System.out.println(user2.getName());
			
			User u3 = (User) clazz.newInstance();
			//直接调用
			u3.setName("gaoqi");
			//反射调用
			//方法名成了String类型，可以动态调用你想要调用的方法
			Method me = clazz.getDeclaredMethod("setName", String.class);
			me.invoke(u3, "gaoqiyo");
			System.out.println(u3.getName());
			
			User u4 = (User) clazz.newInstance();
			Field f = clazz.getDeclaredField("name");
			f.setAccessible(true);
			f.set(u4, "penghangkong");
			System.out.println(u4.getName());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
