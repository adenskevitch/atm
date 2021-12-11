package com.solvd.atm.persistence;

import com.solvd.atm.domain.Atm;
import org.apache.ibatis.annotations.Param;

public interface AtmRepository {

    Atm getAtmInfo(String uniqueNumber);

    //void decrementAtmCash(@Param("atm") Atm atm, @Param("money") Integer money);

}
