package app.constants;
/**
 *
 * @author Siergus
 */
public final class Mappings {
    public static final String API = "/api";
    public static final String USERS = "/users";
    public static final String USER_INFO = "/user_info";
    public static final String TRAINING_PLAN = "/training_plan";
    public static final String TRAINING = "/training";
    public static final String EXERCISE = "/exercise";
    
    public static final String USER_CREATE = "/";
    public static final String USER_DELETE = "/{id}/";
    public static final String USER_GET_ALL = "/";
    public static final String USER_GET_BY_ID = "/{id}/";
    public static final String USER_UPDATE = "/{id}/";
    
    public static final String USER_INFO_UPDATE = "/{userId}/";
    public static final String USER_INFO_GET = "/{userId}/";
    public static final String USER_INFO_GET_ALL = "/";
    public static final String USER_INFO_CREATE = "/{userId}/";
    
    public static final String TRAINING_PLAN_CREATE = "/{userId}/";
    public static final String TRAINING_PLAN_DELETE = "/{id}/";
    public static final String TRAINING_PLAN_UPDATE = "/{id}/";
    public static final String TRAINING_PLAN_GET_ALL = "/";
    public static final String TRAINING_PLAN_GET_ALL_BY_USERID = "/{userId}/";
    
    public static final String TRAINING_CREATE = "/{trainingPlanId}/";
    public static final String TRAINING_DELETE = "/{id}/";
    public static final String TRAINING_UPDATE = "/{id}/";
    public static final String TRAINING_GET_ALL = "/";
    public static final String TRAINING_FOR_TRAINING_PLAN = "/{trainingPlanId}/";
    
    public static final String EXERCISE_CREATE = "/{trainingId}/";
    public static final String EXERCISE_DELETE = "/{id}/";
    public static final String EXERCISE_UPDATE = "/{id}/";
    public static final String EXERCISE_GET_ALL = "/";
    public static final String EXERCISE_FOR_TRAINING = "/{trainingId}/";

}