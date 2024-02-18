package fitnessdb;
import org.junit.Test;
import static org.junit.Assert.*;
public class MemberListTest {

    @Test
    public void testAdd() {
        MemberList memberList = new MemberList();
        memberList.load();

        Member member1 = new Member(new Profile("Adeola", "Asimolowo", new Date(2003, 5 , 8)), new Date(2025, 8, 25), Location.SOMERVILLE);
        Member member2 = new Member(new Profile("Danny","Phantom", new Date(2003, 9, 12 )), new Date(2024 , 12, 29), Location.EDISON);

        assertTrue(memberList.add(member1)); // Add member1
        assertTrue(memberList.add(member2)); // Add member2

        assertEquals(14, memberList.getSize()); // Check if size is 14
    }

    @Test
    public void testRemove() {
        MemberList memberList = new MemberList();
        memberList.load();
        Member member1 = new Member(new Profile("Adedoyin", "Adebayo", new Date(2005, 8 , 8)), new Date(2025, 8, 25), Location.PISCATAWAY);
        Member member2 = new Member(new Profile("Daniel","Ghost", new Date(1998, 11, 15 )), new Date(2024 , 12, 29), Location.BRIDGEWATER);

        memberList.add(member1);
        memberList.add(member2);

        assertTrue(memberList.remove(member1)); // Remove member1

        assertEquals(13, memberList.getSize()); // Check if size is 13
    }
}
