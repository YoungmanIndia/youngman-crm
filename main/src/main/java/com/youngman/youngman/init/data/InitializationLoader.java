package com.youngman.youngman.init.data;

import com.youngman.model.business.services.init.InitializationDatabase;
import com.youngman.model.business.utils.CoreConfiguration;
import com.youngman.youngman.admin.WebUserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class InitializationLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(InitializationLoader.class);

    @Value("${db.init.data:true}")
    private boolean initDefaultData;

    @Inject
    private InitializationDatabase initializationDatabase;

    @Inject
    private WebUserServices userDetailsService;

    @Inject
    private CoreConfiguration configuration;

    @PostConstruct
    public void init() {

        try {

            //Check flag to populate or not the database
            if(!this.initDefaultData) {
                return;
            }

            if (initializationDatabase.isEmpty()) {


                //All default data to be created

                LOGGER.info(String.format("%s : Youngman database is empty, populate it....", "main"));

                initializationDatabase.populate("main");

                userDetailsService.createDefaultAdmin();


            }

        } catch (Exception e) {
            LOGGER.error("Error in the init method",e);
        }

    }
}
