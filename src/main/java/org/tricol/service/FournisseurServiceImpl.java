package org.tricol.service;

import org.tricol.model.Fournisseur;
import org.tricol.repository.FournisseurRepositoryInterface;

import java.util.List;
import java.util.Optional;

public class FournisseurServiceImpl implements FournisseurServiceInterface {
    private final FournisseurRepositoryInterface fournisseurRepository;

    public FournisseurServiceImpl(FournisseurRepositoryInterface fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    public void addFournisseur(Fournisseur f) {
        fournisseurRepository.save(f);
    }

    public void deleteFournisseur(Fournisseur f) {
        fournisseurRepository.delete(f);
    }

    public void updateFournisseur(Fournisseur f) {
        fournisseurRepository.save(f);
    }

    public Optional<Fournisseur> findFournisseurById(Long id) {
        return fournisseurRepository.findById(id);
    }

    public List<Fournisseur> findAllFournisseur() {
        return fournisseurRepository.findAll();
    }

}
