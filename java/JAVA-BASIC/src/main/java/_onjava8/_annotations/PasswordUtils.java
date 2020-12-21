package _onjava8._annotations;

import java.util.List;

public class PasswordUtils {

    @UseCase(id = 45, description = "passwords must contain at least one numeric")
    public boolean validatePassword(String passwd) {
        return (passwd.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 23)
    public String encryptPassword(String passwd) {
        return new StringBuilder(passwd)
                .reverse().toString();
    }

    @UseCase(id = 49, description = "New password can't equal used one")
    public boolean checkForNewPassword(
            List<String> prevPasswords, String passwd) {
        return !prevPasswords.contains(passwd);
    }

}
