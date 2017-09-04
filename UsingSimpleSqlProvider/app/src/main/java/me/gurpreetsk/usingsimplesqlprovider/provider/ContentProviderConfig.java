package me.gurpreetsk.usingsimplesqlprovider.provider;

import ckm.simple.sql_provider.UpgradeScript;
import ckm.simple.sql_provider.annotation.ProviderConfig;
import ckm.simple.sql_provider.annotation.SimpleSQLConfig;

/**
 * Created by Gurpreet on 04/09/17.
 */

@SimpleSQLConfig(name = "MyProvider",
        authority = "me.gurpreetsk.usingsimplesqlprovider",
        database = "myDb.db",
        version = 1)
public class ContentProviderConfig implements ProviderConfig {
    @Override
    public UpgradeScript[] getUpdateScripts() {
        return new UpgradeScript[0];
    }
}
