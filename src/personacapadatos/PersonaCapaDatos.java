package personacapadatos;

import java.sql.*;
import java.util.List;
import persona.dto.PersonaDTO;
import persona.jdbc.Conexion;
import persona.jdbc.PersonaDAO;
import persona.jdbc.PersonaDAOImpl;

public class PersonaCapaDatos {

    public static void main(String[] args) {
        PersonaDAO personaDAO = null;
        PersonaDTO personaDTO = new PersonaDTO();
        Connection conn = null;
        personaDTO.setNombre("Carlos");
        personaDTO.setApellido("Morales");
        
        try{
            conn = Conexion.getConnection();
            personaDAO = new PersonaDAOImpl(conn);
            
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            
            personaDAO.insert(personaDTO);
            //personaDAO.delete(new PersonaDTO(4));
            
            List<PersonaDTO> personas = personaDAO.select();
            for(PersonaDTO persona : personas){
                System.out.println(persona.toString());
            }
            
            conn.commit();
        } catch(Exception e) {
            try{
                conn.rollback();
                System.out.println("Rollback ;)");
            } catch (SQLException sqle){
                sqle.printStackTrace(System.out);
            }
            e.printStackTrace(System.out);
        }
    }
    
}
