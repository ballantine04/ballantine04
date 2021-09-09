class AerospaceEngineer {
    private AirplaneBuilder airplaneBuilder;
    public void setAirplaneBuilder(AirplaneBuilder ab){
        airplaneBuilder = ab;
    }
    public Airplane getAirplane(){
        return airplaneBuilder.getAirplane();
    }
    public void constructAirplane(){
        airplaneBuilder.createNewAirplane();
        airplaneBuilder.buildWings();
        airplaneBuilder.buildPowerplant();
        airplaneBuilder.buildAvionics();
        airplaneBuilder.buildSeats();
    }
}

abstract class AirplaneBuilder {
    protected Airplane airplane;
    protected String customer;
    protected String type;
    public Airplane getAirplane(){
        return airplane;
    }
    public void createNewAirplane(){
        airplane = new Airplane(customer, type);
    }
    public abstract void buildWings();
    public abstract void buildPowerplant();
    public abstract void buildAvionics();
    public abstract void buildSeats();
}

class Airplane {
    private String type;
    private float wingspan;
    private String powerplant;
    private int crewSeats;
    private int passengerSeats;
    private String avionics;
    private String customer;
    Airplane(String customer, String type){
        this.customer = customer;
        this.type = type;
    }
    public void setWingspan(float w) { this.wingspan = w; }
    public void setPowerplant(String p) { this.powerplant = p; }
    public void setAvionics(String a) { this.avionics = a; }
    public void setNumberSeats(int crewSeats, int passengerSeats) {
        this.crewSeats = crewSeats;
        this.passengerSeats = passengerSeats;
    }
    public String getCustomer() { return customer; }
    public String getType() { return type; }
}


// Concreate Builder 1
class CropDuster extends AirplaneBuilder {
    CropDuster (String customer) {
        super.customer = customer;
        super.type = "Crop Duster v3.4";
    }
    public void buildWings() {
        airplane.setWingspan(9f);
    }
    public void buildPowerplant() {
        airplane.setPowerplant("single piston");
    }
    public void buildAvionics() {}
    public void buildSeats() {
        airplane.setNumberSeats(1, 1);
    }
}
// Concreate Builder 2
class FighterJet extends AirplaneBuilder {
    FighterJet (String customer) {
        super.customer = customer;
        super.type = "F-35 Lightning II";
    }
    public void buildWings() {
        airplane.setWingspan(35.0f);
    }
    public void buildPowerplant() {
        airplane.setPowerplant("dual thrust vectoring");
    }
    public void buildAvionics() {
        airplane.setAvionics("military");
    }
    public void buildSeats() {
        airplane.setNumberSeats(1, 0);
    }
}
// Concreate Builder 2
// class Glider extends AirplaneBuilder {
//  ...
// }

public class builder_pattern{
    public static void main(String[] args) {
        AerospaceEngineer director = new AerospaceEngineer();

        // Instanciate each concrate builder
        AirplaneBuilder crop = new CropDuster("Farmer Joe");
        AirplaneBuilder fighter = new FighterJet("the navy");
        //AirplaneBuilder glider = new Glider("Tim Rice");

        // build a CropDuseter
        director.setAirplaneBuilder(crop);
        director.constructAirplane();
        Airplane completedCropDuster = director.getAirplane();
        System.out.println(completedCropDuster.getType()+" is completed and ready for delivery to "+completedCropDuster.getCustomer());

        // build a FighterJet
        director.setAirplaneBuilder(fighter);
        director.constructAirplane();
        Airplane completedFighterJet = director.getAirplane();
        System.out.println(completedFighterJet.getType()+" is completed and ready for delivery to "+completedFighterJet.getCustomer());
    }
}

[output]
Crop Duster v3.4 is completed and ready for delivery to Farmer Joe
F-35 Lightning II is completed and ready for delivery to the navy
