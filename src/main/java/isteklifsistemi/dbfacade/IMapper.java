package isteklifsistemi.dbfacade;


/**
 * Created by alpay on 5/21/17.
 */
public interface IMapper {
    Object get(Long OID);
    Object put(Object obj);
}
