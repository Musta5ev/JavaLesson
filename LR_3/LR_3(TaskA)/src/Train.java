import java.util.Date;

public class Train
{
    final int num;
    String destination;
    Date departure;
    Seats seats;
    public Train(String destination, int num,Date departure, Seats seats)
    {
        this.destination = destination;
        this.num = num;
        this.departure = departure;
        this.seats = seats;
    }

    public String getDestination() {
        return destination;
    }

    public int getNum() {
        return num;
    }

    public Date getDeparture() {
        return departure;
    }

    public Seats getSeats() {
        return seats;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public void setSeats(Seats seats) {
        this.seats = seats;
    }

    public boolean equals(Train obj) {
        return obj.getDeparture().equals(this.getDeparture()) &&
                obj.getDestination().equals(this.getDestination()) &&
                obj.getNum() == this.getNum() &&
                obj.getSeats().equals(this.seats);
    }
    @Override
    public String toString() {
        return  "______________________________________________________________________\n"+
                "Train num: " + this.getNum() +"\n"+
                "Destination: " +this.getDestination() +" \n"+
                "Departure: " +this.getDeparture()+" \n"+
                "Seats: \n" +this.getSeats().toString()+
                "______________________________________________________________________\n";
    }
}

