import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {

        // 1 - fazer uma conexão HTTP

        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
        //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        //var extrator = new ExtratorDeConteudoDaNasa();

        String url = "http://localhost:8080/linguagens"; // Api criada
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
        
        var http = new ClienteHttp();
        String json = http.buscaDados(url);
        
        // 3 - exibir e manipular os dados

        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();
        for (Conteudo conteudo : conteudos) {

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}