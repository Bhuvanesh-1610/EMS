package com.expeditors.ems.entity;


import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="user_detail")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="created_at")
    private LocalDateTime createDate;
    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name="role_id", referencedColumnName = "id")




    private Role role;


}