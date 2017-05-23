package isteklifsistemi.dbfacade;


import isteklifsistemi.model.SubCategory;
import isteklifsistemi.service.HizmetKatalogu;

/**
 * Created by alpay on 5/21/17.
 */
public class SubCategoryMapper implements IMapper{
    private HizmetKatalogu hizmetKatalogu;

    public SubCategoryMapper(HizmetKatalogu hizmetKatalogu) {
        this.hizmetKatalogu = hizmetKatalogu;
    }

    @Override
    public Object get(Long OID) {
        return hizmetKatalogu.findSubCategoryOne(OID);
    }

    @Override
    public Object put(Object o) {
        return hizmetKatalogu.createSubCategory((SubCategory) o);
    }
}
