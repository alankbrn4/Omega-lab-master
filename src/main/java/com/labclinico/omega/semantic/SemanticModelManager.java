package com.labclinico.omega.semantic;

import org.apache.jena.rdf.model.*;
import org.springframework.stereotype.Component;

@Component
public class SemanticModelManager {

    private Model model;

    public SemanticModelManager() {
        this.model = ModelFactory.createDefaultModel();
        //Definir ontología básica
        String baseURI = "http://www.labclinico.com/omega#";
        model.setNsPrefix("omega", baseURI);

        //Definir propiedades y clases
        Property tipoMuestra = model.createProperty(baseURI + "tipoMuestra");
        Property tipoAnalisis = model.createProperty(baseURI + "tipoAnalisis");
        Resource muestraClass = model.createResource(baseURI + "Muestra");
        Resource analisisClass = model.createResource(baseURI + "Analisis");
        
        // Añadir relaciones
        model.add(muestraClass, tipoMuestra, "Sangre");
        model.add(muestraClass, tipoMuestra, "Orina");
        model.add(analisisClass, tipoAnalisis, "Hemograma");
        model.add(analisisClass, tipoAnalisis, "Bioquímica");
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    // Métodos para agregar y consultar datos semámticos
    public void addResource(String uri, String property, String value) {
        Resource resource = model.createResource(uri);
        Property prop = model.createProperty(property);
        resource.addProperty(prop, value);
    }

    public void getResource(String uri) {
        Resource resource = model.getResource(uri);
        StmtIterator iter = resource.listProperties();
        while (iter.hasNext()) {
            Statement stmt = iter.nextStatement();
            System.out.println(stmt);
        }
    }

    public void addLiteral(String uri, String property, String value) {
        Resource resource = model.createResource(uri);
        Property prop = model.createProperty(property);
        resource.addProperty(prop, value);
    }

    public void getLiteral(String uri) {
        Resource resource = model.getResource(uri);
        StmtIterator iter = resource.listProperties();
        while (iter.hasNext()) {
            Statement stmt = iter.nextStatement();
            System.out.println(stmt);
        }
    }

}
