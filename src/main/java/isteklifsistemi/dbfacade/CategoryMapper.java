package isteklifsistemi.dbfacade;


import isteklifsistemi.model.Category;
import isteklifsistemi.service.HizmetKatalogu;

/**
 * Created by alpay on 5/21/17.
 */
public class CategoryMapper implements IMapper{

    private HizmetKatalogu hizmetKatalogu;

    public CategoryMapper(HizmetKatalogu hizmetKatalogu) {
        this.hizmetKatalogu = hizmetKatalogu;
    }

    @Override
    public Object get(Long OID) {
        return hizmetKatalogu.findCategoryOne(OID);
    }

    @Override
    public Object put(Object o) {
        return hizmetKatalogu.create((Category) o);
    }
}
