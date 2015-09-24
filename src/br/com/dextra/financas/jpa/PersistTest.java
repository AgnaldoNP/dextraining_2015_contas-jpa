package br.com.dextra.financas.jpa;

import java.util.Date;
import java.util.List;

import br.com.dextra.finances.entity.Investiment;
import br.com.dextra.finances.entity.Person;
import br.com.dextra.finances.entity.cardinality.AddressCardinality;
import br.com.dextra.finances.entity.cardinality.PersonCardinality;
import br.com.dextra.finances.entity.joined.IndividualsPersonJoined;
import br.com.dextra.finances.entity.joined.LegalPersonJoined;
import br.com.dextra.finances.entity.singletable.IndividualsPersonSingleTable;
import br.com.dextra.finances.entity.singletable.LegalPersonSingleTable;
import br.com.dextra.finances.entity.tableperclass.LegalPersonTablePerClass;
import br.com.dextra.service.BaseService;
import br.com.dextra.service.PersonCardinalityService;

public class PersistTest {

	@SuppressWarnings("deprecation")
	public static void main(final String[] args) {

		final Date now = new Date(System.currentTimeMillis());

		// Simple test
		final Person personA = new Person("Agnaldo", new Date("1992/03/05"));
		BaseService.saveEntity(personA);

		final Person personB = new Person("Maria", new Date("1995/09/03"));
		BaseService.saveEntity(personB);

		getPersonById(personA.getId());
		getAllPersons();

		final Investiment investiment = new Investiment();
		BaseService.saveEntity(investiment);

		// Test with SINGLE_TABLE
		final IndividualsPersonSingleTable individualsPersonSingleTable =
				new IndividualsPersonSingleTable();
		individualsPersonSingleTable.setName("Pessoa física");
		individualsPersonSingleTable.setCPF("33224934824");
		individualsPersonSingleTable.setBirtDate(now);

		final LegalPersonSingleTable legalPersonSingleTable =
				new LegalPersonSingleTable();
		legalPersonSingleTable.setName("Pessoa física");
		legalPersonSingleTable.setCNPJ("12345678901234");
		legalPersonSingleTable.setBirtDate(now);

		BaseService.saveEntity(legalPersonSingleTable);
		BaseService.saveEntity(individualsPersonSingleTable);

		// Test with JOINED
		final IndividualsPersonJoined individualsPersonJoined =
				new IndividualsPersonJoined();
		individualsPersonJoined.setCPF("33224934824");
		individualsPersonJoined.setName("Pessoa física");
		individualsPersonJoined.setBirtDate(now);

		final LegalPersonJoined legalPersonJoined = new LegalPersonJoined();
		legalPersonJoined.setName("Pessoa física");
		legalPersonJoined.setCNPJ("12345678901234");
		legalPersonJoined.setBirtDate(now);

		BaseService.saveEntity(legalPersonJoined);
		BaseService.saveEntity(individualsPersonJoined);

		// Test with TABLE_PER_CLASS
		final IndividualsPersonSingleTable individualsPersonTablePerClass =
				new IndividualsPersonSingleTable();
		individualsPersonTablePerClass.setCPF("33224934824");
		individualsPersonTablePerClass.setName("Pessoa física");
		individualsPersonTablePerClass.setBirtDate(now);

		final LegalPersonTablePerClass legalPersonTablePerClass =
				new LegalPersonTablePerClass();
		legalPersonTablePerClass.setName("Pessoa física");
		legalPersonTablePerClass.setCNPJ("12345678901234");
		legalPersonTablePerClass.setBirtDate(now);

		BaseService.saveEntity(legalPersonTablePerClass);
		BaseService.saveEntity(individualsPersonTablePerClass);

		// Test of entity with relation cardinality
		final AddressCardinality address =
				new AddressCardinality("Rua 1", 23, "SP", "Santa Gertrudes");
		BaseService.saveEntity(address);

		final PersonCardinality personCardinality =
				new PersonCardinality("Agnaldo", new Date(
						System.currentTimeMillis()));;
		personCardinality.setAddress(address);
		BaseService.saveEntity(personCardinality);

		listPersonCardinalityByState();

	}

	public static void getPersonById(final Long id) {
		if (id != null) {
			final Person person = BaseService.getById(Person.class, id);
			if (person != null) {
				System.out.println("------LISTANDO DADOS POR PESSOA---------");
				System.out.println("ID.....:" + person.getId());
				System.out.println("NOME...:" + person.getName());
				System.out.println("IDADE..:" + person.getAge());
				System.out.println("----------------------------------------");
			}
		}
	}

	public static void getAllPersons() {
		final List<Person> persons = BaseService.getAll(Person.class);
		if (persons != null) {
			System.out.println("------LISTANDO DADOS POR PESSOA---------");
			for (final Person person : persons) {
				System.out.println("ID.....:" + person.getId());
				System.out.println("NOME...:" + person.getName());
				System.out.println("IDADE..:" + person.getAge());
				System.out.println("----------------------------------------");
				System.out.println("");
			}
		}
	}

	private static void listPersonCardinalityByState() {
		final List<PersonCardinality> persons =
				PersonCardinalityService.getByAddressStae("SP");
		System.out.println("------LISTANDO DADOS POR PESSOA---------");
		System.out.println();
		for (final PersonCardinality person : persons) {
			System.out.println("ID.........:" + person.getId());
			System.out.println("NOME.......:" + person.getName());
			if (person.getAddress() != null) {
				final AddressCardinality addressPerson = person.getAddress();
				System.out.println(String.format("ENDEREÇO...:%s, %s - %s, %s",
						addressPerson.getStreet(), addressPerson.getNumber(),
						addressPerson.getCity(), addressPerson.getState()));
			}
			System.out.println();
		}
		System.out.println("----------------------------------------");
	}

}
