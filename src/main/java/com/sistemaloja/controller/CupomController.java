package com.sistemaloja.controller;

import com.sistemaloja.dto.CupomDTO;
import com.sistemaloja.dto.CupomViewDTO;
import com.sistemaloja.service.CupomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cupons")
public class CupomController {
    @Autowired
    CupomService cupomService;

    @PostMapping
    public void cadastrar(@RequestBody CupomDTO dto){
        cupomService.cadastrar(dto);
    }

    @GetMapping("/{id}")
    public CupomViewDTO findById(@PathVariable Long id) {
        return cupomService.findById(id);
    }

    @PutMapping("/{id}")
    public void desativaById(@PathVariable Long id) {
        cupomService.desativaById(id);
    }

    @PutMapping
    public void desativaStream() {
        cupomService.desativaStream();
    }


}
