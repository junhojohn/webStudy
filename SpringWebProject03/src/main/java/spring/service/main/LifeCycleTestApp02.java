package spring.service.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class LifeCycleTestApp02 {

	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("src/main/resources/config/lifecycleservice02.xml"));
		beanFactory.getBean("lifecycle04");
		beanFactory.getBean("lifecycle05");
	}

}
