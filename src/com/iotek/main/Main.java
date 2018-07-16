package com.iotek.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.iotek.entity.User;

public class Main {
	public static void main(String[] args) {
		//1.创建SessionFactory
		SessionFactory sessionFactory = null;
		//2.创建configuration对象，必须要根据你的基本配置信息和映射关系
		Configuration config = new Configuration().configure();
		//3.创建Session
		Session session = null;
		//4.把注册信息传入ServiceRegistry中，Hibernate4.x版本的做法
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		//5.获取Session
		session = sessionFactory.openSession();
		//6.开启事务
		Transaction tx = session.beginTransaction();
		//7.进行你要的数据库操作
		User user = new User();
		user.setName("haha1");
		session.save(user);
		//8.提交事务
		tx.commit();
		//9.关闭资源
		session.close();
		sessionFactory.close();
	}
}






