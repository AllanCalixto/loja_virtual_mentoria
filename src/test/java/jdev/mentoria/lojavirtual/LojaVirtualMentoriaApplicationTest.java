package jdev.mentoria.lojavirtual;

import jdev.mentoria.lojavirtual.controller.AcessoController;
import jdev.mentoria.lojavirtual.model.Acesso;
import jdev.mentoria.lojavirtual.repository.AcessoRepository;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = LojaVirtualMentoriaApplication.class)
public class LojaVirtualMentoriaApplicationTest extends TestCase {
    
    @Autowired
    private AcessoController acessoController;
    
    @Autowired
    private AcessoRepository acessoRepository;
    
    
    @Test
    public void testCadastraAcesso() {
        Acesso acesso = new Acesso();
        acesso.setDescricao("ROLE_ADMIN");
        acesso = acessoController.salvarAcesso(acesso).getBody();
        assertEquals("ROLE_ADMIN", acesso.getDescricao());
        assertTrue(acesso.getId() > 0);
        
        Optional<Acesso> acesso2 = acessoRepository.findById(acesso.getId());
        assertTrue(acesso2.isPresent());
        assertEquals(acesso.getId(), acesso2.get().getId());
        
        acessoRepository.deleteById(acesso2.get().getId());
        acessoRepository.flush();
        Acesso acesso3 = acessoRepository.findById(acesso2.get().getId()).orElse(null);
        assertEquals(true, acesso3 == null);
        
        /* Teste de Query */
        acesso = new Acesso();
        acesso.setDescricao("ROLE_ALUNO");
        acesso = acessoController.salvarAcesso(acesso).getBody();
        List<Acesso> acessos = acessoRepository.buscarAcessoDesc("ALUNO".trim().toUpperCase());
        assertEquals(1, acessos.size());
        acessoRepository.deleteById(acesso.getId());
        
        
    }
    
}