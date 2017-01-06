package app.constants;
/**
 *
 * @author Siergus
 */
public final class Mappings {
    public static final String API = "/api";
    public static final String USERS = "/users";
    public static final String USER_INFO = "/user_info";
    
    public static final String USER_CREATE = "/";
    public static final String USER_DELETE = "/{id}";
    public static final String USER_GET_ALL = "/";
    public static final String USER_GET_BY_ID = "/id/{id}";
    public static final String USER_GET_BY_EMAIL = "/email/{email}";
    public static final String USER_UPDATE = "/{id}";
    
    public static final String USER_INFO_UPDATE = "/{userId}";
    public static final String USER_INFO_GET = "/{userId}";
    public static final String USER_INFO_GET_ALL = "/";
}
