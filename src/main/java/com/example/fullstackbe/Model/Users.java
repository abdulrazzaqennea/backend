package com.example.fullstackbe.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotNull
    @Size(min=2,max=30)
    private String business;
    @NotNull
    private String contact;
    @NotNull
    private String license;
    @Size(min=15,max=15)
    private String gst;
    @Pattern(regexp="(^$|[0-9]{10})")
    private String number;
    @Column(unique = true,nullable = false)
    private String password;
    @Column(columnDefinition = "boolean default false")
    private boolean block;
    @Column(columnDefinition = "boolean default false")
    private boolean auth;
    private String role;
}
