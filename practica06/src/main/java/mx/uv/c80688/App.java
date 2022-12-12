package mx.uv.c80688;
import static spark.Spark.*;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        // github snae
        System.out.println( "Hello World!" );
        get("/hello", (req, res) -> "Hello World");
        get("/aaron", (req, res) -> "Hello Aaron");
        get("/eduardo", (req, res) -> "Hello Eduardo");
        get("/", (req, res) -> "<h1>Hola Sistemas Web</h1>");

        post("/", (req, res)->{
            System.out.println("login:" + req.queryParams("login"));
            System.out.println("Contraseña: " + req.queryParams("password"));
            String usuario = req.queryParams("login");

            System.out.println(req.body());

            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(req.body());
            JsonObject peticionCliente = arbol.getAsJsonObject();
            System.out.println(peticionCliente.get("login"));
            System.out.println(peticionCliente.get("password"));
            String user = req.queryParams("login");

            JsonObject respuesta = new JsonObject();
            respuesta.addProperty("msj", "bienvenido");
            respuesta.addProperty("usuario", usuario);

            if(usuario == "omar"){
                res.status(200);
                return respuesta; 
            } else{
                res.status(404);
                return "Quien eres? " + usuario;
            }
        });
    }
}
