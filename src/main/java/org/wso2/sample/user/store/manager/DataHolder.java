/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wso2.sample.user.store.manager;

import org.wso2.carbon.user.core.service.RealmService;

/**
 *
 * @author thilina
 */
public class DataHolder {
    
     private static RealmService realmService;
    private static volatile DataHolder dataHolder;
    private static CustomUserOperationEventListener customUserOperationEventListener;

    private DataHolder() {

    }

    public static DataHolder getInstance() {

        if (dataHolder == null) {

            synchronized (DataHolder.class) {
                if (dataHolder == null) {
                    dataHolder = new DataHolder();
                    customUserOperationEventListener = new CustomUserOperationEventListener();
                }
            }

        }

        return dataHolder;
    }

    public void setRealmService(RealmService realmService) {
        this.realmService = realmService;
    }

    public RealmService getRealmService() {
        return realmService;
    }

    public CustomUserOperationEventListener getCustomUserOperationEventListener() {
        return customUserOperationEventListener;
    }
}
