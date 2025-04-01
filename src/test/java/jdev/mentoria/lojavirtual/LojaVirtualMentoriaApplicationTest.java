package jdev.mentoria.lojavirtual;

import jdev.mentoria.lojavirtual.controller.AcessoController;
import jdev.mentoria.lojavirtual.model.Acesso;
import jdev.mentoria.lojavirtual.repository.AcessoRepository;
import jdev.mentoria.lojavirtual.service.AcessoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = LojaVirtualMentoriaApplication.class)
class LojaVirtualMentoriaApplicationTest {
    
    @Autowired
    private AcessoController acessoController;
    
    
    @Test
    public void testCadastraAcesso() {
        Acesso acesso = new Acesso();
        acesso.setDescricao("ROLE_ADMIN");
        acessoController.salvarAcesso(acesso);
    }
    
}