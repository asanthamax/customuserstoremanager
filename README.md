# customuserstoremanager

here i created the custom user store manager by extending the exsisting JDBCUserstore manager class in wso2 identity server in the custom user store 
i override the doAuthenticate method to track the lastPasswordResetTime through new user claim in wso2IS and there i check the password
reset time is greater than 65 days if it is greater than 65 days giving a error message which password is expired and reset a new password
and also in addition to CustomUserStoreManager Class i created the CustomEventlistener Class by extending the CustomUserStoreManager class
and override it's methods doUpdateCredentials and doUpdateCredentialByAdmin to track the lastPasswordReset timestamp whenever user change his password 
this event will trigger
