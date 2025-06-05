package com.POS.minimercados.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "El nombre no puede estar en blanco")
    String nombre;

    String descripcion;

    @PositiveOrZero(message = "El precio debe ser cero o positivo")
    Double precio;

    @PositiveOrZero(message = "La cantidad debe ser cero o positiva")
    Integer cantidadStock;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    Category categoria;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    Proveedor proveedor;
}
