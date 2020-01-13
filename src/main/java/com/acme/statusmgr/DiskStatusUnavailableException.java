package com.acme.statusmgr;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown by server when their is no quick disk status information available.
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason="DiskStatus is currently unavailable")
public class DiskStatusUnavailableException extends RuntimeException { }