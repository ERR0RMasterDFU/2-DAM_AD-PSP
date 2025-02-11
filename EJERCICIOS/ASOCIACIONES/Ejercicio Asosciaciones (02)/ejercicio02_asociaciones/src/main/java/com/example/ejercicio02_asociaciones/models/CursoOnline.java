package com.example.ejercicio02_asociaciones.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class CursoOnline {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private double puntuacion;

    @ManyToOne
    @JoinColumn(name = "profesor_id", foreignKey = @ForeignKey(name = "fk_curso_online_profesor"))
    private Profesor profesor;

    @OneToMany(mappedBy = "curso",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    private List<Video> videos = new ArrayList<>();

    // HELPERS

    private void addVideo (Video v) {
        v.setCurso(this);
        this.videos.add(v);
    }

    private void removeVideo (Video v) {
        this.videos.remove(v);
        v.setCurso(null);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CursoOnline that = (CursoOnline) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
