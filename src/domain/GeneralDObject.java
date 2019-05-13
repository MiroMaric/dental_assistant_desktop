
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface GeneralDObject {
    
    String getClassName();
    String getAtrValue();
    String setAtrValue();
    String getNameByColumn(int i);
    String getWhereCondition();
    GeneralDObject getNewRecord(ResultSet rs) throws SQLException;
    
}
