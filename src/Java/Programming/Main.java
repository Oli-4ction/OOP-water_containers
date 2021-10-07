package Java.Programming;

class Container  {

    int waterLevel;
    Container otherContainer;

    void init (int amount) {
        waterLevel = amount;
    }

    void connectTo(Container container) {
        otherContainer = container;
    }

    int getWaterLevel() {
        return waterLevel;
    }

    int receive (int amount) {
        int returnExcess;
        if(amount + waterLevel > 100) {
            returnExcess = 100 - waterLevel;
            waterLevel = 100;
        }
        else {
            waterLevel = waterLevel + amount;
            returnExcess = amount;
        }
        return returnExcess;
    }

    void dispense (int amount) {
        int pumped;
        if (amount > waterLevel)
            pumped = otherContainer.receive(waterLevel);
        else
            pumped = otherContainer.receive(amount);
        waterLevel = waterLevel - pumped;
        }
    }

    class Output {

        static void output(Container container1, Container container2) {
            System.out.println("Container 1 --------- Contianer 2");
            System.out.println(container1.getWaterLevel() + "L");
            System.out.println("---");
            System.out.println(container2.getWaterLevel() + "L");
        }



    public static void main(String[] args) {
	    Container container1 = new Container();
	    Container container2 = new Container();

	    container1.init(60);
	    container2.init(60);

	    container1.connectTo(container2);
	    container2.connectTo(container1);

	    output(container1, container2);

	    container1.dispense(10);
        output(container1, container2);

	    container1.dispense(40);
        output(container1, container2);

	    container2.dispense(60);
        output(container1, container2);
    }
}
