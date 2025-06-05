package com.POS.minimercados.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "detalles_venta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = false)
    Venta venta;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    Product producto;

    @Positive(message = "La cantidad debe ser positiva")
    Integer cantidad;

    Double precioUnitario;

    Double subtotal;
}
