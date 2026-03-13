package com.klef.fsad.exam;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;

public class ClientDemo {

 public static void main(String[] args) {

  SessionFactory factory =
   new Configuration().configure().buildSessionFactory();

  Session session = factory.openSession();

  Transaction tx = session.beginTransaction();

  // INSERT RECORD

  Ticket t = new Ticket();

  t.setName("Movie Ticket");

  t.setDate(new Date());

  t.setStatus("Booked");

  session.save(t);

  // HQL UPDATE USING POSITIONAL PARAMETERS

  String hql =
   "update Ticket set name=?, status=? where id=?";

  Query query = session.createQuery(hql);

  query.setParameter(1,"Concert Ticket");

  query.setParameter(2,"Confirmed");

  query.setParameter(3,1);

  int result = query.executeUpdate();

  System.out.println("Rows Updated: "+result);

  tx.commit();

  session.close();

  factory.close();

 }
}