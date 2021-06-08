/*
 * ©Edward, 2021
 */

package ru.edward.jaxb;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 * @author VW
 * Тест Jaxb - маршализация через JAXB (javax.xml.bind)
 */
public class RunMarshaller {

	public static void main(String[] args) throws Exception {
		Person person = new Person();
		person.setName("Oleg");
		person.setAge(19);

		Person friend1 = new Person();
		Person friend2 = new Person();

		friend1.setName("Viktor");
		friend1.setAge(20);

		friend2.setName("Stepan");
		friend2.setAge(15);

		List<Person> friends = new ArrayList<>();
		friends.add(friend1);
		friends.add(friend2);

		person.setFriends(friends);

		JAXBContext context = JAXBContext.newInstance(person.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(person, new File("person.xml"));
	}
}
