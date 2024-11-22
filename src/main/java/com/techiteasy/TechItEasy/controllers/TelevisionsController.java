package com.techiteasy.TechItEasy.controllers;

import com.techiteasy.TechItEasy.exceptions.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class TelevisionsController {

    List <String> TelevisionDatabase = new ArrayList<>();


   /* @GetMapping("/api/televisions")
    public ResponseEntity<String> getTelevisions() {
        return ResponseEntity.ok("television");
    }*/

    @GetMapping("/api/televisions")
    public List<String> getTelevisionDatabase() {
        if (TelevisionDatabase.isEmpty()){
            throw new RecordNotFoundException("Geen resulaten in database");
        }
        return TelevisionDatabase;
    }

    /*@GetMapping("/api/televisions/{id}")
    public ResponseEntity<String> getTelevisionById(@PathVariable int id) {
        return ResponseEntity.ok("television");
    }*/

    @GetMapping("/api/televisions/{id}")
    public String getTelevisionDatabaseById(@PathVariable int id){
        if (id >= TelevisionDatabase.size()){
            throw new RecordNotFoundException("id bestaat niet");
        }
        return TelevisionDatabase.get(id);
    }

    /*@PostMapping("/api/televisions")
    public ResponseEntity<String> addTelevision(@RequestBody String title) {
        return ResponseEntity.created(null).body("television");
    }*/

    @PostMapping("api/televisions")
    public String addTelevision(@RequestBody String newTelevision){
        TelevisionDatabase.add(newTelevision);
        return newTelevision;
    }

    /*@PutMapping("/api/televisions/{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable int id, @RequestBody String tvTitle){
        return ResponseEntity.noContent().build();
    }*/

    @PutMapping("/api/televisions/{id}")
    public String updateTelevision(@PathVariable int id, @RequestBody String tvTitle){
        if (id >= TelevisionDatabase.size()){
            throw new RecordNotFoundException("id bestaat niet");
        }
        TelevisionDatabase.set(id, tvTitle);
        return TelevisionDatabase.get(id);
    }

    /*@DeleteMapping("/api/televisions/{id}")
    public ResponseEntity<String> deleteTv(@PathVariable int id){
        return ResponseEntity.noContent().build();
    }
*/
    @DeleteMapping("/api/televisions/{id}")
    public String deleteTv(@PathVariable int id){
        if (id >= TelevisionDatabase.size()){
            throw new RecordNotFoundException("id bestaat niet");
        }
        return TelevisionDatabase.remove(id);
    }


}
