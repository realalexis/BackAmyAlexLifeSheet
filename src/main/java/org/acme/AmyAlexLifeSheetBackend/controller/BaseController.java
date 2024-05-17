package org.acme.AmyAlexLifeSheetBackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
public abstract class BaseController<Entity, ID> {
    private final JpaRepository<Entity, ID> repository;

    @Autowired
    public BaseController(JpaRepository<Entity, ID> repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Entity> create(@RequestBody Entity entity) {
        Entity savedEntity = repository.save(entity);
        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Entity> getById(@PathVariable ID id) {
        Optional<Entity> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            return ResponseEntity.ok(optionalEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Entity>> getAll() {
        List<Entity> entities = repository.findAll();
        return ResponseEntity.ok(entities);
    }

    @PutMapping("{id}")
    public ResponseEntity<Entity> update(@PathVariable ID id, @RequestBody Entity entity) {
        if (repository.existsById(id)) {
            entity = repository.save(entity);
            return ResponseEntity.ok(entity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}