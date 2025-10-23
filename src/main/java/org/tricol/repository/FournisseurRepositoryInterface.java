package org.tricol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.tricol.model.Fournisseur;

import java.util.List;

public interface FournisseurRepositoryInterface extends JpaRepository<Fournisseur, Long> {
    List<Fournisseur> findByNom(String nom);

    @Query("SELECT f FROM Fournisseur f WHERE f.email ILIKE %?1")
    List<Fournisseur> findByEmailEndingWith(String ending);
}
