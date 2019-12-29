package com.yunhua.test;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.cfg.Configuration;
import com.yunhua.pojo.Person;  
/*
 * 
 * 手动导入hibernate jar包进行hibernate的使用
 * */

public class TestHibernate {
	
	public static void main(String[] args) {
		
		//读取hibernate.cfg.xml文件  
        Configuration cfg = new Configuration();
        cfg.configure();  
        //建立SessionFactory  
        SessionFactory factory =cfg.buildSessionFactory();  
        //取得session  
        Session session = null; 
        try{  
            //开启session  
            session = factory.openSession();  
            //开启事务  
            session.beginTransaction();  
            Person user = new Person();  
            user.setName("zhanshan");  
            user.setAge(36);
            //保存User对象  
            session.save(user);  
            //提交事务  
            session.getTransaction().commit();  
              
        }catch(Exception e){  
            e.printStackTrace();  
            session.getTransaction().rollback();   //回滚事务  
        }finally{  
            if(session != null){  
                if(session.isOpen()){  
                    session.close();   //关闭session  
                }  
            }  
            if(factory != null) {
            	factory.close();//关闭session  
            }
        }  

	}

}
