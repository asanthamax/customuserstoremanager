/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wso2.sample.user.store.manager.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.user.core.listener.UserOperationEventListener;
import org.wso2.carbon.user.core.service.RealmService;
import org.wso2.sample.user.store.manager.DataHolder;

/**
 *
 * @author thilina
 */
public class CustomUserOperationEventListenerDSComponent {
    
     private static Log log = LogFactory.getLog(CustomUserOperationEventListenerDSComponent.class);
    private static RealmService realmService;
    
    protected void activate(ComponentContext context)
    {
        context.getBundleContext().registerService(UserOperationEventListener.class.getName(),DataHolder.getInstance().getCustomUserOperationEventListener(),null);        
        log.info("Event Listener Service Started...");
    }
    
    protected void deactivate(ComponentContext context)
    {
        if(log.isDebugEnabled())
        {
            log.info("Event Listener deactivated");
        }
    }
    
    protected void setRealmService(RealmService realmService) {
        if (log.isDebugEnabled()) {
            log.debug("Setting the Realm Service");
        }
        DataHolder.getInstance().setRealmService(realmService);
    }

    protected void unsetRealmService(RealmService realmService) {
        if (log.isDebugEnabled()) {
            log.debug("UnSetting the Realm Service");
        }
        DataHolder.getInstance().setRealmService(null);
    }
}
