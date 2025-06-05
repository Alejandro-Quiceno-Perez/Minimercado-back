package com.POS.minimercados.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       Long id;

       @NotBlank(message = "El nombre no puede estar en blanco")
       String username;

       @NotBlank(message = "El apellido no puede estar en blanco")
       String lastName;

       @NotBlank(message = "El email no puede estar en blanco")
       @Email(message = "Debe proporcionar un email válido")
       String email;

       @NotBlank(message = "La contraseña no puede estar en blanco")
       String password;

       @NotBlank(message = "El rol no puede estar en blanco")
       String role; // Ej: ADMIN, CLIENTE, VENDEDOR

       @NotBlank(message = "El número de teléfono no puede estar en blanco")
       String phone;

       @NotBlank(message = "La dirección no puede estar en blanco")
       String address;
}
