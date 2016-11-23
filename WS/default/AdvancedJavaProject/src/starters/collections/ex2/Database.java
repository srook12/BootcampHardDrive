package starters.collections.ex2;

import java.util.Map;

/**
*   This interface provided functionality need to access a data set
*   which is indexed by a unique key value.  The interface extends
*   Sun's Map interface, which maps keys to values.  A map cannot
*   contain duplicate keys.
*
*   Two additional methods are provided.  The open() method does whatever
*   is appropriate to make the database available for use.  This could
*   involve opening and/or reading a file, opening a network connection,
*   creating a JDBC connection, etc.  The close() method terminates
*   use of the database.  Both methods are boolean, returning true for
*   success and false for failure.  A more sophisticated approach would
*   use exceptions.
*/

public interface Database extends Map {
    
    public abstract boolean open ();
    public abstract boolean close();
}
