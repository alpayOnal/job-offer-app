package isteklifsistemi.controller;

import isteklifsistemi.Register;
import isteklifsistemi.SecurityConfig;
import isteklifsistemi.model.Teklif;
import isteklifsistemi.service.TeklifKatalogu;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/teklifler")
public class TeklifController {

    private Register register;
    private TeklifKatalogu teklifKatalogu;

    public TeklifController(Register register, TeklifKatalogu teklifKatalogu) {
        this.register = register;
        this.teklifKatalogu = teklifKatalogu;
    }

    @GetMapping
    public Iterable<Teklif> getAll() {
        return teklifKatalogu.findAll();
    }

    @GetMapping("/{id}")
    public Teklif get(@PathVariable long id) {
        return teklifKatalogu.findOne(id);
    }

    @PostMapping
    public Teklif create(@RequestBody Teklif teklif, @AuthenticationPrincipal SecurityConfig.AuthenticatedUser authenticated) {
        teklif.setUser(authenticated.getUser());
        teklif = teklifKatalogu.save(teklif);
        return teklif;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id, @AuthenticationPrincipal SecurityConfig.AuthenticatedUser authenticated) {
        Teklif teklif = teklifKatalogu.findOne(id);
        if (teklif.getUser().getId() == authenticated.getUser().getId())
            teklifKatalogu.delete(id);
    }

}