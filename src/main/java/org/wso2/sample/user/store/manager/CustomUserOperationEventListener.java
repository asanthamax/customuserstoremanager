/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wso2.sample.user.store.manager;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.user.core.UserStoreException;

/**
 *
 * @author thilina
 */
public class CustomUserOperationEventListener extends CustomUserStoreManager {
    
    private static Log log = LogFactory.getLog(CustomUserOperationEventListener.class);
    private static final String LAST_PASSWORD_RESET_CLAIM = "http://wso2.org/claims/lastPasswordResetTimestamp";
     @Override
    public void doUpdateCredential(String userName, Object newCredential, Object oldCredential) throws UserStoreException {
        try{
            super.doUpdateCredential(userName, newCredential, oldCredential);
            long lastPasswordResetTime = System.currentTimeMillis();
            Map<String,String> claimMap = new HashMap<String, String>();
            claimMap.put(LAST_PASSWORD_RESET_CLAIM,Long.toString(lastPasswordResetTime));
            this.setUserClaimValues(userName, claimMap,null);
            log.info("Password Resetted Successfully at "+lastPasswordResetTime);
        }catch(Exception ex){
            log.error("Authentication Fail Cannot reset timestamp "+ex.getLocalizedMessage());
            throw new UserStoreException("Password Update");
        }
    }

    @Override
    public void doUpdateCredentialByAdmin(String userName, Object newCredential) throws UserStoreException {
         
        try{
            super.doUpdateCredentialByAdmin(userName, newCredential);
            long lastPasswordResetTime = System.currentTimeMillis();
            Map<String,String> claimMap = new HashMap<String, String>();
            claimMap.put(LAST_PASSWORD_RESET_CLAIM,Long.toString(lastPasswordResetTime));
            this.setUserClaimValues(userName, claimMap,null);
            log.info("Password Resetted Successfully at "+lastPasswordResetTime);
        }catch(Exception ex){
            log.error("Authentication Fail Cannot reset timestamp "+ex.getLocalizedMessage());
            throw new UserStoreException("Password Update");
        }
    }
}
