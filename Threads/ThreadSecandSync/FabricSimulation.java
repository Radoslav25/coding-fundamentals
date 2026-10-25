package ThreadSecandSync;

public class FabricSimulation {

	public static void main(String[] args) {
		Parts parts = new Parts();
		new Technician(parts).start();
		new Machine(parts).start();
	}

}
