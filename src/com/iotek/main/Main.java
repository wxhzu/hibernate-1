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
		//1.����SessionFactory
		SessionFactory sessionFactory = null;
		//2.����configuration���󣬱���Ҫ������Ļ���������Ϣ��ӳ���ϵ
		Configuration config = new Configuration().configure();
		//3.����Session
		Session session = null;
		//4.��ע����Ϣ����ServiceRegistry�У�Hibernate4.x�汾������
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		//5.��ȡSession
		session = sessionFactory.openSession();
		//6.��������
		Transaction tx = session.beginTransaction();
		//7.������Ҫ�����ݿ����
		User user = new User();
		user.setName("haha1");
		session.save(user);
		//8.�ύ����
		tx.commit();
		//9.�ر���Դ
		session.close();
		sessionFactory.close();
	}
}






