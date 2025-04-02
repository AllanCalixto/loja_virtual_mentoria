package jdev.mentoria.lojavirtual.controller;

import jdev.mentoria.lojavirtual.model.Acesso;
import jdev.mentoria.lojavirtual.repository.AcessoRepository;
import jdev.mentoria.lojavirtual.service.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AcessoController {

    private final AcessoService acessoService;
    private final AcessoRepository acessoRepository;
    
    public AcessoController(AcessoService acessoService, AcessoRepository acessoRepository) {
        this.acessoService = acessoService;
        this.acessoRepository = acessoRepository;
    }
    
    @ResponseBody
    @PostMapping(value = "**/salvarAcesso")
    public ResponseEntity<Acesso> salvarAcesso(@RequestBody Acesso acesso) {
        Acesso acessoSalvo = acessoService.save(acesso);
        return new ResponseEntity<Acesso>(acessoSalvo, HttpStatus.OK);
    }
    
    @ResponseBody
    @DeleteMapping(value = "**/deleteAcesso")
    public ResponseEntity<?> deleteAcesso(@RequestBody Acesso acesso) {
        acessoRepository.deleteById(acesso.getId());
        return new ResponseEntity("Acesso removido!", HttpStatus.OK);
    }
}
