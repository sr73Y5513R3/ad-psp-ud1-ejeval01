package com.salesianostriana.dam.resteval;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/place/")
public class PlaceController {

    private PlaceRepository placeRepository;

    @GetMapping
    public ResponseEntity<List<Place>> getPlaces() {
        return ResponseEntity.ok(placeRepository.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Place>> findByid(@PathVariable Long id){
        return ResponseEntity.ok(placeRepository.get(id));
    }

    /*

    @PostMapping
    public ResponseEntity<Place> create(@RequestBody Place place){
        return ResponseEntity.created(placeRepository.add(place));
    }

    */
    @PutMapping("{id}")
    public ResponseEntity<Optional<Place>> update(@PathVariable Long id, @RequestBody Place place){
        return ResponseEntity.ok(placeRepository.edit(id, place));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Optional<Place>> delete(@PathVariable Long id){
        placeRepository.delete(id);
        return ResponseEntity.noContent().build();
    }

}
