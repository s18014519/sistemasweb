package mx.uv.www;

import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;
import javax.sound.sampled.Port;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App 
{

    public static Gson gson = new Gson();
    private static Map<String, Usuario> usuarios = new HashMap<>();
    //private static Conexion c;
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        //Conectar a la base de datos
        //c = new Conexion();
        //c.getConnection();

        port(80);

        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            System.out.println(accessControlRequestHeaders);
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            System.out.println(accessControlRequestMethod); 
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });

        before((req, res) -> res.header("Access-Control-Allow-Origin", "*"));

        System.out.println( "Hello World!" );

        Usuario u1 = new Usuario("1", "pedro", "1234");
        Usuario u2 = new Usuario("2", "pablo", "1234");

        usuarios.put(u1.getId(), u1);
        usuarios.put(u2.getId(), u2);

        before((req, res) -> res.type("application/json"));
        //get("/", (req, res) -> gson.toJson(usuarios));
        get("/", (req, res) -> gson.toJson(DAO.dameUsuarios()));

        post("/", (req, res) ->{
            String datosCliente = req.body();
            Usuario u = gson.fromJson(datosCliente, Usuario.class);
            //usuarios.put(u.getId(), u);
            //return "Se ingresó el usuario: " + u.getId();
            return DAO.crearUsuario(u);
        });
    }
}
