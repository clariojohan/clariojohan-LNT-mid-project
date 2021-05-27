import java.util.Scanner;
import java.util.ArrayList;

public class main {

	static int jumlahData = 0;
	static Scanner scan = new Scanner(System.in);
	static ArrayList <vehicle>list = new ArrayList<>();
	
	public static void input(){
		vehicle tmp = new vehicle();
		String vehicleType;
		String brand;
		String name;
		String license;
		int topSpeed;
		int gasCapacity;
		int wheel;
		String type;
		int entertain;
		int helm;

		// Input type [Car | Motorcycle]: Car
		// Input brand [>= 5]: Mitsubishi
		// Input name[>= 5]: Triton
		// Input license: B 1928 WIB
		// Input top speed [100 <= topSpeed <= 250]: 150
		// Input gas capacity [30 <= gasCap <= 60]: 55
		// Input wheel [4 <= wheel <= 6]: 4
		// Input type [Suv | supercar | Minivan]: suv
		// Input entertainment system amount [>= 1]: 2
		// ENTER to return

		//scan vehicleType
		do{
			System.out.print("Input type [Car | Motorcycle]: ");
			vehicleType = scan.nextLine();
		}
		while(!vehicleType.equals("Car") && !vehicleType.equals("Motorcycle"));
		tmp.setVehicleType(vehicleType);
		
		//scan brand
		do{
			System.out.print("Input brand [>= 5]: ");
			brand = scan.nextLine();
		}
		while(brand.length() < 5);
		tmp.setBrand(brand);

		//scan name
		do{
			System.out.print("Input name [>= 5]: ");
			name = scan.nextLine();
		}
		while(name.length() < 5);
		tmp.setName(name);

		//scan license number
		String regex = "[A-Z]+ [0-9]{1,4}+ [A-Z]{1,3}+";
		do{
			System.out.print("Input license: ");
			license = scan.nextLine();
		}
		while(!license.matches(regex));
		tmp.setLicense(license);
		
		//scan topSpeed
		do{
			System.out.print("Input top speed [100 <= topSpeed <= 250]: ");
			topSpeed = scan.nextInt(); scan.nextLine();
		}
		while(topSpeed < 100 || topSpeed > 250);
		tmp.setTopSpeed(topSpeed);
		
		//scan gasCapacity
		do{
			System.out.print("Input gas capacity [30 <= gasCap <= 60]: ");
			gasCapacity = scan.nextInt(); scan.nextLine();
		}
		while(gasCapacity < 30 || gasCapacity > 60);
		tmp.setGasCapacity(gasCapacity);
		
		//scan wheel
		if (vehicleType.equals("Car")){	
			do{
				System.out.print("Input wheel [4 <= wheel <= 6]: ");
				wheel = scan.nextInt(); scan.nextLine();
			}
			while(wheel < 4 || wheel > 6);
			tmp.setWheel(wheel);
		}
		else if (vehicleType.equals("Motorcycle")){
			do{
				System.out.print("Input wheel [2 <= wheel <= 3]: ");
				wheel = scan.nextInt(); scan.nextLine();
			}
			while(wheel < 2 || wheel > 3);
			tmp.setWheel(wheel);
		}
		
		// scan type
		if (vehicleType.equals("Car")){	
			do{
				System.out.print("Input type [Suv | Supercar | Minivan]: ");
				type = scan.nextLine();
			}
			while(!type.equals("Suv") && !type.equals("Supercar") && !type.equals("Minivan"));
			tmp.setType(type);
		}
		else if (vehicleType.equals("Motorcycle")){
			do{
				System.out.print("Input type [Automatic | Manual]: ");
				type = scan.nextLine();
			}
			while(!type.equals("Automatic") && !type.equals("Manual"));
			tmp.setType(type);
		}
		
		// scan entertain / helm
		if (vehicleType.equals("Car")){	
			do{
				System.out.print("Input entertainment system amount [>= 1]: ");
				entertain = scan.nextInt(); scan.nextLine();
			}
			while(entertain < 1);
			tmp.setEntertain(entertain);
		}
		else if (vehicleType.equals("Motorcycle")){
			do{
				System.out.print("Input helm qty [>= 1] ");
				helm = scan.nextInt(); scan.nextLine();
			}
			while(helm < 1);
			tmp.setHelm(helm);
		}
		list.add(tmp);
		jumlahData++;
		System.out.println("ENTER to return"); scan.nextLine();
	}
	
	public static void view(){
		int choose = 0;
		System.out.println("|-----|---------------|---------------|");
		System.out.println("|No   |Type           |Name           |");
		System.out.println("|-----|---------------|---------------|");
		for (int i = 0; i < jumlahData; i++){
			System.out.printf("|%-5s|%-15s|%-15s|\n", Integer.toString(i+1), list.get(i).getType(), list.get(i).getName());
		}
		System.out.println("|-----|---------------|---------------|");

		do{
			System.out.print("Pick a vehicle number to test drive[Enter '0' to exit]:");
			choose = scan.nextInt(); scan.nextLine();
			if (choose == 0){
				return;
			}
		}
		while(choose < 0 || choose > jumlahData);
		choose--; // karena index mulai dari 0, maka kita --

		vehicle index = list.get(choose);
		System.out.println("Brand: "+ index.getBrand());
		System.out.println("Name: "+ index.getName());
		System.out.println("License Plate: "+ index.getLicense());
		System.out.println("Type: "+ index.getType());
		System.out.println("Gas Capacity: "+ index.getGasCapacity());
		System.out.println("Top Speed: "+ index.getTopSpeed());
		System.out.println("Wheel(s): "+ index.getWheel());
		if (index.getVehicleType().equals("Car")){
			System.out.println("Entertaiment System: "+ index.getEntertain());
			System.out.println("Turning on entertaiment system...");
			if(index.getType().equals("Supercar")){
				System.out.println("Boosting!");
			}
		}
		else{
			int hargaHelm = 0;
			System.out.println(index.getName() + " is standing!");
			do {	
				System.out.print("Input Price: ");
				hargaHelm = scan.nextInt(); scan.nextLine();
			}
			while(hargaHelm < 0);
			System.out.println("Price: " + hargaHelm * index.getHelm());
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choose = 0;
		while(choose != 3){
			System.out.println("MENU");
			System.out.println("----");
			System.out.println("1. Input");
			System.out.println("2. View");
			System.out.println("3. Exit");
			System.out.println(">>");

			choose = scan.nextInt(); scan.nextLine();
			if (choose == 1) input();
			else if (choose == 2) view();
		}

	}

}
