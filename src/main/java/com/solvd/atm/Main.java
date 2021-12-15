package com.solvd.atm;

import com.solvd.atm.domain.Atm;
import com.solvd.atm.persistence.ConfigProperties;
import com.solvd.atm.service.AtmService;
import com.solvd.atm.service.impl.AtmServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger();

    static {
        Atm.setInstance(new AtmServiceImpl().getAtmInfo(ConfigProperties.getProperty("atmNumber")));
        LOGGER.info(Atm.getInstance());
    }

    public static void main(String[] args) {
        AtmService atmService = new AtmServiceImpl();
        atmService.inputCard();
    }
}
