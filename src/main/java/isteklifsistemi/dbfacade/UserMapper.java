package isteklifsistemi.dbfacade;


import isteklifsistemi.model.User;
import isteklifsistemi.service.UserKatalogu;

/**
 * Created by alpay on 5/21/17.
 */
public class UserMapper implements IMapper{
    private UserKatalogu userKatalogu;

    public UserMapper(UserKatalogu userKatalogu) {
        this.userKatalogu = userKatalogu;
    }

    @Override
    public Object get(Long OID) {
        return userKatalogu.findOne(OID);
    }

    @Override
    public Object put(Object o) {
        return userKatalogu.save((User) o);
    }
}
