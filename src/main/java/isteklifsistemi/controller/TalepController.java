package isteklifsistemi.controller;

import isteklifsistemi.Register;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import isteklifsistemi.SecurityConfig;
import isteklifsistemi.model.Talep;
import isteklifsistemi.service.TalepKatalogu;

@RestController
@RequestMapping("/api/v1/talepler")
public class TalepController {

    private Register register;
    private TalepKatalogu talepKatalogu;

    public TalepController(Register register, TalepKatalogu talepKatalogu) {
        this.register = register;
        this.talepKatalogu = talepKatalogu;
    }


    @GetMapping
    public Iterable<Talep> getAll() {
        return talepKatalogu.findAll();
    }

    @GetMapping("/{id}")
    public Talep get(@PathVariable long id) {
        return talepKatalogu.findOne(id);
    }

    @PostMapping
    public Talep create(@RequestBody Talep talep, @AuthenticationPrincipal SecurityConfig.AuthenticatedUser authenticated) {
        talep.setUser(authenticated.getUser());
        talep = register.talepOlustur(talep);
        return talep;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id, @AuthenticationPrincipal SecurityConfig.AuthenticatedUser authenticated) {
        Talep talep = talepKatalogu.findOne(id);
        if (talep.getUser().getId() == authenticated.getUser().getId())
            talepKatalogu.delete(id);
    }

}
