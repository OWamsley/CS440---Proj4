public class Person {
    int id;
    int gender;
    int time;
    int arrival;
    int departure;
    char genderChar;

    public Person(int id, int gender, int time, int arrival){
        this.id = id;
        this.gender = gender;
        this.time = time;
        this.arrival= arrival;   
        if(gender == 0){
            this.genderChar = 'm';
        }
        else{
            this.genderChar = 'f';
        }
    }
    
    @Override
    public String toString(){
        String print = "ID: " + this.id + "  Gender: " + this.gender + "  Time: " + this.time + "  Arrival: " + this.arrival + "  Departure: " + this.departure + " \n";
        return print;
    }

    public void setDeparture(int i){
        this.departure = i;

    }


    
    
}
