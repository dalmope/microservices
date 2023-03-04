package com.example.monolith.client;

import com.example.monolith.dto.PhotoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "image-service", path = "/photo")
public interface IPhotoClient {

    @GetMapping
    public ResponseEntity<List<PhotoDto>> getAllPhotos();

    @GetMapping("/{photoId}")
    public ResponseEntity<PhotoDto> getPhotoById(@PathVariable String photoId);

    @PostMapping
    public ResponseEntity<PhotoDto> savePhoto(@RequestBody PhotoDto photoDto);

    @PutMapping
    public ResponseEntity<Void> updatePokemon(@RequestBody PhotoDto photoDto);

    @DeleteMapping("/{photoId}")
    public ResponseEntity deletePhotoById(@PathVariable String photoId);

}

