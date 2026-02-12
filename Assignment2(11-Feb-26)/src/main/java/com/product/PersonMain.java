package com.product;


public class PersonMain {

    public static void main(String[] args) {

        PersonDao dao = new PersonDao();

        Person p = new Person();
        p.setId(1);
        p.setName("Naman");
        p.setDob("10-05-2003");
        p.setAddress("Delhi");
        p.setPincode(110001);

        System.out.println(dao.insertPerson(p));

        Person found = dao.findById(1);
        System.out.println(found);

        found.setAddress("Mumbai");
        dao.update(found);

        System.out.println("Updated: " + dao.findById(1));

        System.out.println(dao.deleteById(1));
    }
}

