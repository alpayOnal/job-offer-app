package isteklifsistemi;

import isteklifsistemi.dbfacade.DBFacade;
import isteklifsistemi.model.MeslekProfili;
import isteklifsistemi.model.Talep;
import isteklifsistemi.model.Teklif;
import isteklifsistemi.model.User;
import isteklifsistemi.service.*;
import org.springframework.stereotype.Component;

@Component
public class Register {
    private final TalepKatalogu talepKatalogu;
    private final HizmetKatalogu categoryService;
    private final UserKatalogu userKatalogu;
    private final TeklifKatalogu teklifKatalogu;
    private final MeslekProfiliKatalogu meslekProfiliKatalogu;

    public Register(TalepKatalogu talepKatalogu, HizmetKatalogu categoryService, UserKatalogu userKatalogu,
                    TeklifKatalogu teklifKatalogu, MeslekProfiliKatalogu meslekProfiliKatalogu) {
        this.talepKatalogu = talepKatalogu;
        this.categoryService = categoryService;
        this.userKatalogu = userKatalogu;
        this.teklifKatalogu = teklifKatalogu;
        this.meslekProfiliKatalogu = meslekProfiliKatalogu;
    }

    public Teklif teklifOlustur(Teklif teklif) {
        return (Teklif) DBFacade.put(teklif);
    }

    public Talep talepOlustur(Talep talep) {
        return (Talep) DBFacade.put(talep);
    }

    public MeslekProfili meslekProfiliOustur(MeslekProfili meslekProfili) {
        return (MeslekProfili) DBFacade.put(meslekProfili);
    }

    public User register(User user) {
        return (User) DBFacade.put(user);
    }

    public User login(User user) {
        return  user;
    }

}
