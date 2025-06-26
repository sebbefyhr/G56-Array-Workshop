package se.lexicon;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.naming.Name;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 tests for the NameRepository class.
 */
public class NameRepositoryTest {


    @Test
    void nameRepoGetSizeTest(){
        int size = NameRepository.getSize();
        assertEquals(size, 0);
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        assertNotEquals(NameRepository.getSize(), 0);
        assertEquals(NameRepository.getSize(), 2);
    }
    @Test
    void nameRepoSetNamesTest(){
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        assertEquals(NameRepository.getSize(), 2);
    }

    @Test
    void nameRepoClearTest(){
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan", "Sebbe Fyr"});
        assertNotEquals(NameRepository.getSize(), 4);
        assertEquals(NameRepository.getSize(), 3);

        NameRepository.clear();
        assertEquals(NameRepository.getSize(), 0);
    }

    @Test
    void nameRepoFindAllTest(){
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan", "Sebbe Fyr", "Sebbe benn", "Mehrdad Hablad"});
        assertEquals(NameRepository.findAll().length, 5);
        NameRepository.remove("Erik Svensson");
        assertNotEquals(NameRepository.findAll().length, 5);
        assertEquals(NameRepository.findAll().length, 4);

    }

    @Test
    void nameRepoFind(){
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan", "Sebbe Fyr", "Sebbe benn", "Mehrdad Hablad"});
        String result = NameRepository.find("Erik Svensson");

        assertEquals(result, "Erik Svensson");
        assertNotEquals(result, "Erik zvensson");
        assertEquals(NameRepository.find("sebbe Fyr"),"Sebbe Fyr" );
        assertNull(NameRepository.find("sebbe Fyren"));
    }

    @Test
    void nameRepoAddTest(){
        boolean bool = NameRepository.add("Sebbe Fyr");
        assertTrue(bool);
        assertFalse(NameRepository.add("sebbe Fyr"));
        assertTrue(NameRepository.add("Merhad Hablad"));
        assertFalse(NameRepository.add("MeRHad hablad"));
    }
    @Test
    void nameRepoFindByFirstNameTest(){
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan", "Sebbe Fyr", "Sebbe benn", "Mehrdad Hablad"});
        String[] sebbes = NameRepository.findByFirstName("sebbe");

        assertEquals(sebbes.length, 2);
        String[] erikcs = NameRepository.findByFirstName("erik");
        assertEquals(erikcs.length, 1);

        NameRepository.add("sebbe henne");
        assertEquals(NameRepository.findByFirstName("sebbe").length, 3);

    }

    @Test
    void nameRepoFindByLastNameTest(){
        NameRepository.setNames(new String[]{"Erik Fyr", "Mehrdad Javan", "Sebbe Fyr", "Sebbe benn", "Mehrdad Hablad"});
        String[] sebbes = NameRepository.findByLastName("Fyr");

        assertEquals(sebbes.length, 2);
        String[] erikcs = NameRepository.findByLastName("Mehrdad");
        assertEquals(erikcs.length, 2);

        NameRepository.add("sebbe henne");
        assertEquals(NameRepository.findByLastName("javan").length, 1);

    }

    @Test
    void nameRepoUpdateTest(){
        NameRepository.add("Sebbe Fyr");
        boolean bool = NameRepository.update("Sebbe Fyr", "Sebbe Fyren");
        assertTrue(bool);
        assertFalse(NameRepository.update("sebbes Fyr", "Sebbe Fyren"));
    }
    @Test
    void nameRepoRemoveTest(){
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan", "Sebbe Fyr"});
        assertEquals(NameRepository.getSize(), 3);
        boolean bool = NameRepository.remove("sebbe fyr");
        System.out.println();
        System.out.println(bool);
        assertTrue(bool);
        assertEquals(NameRepository.getSize(), 2);


    }
}
/*
clear()
findAll()
find(String fullName)
add(String fullName)
findByFirstName(String firstName)
findByLastName(String lastName)
update(String original, String updatedName)
remove(String fullName)
 */