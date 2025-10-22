package org.tricol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tricol.model.Fournisseur;
import org.tricol.service.FournisseurServiceImpl;
import org.tricol.service.FournisseurServiceInterface;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/fournisseurs")
public class FournisseurController {

    private final FournisseurServiceInterface fournisseurServiceInterface;

    @Autowired
    public FournisseurController(FournisseurServiceInterface fournisseurServiceInterface) {
        this.fournisseurServiceInterface = fournisseurServiceInterface;
    }

    @GetMapping
    public ResponseEntity<List<Fournisseur>> getAllFournisseurs() {
        List<Fournisseur> fournisseurs = fournisseurServiceInterface.findAllFournisseur();
        return ResponseEntity.ok(fournisseurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable("id") Long id) {
        Optional<Fournisseur> fournisseur = fournisseurServiceInterface.findFournisseurById(id);
        return fournisseur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Fournisseur createFournisseur(@RequestBody Fournisseur fournisseur) {
        fournisseurServiceInterface.addFournisseur(fournisseur);
        return fournisseur;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable("id") Long id, @RequestBody Fournisseur updatedFournisseur) {
        Optional<Fournisseur> optionalFournisseur = fournisseurServiceInterface.findFournisseurById(id);
        if (optionalFournisseur.isPresent()) {
            Fournisseur fournisseur = optionalFournisseur.get();
            fournisseur.setNom(updatedFournisseur.getNom());
            fournisseur.setSociete(updatedFournisseur.getSociete());
            fournisseur.setAddresse(updatedFournisseur.getAddresse());
            fournisseur.setContact(updatedFournisseur.getContact());
            fournisseur.setEmail(updatedFournisseur.getEmail());
            fournisseur.setTelephone(updatedFournisseur.getTelephone());
            fournisseur.setVille(updatedFournisseur.getVille());
            fournisseur.setIce(updatedFournisseur.getIce());
            fournisseurServiceInterface.updateFournisseur(fournisseur);
            return ResponseEntity.ok(fournisseur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFournisseur(@PathVariable("id") Long id) {
        Optional<Fournisseur> optionalFournisseur = fournisseurServiceInterface.findFournisseurById(id);
        if (optionalFournisseur.isPresent()) {
            fournisseurServiceInterface.deleteFournisseur(optionalFournisseur.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
