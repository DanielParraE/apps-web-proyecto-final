/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositoriosadicionales;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entidades.Estado;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Daniel Parra
 */
public class EstadoRepository {

    private List<Estado> estados;
    private final String path = "./Estados.json";

    public EstadoRepository() throws IOException {
        leerArchivo();
    }

    public void leerArchivo() throws FileNotFoundException, IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.path))) {
            Gson gson = new Gson();
            this.estados = gson.fromJson(bufferedReader, new TypeToken<List<Estado>>() {
            }.getType());
        }
    }

    public List<Estado> getAll() {
        return this.estados;
    }

}
