package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import model.Categoria;


/**
 *
 * @author 631220016
 */
public class ProdutoDAO {
    public static void inserir(Produto produto){
            String query = "INSERT INTO produto ( produto, categoria, quantidade, preco ) "
                + " VALUES ('" + produto.getProduto() + "' , "                
                + " '" + produto.getCategoria().getId_categoria()+ "' , "
                + " '" + produto.getQuantidade() + "' , "
                + " '" + produto.getPreco()+ "') ";
;
        Conexao.executar( query );
    }
    
    public static void editar(Produto produto){
        String query = "UPDATE produto SET "
                     + " produto =  '" + produto.getProduto() + "' , "
                     + " preco =  '" + produto.getPreco()+ "' , "
                     + " quantidade =  '" + produto.getQuantidade()+ "' , "
                     + " categoria = '" + produto.getCategoria().getId_categoria()+ "' , "
                     + " WHERE id = " + produto.getId_produto();
        Conexao.executar( query );
    }
    
    public static void excluir(int id_produto){
        String query = "DELETE FROM produto  "
                     + " WHERE id = " + id_produto;
        Conexao.executar( query );
    }
    
    public static List<Produto> getProduto(){
        List<Produto> lista = new ArrayList<>();
        String query = "SELECT a.id_produto, a.produto, a.quantidade, a.preco, "
                     + " b.id_categoria, b.categoria "
                     + " FROM produto a "
                     + " INNER JOIN categoria b "
                     + " ON a.categoria = b.id_categoria "
                     + " ORDER BY produto";
        ResultSet rs = Conexao.consultar( query );
        
        if( rs != null ){
           
            try {
                while ( rs.next() ) {                    
                    Produto prod = new Produto();
                    prod.setId_produto( rs.getInt( 1 ) );
                    prod.setProduto( rs.getString( 2 ) );
                    prod.setQuantidade(rs.getString( 3 ) );
                    prod.setPreco( rs.getString( 4 ));
                    
                    Categoria cat = new Categoria();
                    cat.setId_categoria( rs.getInt( 5 ));
                    cat.setCategoria( rs.getString( 6 ));
                    
                    prod.setCategoria(cat);
                    lista.add(prod);
                }
            } catch (Exception e) {
                
            }
        }
        return lista;
    }
    
    public static Produto getProdutoById( int id_produto ){
 
        String query = "SELECT id_produto, produto FROM produto "
                     + " WHERE id_produto = " + id_produto;
        ResultSet rs = Conexao.consultar( query );
        if( rs != null ){
            try {
                rs.next();                   
                Produto prod = new Produto();
                prod.setId_produto( rs.getInt( 1 ) );
                prod.setProduto(rs.getString( 2 ) );
                return prod;
            } catch (Exception e) {
                return null;
            }
        }else{
            return null;
        }
    }
}
