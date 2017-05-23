package isteklifsistemi.dbfacade;

import isteklifsistemi.model.MeslekProfili;
import isteklifsistemi.model.Talep;
import isteklifsistemi.model.Teklif;
import isteklifsistemi.model.User;
import isteklifsistemi.service.MeslekProfiliKatalogu;
import isteklifsistemi.service.UserKatalogu;
import isteklifsistemi.service.TalepKatalogu;
import isteklifsistemi.service.TeklifKatalogu;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by alpay on 5/21/17.
 */
@Component
public class DBFacade {
    private static HashMap<Class, IMapper> mappers;
    public final  TalepKatalogu talepKatalogu;
    public final TeklifKatalogu teklifKatalogu;
    public final UserKatalogu userKatalogu;
    public final MeslekProfiliKatalogu meslekProfiliKatalogu;


    private static DBFacade uniqueInstance = null;

    public DBFacade(TalepKatalogu talepKatalogu, TeklifKatalogu teklifKatalogu, UserKatalogu userKatalogu, MeslekProfiliKatalogu meslekProfiliKatalogu) {
        this.talepKatalogu = talepKatalogu;
        this.teklifKatalogu = teklifKatalogu;
        this.userKatalogu = userKatalogu;
        this.meslekProfiliKatalogu = meslekProfiliKatalogu;

        mappers = new HashMap<Class, IMapper>();
        mappers.put(Talep.class, new TalepMapper(talepKatalogu));
        mappers.put(Teklif.class, new TeklifMapper(teklifKatalogu));
        mappers.put(User.class, new UserMapper(userKatalogu));
        mappers.put(MeslekProfili.class, new MeslekProfiliMapper(meslekProfiliKatalogu));
    }

    public static DBFacade getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new DBFacade(
                    DBFacade.getUniqueInstance().talepKatalogu,
                    DBFacade.getUniqueInstance().teklifKatalogu,
                    DBFacade.getUniqueInstance().userKatalogu,
                    DBFacade.getUniqueInstance().meslekProfiliKatalogu);
            return uniqueInstance;
        }
        else return uniqueInstance;
    }

    public static Object put(Object obj) {
        IMapper mapper = (IMapper) mappers.get(obj.getClass());
        return mapper.put(obj);
    }

    @SuppressWarnings("unchecked")
    public Object get(Long oid, Class type) {
        IMapper mapper = (IMapper) mappers.get(type);
        return mapper.get(oid);
    }
}
