package com.miprestamo.apps.miprestamoapi.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.miprestamo.apps.miprestamoapi.entities.Client;
import com.miprestamo.apps.miprestamoapi.entities.IdentificationDocument;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureEmbeddedDatabase
public class FlywayDbMigrationTest {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private IDRepository idRepository;

	@Test
	@DisplayName("Given that Flyway migrates all initial data, When ClientRepository is called by ID, Then the data is stored OK")
	public void callClientRepositorybyId() {
		final Optional<Client> optionalClient = clientRepository.findById(1);
		assertThat(optionalClient).hasValueSatisfying(client -> {
			assertThat(client.getId()).isNotNull();
			assertThat(client.getFirstName()).isEqualTo("Elkin");
			assertThat(client.getSecondName()).isEqualTo("Giovanni");
			assertThat(client.getFirstLastName()).isEqualTo("Giraldo");
			assertThat(client.getSecondLastName()).isEqualTo("Pinedo");
			assertThat(client.getBusinessName()).isEqualTo("egiraldo");
			assertThat(client.getAddress()).isEqualTo("Calle 160 # 72 - 51");
			assertThat(client.getPhone()).isEqualTo("3152636667");
			assertThat(client.getDocumentDetails()).isNotNull();
		});
	}

	@Test
	@DisplayName("Given that Flyway migrates all initial data, When IDRepository is called, Then the data is all stored")
	public void callIDRepository() {
		final List<IdentificationDocument> idList = idRepository.findAll();
		assertThat(idList).hasSize(4);
		idList.forEach(id -> {
			assertThat(id.getId()).isNotNull();
			assertThat(id.getPrefix()).isNotNull();
			assertThat(id.getType()).isNotNull();
			assertThat(id.getDocumentDetails()).isNotNull();
		});
	}

}
