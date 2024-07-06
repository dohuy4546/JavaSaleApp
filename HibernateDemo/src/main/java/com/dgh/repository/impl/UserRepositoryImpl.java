/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dgh.repository.impl;

import com.dgh.hibernatedemo.HibernateUtils;
import com.dgh.pojo.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author admin
 */
public class UserRepositoryImpl {
    public User getUserByUsername(String username) {
        try ( Session s = HibernateUtils.getFactory().openSession()) {
            Query q = s.createNamedQuery("User.findByUsername");
            q.setParameter("username", username);
            return (User) q.getSingleResult();
        }
    }

}
