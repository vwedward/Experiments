/*
 * ©Edward, 2021
 */

package ru.edward.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 * @author VW
 * Тест Jaxb - демаршализация через JAXB (javax.xml.bind)
 */
public class RunUnmarshaller {

	public static void main(String[] args) throws Exception {
		JAXBContext context = JAXBContext.newInstance(Person.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Person person = (Person) unmarshaller.unmarshal(new File("person.xml"));
		System.out.println(person);
	}

}
