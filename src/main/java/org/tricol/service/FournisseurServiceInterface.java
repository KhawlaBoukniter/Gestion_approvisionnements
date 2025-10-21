package org.tricol.service;

import org.tricol.model.Fournisseur;

import java.util.List;
import java.util.Optional;

public interface FournisseurServiceInterface {
    void addFournisseur(Fournisseur f);
    void deleteFournisseur(Fournisseur f);
    void updateFournisseur(Fournisseur f);
    Optional<Fournisseur> findFournisseurById(Long id);
    List<Fournisseur> findAllFournisseur();
}
