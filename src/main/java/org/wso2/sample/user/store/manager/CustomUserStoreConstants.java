
package org.wso2.sample.user.store.manager;


import org.wso2.carbon.user.api.Property;
import org.wso2.carbon.user.core.UserStoreConfigConstants;
import org.wso2.carbon.user.core.jdbc.JDBCRealmConstants;

import java.util.ArrayList;

public class CustomUserStoreConstants {


    //Properties for Read Active Directory User Store Manager
    public static final ArrayList<Property> CUSTOM_UM_MANDATORY_PROPERTIES = new ArrayList<Property>();
    public static final ArrayList<Property> CUSTOM_UM_OPTIONAL_PROPERTIES = new ArrayList<Property>();
    public static final ArrayList<Property> CUSTOM_UM_ADVANCED_PROPERTIES = new ArrayList<Property>();


    static {

        setMandatoryProperty(JDBCRealmConstants.DRIVER_NAME, "", "Full qualified driver name");
        setMandatoryProperty(JDBCRealmConstants.URL, "", "URL of the user store database");
        setMandatoryProperty(JDBCRealmConstants.USER_NAME, "", "Username for the database");
        setMandatoryProperty(JDBCRealmConstants.PASSWORD, "", "Password for the database");

        setProperty(UserStoreConfigConstants.disabled, "false", UserStoreConfigConstants.disabledDescription);

        setProperty("ReadOnly", "true", "Indicates whether the user store of this realm operates in the user read only mode or not");
        setProperty(UserStoreConfigConstants.SCIMEnabled, "false", UserStoreConfigConstants.SCIMEnabledDescription);


        //Advanced Properties (No descriptions added for each property)
        setAdvancedProperty("SelectUserSQL", "SELECT * FROM CUSTOMER_DATA WHERE CUSTOMER_NAME=?", "");
        setAdvancedProperty("UserFilterSQL", "SELECT CUSTOMER_NAME FROM CUSTOMER_DATA WHERE CUSTOMER_NAME LIKE ?  ORDER BY CUSTOMER_ID", "");

    }


    private static void setProperty(String name, String value, String description) {
        Property property = new Property(name, value, description, null);
        CUSTOM_UM_OPTIONAL_PROPERTIES.add(property);

    }

    private static void setMandatoryProperty(String name, String value, String description) {
        Property property = new Property(name, value, description, null);
        CUSTOM_UM_MANDATORY_PROPERTIES.add(property);

    }

    private static void setAdvancedProperty(String name, String value, String description) {
        Property property = new Property(name, value, description, null);
        CUSTOM_UM_ADVANCED_PROPERTIES.add(property);

    }


}
