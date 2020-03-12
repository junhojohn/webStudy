package spring.service.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class LifeCycleTestApp01 {

	public static void main(String[] args) {
		
		BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("src/main/resources/config/lifecycleservice01.xml"));
		beanFactory.getBean("lifecycle01");
		beanFactory.getBean("lifecycle02");
		beanFactory.getBean("lifecycle03");
		beanFactory.getBean("lifecycle04");
		
	}

}
