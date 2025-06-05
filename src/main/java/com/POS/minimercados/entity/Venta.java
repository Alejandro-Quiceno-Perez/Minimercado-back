package com.POS.minimercados.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ventas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Venta {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       Long id;

       @NotNull(message = "La fecha de la venta no puede ser nula")
       LocalDateTime fecha;

       @ManyToOne
       @JoinColumn(name = "cliente_id", nullable = false)
       User cliente; // Solo usuarios con rol CLIENTE

       @ManyToOne
       @JoinColumn(name = "vendedor_id", nullable = false)
       User vendedor; // Solo usuarios con rol VENDEDOR

       @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
       List<DetalleVenta> detalles;

       Double total;
}
