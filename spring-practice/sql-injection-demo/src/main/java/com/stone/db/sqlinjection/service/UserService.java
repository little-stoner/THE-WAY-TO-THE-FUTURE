package com.stone.db.sqlinjection.service;

import com.stone.db.sqlinjection.core.Result;

public interface UserService {

    Result psQuery(String username);
    Result sQuery(String username);

}
