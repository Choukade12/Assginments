package org.example.service;

import org.example.entity.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AddressServiceImple implements AddressService {
    private final SessionFactory sessionFactory;

    public AddressServiceImple(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveAdd(Address address) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(address);
        transaction.commit();
        System.out.println("Address added Created");    }
}
