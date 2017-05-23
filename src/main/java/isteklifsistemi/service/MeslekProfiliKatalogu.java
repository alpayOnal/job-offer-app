package isteklifsistemi.service;

import isteklifsistemi.model.MeslekProfili;
import isteklifsistemi.model.User;
import isteklifsistemi.repository.MeslekProfiliRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;

/**
 * Created by alpay on 5/21/17.
 */
@Service
public class MeslekProfiliKatalogu {

    private MeslekProfiliRepository meslekProfiliRepository;

    public MeslekProfiliKatalogu(MeslekProfiliRepository meslekProfiliRepository) {
        this.meslekProfiliRepository = meslekProfiliRepository;
    }

    public MeslekProfili findOne(Long id) {
        return meslekProfiliRepository.findOne(id);
    }

    public Iterable<MeslekProfili> findAllByUser(User user) {
        return meslekProfiliRepository.findAllByUser(user);
    }

    public MeslekProfili save(MeslekProfili meslekProfili) {
        return meslekProfiliRepository.save(meslekProfili);
    }

    public void delete(MeslekProfili meslekProfili) {
        meslekProfiliRepository.delete(meslekProfili.getId());
    }
}
