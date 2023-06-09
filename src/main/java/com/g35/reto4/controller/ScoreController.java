package com.g35.reto4.controller;


import com.g35.reto4.dbo.ScoreDbo;
import com.g35.reto4.model.ScoreModel;
import com.g35.reto4.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    ScoreService scoreService;


    @GetMapping("/all")
    public List<ScoreModel> obtener() {
        return scoreService.obtener();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody ScoreModel score) {
        scoreService.crear(score);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        scoreService.eliminar(id);
    }

    @PutMapping("/update")
    public void actualizar(@RequestBody ScoreDbo scoreDbo) {
        scoreService.actualizar(scoreDbo);
    }

}

