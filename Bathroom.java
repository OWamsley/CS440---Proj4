import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Bathroom {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Which people arrival option? Enter 0, 1, or 2");
        int option = input.nextInt();
        ArrayList<Person> people = createPeople(option);
        bathroomAlgorithm(people);
    }

    public static ArrayList<Person> createPeople(int setting) {
        Random random = new Random();
        ArrayList<Person> people = new ArrayList<Person>();
        if (setting == 0) {
            // option a: 5, wait 10, 5, wait 10, 5, wait 10, 5
            int id = 1;
            Person newPerson;
            for (int x = 0; x < 10; x++) {
                int gender;
                int genderOdds = random.nextInt(100);
                if (genderOdds < 60) {
                    gender = 1;
                    // female
                } else {
                    gender = 0;
                    // male
                }
                int time = random.nextInt(6) + 3;
                newPerson = new Person(id, gender, time, 0);
                people.add(newPerson);
                id++;
            }
            for (int x = 0; x < 10; x++) {
                int gender;
                int genderOdds = random.nextInt(100);
                if (genderOdds < 60) {
                    gender = 1;
                    // female
                } else {
                    gender = 0;
                    // male
                }
                int time = random.nextInt(6) + 3;
                newPerson = new Person(id, gender, time, 10);
                people.add(newPerson);
                id++;
            }
            for (int x = 0; x < 10; x++) {
                int gender;
                int genderOdds = random.nextInt(100);
                if (genderOdds < 60) {
                    gender = 1;
                    // female
                } else {
                    gender = 0;
                    // male
                }
                int time = random.nextInt(6) + 3;
                newPerson = new Person(id, gender, time, 20);
                people.add(newPerson);
                id++;
            }
            for (int x = 0; x < 10; x++) {
                int gender;
                int genderOdds = random.nextInt(100);
                if (genderOdds < 60) {
                    gender = 1;
                    // female
                } else {
                    gender = 0;
                    // male
                }
                int time = random.nextInt(6) + 3;
                newPerson = new Person(id, gender, time, 30);
                people.add(newPerson);
                id++;
            }
        } else if (setting == 1) {
            // option b: 10, wait 10, 10
            int id = 1;
            Person newPerson;
            for (int x = 0; x < 10; x++) {
                int gender;
                int genderOdds = random.nextInt(100);
                if (genderOdds < 60) {
                    gender = 1;
                    // female
                } else {
                    gender = 0;
                    // male
                }
                int time = random.nextInt(6) + 3;
                newPerson = new Person(id, gender, time, 0);
                people.add(newPerson);
                id++;
            }
            for (int x = 0; x < 10; x++) {
                int gender;
                int genderOdds = random.nextInt(100);
                if (genderOdds < 60) {
                    gender = 1;
                    // female
                } else {
                    gender = 0;
                    // male
                }
                int time = random.nextInt(6) + 3;
                newPerson = new Person(id, gender, time, 10);
                people.add(newPerson);
                id++;
            }
        }

        else if (setting == 2) {
            // option c: 20 arrive at once.
            int id = 1;
            Person newPerson;
            for (int x = 0; x < 20; x++) {
                int gender;
                int genderOdds = random.nextInt(100);
                if (genderOdds < 60) {
                    gender = 1;
                    // female
                } else {
                    gender = 0;
                    // male
                }
                int time = random.nextInt(6) + 3;
                newPerson = new Person(id, gender, time, 0);
                people.add(newPerson);
                id++;

            }
        }
        return people;
    }

    public static void bathroomAlgorithm(ArrayList<Person> peopleWaiting) {
        // peopleWaiting must be in order of arrival.
        int curTime = 0;
        int curInRoom = 0;
        int curGender = 0;
        int timeLeft = 0;
        int[] departTime = {-1, -1};
        ArrayList<Person> done = new ArrayList<Person>();

        while (peopleWaiting.isEmpty() == false) {
            if (curInRoom == 0) {
                Person curPerson = peopleWaiting.get(0);
                curInRoom++;
                timeLeft = curPerson.time;
                curGender = curPerson.gender;
                departTime[0] = curTime + curPerson.time;
                System.out.println("@t= " + curTime + " ; Person " + curPerson.id + " (" + curPerson.genderChar + ") enters the facilities for " + curPerson.time + " minutes");
                curPerson.setDeparture(timeLeft + curTime);
                done.add(curPerson);
                peopleWaiting.remove(curPerson);
            }
            if (curInRoom < 2) {
                Person personAdded;
                for (Person person : peopleWaiting){
                    if((curGender == person.gender) && (person.time <= timeLeft) && (person.arrival <= curTime)){
                        curInRoom++;
                        departTime[1] = curTime + person.time;
                        System.out.println("@t= " + curTime + " ; Person " + person.id + " (" + person.genderChar + ") enters the facilities for " + person.time + " minutes");
                        done.add(person);
                        person.setDeparture(curTime + person.time);
                        peopleWaiting.remove(person);
                        break;
                    }
                }
            }
            if(departTime[1] == curTime){
                // if the second person is done, they leave, leaving the first person
                curInRoom = 1;
            }
            if(departTime[0] == curTime){
                //if first person in bathroom is done, then there is nobody in the bathroom.
                curInRoom = 0;
            }

            timeLeft--;
            curTime++;
            

        }
        int departNo = 1;
        for(Person i : done){
            System.out.println("@t= " + i.departure + "; Person " + i.id + " (" + i.genderChar + ") exits (departure # " + departNo);
            departNo++;
        }
    }
}
