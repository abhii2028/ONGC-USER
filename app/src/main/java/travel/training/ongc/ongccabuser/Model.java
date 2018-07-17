package travel.training.ongc.ongccabuser;

public class Model {

    String id,personName,departmentName,timeSlot,pickupPoint,destination;

    public Model(String id, String personName, String departmentName, String timeSlot, String pickupPoint, String destination) {
        this.id = id;
        this.personName = personName;
        this.departmentName = departmentName;
        this.timeSlot = timeSlot;
        this.pickupPoint = pickupPoint;
        this.destination = destination;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(String pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
