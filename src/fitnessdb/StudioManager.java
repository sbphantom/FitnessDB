package fitnessdb;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class StudioManager {
    private MemberList memberlist;
    private Schedule schedule;

    private String commandAdd(String[] response) {
        String fname = response[1];
        String lname = response[2];
        Date dob;
        try {
            dob = new Date(response[3]);
        } catch (NumberFormatException e) {
            return "The date contains characters.";
        }
        Location location = Location.getLocation(response[4]);
        Profile profile = new Profile(fname, lname, dob);

        if (!dob.isValid()) {
            return String.format("DOB %s: invalid calendar date!", dob);
        } else if (dob.compareTo(Date.todayDate()) >= 0) {
            return String.format("DOB %s: cannot be today or a future date!", dob);
        } else if (profile.isMinor()) {
            return String.format("DOB %s: must be 18 or older to join!", dob);
        }
        if (location == null) {
            return String.format("%s: invalid studio location!", response[4]);
        }

        if (response[0].equals("AB") && memberlist.add(new Basic(profile, Date.todayDate().addMonths(1), location))) {
            return String.format("%s %s added.", fname, lname);
        } else if (response[0].equals("AF") && memberlist.add(new Family(profile, Date.todayDate().addMonths(3), location)))
            return String.format("%s %s added.", fname, lname);
        else if (response[0].equals("AP") && memberlist.add(new Premium(profile, Date.todayDate().addYears(1), location)))
            return String.format("%s %s added.", fname, lname);
        else {
            return String.format("%s %s is already in the member database.", fname, lname);
        }
    }

    //C Bill Scanlan 5/1/1999
    private String commandC(String[] response) {

        String fname = response[1];
        String lname = response[2];
        Date dob;
        try {
            dob = new Date(response[3]);
        } catch (NumberFormatException e) {
            return "The date contains characters.";
        }
        Profile profile = new Profile(fname, lname, dob);

        Member member = new Member(profile);

        if (memberlist.remove(member)) {
            return String.format("%s %s removed.", fname, lname);
        } else
            return String.format("%s %s is not in the member database.", fname, lname);
    }

    private void commandPrint(String s) {
        switch (s) {
            case "S" -> System.out.println(schedule.listString());
            case "PM" -> memberlist.printByMember();
            case "PC" -> memberlist.printByCounty();
            case "PF" -> memberlist.printByFees();
        }
    }

    //R cardio Jennifer somerville Roy Brooks 8/8/1977
    private String commandRecord(String[] request) {
        boolean isGuest = request[0].equals("RG");

        Offer offer = Offer.getOffer(request[1]);
        Instructor instructor = Instructor.getInstructor(request[2]);
        Location location = Location.getLocation(request[3]);

        if (offer == null) {
            return String.format("%s - class name does not exist.", request[1]);
        }
        if (instructor == null) {
            return String.format("%s - instructor does not exist.", request[2]);
        }
        if (location == null) {
            return String.format("%s - invalid studio location.", request[3]);
        }
        FitnessClass target = schedule.findClass(new FitnessClass(offer, instructor, location));
        if (target == null) {
            return String.format("%s by %s does not exist at %s", request[1], request[2], request[3]);
        }

        String fname = request[4];
        String lname = request[5];
        Date dob = new Date(request[6]);

        Profile profile = new Profile(fname, lname, dob);
        Member member = memberlist.getMember(new Member(profile));

        if (member == null) {
            return String.format("%s %s %s is not in the member database.", fname, lname, dob);
        } else if (member.isExpired()) {
            return (String.format("%s %s %s membership expired.", fname, lname, dob));
        }
        if (!isGuest) {
            if (member instanceof Basic && !location.equals(member.getHomeStudio())) {
                return (String.format("%s %s is attending a class at %s - [BASIC] home studio at %s", fname, lname, location.name(), member.getHomeStudio().name()));
            }
            FitnessClass[] memberAttendance = member.getAttendance();
            if (memberAttendance[target.getTime().ordinal()] == null) {
                memberAttendance[target.getTime().ordinal()] = (target);
                target.addMember(member);
                if (member instanceof Basic basic) {
                    basic.incrementClassCount();
                }
                return String.format("%s %s attendance recorded %s at %s", fname, lname, offer, location);
            } else if (!memberAttendance[target.getTime().ordinal()].equals(target)) {
                return String.format("Time conflict - %s %s is in another class held at %s - %s", fname, lname, target.getTime(), target);
            } else {
                return String.format("%s %s is already in the class.", fname, lname);
            }
        } else {
            if (member instanceof Basic) {
                return (String.format("%s %s [BASIC] - no guest pass.", member.getProfile().getFname(), member.getProfile().getLname()));
            } else if (!member.canGuest()) {
                return (String.format("%s %s guest pass not available.", member.getProfile().getFname(), member.getProfile().getLname()));
            }
            if (!location.equals(member.getHomeStudio())) {
                return (String.format("%s %s (guest) is attending a class at %s - home studio at %s", fname, lname, location.name(), member.getHomeStudio().name()));
            } else {
                target.addGuest(member);
                member.useGuestPass();
                return String.format("%s %s (guest) attendance recorded %s at %s", fname, lname, offer, location);
            }
        }

    }

    //U Pilates KIM FRANKLIN Mary Lindsey 12/1/1989
    private String commandUpdate(String[] request) {
        boolean isGuest = request[0].equals("UG");

        Offer offer = Offer.getOffer(request[1]);
        Instructor instructor = Instructor.getInstructor(request[2]);
        Location location = Location.getLocation(request[3]);
        FitnessClass target = schedule.findClass(new FitnessClass(offer, instructor, location));

        String fname = request[4];
        String lname = request[5];
        Date dob = new Date(request[6]);
        Profile profile = new Profile(fname, lname, dob);
        Member member = memberlist.getMember(new Member(profile));

        if (!isGuest) {
            FitnessClass[] memberAttendance = member.getAttendance();
            if (memberAttendance[target.getTime().ordinal()] == null) {
                return String.format("%s %s is not in %s, %s, %s", fname, lname, target, target.getStudio().getZipCode(), target.getStudio().getCounty());
            } else {
                memberAttendance[target.getTime().ordinal()] = null;
                target.removeMember(member);
                return String.format("%s %s is removed from %s, %s, %s", fname, lname, target, target.getStudio().getZipCode(), target.getStudio().getCounty());
            }
        } else {
            target.removeGuest(member);
            return String.format("%s %s (guest) is removed from %s, %s, %s", fname, lname, target, target.getStudio().getZipCode(), target.getStudio().getCounty());

        }
    }

    private String commandHandler(String inputString) {
        String[] request = inputString.split(" ");
        String command = request[0];
        return switch (command) {
            case "AB", "AF", "AP" -> {
                if (request.length == 5) {
                    yield commandAdd(request);
                } else yield "Missing data tokens.";
            }
            case "C" -> {
                if (request.length == 4) {
                    yield commandC(request);
                } else yield "Missing data tokens.";
            }
            case "S", "PM", "PC", "PF" -> {
                commandPrint(request[0]);
                yield "";
            }
            case "R", "RG" -> {
                if (request.length == 7) {
                    yield commandRecord(request);
                } else yield "Missing data tokens.";
            }
            case "U", "UG" -> {
                if (request.length == 7) {
                    yield commandUpdate(request);
                } else yield "Missing data tokens.";
            }
            default -> String.format("%s is an invalid command!", command);
        };
    }

    private void loadMembers(File file) {
        try {
            memberlist.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("\n-list of members loaded-");
            for (Member m : memberlist.getMembers()) {
                if (m != null) System.out.println(m);
            }
            System.out.println("-end of list-\n\n");
        }
    }

    private void loadSchedule(File file) {
        try {
            schedule.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("-Fitness classes loaded-");
            for (FitnessClass f : schedule.getClasses()) {
                if (f != null) System.out.println(f);
            }
            System.out.println("-end of class list.\n");
        }
    }

    public void run() {
        memberlist = new MemberList();
        loadMembers(new File("data/memberList.txt"));

        schedule = new Schedule();
        loadSchedule(new File("data/classSchedule.txt"));

        System.out.println("Studio Manager is up running...\n");

        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            String line = input.nextLine();
            if (line.trim().isEmpty()) {
                continue;
            }

            if (line.equals("Q")) {
                System.out.println("Studio Manager terminated.");
                input.close();
                break;
            }

            System.out.println(commandHandler(line));
        }
    }
}