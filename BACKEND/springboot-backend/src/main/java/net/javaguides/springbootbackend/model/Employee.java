package net.javaguides.springbootbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "employess")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "first_name")
  private String firstname;
  @Column(name = "last_name")
  private String Lastname;
  @Column(name = "email_id")
  private String emailId;


  public Employee() {
  }

  public Employee(String firstname, String Lastname, String emailId) {
    this.firstname = firstname;
    this.Lastname = Lastname;
    this.emailId = emailId;
  }


  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstname() {
    return this.firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return this.Lastname;
  }

  public void setLastname(String Lastname) {
    this.Lastname = Lastname;
  }

  public String getEmailId() {
    return this.emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }
}
