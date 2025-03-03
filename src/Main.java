import java.util.*;


public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        List<String> participants = new ArrayList<>();
        participants.add("John");
        participants.add("Jane");
        participants.add("Jack");
        participants.add("Jill");
        participants.add("Joe");
        participants.add("Robert");
        participants.add("ma");
        participants.add("asdf");
        participants.add("adsffwe");
        participants.add("werqer");
        participants.add("weqewq");
        participants.add("asd");

//        Map<String, String[]> pairs = new HashMap<>();
//        pairs.put("John", new String[]{"Jane", "Jack"});
//        System.out.println(Arrays.toString(pairs.get("John")));

        List<String> rooms = new ArrayList<>();
        rooms.add("Elvetia");
        rooms.add("Sigma");
        rooms.add("Belvedere");
        rooms.add("adasf");

        int n = 4;

        int nrOfParticipantsInaRoom = participants.size() / n;
        Collections.shuffle(participants);
        while(participants.size() > nrOfParticipantsInaRoom){
            List<String> breakRooms = new ArrayList<>();
            for(int i = 0; i<nrOfParticipantsInaRoom;i++){
                breakRooms.add(participants.remove(0));
            }
            System.out.println(breakRooms + " ----> " + rooms.remove(random.nextInt(2)));


        }

        System.out.println(participants + " ----> " + rooms.getLast());


//        List<String> rooms = new ArrayList<>();
//        rooms.add("Elvetia");
//        rooms.add("Sigma");
//        rooms.add("Belvedere");
//        while(!participants.isEmpty()) {
//
//            List<String> breakRooms = new ArrayList<>();
//            int limit = random.nextInt(1,participants.size()+1);
//
//            while (limit != 0) {
//                breakRooms.add(participants.removeFirst());
//                Collections.shuffle(participants);
//                limit--;
//            }
//            System.out.println(breakRooms);
//        }





        }


    }