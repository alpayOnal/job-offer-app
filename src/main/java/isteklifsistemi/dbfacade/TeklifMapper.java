package isteklifsistemi.dbfacade;


import isteklifsistemi.model.Teklif;
import isteklifsistemi.service.TeklifKatalogu;

/**
 * Created by alpay on 5/21/17.
 */
public class TeklifMapper implements IMapper{

    private TeklifKatalogu teklifKatalogu;

    public TeklifMapper(TeklifKatalogu teklifKatalogu) {
        this.teklifKatalogu = teklifKatalogu;
    }

    @Override
    public Object get(Long OID) {
        return teklifKatalogu.findOne(OID);
    }

    @Override
    public Object put(Object o) {
        return teklifKatalogu.save((Teklif) o);
    }
}
