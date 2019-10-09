
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;

/**
 *
 * @author 631220016
 */
public class CategoriaDAO {
    
    public static void inserir(Categoria categoria){
            String query = "INSERT INTO categoria ( categoria ) "
                + " VALUES ('" + categoria.getCategoria() + "'); ";
        Conexao.executar( query );
    }
    
    public static void editar(Categoria categoria){
        String query = "UPDATE categoria SET "
                     + " categoria =  '" + categoria.getCategoria() + "' "
                     + " WHERE id = " + categoria.getId_categoria();
        Conexao.executar( query );
    }
    
    public static void excluir(int id_categoria){
        String query = "DELETE FROM categoria  "
                     + " WHERE id = " + id_categoria;
        Conexao.executar( query );
    }
    
    public static List<Categoria> getCategoria(){
        List<Categoria> lista = new ArrayList<>();
        String query = "SELECT id_categoria, categoria FROM categoria ORDER BY categoria";
        ResultSet rs = Conexao.consultar( query );
        
        if( rs != null ){
           
            try {
                while ( rs.next() ) {                    
                    Categoria cat = new Categoria();
                    cat.setId_categoria( rs.getInt( 1 ) );
                    cat.setCategoria( rs.getString( 2 ) );
                    lista.add(cat);
                }
            } catch (Exception e) {
                
            }
        }
        return lista;
    }
    
    public static Categoria getCategoriaById( int id_categoria ){
 
        String query = "SELECT id_categoria, categoria FROM categoria "
                     + " WHERE id_categoria = " + id_categoria;
        ResultSet rs = Conexao.consultar( query );
        if( rs != null ){
            try {
                rs.next();                   
                Categoria cat = new Categoria();
                cat.setId_categoria( rs.getInt( 1 ) );
                cat.setCategoria(rs.getString( 2 ) );
                return cat;
            } catch (Exception e) {
                return null;
            }
        }else{
            return null;
        }
    }
}
