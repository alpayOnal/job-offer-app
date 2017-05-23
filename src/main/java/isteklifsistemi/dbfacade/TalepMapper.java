package isteklifsistemi.dbfacade;


import isteklifsistemi.model.Talep;
import isteklifsistemi.service.TalepKatalogu;

/**
 * Created by alpay on 5/21/17.
 */
public class TalepMapper implements IMapper{

    private TalepKatalogu  talepKatalogu;

    public TalepMapper(TalepKatalogu talepKatalogu) {
        this.talepKatalogu = talepKatalogu;
    }

    @Override
    public Object get(Long OID) {
        return talepKatalogu.findOne(OID);
    }

    @Override
    public Object put(Object obj) {
        return talepKatalogu.save((Talep) obj);
    }
}
