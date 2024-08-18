package com.moger.demo.entities;

import java.util.Date;
import com.moger.demo.DataConstants.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Pattern(regexp = "^[a-zA-Z0-9_.±]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$", message = "Invalid Email")
    private String email;
    private String password;
	@Column(name = "first_name")
	private String firstName;
    private String lastName;
    @Column(name = "gender_id")
	private Gender gender;
    @Column(name = "user_type_id")
	private String userType;
    private Date created_date;
    public User() {
	}
}
