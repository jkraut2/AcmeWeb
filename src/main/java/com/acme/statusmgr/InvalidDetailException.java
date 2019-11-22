
package com.acme.statusmgr;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class that responds to invalid detail request from server.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Invalid details")
public class InvalidDetailException extends RuntimeException { }