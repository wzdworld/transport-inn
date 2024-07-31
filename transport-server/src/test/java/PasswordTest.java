import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

public class PasswordTest {
    @Test
    public void getMd5Password() {
        String originalPassword = "123456";
        String md5Password = DigestUtils.md5DigestAsHex(originalPassword.getBytes());
        System.out.println(md5Password);// e10adc3949ba59abbe56e057f20f883e

    }

}
