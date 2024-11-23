class Seats
{
    int general;
    int compartment;
    int reservedSeat;
    int suite;

    public Seats(int general, int compartment, int reservedSeat, int suite)
    {
        this.general = general;
        this.compartment = compartment;
        this.reservedSeat = reservedSeat;
        this.suite = suite;
    }
    @Override
    public String toString() {
        return  "\tgeneral: " + this.general + "\n" +
                "\tcompartment: " + this.compartment + " \n" +
                "\treservedSeat: " + this.reservedSeat + " \n" +
                "\tsuite: " + this.suite + " \n";
    }
}