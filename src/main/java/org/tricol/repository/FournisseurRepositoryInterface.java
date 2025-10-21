package org.tricol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tricol.model.Fournisseur;


public interface FournisseurRepositoryInterface extends JpaRepository<Fournisseur, Long> {
}
