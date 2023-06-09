package com.g35.reto4.controller;


import com.g35.reto4.dbo.MessageDbo;
import com.g35.reto4.model.MessageModel;
import com.g35.reto4.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping("/all")
    public List<MessageModel> obtener() {
        return messageService.obtener();
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody MessageModel message) {
        messageService.crear(message);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        messageService.eliminar(id);
    }

    @PutMapping("/update")
    public void actualizar(@RequestBody MessageDbo messageDbo) {
        messageService.actualizar(messageDbo);
    }

}

