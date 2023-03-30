import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {

    public List<Conteudo> extraiConteudos (String json){
        
        // Extraindo os conteudos que interessam.
        
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

         //var diretorio = new File("figurinhas/"); // Primeiro desafio da Aula 2: criando um diretório de saída
        //diretorio.mkdir();


        // Populando a lista.

        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        } 
            
        return conteudos;

    }
    
}
