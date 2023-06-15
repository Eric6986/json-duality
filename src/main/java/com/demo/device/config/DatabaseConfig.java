package com.demo.device.config;

import com.demo.device.oci.OciHelperBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Autowired
    OciHelperBean ociHelperBean;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    private String userName;

    private String password;


    @Bean
    public DataSource getDataSource() {

        String adbUsernameOcid = ociHelperBean.getAdbUsernameOcid();
        String adbPasswordOcid = ociHelperBean.getAdbPasswordOcid();

        if(adbUsernameOcid != null && adbUsernameOcid.startsWith("ocid1.vaultsecret") && adbPasswordOcid != null && adbPasswordOcid.startsWith("ocid1.vaultsecret")) {
            try {
                String adbUserName = ociHelperBean.getSecretValue(adbUsernameOcid);
                String adbPassword = ociHelperBean.getSecretValue(adbPasswordOcid);
                if(adbUserName != null && adbPassword != null) {
                    this.userName = adbUserName;
                    this.password = adbPassword;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Unable to get  OCI Secrets");
            }
        }

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(dbUrl);
        dataSourceBuilder.username(userName);
        dataSourceBuilder.password(password);

        return dataSourceBuilder.build();
    }
}
