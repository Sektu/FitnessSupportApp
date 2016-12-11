package app.constants;
/**
 *
 * @author Siergus
 */
public final class Mappings {
    private static final String MAIN_PATH = "/api";
    private static final String USER_PATH = "/user";
    
    public static final String USER_CREATE_BY_EMAIL_AND_PASSWORD = MAIN_PATH + USER_PATH + "/create";
    public static final String USER_DELETE_BY_ID = MAIN_PATH + USER_PATH + "/deleteById";
    public static final String USER_GET_BY_ID = MAIN_PATH + USER_PATH + "/getById";
    public static final String USER_GET_BY_EMAIL = MAIN_PATH + USER_PATH + "/getByEmail";
    public static final String USER_UPDATE_EMAIL_AND_PASSWORD_BY_ID = MAIN_PATH + USER_PATH + "/updateEmailAndPasswordById";
    public static final String USER_UPDATE_PASSWORD_BY_EMAIL = MAIN_PATH + USER_PATH + "/updatePasswordByEmail";
    public static final String USER_GET_ALL_EMAILS = MAIN_PATH + USER_PATH + "/getAllEmails";
}
