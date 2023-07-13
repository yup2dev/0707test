package com.ll.aaaa.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class SiteUser {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String userName;
    @Column
    private String email;
    @Column
    private String password;
}
