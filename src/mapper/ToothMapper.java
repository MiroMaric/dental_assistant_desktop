package mapper;

import domain.tooth.Tooth;
import org.mapstruct.Mapper;

/**
 *
 * @author MikoPC
 */
@Mapper
public interface ToothMapper {
    
    Tooth clone(Tooth tooth);
    
}
