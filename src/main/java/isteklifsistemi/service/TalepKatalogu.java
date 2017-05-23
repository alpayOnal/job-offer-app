package isteklifsistemi.service;

import isteklifsistemi.model.Talep;
import isteklifsistemi.repository.TalepRepository;
import org.springframework.stereotype.Service;

@Service
public class TalepKatalogu {

    private TalepRepository talepRepository;

    public TalepKatalogu(TalepRepository talepRepository) {
        this.talepRepository = talepRepository;
    }

    public Talep save(Talep talep) {
        return talepRepository.save(talep);
    }

    public Talep findOne(long id) {
        return talepRepository.findOne(id);
    }

    public Iterable<Talep> findAll() {
        return talepRepository.findAll();
    }

    public void delete(long id) {
        talepRepository.delete(id);
    }
}
