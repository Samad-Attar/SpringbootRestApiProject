package com.example.demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
//import lombok.ToString;
//@Setter
//@Getter
//@ToString
@Entity
@Table(name = "users")
public class User {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	 
    @Column(name = "name") 
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "pincode")
    private String pincode;
   
    @Column(name = "userid")
    private String userid;
   
	
	 public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPincode() {
			return pincode;
		}
		public void setPincode(String pincode) {
			this.pincode = pincode;
		}
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		
	 public User() {
		super();
	}
	
    @Override
	public String toString() {
		return "User [name= "+ name +",id=" + id + ",email=" + email + ",pincode=" +  pincode  + ", userid=" + userid +"]";
	}
	

}
