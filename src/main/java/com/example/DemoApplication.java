package com.example;

import com.example.Entities.Compte;
import com.example.Entities.TypeCompte;
import com.example.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CompteRepository compteRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Ajout de quelques comptes par défaut
		compteRepository.save(new Compte(null, 1500.00, new Date(), TypeCompte.EPARGNE));
		compteRepository.save(new Compte(null, 3000.00, new Date(), TypeCompte.COURANT));
		compteRepository.save(new Compte(null, 2500.00, new Date(), TypeCompte.EPARGNE));

		// Affichage des comptes pour vérifier que l'insertion a réussi
		System.out.println("Comptes initialisés :");
		compteRepository.findAll().forEach(compte ->
				System.out.println("Compte ID: " + compte.getId() + ", Solde: " + compte.getSolde())
		);
	}
}