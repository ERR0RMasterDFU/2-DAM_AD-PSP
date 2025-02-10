package com.salesianostriana.dam.monumentos.services;

import com.salesianostriana.dam.monumentos.models.Monumento;
import com.salesianostriana.dam.monumentos.repositories.MonumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonumentoService {

    @Autowired
    private MonumentoRepository repositorio;

    // OBTENER LISTA DE TODOS LOS MONUMENTOS - FindAll()
    public List<Monumento> obtenerListaMonumentos () {
        return repositorio.findAll();
    }

    // OBTENER MONUMENTO POR ID - FindById()
    public Optional<Monumento> obtenerMonumentoPorId (long id) {
        return repositorio.findById(id);
    }

    // CREAR MONUMENTO - Save()
    public Monumento crearMonumento (Monumento monumento) {
        return repositorio.save(monumento);
    }

    // ACTUALIZAR MONUMENTO - Save()
    public Monumento actualizarMonumento (Monumento monumento, Long id) {

        Monumento mon = null;
        Optional<Monumento> monumentoAEditar = repositorio.findById(id);

        if(monumentoAEditar.isPresent()) {
            mon = monumentoAEditar.get();
            mon = repositorio.save(monumento);
            return mon;
        }else {
            return null;
        }
    }

    // BORRAR MONUMENTO - DeleteById()
    public void borrarMonumentoPorId (long id) {
        repositorio.deleteById(id);
    }

}