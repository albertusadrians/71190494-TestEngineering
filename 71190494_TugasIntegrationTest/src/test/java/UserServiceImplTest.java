import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;


public class UserServiceImplTest {
    //Mock User
    User user = Mockito.mock(User.class);
    //Mock UserDAO
    UserDAO userDAO = Mockito.mock(UserDAO.class);
    //Mock SecurityService
    SecurityService securityService = Mockito.mock(SecurityService.class);
    //Instansiasi UserServiceImpl
    UserServiceImpl sut = new UserServiceImpl(userDAO,securityService);

    @Test
    public void verifyGetPassword() throws Exception {
        //sut memanggil method assignPassword()
        sut.assignPassword(user);
        //verifikasi apakah user sudah mendapatkan password setelah object sut memanggil method assignPassword
        verify(user).getPassword();
    }

    @Test
    public void verifyUpdateUser() throws Exception {
        //sut memanggil method assignPassword()
        sut.assignPassword(user);
        //verifikasi apakah method updateUser sudah terpanggil dengan benar saat object sut memanggil method assignPassword
        verify(userDAO).updateUser(user);
    }
}
