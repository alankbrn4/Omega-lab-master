package com.labclinico.omega.semantic;

import org.apache.jena.rdf.model.RDFNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;


@RestController
@RequestMapping("/api/semantic")
public class SemanticController {
    @Autowired
    private SemanticModelManager semanticModelManager;

    @GetMapping("/tipos-muestra")
    public ResponseEntity<List<String>> getTiposMuestra() {
        Model model = semanticModelManager.getModel();
        Property tipoMuestra = model.getProperty("http://labclinico.com/omega#tipoMuestra");
        
        List<String> tiposMuestra = model.listStatements(null, tipoMuestra, (RDFNode) null)
            .mapWith(statement -> statement.getObject().toString())
            .toList();
        
        return ResponseEntity.ok(tiposMuestra);
    }

}
