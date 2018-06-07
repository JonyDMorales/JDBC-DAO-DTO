package persona.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import persona.dto.PersonaDTO;

public class PersonaDAOImpl implements PersonaDAO{

    private Connection connection;
    private static final String INSERT = "INSERT INTO personas(nombre, apellido) VALUES(?,?)";
    private static final String UPDATE = "UPDATE personas SET nombre=?, apellido=? WHERE id=?";
    private static final String DELETE = "DELETE FROM personas WHERE id=?";
    private static final String SELECT = "SELECT * FROM personas";

    public PersonaDAOImpl() { }

    public PersonaDAOImpl(Connection conn) {
        this.connection = conn;
    }
    
    @Override
    public int insert(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = (this.connection != null) ? this.connection : Conexion.getConnection();
            stmt = conn.prepareStatement(INSERT);
            int index = 1;
            stmt.setString(index++, persona.getNombre());
            stmt.setString(index++, persona.getApellido());
            rows = stmt.executeUpdate();
        } finally {
            //Conexion.close(conn);
            Conexion.close(stmt);
        }
        return rows;
    }

    @Override
    public int update(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = (this.connection != null) ? this.connection : Conexion.getConnection();
            stmt = conn.prepareStatement(UPDATE);
            int index = 1;
            stmt.setString(index++, persona.getNombre());
            stmt.setString(index++, persona.getApellido());
            stmt.setInt(index, persona.getId());
            rows = stmt.executeUpdate();
        } finally {
            //Conexion.close(conn);
            Conexion.close(stmt);
        }
        return rows;
    }

    @Override
    public int delete(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = (this.connection != null) ? this.connection : Conexion.getConnection();
            stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, persona.getId());
            rows = stmt.executeUpdate();
        } finally {
            //Conexion.close(conn);
            Conexion.close(stmt);
        }
        return rows;
    }

    @Override
    public List<PersonaDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO personaDTO = null;
        List<PersonaDTO> personas = new ArrayList<PersonaDTO>();
        
        try {
            conn = (this.connection != null) ? this.connection : Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                personaDTO = new PersonaDTO();
                personaDTO.setId(id);
                personaDTO.setNombre(nombre);
                personaDTO.setApellido(apellido);
                personas.add(personaDTO);
            }
        } finally {
            //Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return personas;
    }
   
    
}
