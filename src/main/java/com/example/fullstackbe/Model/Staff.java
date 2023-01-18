package com.example.fullstackbe.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Staff implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotBlank(message = "Enter the position")
    private String position;
    @NotBlank(message = "Enter the Name")
    private String name;
    @NotNull(message = "Enter the phone number")
    @Min(6000000000L)
    @Max(9999999999L)
    private long number;
    @NotBlank(message = "Enter the position")
    @Email(message = "Enter a valid email address")
    private String email;
}
