package com.example.api02_monumentos.repositories;

import com.example.api02_monumentos.models.Monument;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class MonumentRepository {

    private HashMap<Long, Monument> listMonuments = new HashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    @PostConstruct
    public void init() {
        addMonument(Monument.builder()
                .id(1L)
                .countryCode("ES")
                .countryName("España")
                .cityName("Bilbao")
                .name("Puppy")
                .longitude("2°55′31″ O")
                .latitude("43°15′45″ N")
                .description("Perrito muy alegre hecho de flores.")
                .image("https://media.tacdn.com/media/attractions-splice-spp-674x446/0b/27/a5/f3.jpg")
                .build());
        addMonument(Monument.builder()
                .id(2L)
                .countryCode("MX")
                .countryName("México")
                .cityName("Ciudad de México")
                .name("Ángel de la Independencia")
                .longitude("99°7′39.58″ 0")
                .latitude("19°25′42.49″ N")
                .description("La estatua de bronce de un león gigante con un niño de Rivas Mercado, " +
                        "simboliza al pueblo mexicano “fuerte en la guerra y dócil en la paz.”")
                .image("https://i0.wp.com/historico.alcaldiacuauhtemoc.mx/wp-content/uploads/2020/01/" +
                        "cuauchtemocAngel-de-la-Independencia-destacada.jpg?fit=528%2C453&ssl=1")
                .build());
        addMonument(Monument.builder()
                .id(3L)
                .countryCode("FR")
                .countryName("Francia")
                .cityName("París")
                .name("Torre Eiffel")
                .longitude("2°20′54.96″ E")
                .latitude("48°51′12.24″ N")
                .description("Es una construcción de hierro de 300 metros de altura que fue creada " +
                        "para la Exposición Universal de París de 1889.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Eiffelturm.JPG/280" +
                        "px-Eiffelturm.JPG")
                .build());
    }

    public List<Monument> getAll() {
        return List.copyOf(listMonuments.values());
    }

    public List<Monument> query(String counrtyCode, String sortDirection) {
        List<Monument> data = new ArrayList<>(listMonuments.values());
        List<Monument> result;

        if (counrtyCode.isBlank()) {
            result = data;
        } else {
            result = data
                    .stream()
                    .filter(m -> m.getCountryCode().equals(counrtyCode))
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        if (sortDirection.equalsIgnoreCase("asc"))
            result.sort(Comparator.comparing(Monument::getName));
        else if (sortDirection.equalsIgnoreCase("desc"))
            result.sort(Comparator.comparing(Monument::getName).reversed());

        return Collections.unmodifiableList(result);
    }

    public Optional<Monument> findById(Long id) {
        return Optional.ofNullable(listMonuments.get(id));
    }

    public Monument addMonument(Monument m) {
        long id = counter.incrementAndGet();
        m.setId(id);
        listMonuments.put(m.getId(), m);
        return m;
    }

    public Optional<Monument> editMonument(Long id, Monument newValue) {
        return Optional.ofNullable(listMonuments.computeIfPresent(id, (k, v) -> {
            v.setLatitude(newValue.getLatitude());
            v.setLongitude(newValue.getLongitude());
            v.setCountryName(newValue.getCountryName());
            v.setDescription(newValue.getDescription());
            v.setImage(newValue.getImage());
            v.setCountryCode(newValue.getCountryCode());
            v.setName(newValue.getName());
            v.setCityName(newValue.getCityName());

            return v;
        }));
    }

    public void deleteMonument(Long id) {
        listMonuments.remove(id);
    }

}