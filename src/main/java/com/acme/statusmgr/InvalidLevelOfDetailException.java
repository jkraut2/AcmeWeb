package com.acme.statusmgr;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

    /**
     * Class that handles server response for invalid levelofdetail parameter.
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Invalid level of detail")
    public class InvalidLevelOfDetailException extends RuntimeException { }

