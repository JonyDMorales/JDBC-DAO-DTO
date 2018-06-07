package persona.jdbc;

import java.sql.SQLException;
import java.util.List;
import persona.dto.PersonaDTO;

public interface PersonaDAO {
    
    public int insert(PersonaDTO persona) throws SQLException;
    public int update(PersonaDTO persona) throws SQLException;
    public int delete(PersonaDTO persona) throws SQLException;
    public List<PersonaDTO> select() throws SQLException;
    
}
