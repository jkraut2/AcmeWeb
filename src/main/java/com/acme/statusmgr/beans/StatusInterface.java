/**
 * Interface for all objects representing Server Status.
 * To be used for all classes which want to be returned as a server status
 * in the status controller
 */
public interface StatusInterface
{
    long getId();

    String getContentHeader();

    String getStatusDesc();
}