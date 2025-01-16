package com.salesianostriana.dam.ejercicio01_asociaciones.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Categoria {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private Set<Producto> productos = new HashSet<>();

    @OneToMany
    @Builder.Default
    @ToString.Exclude
    private Set<Categoria> categorias = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="categoria_relacion_id", foreignKey = @ForeignKey(name = "fk_categoria_categoria"))
    private Categoria categoriaMismaRelacion;


    // MÉTODOS HELPER -----------------------------------------------------------------------------------------------

    public void addProducto (Producto p) {
        p.setCategoria(this);
        productos.add(p);
    }

    public void removeProducto (Producto p) {
        productos.remove(p);
        p.setCategoria(null);
    }

    public void addCategoria (Categoria c) {
        c.setCategoriaMismaRelacion(this);
        categorias.add(c);
    }

    public void removeProducto (Categoria c) {
        categorias.remove(c);
        c.setCategoriaMismaRelacion(null);
    }


    // EQUALS & HASH CODE --------------------------------------------------------------

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Categoria categoria = (Categoria) o;
        return getId() != null && Objects.equals(getId(), categoria.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

}
