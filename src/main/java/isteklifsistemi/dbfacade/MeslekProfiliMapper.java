package isteklifsistemi.dbfacade;

import isteklifsistemi.model.MeslekProfili;
import isteklifsistemi.service.MeslekProfiliKatalogu;


/**
 * Created by alpay on 5/21/17.
 */
public class MeslekProfiliMapper implements IMapper{

    private MeslekProfiliKatalogu meslekProfiliKatalogu;

    public MeslekProfiliMapper(MeslekProfiliKatalogu meslekProfiliKatalogu) {
        this.meslekProfiliKatalogu = meslekProfiliKatalogu;
    }

    @Override
    public Object get(Long OID) {
        return meslekProfiliKatalogu.findOne(OID);
    }

    @Override
    public Object put(Object o) {
        return meslekProfiliKatalogu.save((MeslekProfili) o);
    }
}
