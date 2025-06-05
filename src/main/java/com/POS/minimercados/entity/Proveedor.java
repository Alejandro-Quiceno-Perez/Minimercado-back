package com.POS.minimercados.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "proveedores")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Proveedor {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       Long id;

       @NotBlank(message = "El nombre del proveedor no puede estar en blanco")
       String nombre;

       @NotBlank(message = "El teléfono no puede estar en blanco")
       String telefono;

       @NotBlank(message = "La dirección no puede estar en blanco")
       String direccion;
}
