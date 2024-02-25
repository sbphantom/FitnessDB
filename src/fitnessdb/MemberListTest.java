package fitnessdb;
import org.junit.Test;
import static org.junit.Assert.*;


import java.io.File;
import java.io.IOException;

public class MemberListTest {

    @Test
    public void testAdd() {
        MemberList memberList = new MemberList();
        try {
            memberList.load(new File("src//fitnessdb//memberList.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Member member1 = new Basic(new Profile("Adeola", "Asimolowo", new Date(2003, 5 , 8)), new Date(2025, 8, 25), Location.SOMERVILLE);
        Member member2 = new Premium(new Profile("Danny","Phantom", new Date(2003, 9, 12 )), new Date(2024 , 12, 29), Location.EDISON);
        Member member3 = new Family(new Profile("John", "Doe", new Date(1987, 4, 13)),  new Date(2024 , 5, 7), Location.BRIDGEWATER);

        //True Test Cases
        assertTrue(memberList.add(member1));
        assertTrue(memberList.add(member2));
        assertTrue(memberList.add(member3));

        assertEquals(15, memberList.getSize()); // Check if size is 15

        Member x = new Basic(new Profile("Adeola", "Asimolowo", new Date(2003, 5 , 32)), new Date(2025, 8, 25), Location.SOMERVILLE); // Incorrect born date.
        Member y = new Premium(new Profile("Danny","Phantom", new Date(2003, 9, 12 )), new Date(2004 , 12, 29), Location.EDISON); //Membership date is expired
        Member z = new Family(new Profile("John", "Doe", new Date(1987, 4, 13)),  new Date(2024 , 5, 7), Location.BRIDGEWATER);//incorrect born date.
        //False Test Cases
        assertFalse(memberList.add(x));
        assertFalse(memberList.add(y));
        assertFalse(memberList.add(z));

    }

    @Test
    public void testRemove() {
        MemberList memberList = new MemberList();
        try {
            memberList.load(new File("src//fitnessdb//memberList.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Member member1 = new Member(new Profile("Adedoyin", "Adebayo", new Date(2005, 8 , 8)), new Date(2025, 8, 25), Location.PISCATAWAY);
        Member member2 = new Member(new Profile("Daniel","Ghost", new Date(1998, 11, 15 )), new Date(2024 , 12, 29), Location.BRIDGEWATER);

        memberList.add(member1);
        memberList.add(member2);

        assertTrue(memberList.remove(member1)); // Remove member1

        assertEquals(13, memberList.getSize()); // Check if size is 13
    }
}
