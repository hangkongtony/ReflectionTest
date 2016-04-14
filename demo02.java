package testReflection;

import java.lang.reflect.Method;

import testReflection.bean.User;

public class Demo02 {

	public static void test01()
	{
		User u1 = new User();
		long start = System.currentTimeMillis();
		for(int i = 0 ; i<100000000;i++)
		{
			u1.getName();
		}
		long stop = System.currentTimeMillis();
		System.out.println("耗时:"+(stop-start)+"ms");
	}
	
	public static void test02() throws Exception
	{
		User u2 = new User();
		long start = System.currentTimeMillis();
		Class<User> clazz = (Class<User>) Class.forName("testReflection.bean.User");
		Method me = clazz.getDeclaredMethod("getName", null);
		//me.setAccessible(false);
		for(int i = 0 ; i<100000000;i++)
		{
			me.invoke(u2, null);
		}
		long stop = System.currentTimeMillis();
		System.out.println("耗时:"+(stop-start)+"ms");
	}
	
	public static void test03() throws Exception
	{
		User u2 = new User();
		long start = System.currentTimeMillis();
		Class<User> clazz = (Class<User>) Class.forName("testReflection.bean.User");
		Method me = clazz.getDeclaredMethod("getName", null);
		me.setAccessible(true);
		for(int i = 0 ; i<100000000;i++)
		{
			me.invoke(u2, null);
		}
		long stop = System.currentTimeMillis();
		System.out.println("耗时:"+(stop-start)+"ms");
	}
	public static void main(String[] args) throws Exception {
		test01();
		test02();
		test03();
	}

}
