package br.com.dextra.financas.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.dextra.finances.entity.Address;
import br.com.dextra.finances.entity.Agency;
import br.com.dextra.finances.entity.Investiment;
import br.com.dextra.finances.entity.Person;
import br.com.dextra.finances.entity.Phone;
import br.com.dextra.finances.entity.ServicePackage;
import br.com.dextra.finances.entity.joined.IndividualsPersonJoined;
import br.com.dextra.finances.entity.joined.LegalPersonJoined;
import br.com.dextra.finances.entity.singletable.IndividualsPersonSingleTable;
import br.com.dextra.finances.entity.singletable.LegalPersonSingleTable;
import br.com.dextra.finances.entity.tableperclass.LegalPersonTablePerClass;
import br.com.dextra.service.AgencyCardinalityService;
import br.com.dextra.service.BaseService;
import br.com.dextra.service.PersonCardinalityService;

public class PersistTest {

	public static void main(final String[] args) {

		final Date now = new Date(System.currentTimeMillis());

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
		final Address address =
				new Address("Rua 1", 23, "SP", "Santa Gertrudes");
		BaseService.saveEntity(address);

		final Person personCardinality = new Person("Agnaldo");
		personCardinality.setAddress(address);
		BaseService.saveEntity(personCardinality);

		listPersonCardinalityByState();

		final Phone phone1 = new Phone("123456789", "55");
		final Phone phone2 = new Phone("43123456789", "55");

		final List<Phone> phones = new ArrayList<Phone>();
		phones.add(phone1);
		phones.add(phone2);

		final Agency agency = new Agency("Agencia Tabajaras", address, phones);

		BaseService.saveEntity(agency);

		// Test
		final Person personWithPhones = new Person("João");

		final Phone phone3 = new Phone("65323445", "55");
		final List<Phone> phones2 = new ArrayList<Phone>();
		phones2.add(phone1);
		phones2.add(phone3);
		personWithPhones.setPhones(phones2);
		BaseService.saveEntity(phone1);
		BaseService.saveEntity(phone3);

		final ServicePackage service = new ServicePackage("Serviço 1", 350D);
		final ServicePackage service2 = new ServicePackage("Serviço 1", 350D);
		final List<ServicePackage> services = new ArrayList<ServicePackage>();
		services.add(service);
		services.add(service2);
		personWithPhones.setServicePackages(services);
		BaseService.saveEntity2(service);
		BaseService.saveEntity(service2);

		BaseService.saveEntity(personWithPhones);
		listAgencyByPhone();

	}

	private static void listAgencyByPhone() {
		final List<Agency> agencys =
				AgencyCardinalityService.getByPhone("55", "123456789");
		if ((agencys != null) && (agencys.size() > 0)) {
			System.out.println("------LISTANDO DADOS POR PESSOA---------");
			for (final Agency ag : agencys) {
				System.out.println("NOME DA AGENCIA ... :" + ag.getName());
				if (ag.getAddress() != null) {
					final Address addressPerson = ag.getAddress();
					System.out.println(String.format(
							"ENDEREÇO...:%s, %s - %s, %s",
							addressPerson.getStreet(),
							addressPerson.getNumber(), addressPerson.getCity(),
							addressPerson.getState()));
				}
			}
			System.out.println("-----------------------------------------");
		}
	}

	public static void getPersonById(final Long id) {
		if (id != null) {
			final Person person = BaseService.getById(Person.class, id);
			if (person != null) {
				System.out.println("------LISTANDO DADOS POR PESSOA---------");
				System.out.println("ID.....:" + person.getId());
				System.out.println("NOME...:" + person.getName());
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
				System.out.println("----------------------------------------");
				System.out.println("");
			}
		}
	}

	private static void listPersonCardinalityByState() {
		final List<Person> persons =
				PersonCardinalityService.getByAddressStae("SP");
		System.out.println("------LISTANDO DADOS POR PESSOA---------");
		System.out.println();
		for (final Person person : persons) {
			System.out.println("ID.........:" + person.getId());
			System.out.println("NOME.......:" + person.getName());
			if (person.getAddress() != null) {
				final Address addressPerson = person.getAddress();
				System.out.println(String.format("ENDEREÇO...:%s, %s - %s, %s",
						addressPerson.getStreet(), addressPerson.getNumber(),
						addressPerson.getCity(), addressPerson.getState()));
			}
			System.out.println();
		}
		System.out.println("----------------------------------------");
	}

}
