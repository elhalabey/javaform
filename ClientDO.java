/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contactform.dal;

/**
 *
 * @author Halaby
 */
public class ClientDO {
      
int id;
String firstname;
String lastname ;
String email;
int phone;
String message;
String orgname;
String orgloc;

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public void setOrgloc(String orgloc) {
        this.orgloc = orgloc;
    }


    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public String getMessage() {
        return message;
    }

    public String getOrgname() {
        return orgname;
    }

    public String getOrgloc() {
        return orgloc;
    }



}
