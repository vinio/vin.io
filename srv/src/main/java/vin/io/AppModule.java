package vin.io;

import com.google.common.base.Charsets;
import restx.config.ConfigLoader;
import restx.config.ConfigSupplier;
import restx.factory.Module;
import restx.factory.Provides;
import restx.security.SignatureKey;

import javax.inject.Named;

@Module
public class AppModule {

    @Provides
    public SignatureKey signatureKey() {
        return new SignatureKey("-3680963821866871004 vin.io 327ff6db-c77f-43e7-86f8-d2ed746469a5 vin.io".getBytes(Charsets.UTF_8));
    }

    @Provides
    @Named("restx.admin.password")
    public String restxAdminPassword() {
        return "admin";
    }

    @Provides
    @Named("mongo.db")
    public String dbName() {
        return "vin_dot_io";
    }

    @Provides
    public ConfigSupplier appConfigSupplier(ConfigLoader configLoader) {
        // Load settings.properties in vin.io package as a set of config entries
        return configLoader.fromResource("vin/io/settings");
    }
}
