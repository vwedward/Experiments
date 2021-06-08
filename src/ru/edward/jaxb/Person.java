/*
 * ©Edward, 2021
 */

package ru.edward.jaxb;

import java.util.List;
import javax.xml.bind.annotation.*;

/**
 * @author VW
 * Тест Jaxb
 */
@XmlRootElement(name = "Person")
@XmlType(propOrder = {"name", "age", "friends"})
public class Person {
	private String name;
	private int Age;
	private List<Person> friends;
	public String getName() {
		return name;
	}
	@XmlElement(name = "Name")
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return Age;
	}
	@XmlElement
	public void setAge(int age) {
		Age = age;
	}
	public List<Person> getFriends() {
		return friends;
	}
	@XmlElement(name = "Friend")
	@XmlElementWrapper
	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}
    @Override
    public String toString() {
        String res = "Person{" +
                "Name='" + name + '\'' +
                ", Age=" + Age + ", friends{";
        if(friends != null){
            for(Person p : friends){
                res += p.toString();
            }
        }
        res += "}}";
        return res;
    }
}
